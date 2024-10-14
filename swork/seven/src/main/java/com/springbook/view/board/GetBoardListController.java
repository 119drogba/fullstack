package com.springbook.view.board;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.springbook.biz.board.BoardService;
import com.springbook.biz.board.BoardVO;

public class GetBoardListController implements Controller {
	@Autowired
	BoardService boardService;
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
		System.out.println("글 목록 검색 처리");
		
//		request.setCharacterEncoding("utf-8");
		
		// 1. 사용자 입력 정보 추출(검색 기능은 나중에 구현)
		// 2. DB 연동 처리
		BoardVO vo = new BoardVO();
		String keyword, condition;
		if(request.getParameter("searchKeyword") == null) keyword = "";
		else  keyword = request.getParameter("searchKeyword");
		
		if(request.getParameter("searchCondition") == null) condition = "TITLE";
		else condition = request.getParameter("searchCondition");
		
		if(condition.equals("TITLE")) {
			vo.setTitle(keyword);
			vo.setContent("");
		}else {
			vo.setTitle("");
			vo.setContent(keyword);
		}
		
		List<BoardVO> boardList = boardService.getBoardList(vo, keyword, condition );
		
		// 3. 검색 결과를 세션에 저장하고 목록 화면을 리턴한다. 
		ModelAndView mav = new ModelAndView();
		mav.addObject("boardList", boardList); 
		//request.setAttribute("boardList", boardList ) 동일
		mav.setViewName("board/getBoardList");
		/*setViewName의 매개변수 안에 
		 * 1. redirect: 이 없는 경우 => forwarding방식으로 페이지 이동(뷰 리졸버 객체 실행됨)
		 * 2. redirect: 이 있는 경우 => redirect방식으로 페이지 이동
		 * 	(뷰리졸버 객체 실행 안됨. WEB-INF경로안의 페이지들은 접근 안됨 
		 */
		return mav;
	}
}











