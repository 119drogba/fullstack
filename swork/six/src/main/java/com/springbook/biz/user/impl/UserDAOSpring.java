package com.springbook.biz.user.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.springbook.biz.board.impl.BoardRowMapper;
import com.springbook.biz.user.UserVO;

public class UserDAOSpring extends JdbcDaoSupport {
	private Connection conn;
	private PreparedStatement ps ;
	private ResultSet rs;
	
	@Autowired
	public void setSuperDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}
	//로그인
	public final String USER_LOGIN = "SELECT * FROM USERS WHERE ID = ? AND PASSWORD = ?";
	
	public UserVO login(UserVO vo) {
		

		try {
			System.out.println();
			Object[] args= {vo.getSeq()};
			return getJdbcTemplate().queryForObject(BOARD_GET, new BoardRowMapper(), args);
		}catch(IncorrectResultSizeDataAccessException err) {
			return null;
		}
	}
		
	}
	
	
	//회원목록
	public final String USER_LIST ="SELECT * FROM USERS ORDER BY ID " ;
	public List<UserVO> getUserList(){
		
	}
	
	
	//회원수정
	public final String USER_UPDATE = "UPDATE USERS SET PASSWORD = ? , NAME =?, ROLE = ? WHERE ID = ?";
	public int userUpdate(UserVO vo) {
		
			
	
	}
	
	//회원가입
	public final String USER_INSERT = "INSERT INTO USERS VALUES (?, ? ,?, ?)";
	public int userInsert(UserVO vo) {
		
	}
	
	//회원 탈퇴
	public final String USER_DELETE = "DELETE FROM USERS WHERE ID = ? AND PASSWORD = ?";
	public int userDelete(UserVO vo) {
		
}
