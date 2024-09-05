package com.model;

import java.sql.*;
import javax.naming.*;
import javax.sql.DataSource;
//Member테이블의 데이터에 접근하기 위한 SQL쿼리문을 담고 있는 클래스 생성

public class MemberDAO {

	private Connection conn = null;

	private Connection getConnect() {
		try {
			Context ctx = new InitialContext();
			DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/OracleDB");
			conn = ds.getConnection();
		} catch (Exception n) {
			System.out.println(n);
		}
		return conn;
	}
	//로그인 메소드
	public MemberVO login(String id, String pw) {
		String sql = "select * from member where id = ? and password=? ";
		PreparedStatement ps = null;
		ResultSet rs = null;
		getConnect();
		MemberVO vo = null;

		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, pw);
			rs = ps.executeQuery();
			if (rs.next()) {
				vo = new MemberVO();
				vo.setAddress(rs.getString("ADDRESS"));
				vo.setBirth(rs.getString("BIRTH"));
				vo.setGender(rs.getString("GENDER"));
				vo.setId(rs.getString("ID"));
				vo.setMail(rs.getString("MAIL"));
				vo.setName(rs.getString("NAME"));
				vo.setPassword(rs.getString("PASSWORD"));
				vo.setPhone(rs.getString("PHONE"));
				vo.setRegist_day(rs.getString("REGIST_DAY"));
			}

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (ps != null)
					ps.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return vo;
	}
}