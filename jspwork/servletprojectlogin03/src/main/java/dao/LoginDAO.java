package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import vo.Member;
import static db.JdbcUtil.*;

public class LoginDAO {
	private static LoginDAO loginDAO; // null => &100
	private Connection con; //null => &200 (open => close)
	
	private LoginDAO() {}
	
	public static LoginDAO getInstance(){
		if(loginDAO == null){
			loginDAO = new LoginDAO(); //&100
		}
		return loginDAO;
	}
	
	public void setConnection(Connection con){ //&200
		this.con = con;
	}
	
	public Member selectLoginMember(String id, String passwd) {
		Member loginMember = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = con.prepareStatement("SELECT * FROM users WHERE id = ? AND passwd = ?");
			pstmt.setString(1, id);
			pstmt.setString(2, passwd);
			rs = pstmt.executeQuery();
			if(rs.next()){  
				
				loginMember = new Member();//데이터베이스의 한줄 데이터를 받아오기 위한 객체 생성
				loginMember.setAddr(rs.getString("addr"));
				loginMember.setAge(rs.getInt("age"));
				loginMember.setEmail(rs.getString("email"));
				loginMember.setGender(rs.getString("gender"));
				loginMember.setId(rs.getString("id"));
				loginMember.setName(rs.getString("name"));
				loginMember.setNation(rs.getString("nation"));
				loginMember.setPasswd(rs.getString("passwd"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			try {
				close(rs);
				close(pstmt);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return loginMember;
	}
	
}




