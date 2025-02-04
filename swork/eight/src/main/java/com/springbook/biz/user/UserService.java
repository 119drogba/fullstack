package com.springbook.biz.user;

import java.util.List;

public interface UserService {
	public List<UserVO> getUserList(String keyword);
	public UserVO selUser(UserVO vo);
	
	public UserVO login(UserVO vo);
	public void userUpdate(UserVO vo);
	public void userInsert(UserVO vo);
	public void userDelete(UserVO vo);

}
