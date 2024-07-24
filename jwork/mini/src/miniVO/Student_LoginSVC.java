package miniVO;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Student_LoginSVC {

	private Connection con;

	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void connect() {
		try {
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			con = DriverManager.getConnection(url, "LMS", "1111");
		} catch (SQLException se) {
			se.printStackTrace();
		}
	}

	// 학생 로그인 메서드
	public StudentVO login(Scanner sc) {
		System.out.print("아이디를 입력하세요: ");
		String s_id = sc.next();
		System.out.print("비밀번호를 입력하세요: ");
		String s_pwd = sc.next();
		connect();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		StudentVO user = null;

		try {

			String sql = "SELECT * FROM STUDENT WHERE s_id = ? AND s_pwd = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, s_id);
			pstmt.setString(2, s_pwd);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				String s_num = rs.getString("s_num");
				String s_name = rs.getString("s_name");
				String s_hire = rs.getString("s_hire");
				String s_state = rs.getString("s_state");

				user = new StudentVO(s_num, s_name, s_id, s_pwd, s_hire, s_state);
				System.out.println("로그인 성공! " + s_name + "님 환영합니다.");
			} else {
				System.out.println("로그인 실패! 아이디 및 비밀번호를 확인하세요.");
			}
		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return user;
	}
	public void studentmeber()  {
		connect();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT s_num, s_name, s_id, TO_CHAR(s_hire, 'YYYY-MM-DD') AS s_hire, s_state FROM student";
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			System.out.println("    학번       이름  아이디  입학일자      상태");
			while (rs.next()) {
				
				System.out.printf("%10s %5s %5s %5s %5s \n", rs.getString("s_num"), rs.getString("s_name"),
						rs.getString("s_id"), rs.getString("s_hire"),rs.getString("s_state"));
			}
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public StudentVO getstudent(String s_num) {
		StudentVO studentVO = null;
		connect();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from student where s_num=?";
		try {
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, s_num);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				String ds_num = rs.getString("s_num");
				String s_name = rs.getString("s_name");
				String s_id = rs.getString("s_id");
				String s_pwd = rs.getString("s_pwd");
				String s_hire = rs.getString("s_hire");
				String s_state = rs.getString("s_state");

				studentVO = new StudentVO(ds_num, s_name, s_id, s_pwd, s_hire, s_state);

			}
		} catch (Exception e) {

		}
		return studentVO;
	}

	// 학생 등록 메서드
	public int updateStudent(Scanner sc) {
		// 사용자 입력을 받습니다.
		System.out.print("학번을 입력하세요: ");
		String s_num = sc.next();
		System.out.print("아이디를 입력하세요: ");
		String s_id = sc.next();
		System.out.print("비밀번호를 입력하세요: ");
		String s_pwd = sc.next();
		System.out.print("이름을 입력하세요: ");
		String s_name = sc.next();

		connect(); // 데이터베이스 연결을 수행합니다.

		PreparedStatement pstmt = null;
		String sql = "UPDATE STUDENT SET s_id = ?, s_pwd = ?, s_name = ? , S_STATE = 'Y' "
				+ "WHERE s_num = ? and s_state = 'N' ";

		int cnt = 0;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, s_id);
			pstmt.setString(2, s_pwd);
			pstmt.setString(3, s_name);
			pstmt.setString(4, s_num);

			cnt = pstmt.executeUpdate(); // UPDATE 쿼리를 실행하고 영향을 받은 행 수를 반환합니다.

			if (cnt > 0) {
				System.out.println("학생 정보 업데이트 완료");
			} else {
				System.out.println("회원 가입이 실패하였습니다.");
				System.out.println("사유: 없는 학번이거나 중복 아이디");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// finally 블록에서 모든 리소스를 닫습니다.
			try {
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return cnt;
	}
}