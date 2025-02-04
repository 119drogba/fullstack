package com.springbook.view.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import com.springbook.biz.BoardService;
import com.springbook.biz.BoardVO;

@Controller
@SessionAttributes("board")
public class BoardController {

	@Autowired
	private BoardService boardService;

	// ################## 로직 추가 #######################//
	String realPath = "c:/swork/nine/src/main/webapp/img/";

	@PostMapping(value = "/insertBoard.do")
//도메인 주소를 서버의 절대경로로 변경하는 로직 (실제로 웹 서버에 배포할때는 이 로직으로 처리할 것)
//	public String insertBoard(MultipartHttpServletRequest request, BoardVO vo) throws IllegalStateException, IOException {
	public String insertBoard(BoardVO vo) throws IllegalStateException, IOException {
		MultipartFile uplodFile = vo.getUploadFile();

		// 도메인 주소를 서버의 절대경로로 변경하는 로직 (실제로 웹 서버에 배포할때는 이 로직으로 처리할 것)
		// realPath = request.getSession().getServletContext().getRealPath("/img/");

		File f = new File(realPath);
		if (!f.exists()) {
			// c:/swork/nine/src/main/webapp/img/ - 폴더생성됨

			f.mkdirs();
		}

		if (!uplodFile.isEmpty()) {
			String fileName = uplodFile.getOriginalFilename(); // 에이팜.png
			vo.setFilename(fileName);
			// "c:/swork/nine/src/main/webapp/img/에이팜.png";
			// 실제로 서버로 파일이 업로드 되는 지점
			uplodFile.transferTo(new File(realPath + fileName));
		}
		boardService.insertBoard(vo);
		return "/getBoardList.do";
	}

	// 글 목록
	@RequestMapping("/getBoardList.do")
	public String getBoardListPost(BoardVO vo, Model model) {
		System.out.println("글 목록 검색 처리");

		model.addAttribute("boardList", boardService.getBoardList(vo));
		return "/WEB-INF/board/getBoardList.jsp";
	}

	// 글 상세 조회
	@RequestMapping("/getBoard.do")
	public String getBoard(BoardVO vo, Model model) {
		model.addAttribute("board", boardService.getBoard(vo));
		return "WEB-INF/board/getBoard.jsp";
	}

	// 파일다운로드 //################## 로직 추가예정 #######################//
	@GetMapping(value = "/download.do")
	public void fileDownLoad(@RequestParam(value = "filename", required = false) String filename,
			HttpServletRequest request, HttpServletResponse response) throws IOException {
		System.out.println("파일 다운로드");
		if (!(filename == null || filename.equals(""))) {
			// 요청파일 정보 불러오기(실제 웹서버에 배포시 도메인주소를 물리적인 주소로 변경할때 사용)
			// realPath = request.getSession().getServletContext().getRealPath("/img/");

			File file = new File(realPath + filename);

			// 한글은 http 헤더에 사용할 수 없기 때문에 파일명은 영문으로 인코딩하여 헤더에 적용한다
			String fn = new String(file.getName().getBytes(), "iso_8859_1");

			// ContentType설정
			byte[] bytes = org.springframework.util.FileCopyUtils.copyToByteArray(file);
			response.setHeader("Content-Disposition", "attachment; filename=\"" + fn + "\""

			);
			response.setContentLength(bytes.length);
			// response.setContentType("image/jpeg"); //기술안하면 자동으로 컨텐츠 타입 인식함

			response.getOutputStream().write(bytes); // 클라이언트에 저장할 수 있도록 출력하기
			response.getOutputStream().flush(); // 실제 클라이언트의 pc에 파일이 저장되는 시점
			response.getOutputStream().close(); // 자원 반납처리

		}
	}

}
