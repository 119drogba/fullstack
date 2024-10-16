package com.springbook.biz.board.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.springbook.biz.board.BoardVO;

@Repository
public class BoardDAOMybatis {
	////마이바티스 객체 선언 및 자동주입처리 예정
	
	// CRUD 기능의 메소드 구현
	// 글등록
	public void insertBoard(BoardVO vo) {
		System.out.println("===>mybatis insertBoard() 기능처리");
	}

	// 글수정
	public void updateBoard(BoardVO vo) {
		System.out.println("===>mybatis로 updateBoard() 기능처리");
	}

	// 글삭제
	public void deleteBoard(BoardVO vo) {
		System.out.println("===>mybatis로 deleteBoard() 기능처리");
	}

	// 글상세 조회
	public BoardVO getBoard(BoardVO vo) {
		System.out.println("===>mybatis로 getBoard() 기능처리");
		return null;
	}

	// 글목록 조회
	public List<BoardVO> getBoardList(BoardVO vo) {
		System.out.println("===>mybatis로 getBoardList() 기능처리");
		return null;
	}

}

