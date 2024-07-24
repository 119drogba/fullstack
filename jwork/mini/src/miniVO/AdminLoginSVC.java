package miniVO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class AdminLoginSVC {
	Connection con;

	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void connect() {
		try {
			String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
			con = DriverManager.getConnection(url, "LMS", "1111");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 로그인 메뉴
	public AdminVO login(Scanner sc) {
		AdminVO adminVO = null;
		Statement stmt = null;
		ResultSet rs = null;

		System.out.print("아이디 입력 >> ");
		String a_id = sc.next().toLowerCase();

		System.out.print("비번 입력 >> ");
		String a_pwd = sc.next().toLowerCase();

		try {
			connect();
			stmt = con.createStatement();
			String sql = "select * from admin where a_id = '" + a_id + "' and " + "a_pwd = '" + a_pwd + "'";
			rs = stmt.executeQuery(sql);
			if (rs.next()) {
				String a_name = rs.getString("a_name");
				String a_roll = rs.getString("a_roll");
				String a_state = rs.getString("a_state");
				adminVO = new AdminVO(a_id, a_pwd, a_name, a_roll, a_state);
				System.out.println(a_name + "님 환영합니다.");
			} else {
				System.out.println("관리자가 아닙니다.");
			}
		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				if (con != null)
					con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return adminVO;
	}

	public void selectMember() {
		connect();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql3 = "select * from admin";
		try {
			pstmt = con.prepareStatement(sql3);
			rs = pstmt.executeQuery();
			System.out.println("아이디   비밀번호   이름    역할   상태");
			while (rs.next()) {
				System.out.printf("%5s %5s %5s %5s %5s \n", rs.getString("a_id"), rs.getString("a_pwd"),
						rs.getString("a_name"), rs.getString("a_roll"), rs.getString("a_state"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
	}

	// 회원가입 메뉴
	public void insertMember(Scanner sc) { // 회원가입
		connect();
		PreparedStatement ps = null;
		ResultSet rs = null;

		String a_id = null;
		while (true) {
			System.out.print("아이디 입력 >> ");
			a_id = sc.next().toLowerCase();
			if (!a_id.matches("[a-zA-Z0-9]+")) {
				System.out.println("영어 대소문자, 숫자만 입력 가능합니다.");
			} else {
				break;
			}
		}

		System.out.print("비번 입력 >> ");
		String a_pwd = sc.next().toLowerCase();

		sc.nextLine();

		String a_name = null;
		while (true) {
			System.out.print("이름 입력 >> ");
			a_name = sc.nextLine().toLowerCase();
			if (a_name.matches(".*[0-9]+.*")) {
				System.out.println("이름에는 숫자가 올 수 없습니다.");
			} else if (a_name.matches(".*[ㄱ-ㅎㅏ-ㅣ]+.*")) {
				System.out.println("한글은 자음만 또는 모음만 입력하실 수 없습니다.");
			} else if (!a_name.matches("^[가-힣a-zA-Z]+$")) {
				System.out.println("이름에는 숫자나 특수문자가 포함될 수 없습니다.");
			} else {
				break;
			}
		}

		try {
			String sql = "SELECT COUNT(*) FROM admin WHERE a_id = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, a_id);
			rs = ps.executeQuery();
			if (rs.next() && rs.getInt(1) > 0) {
				System.out.println("관리자등록 - 아이디 중복");
				System.out.println("가입 실패");
			} else {
				System.out.println("가입 성공");
			}
			ps.close();

			String sql2 = "INSERT INTO admin (a_id, a_pwd, a_name) VALUES (?, ?, ?)";

			ps = con.prepareStatement(sql2);
			ps.setString(1, a_id);
			ps.setString(2, a_pwd);
			ps.setString(3, a_name);
			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (ps != null)
					ps.close();
				if (con != null)
					con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

}
