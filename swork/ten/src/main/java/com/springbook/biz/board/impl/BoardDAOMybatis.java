package com.springbook.biz.board.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springbook.biz.board.BoardVO;

@Repository
public class BoardDAOMybatis {
	//mybatis탬플릿 객체 생성 및 의존성 주입처리
	@Autowired
	private SqlSessionTemplate mybatis;
	/*
	 *  insert문 => insert메소드사용 insert("맵퍼객체명.쿼리객체명", 바인드변수를 담고있는 변수나 객체);
	 *  delete문 => delete메소드사용 delete("맵퍼객체명.쿼리객체명", 바인드변수를 담고있는 변수나 객체);
	 *  update문 => update메소드사용 update("맵퍼객체명.쿼리객체명", 바인드변수를 담고있는 변수나 객체);
	 *  select 1줄 => selectOne("맵퍼객체명.쿼리객체명", 바인드변수를 담고있는 변수나 객체);
	 *  select 여러줄 => selectList("맵퍼객체명,쿼리객체명", 바인드변수를 담고있는 변수나 객체);
	 */
	
	
	// CRUD 기능의 메소드 구현
	// 글등록
	public void insertBoard(BoardVO vo) {
		System.out.println("===>mybatis insertBoard() 기능처리");
		mybatis.insert("BoardDAO.insertBoard" ,vo);
	}

	// 글수정
	public void updateBoard(BoardVO vo) {
		System.out.println("===>mybatis로 updateBoard() 기능처리");
		mybatis.update("BoardDAO.updateBoard",vo);
	}

	// 글삭제
	public void deleteBoard(BoardVO vo) {
		System.out.println("===>mybatis로 deleteBoard() 기능처리");
		mybatis.delete("BoardDAO.deleteBoard",vo);
	}

	// 글상세 조회
	public BoardVO getBoard(BoardVO vo) {
		System.out.println("===>mybatis로 getBoard() 기능처리");
		return mybatis.selectOne("BoardDAO.getBoard", vo);
		
	}

	// 글목록 조회
	public List<BoardVO> getBoardList(BoardVO vo) {
		System.out.println("===>mybatis로 getBoardList() 기능처리");
		return mybatis.selectList("BoardDAO.getBoardList", vo);
		
	}

}

