package dbc4;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

//DAO(=Data Access Object) : SQL 명령문을 담고 있는 클래스
public class TB_MEMBER_DAO {

	// --회원 로그인 체크
	// apple,1111

	public TB_MEMBER_VO login(String m_userid, String m_pwd) {
		System.out.println(m_userid + "," + m_pwd);
		String sql = "SELECT * FROM TB_MEMBER " + " WHERE M_YN= 'Y'AND M_USERID=? AND M_PWD=?";
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		TB_MEMBER_VO tvo = null;

		try {

			con = DBConnec1.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, m_userid);
			ps.setString(2, m_pwd);
			rs = ps.executeQuery();

			if (rs.next()) {
				System.out.println("vo에 데이터 담기");
				tvo = new TB_MEMBER_VO();
				tvo.setM_seq(rs.getInt("M_SEQ"));
				tvo.setM_userid(rs.getString("M_USERID")); // apple
				tvo.setM_pwd(rs.getString("M_PWD"));
				tvo.setM_email(rs.getString("M_EMAIL"));
				tvo.setM_hp(rs.getString("M_HP"));
				tvo.setM_registdate(rs.getString("M_REGISTDATE"));
				tvo.setM_point(rs.getInt("M_POINT"));
				tvo.setM_yn(rs.getString("M_YN"));

			}

		} catch (Exception e) {

		} finally {
			try {
				if (rs != null)
					rs.close();
				if (ps != null)
					ps.close();
				DBConnec1.close();

			} catch (SQLException e) {
			}

		}
		return tvo;
	}

	public ArrayList<TB_MEMBER_VO> memberList() {

		String sql = "select * from tb_member";
		ArrayList<TB_MEMBER_VO> mList = new ArrayList<>();
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;

		try {
			con = DBConnec1.getConnection();
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {

				TB_MEMBER_VO tvo = new TB_MEMBER_VO();

				tvo.setM_seq(rs.getInt("M_SEQ"));
				tvo.setM_userid(rs.getString("M_USERID")); // apple
				tvo.setM_pwd(rs.getString("M_PWD"));
				tvo.setM_email(rs.getString("M_EMAIL"));
				tvo.setM_hp(rs.getString("M_HP"));
				tvo.setM_registdate(rs.getString("M_REGISTDATE"));
				tvo.setM_point(rs.getInt("M_POINT"));
				tvo.setM_yn(rs.getString("M_YN"));
				mList.add(tvo);
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				// 객체 담기 conn, ps, st, re
				rs.close();
				st.close();
				DBConnec1.close();

			} catch (SQLException e) {

				System.out.println(e.getMessage());

			}

		}
		return mList;

	}

	// 회원가입
	// insert into tb_member (M_SEQ, M_USERID, M_PWD,M_EMAIL,M_HP,M_YN)
	// values (SEQ_TB_MEMBER.NEXTVAL, ?,?,?,?);

	public int join(String m_userid, String m_pwd, String m_email, String m_hp) {
		String sql = "insert into tb_member (M_SEQ, M_USERID, M_PWD,M_EMAIL,M_HP)";
		sql += " values (SEQ_TB_MEMBER.NEXTVAL , ?,?,?,?)";

		Connection con = null;
		PreparedStatement ps = null;
		int rowCount = 0;

		try {
			con = DBConnec1.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, m_userid);
			ps.setString(2, m_pwd);
			ps.setString(3, m_email);
			ps.setString(4, m_hp);
			rowCount = ps.executeUpdate();

		} catch (Exception e) {

			System.out.println(e.getMessage());

		} finally {
			try {

				if (ps != null)
					ps.close();
				DBConnec1.close();

			} catch (SQLException e) {

				System.out.println(e.getMessage());
			}
		}

		return rowCount;
	}

	public int notUse(String m_userid) {
		String sql = "UPDATE TB_MEMBER SET M_YN = 'N' WHERE M_USERID = ?";
		Connection con = null;
		PreparedStatement ps = null;
		int rowCount = 0;

		try {
			con = DBConnec1.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, m_userid);
			rowCount = ps.executeUpdate();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try { if (ps != null)
				ps.close();
			DBConnec1.close();

			} catch (SQLException e) {
				
				System.out.println(e.getMessage());
			}
		}
		return rowCount;
	}

}
