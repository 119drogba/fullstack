package com.springbook.biz.board.impl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.springbook.biz.board.BoardVO;

@Repository
public class BoardDAOSpring extends JdbcDaoSupport{
	
	@Autowired
	public void setSuperDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}
	
	//CRUD 기능의 메소드 구현
	//글등록
	private final String BOARD_INSERT = "insert into board(title, writer, content) values( ?, ?, ?)";
	public int insertBoard(BoardVO vo) {
		System.out.println("===>Spring JDBC로 insertBoard() 기능처리");
		return getJdbcTemplate().update(BOARD_INSERT, vo.getTitle(), vo.getWriter(), vo.getContent());
		//"JdbcTemplate 테스트" ,"홍길동", "JdbcTemplate  테스트"
	}
		
	
	//글수정
	private final String BOARD_UPDATE = "update board set title =?, content=? where seq=? ";
	public void updateBoard(BoardVO vo) {
		System.out.println("===>Spring JDBC로 updateBoard() 기능처리");
		getJdbcTemplate().update(BOARD_UPDATE, vo.getTitle(), vo.getContent(), vo.getSeq());
	}
	
	//글삭제
	private final String BOARD_DELETE = "delete from board where seq = ?";
	public void deleteBoard(BoardVO vo) {
		System.out.println("===>Spring JDBC로 deleteBoard() 기능처리");
		getJdbcTemplate().update(BOARD_DELETE, vo.getSeq());
	}
	
	//글상세 조회
	private final String BOARD_GET = "select * from board where seq=?";
	public BoardVO getBoard(BoardVO vo) {
		try {
			System.out.println("===>Spring JDBC로 getBoard() 기능처리");
			Object[] args = {vo.getSeq()}; //50
			return getJdbcTemplate().queryForObject(BOARD_GET, new BoardRowMapper(), args);
		}catch(IncorrectResultSizeDataAccessException err) {
			return null;
		}
	}
	//글목록 조회
	private final String BOARD_LIST = "select * from board order by seq desc";
	public List<BoardVO> getBoardList(BoardVO vo) {
		System.out.println("===>Spring JDBC로 getBoardList() 기능처리");
		try {
			return getJdbcTemplate().query(BOARD_LIST, new BoardRowMapper());
		}catch(EmptyResultDataAccessException err) {
			return null;
		}
	}
}