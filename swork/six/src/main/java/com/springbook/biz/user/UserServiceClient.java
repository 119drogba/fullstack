package com.springbook.biz.user;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class UserServiceClient {

	public static void main(String[] args) {
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("applicationContext.xml");
		UserService userService = (UserService) ctx.getBean("userService");
		
		//로그인
		UserVO vo = new UserVO();
		vo.setId("admin");
		vo.setPassword("1111");
		vo = userService.login(vo);
		if(vo!=null) System.out.println("로그인정보: "+vo);
		else System.out.println("로그인 실패");
		
		//회원 목록
		List<UserVO> uList = userService.getUserList();
		for(UserVO uvo : uList) {
			System.out.println(uvo);
		}
		
		//회원가입(INSERT INTO USERS VALUES (?, ? ,?, ?)) 
		//UserVO 
//		vo.setId("duly");
//		vo.setPassword("1234");
//		vo.setName("둘리");
//		vo.setRole("User");
//		
//		int cnt = userService.userInsert(vo);
//		if(cnt > 0) System.out.println("회원등록완료");
//		else System.out.println("회원등록실패");
		
		//회원탈퇴 (DELETE FROM USERS WHERE ID = ? AND PASSWORD = ?)
//		vo.setId("duly");
//		vo.setPassword("1234");
//		int cnt = userService.userDelete(vo) ;
//		if(cnt > 0) System.out.println("회원탈퇴완료");
//		else System.out.println("회원탈퇴실패");
		
		
		//회원수정"UPDATE USERS SET PASSWORD = ? , NAME =?, ROLE = ? WHERE ID = ?";
		vo.setPassword("1234");
		vo.setName("고길동");
		vo.setRole("Admin");
		vo.setId("user1");
		userService.userUpdate(vo);
		
		ctx.close();
	}

}













