package com.model;

public class MemberSVC {
	private MemberDAO dao = new MemberDAO();
	
	public MemberVO login(String id, String pw) {
		return dao.login(id,pw);
	}

	
	
}
