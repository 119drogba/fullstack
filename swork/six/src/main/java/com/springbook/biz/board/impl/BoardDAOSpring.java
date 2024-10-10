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
public class BoardDAOSpring extends JdbcDaoSupport {
	
	//sql명령어들
	private final String BOARD_INSERT = "insert into board(title, writer, content) "
			+ " values(?, ?, ?)";
	
	private final String BOARD_UPDATE = "update board set title =?, content=? where seq=? ";
	private final String BOARD_DELETE = "delete from board where seq = ?";
	private final String BOARD_GET = "select * from board where seq=?";
	private final String BOARD_LIST = "select * from board order by seq desc";
	
	
	@Autowired
	public void setSuperDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}
	
	
	
	public int insertBoard(BoardVO vo) {
		System.out.println("===>Spring JDBC로 insertBoard() 기능처리");
		return getJdbcTemplate().update(BOARD_INSERT, vo.getTitle(), vo.getWriter(), vo.getContent());
	}

	
	
	//글수정
	public int updateBoard(BoardVO vo) {
		System.out.println("===>Spring JDBC로 updateBoard() 기능처리");
		return getJdbcTemplate().update(BOARD_UPDATE, vo.getTitle(), vo.getContent(),vo.getSeq());
	}
		
	
	
	
	public int deleteBoard(BoardVO vo) {
		return getJdbcTemplate().update(BOARD_DELETE, vo.getSeq());
	
	}
	
	
	public BoardVO getBoard(BoardVO vo) {
		
		try {
			System.out.println();
			Object[] args= {vo.getSeq()};
			return getJdbcTemplate().queryForObject(BOARD_GET, new BoardRowMapper(), args);
		}catch(IncorrectResultSizeDataAccessException err) {
			return null;
		}
	}
	
	
	public List<BoardVO> getBoardList(BoardVO vo) {
		System.out.println();
		try {
			return getJdbcTemplate().query(BOARD_LIST, new BoardRowMapper());
		}catch(EmptyResultDataAccessException err) {
			return null;
		}
		
	
}}