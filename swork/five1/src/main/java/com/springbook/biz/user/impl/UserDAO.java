package com.springbook.biz.user.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.springbook.biz.common.JDBCUtil;
import com.springbook.biz.user.UserVO;

@Repository
public class UserDAO {
	private Connection conn;
	private PreparedStatement ps ;
	private ResultSet rs;
	
	//로그인
	public final String USER_LOGIN = "SELECT * FROM USERS WHERE ID = ? AND PASSWORD = ?";
	
	public UserVO login(UserVO vo) {
		System.out.println("user의 DAO login실행");
		UserVO uvo = null;
		try {
			conn = JDBCUtil.getConnection();
			ps = conn.prepareStatement(USER_LOGIN);
			ps.setString(1, vo.getId());  //"admin"
			ps.setString(2, vo.getPassword()); //"1111"
			rs = ps.executeQuery();
			if(rs.next()) {
				uvo = new UserVO();
				uvo.setId(rs.getString("ID"));
				uvo.setPassword(rs.getString("PASSWORD"));
				uvo.setName(rs.getString("NAME"));
				uvo.setRole(rs.getString("ROLE"));
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(rs, ps, conn);
		}
		return uvo;
	}
	
	
	//회원목록
	public final String USER_LIST ="SELECT * FROM USERS ORDER BY ID " ;
	public List<UserVO> getUserList(){
		List<UserVO> userList = new ArrayList<UserVO>();
		try {
			conn = JDBCUtil.getConnection();
			ps = conn.prepareStatement(USER_LIST);
			rs = ps.executeQuery();
			while(rs.next()) {
				UserVO uvo = new UserVO();
				uvo.setId(rs.getString("ID"));
				uvo.setPassword(rs.getString("PASSWORD"));
				uvo.setName(rs.getString("NAME"));
				uvo.setRole(rs.getString("ROLE"));
				userList.add(uvo);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(rs, ps, conn);
		}
		
		return userList;
	}
	
	
	//회원수정
	public final String USER_UPDATE = "UPDATE USERS SET PASSWORD = ? , NAME =?, ROLE = ? WHERE ID = ?";
	public int userUpdate(UserVO vo) {
		int cnt  = 0;
		try {
			conn = JDBCUtil.getConnection();
			ps = conn.prepareStatement(USER_UPDATE);
			ps.setString(1, vo.getPassword());
			ps.setString(2, vo.getName());
			ps.setString(3, vo.getRole());
			ps.setString(4, vo.getId());
			cnt = ps.executeUpdate();
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(ps, conn);
		}
		return cnt;
	}
	
	//회원가입
	public final String USER_INSERT = "INSERT INTO USERS VALUES (?, ? ,?, ?)";
	public int userInsert(UserVO vo) {
		int cnt  = 0;
		try {
			conn = JDBCUtil.getConnection();
			ps = conn.prepareStatement(USER_INSERT);
			ps.setString(1, vo.getId());
			ps.setString(2, vo.getPassword());
			ps.setString(3, vo.getName());
			ps.setString(4, vo.getRole());
			cnt = ps.executeUpdate();
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(ps, conn);
		}
		return cnt;
	}
	
	//회원 탈퇴
	public final String USER_DELETE = "DELETE FROM USERS WHERE ID = ? AND PASSWORD = ?";
	public int userDelete(UserVO vo) {
		int cnt  = 0;
		try {
			conn = JDBCUtil.getConnection();
			ps = conn.prepareStatement(USER_DELETE);
			ps.setString(1, vo.getId());
			ps.setString(2, vo.getPassword());
			cnt  = ps.executeUpdate();
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(ps, conn);
		}
		return cnt;
	}
	
}
