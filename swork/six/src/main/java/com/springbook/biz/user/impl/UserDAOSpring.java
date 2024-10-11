package com.springbook.biz.user.impl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.springbook.biz.user.UserVO;

@Repository
public class UserDaoSpring extends JdbcDaoSupport{
	
	public final String USER_LOGIN = "SELECT * FROM USERS WHERE ID = ? AND PASSWORD = ?";
	public final String USER_LIST ="SELECT * FROM USERS ORDER BY ID " ;
	public final String USER_UPDATE = "UPDATE USERS SET PASSWORD = ? , NAME =?, ROLE = ? WHERE ID = ?";
	public final String USER_INSERT = "INSERT INTO USERS VALUES (?, ? ,?, ?)";
	public final String USER_DELETE = "DELETE FROM USERS WHERE ID = ? AND PASSWORD = ?";
	
	@Autowired
	public void setSuperDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}
	
	public UserVO login(UserVO vo){
		System.out.println("getJdbcTemplate() getUser메소드 실행");
		Object[] args = {vo.getId(), vo.getPassword()};
		
		try {
			return getJdbcTemplate().queryForObject(USER_LOGIN, new UserRowMapper(), args);
//		}catch(EmptyResultDataAccessException e) {
		}catch(IncorrectResultSizeDataAccessException e) {
			return null;
		}
	}
	
	public List<UserVO> getUserList(){
		System.out.println("getJdbcTemplate() selectList메소드 실행");
		try {
			return getJdbcTemplate().query(USER_LIST, new UserRowMapper());
		}catch(EmptyResultDataAccessException e) {
			return null;
		}
	}
	
	public void userUpdate(UserVO vo) {
		System.out.println("getJdbcTemplate() updateUser메소드 실행");
		Object[] args = { vo.getPassword(), vo.getName(), vo.getId() };
		getJdbcTemplate().update(USER_UPDATE, args);
	}
	
	public void userInsert(UserVO vo) {
		System.out.println("getJdbcTemplate() insertUser메소드 실행");
		Object[] args = {vo.getId(), vo.getPassword(), vo.getName(), vo.getRole()};
		getJdbcTemplate().update(USER_INSERT, args);
	}
	
	public void userDelete(UserVO vo) {
		System.out.println("getJdbcTemplate() deleteUser메소드 실행");
		getJdbcTemplate().update(USER_DELETE, vo.getId());
	}
	
}
