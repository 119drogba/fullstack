package com.springbook.biz.user.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.springbook.biz.user.UserVO;
@Repository
public class UserDAODBCP {
	public final String USER_LOGIN = "SELECT * FROM USERS WHERE ID = ? AND PASSWORD = ?";
	public final String USER_LIST ="SELECT * FROM USERS ORDER BY ID " ;
	public final String USER_UPDATE = "UPDATE USERS SET PASSWORD = ? , NAME =?, ROLE = ? WHERE ID = ?";
	public final String USER_INSERT = "INSERT INTO USERS VALUES (?, ? ,?, ?)";
	public final String USER_DELETE = "DELETE FROM USERS WHERE ID = ? AND PASSWORD = ?";
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
		
	
	
	public List<UserVO> getUserList(){
		System.out.println("getJdbcTemplate() selectList메소드 실행");
		try {
			return jdbcTemplate.query(USER_LIST, new UserRowMapper());
		}catch(EmptyResultDataAccessException e) {
			return null;
		}
	}
	
	public void userUpdate(UserVO vo) {
		System.out.println("getJdbcTemplate() updateUser메소드 실행");
		Object[] args = { vo.getPassword(), vo.getName(), vo.getId() };
		jdbcTemplate.update(USER_UPDATE, args);
	}
	
	public void userInsert(UserVO vo) {
		System.out.println("getJdbcTemplate() insertUser메소드 실행");
		Object[] args = {vo.getId(), vo.getPassword(), vo.getName(), vo.getRole()};
		jdbcTemplate.update(USER_INSERT, args);
	}
	
	public void userDelete(UserVO vo) {
		System.out.println("getJdbcTemplate() deleteUser메소드 실행");
		jdbcTemplate.update(USER_DELETE, vo.getId());
	}

	public UserVO login(UserVO vo) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
