package com.springbook.biz.user.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbook.biz.user.UserService;
import com.springbook.biz.user.UserVO;

@Service("userService")
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDAODBCP userDAO;
	

	
	@Override
	public UserVO login(UserVO vo) {
		return userDAO.login(vo);
	}

	@Override
	public List<UserVO> getUserList() {
		return userDAO.getUserList();
	}

	@Override
	public void userUpdate(UserVO vo) {
		userDAO.userUpdate(vo);
	}

	@Override
	public void userInsert(UserVO vo) {
		userDAO.userInsert(vo) ;
	}

	@Override
	public void userDelete(UserVO vo) {
		userDAO.userDelete(vo);
	}

}
