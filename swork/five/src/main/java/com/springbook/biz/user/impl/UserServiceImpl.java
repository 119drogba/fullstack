package com.springbook.biz.user.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbook.biz.user.UserService;
import com.springbook.biz.user.UserVO;

@Service("userService")
public class UserServiceImpl implements UserService {
	@Autowired
	UserDAO dao;	
	
	@Override
	public UserVO login(UserVO vo) {
		System.out.println("포인트컷메소드");
		return dao.login(vo);
	}

	@Override
	public List<UserVO> getUserList() {
		return dao.getUserList();
	}

	@Override
	public int userUpdate(UserVO vo) {
		return dao.userUpdate(vo);
	}

	@Override
	public int userInsert(UserVO vo) {
		return dao.userInsert(vo) ;
	}

	@Override
	public int userDelete(UserVO vo) {
		return dao.userDelete(vo);
	}

}
