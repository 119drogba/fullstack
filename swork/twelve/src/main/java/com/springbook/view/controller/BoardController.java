package com.springbook.view.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.springbook.biz.board.BoardService;
import com.springbook.biz.board.BoardVO;
import com.springbook.biz.util.PagingVO;

@Controller
public class BoardController {
	int cntChk = 0;

	@Autowired
	private BoardService boardService;

	String realPath = "c:/swork/twelve/src/main/webapp/resources/img/";
//	String realPath;
	

	// 글목록 검색 옵션
	@ModelAttribute("conditionMap")
	public Map<String, String> searchConditionMap() {
		Map<String, String> conditionMap = new HashMap<String, String>();
		conditionMap.put("내용", "CONTENT");
		conditionMap.put("제목", "TITLE");
		return conditionMap;
	}

	// 글 등록
	@RequestMapping(value = "/insertBoard.do", method = RequestMethod.POST)
	public String insertBoard(BoardVO vo) throws IllegalStateException, IOException {
//	public String insertBoard(MultipartHttpServletRequest request, BoardVO vo) throws IllegalStateException, IOException {
//	상대경로 추가시 
		MultipartFile uplodFile = vo.getUploadFile();
		// 상대 경로 추가 시 realPath 추가
//		realPath = request.getSession().getServletContext().getRealPath("/resources/img/");
		System.out.println("realPath: "+realPath);
		if (uplodFile != null) {
			if (!uplodFile.isEmpty()) {
				String fileName = uplodFile.getOriginalFilename();
				vo.setFilename(fileName);
				uplodFile.transferTo(new File(realPath + fileName));
			}
		}
		boardService.insertBoard(vo);
		return "redirect:getBoardList.do";
	}

	@RequestMapping(value = "/insertBoard", method = RequestMethod.GET)
	public String insertView(BoardVO vo) throws IllegalStateException, IOException {
		return "board/insertBoard";
	}

	// 글 수정
	@RequestMapping("/updateBoard.do")
	public String updateBoard(BoardVO vo, HttpSession session) {
		cntChk++;
		boardService.updateBoard(vo);
		return "redirect:getBoard.do?seq="+vo.getSeq();
	}

	// 글 삭제
	@RequestMapping("/deleteBoard.do")
	public String deleteBoard(BoardVO vo, HttpServletRequest request) {
//	public String deleteBoard(BoardVO vo) {
		// 상대 경로 추가 시 realPath 추가
		realPath = request.getSession().getServletContext().getRealPath("/resources/img/");
		if (vo.getFilename() != null) {
			System.out.println("파일삭제: " + realPath + vo.getFilename());
			File f = new File(realPath + vo.getFilename());
			f.delete();
		}
		boardService.deleteBoard(vo);
		return "redirect:getBoardList.do";
	}

	// 글 상세 조회
	@RequestMapping("/getBoard/{seq}")
	public String getBoard(@RequestParam(value="error", required = false) String error,@PathVariable("seq") int seq,BoardVO vo, Model model) {
		vo.setSeq(seq);
		BoardVO mboard = boardService.getBoard(vo);
		if (!(error==null || error.equals(""))) cntChk = 0;
		else if(cntChk <= 0) boardService.updateCnt(mboard);
		else cntChk = 0;
		mboard = boardService.getBoard(vo);
		model.addAttribute("board", mboard);
		return "board/getBoard";
	}
	
	// 글 상세 조회
	@RequestMapping("/getBoard.do")
	public String getBoard(
			@RequestParam(value="error", required = false) String error,
			@RequestParam(value="nowPage", required = false) String nowPage, /* 241017_추가 페이징처리와 목록, 검색 유지 기능 처리 */
			BoardVO vo, Model model
	) {
		BoardVO mboard = boardService.getBoard(vo);
		if (!(error==null || error.equals(""))) cntChk = 0;
		else if(cntChk <= 0) boardService.updateCnt(mboard);
		else cntChk = 0;
		mboard = boardService.getBoard(vo);
		model.addAttribute("board", mboard);
		/* 241017_추가 페이징처리와 목록, 검색 유지 기능 처리(시작) */
		model.addAttribute("searchCondition", vo.getSearchCondition());
		model.addAttribute("searchKeyword", vo.getSearchKeyword());
		model.addAttribute("nowPage", nowPage);
		/* 241017_추가 페이징처리와 목록, 검색 유지 기능 처리(종료) */
		return "board/getBoard";
	}

	// 글 목록
	@RequestMapping("/getBoardList.do")
	public String getBoardListPost(PagingVO pv, BoardVO vo, Model model,
			@RequestParam(value = "nowPage", required = false) String nowPage) {
		System.out.println("글 목록 검색 처리");
		
		String cntPerPage = "5"; //한페이지보여줄목록수
		if (vo.getSearchCondition() == null)
			vo.setSearchCondition("TITLE");
//		else
//			vo.setSearchCondition(vo.getSearchCondition());
		if (vo.getSearchKeyword() == null)
			vo.setSearchKeyword("");
//		else
//			vo.setSearchKeyword(vo.getSearchKeyword());

		int total = boardService.countBoard(vo);
		if (nowPage == null) {
			nowPage = "1"; 
		}
		
		pv = new PagingVO(total, Integer.parseInt(nowPage), Integer.parseInt(cntPerPage));
		model.addAttribute("paging", pv);
		System.out.println("pagingVO: "+pv);
		vo.setStart(pv.getStart());
		vo.setListcnt(Integer.parseInt(cntPerPage));

		model.addAttribute("searchKeyword", vo.getSearchKeyword());
		model.addAttribute("searchCondition", vo.getSearchCondition());
		model.addAttribute("boardList", boardService.getBoardList(vo));
		return "board/getBoardList";
		//"/WEB-INF/board/getBoardList.jsp""

	}

	// 파일다운로드
	@RequestMapping(value = "/download.do", method = RequestMethod.GET)
	public void fileDownLoad(@RequestParam(value = "filename", required = false) String filename,
			HttpServletRequest request, HttpServletResponse response) throws IOException {
		System.out.println("파일 다운로드");
		// (1) 기본 ajax요청 시 응답
		if (filename == null || filename.equals("")) {
		} else {

			// (2) 요청파일 정보 불러오기
			realPath = request.getSession().getServletContext().getRealPath("/resources/img/");
			File file = new File(realPath + filename);

			// 한글은 http 헤더에 사용할 수 없기 때문에 파일명은 영문으로 인코딩하여 헤더에 적용한다
			String fn = new String(file.getName().getBytes(), "iso_8859_1");

			// (3) ContentType설정
			byte[] bytes = org.springframework.util.FileCopyUtils.copyToByteArray(file);
			response.setHeader("Content-Disposition", "attachment; filename=\"" + fn + "\"");
			response.setContentLength(bytes.length);
			// response.setContentType("image/jpeg");

			response.getOutputStream().write(bytes);
			response.getOutputStream().flush();
			response.getOutputStream().close();
		}
	}

}
