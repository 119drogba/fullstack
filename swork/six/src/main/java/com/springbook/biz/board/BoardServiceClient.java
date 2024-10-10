package com.springbook.biz.board;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class BoardServiceClient {

	public static void main(String[] args) {
		AbstractApplicationContext container = new GenericXmlApplicationContext("applicationContext.xml");
		
		
		//BoardServiceImpl , BoardService 2번객체 주입
		//@Autowired BoardDAO boardDAO; (1번 객체 자동주입) 
		BoardService boardService = (BoardService) container.getBean("boardService");
		
		BoardVO vo = new BoardVO();
		vo.setTitle("AOP annotation테스트");
		vo.setWriter("홍길동");
		vo.setContent("AOP annotation테스트");
//		try {
//			boardService.insertBoard(vo);
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
		
		List<BoardVO> boardList = boardService.getBoardList(vo);
		for(BoardVO board : boardList) {
			System.out.println("-----> "+board.toString());
		}
		System.out.println("시스템종료");
	
		container.close();
	}

}