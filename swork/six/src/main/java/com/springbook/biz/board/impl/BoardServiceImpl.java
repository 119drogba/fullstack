package com.springbook.biz.board.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbook.biz.board.BoardService;
import com.springbook.biz.board.BoardVO;

@Service("boardService")
public class BoardServiceImpl implements BoardService {

//	@Autowired
//	private BoardDAO boardDAO;

	@Autowired
	private BoardDAOSpring boardDAO;
	@Override
	//포인트컷
	public void insertBoard(BoardVO vo) {
		
//			if (vo.getSeq() == 0) {
//				throw new IllegalArgumentException("0번 글은 등록할 수 없습니다.");
////				throw new NumberFormatException("숫자형식이 아닙니다.");
//			} else {
				 boardDAO.insertBoard(vo);
//			}

		
	}

	@Override
	//포인트컷
	public void updateBoard(BoardVO vo) {
		boardDAO.updateBoard(vo);
	}

	@Override
	//포인트컷
	public void deleteBoard(BoardVO vo) {
		boardDAO.deleteBoard(vo);
	}

	@Override
	//포인트컷
	public BoardVO getBoard(BoardVO vo) {
		return boardDAO.getBoard(vo);
	}

	@Override
	//포인트컷
	public List<BoardVO> getBoardList(BoardVO vo) {
		System.out.println("getBoardList()메소드 호출");
		return boardDAO.getBoardList(vo);
	}
}
