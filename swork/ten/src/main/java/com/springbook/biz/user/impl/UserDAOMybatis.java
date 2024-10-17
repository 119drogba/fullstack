package com.springbook.biz.user.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springbook.biz.user.UserVO;

@Repository
public class UserDAOMybatis {
	@Autowired
	private SqlSessionTemplate mybatis;
	/*
	 *  insert문 => insert메소드사용 insert("맵퍼객체명.쿼리객체명", 바인드변수를 담고있는 변수나 객체);
	 *  delete문 => delete메소드사용 delete("맵퍼객체명.쿼리객체명", 바인드변수를 담고있는 변수나 객체);
	 *  update문 => update메소드사용 update("맵퍼객체명.쿼리객체명", 바인드변수를 담고있는 변수나 객체);
	 *  select 1줄 => selectOne("맵퍼객체명.쿼리객체명", 바인드변수를 담고있는 변수나 객체);
	 *  select 여러줄 => selectList("맵퍼객체명,쿼리객체명", 바인드변수를 담고있는 변수나 객체);
	 */
	
	
	public UserVO getUser(UserVO vo) {
		
		return mybatis.selectOne("UserDAO.getUser", vo);
	}
	
	public int joinUser(UserVO vo) {
		return mybatis.insert("UserDAO.joinUser", vo);
	}
	
	public int delUser(UserVO vo) {
		return mybatis.delete("UserDAO.delUser",vo);
		
	}
	
	public int updateUser(UserVO vo) {
		return mybatis.update("UserDAO.updateUser",vo);
	
	}
	
	public UserVO selUser(UserVO vo) {
		return mybatis.selectOne("UserDAO.selUser", vo);
	}
	
	
	public List<UserVO> userList(String keyword){
		return mybatis.selectList("UserDAO.userList", keyword );
		
		
		
	}
}
