package svc;

import static db.JdbcUtil.*;
import java.sql.Connection;
import dao.LoginDAO;
import vo.Member;
public class LoginService {

	public Member getLoginMember(String id, String passwd) {
		LoginDAO loginDAO = LoginDAO.getInstance(); //&100
		Connection con = getConnection(); //static db.JdbcUtil.*;  //&200
		loginDAO.setConnection(con);
		
		
		//////////////////////////
		Member loginMember = loginDAO.selectLoginMember(id,passwd); //초기화된 Member vo클래스
		close(con);
		return loginMember;
	}
	
}








