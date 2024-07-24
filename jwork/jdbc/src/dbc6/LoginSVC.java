package dbc6;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginSVC {

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
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			con = DriverManager.getConnection(url, "TEST", "1111");
			System.out.println("Connection Success!");
		} catch (SQLException se) {
			se.printStackTrace();
		}
	}

	// 로그인, 나의 정보 메뉴
	public User login(String id, String passwd) {
		User user = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			connect();
			stmt = con.createStatement();
//  "SELECT * FROM member1 WHERE id = '' AND passwd = ''";		

			String sql = "SELECT * FROM member1 WHERE id = '" + id + "' AND passwd = '" + passwd + "'";
			rs = stmt.executeQuery(sql);
			if (rs.next()) { // 첫번째 줄 있으면 rs에 담음 한줄씩
				String name = rs.getString("name");
				int age = rs.getInt("age");
				String addr = rs.getNString("addr");
				String email = rs.getNString("email");
				user = new User(id, passwd, name, age, addr, email);
			}
		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			try {
				rs.close();
				stmt.close();
				con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return user;
	}

	// 회원가입 메뉴(insert)
	public int insertMember(String id, String passwd, String name) {
		connect();
		PreparedStatement ps = null;
		String sql = "insert into member1 (id,passwd, name) values (?,?,?)";
		int cnt = 0;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, passwd);
			ps.setString(3, name);
			cnt = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return cnt;
	}
//회원탈퇴 (delete)

	public int deleteMember(String id) {
		connect();
		PreparedStatement ps = null;
		String sql = "delete from member1 where id=?";
		int cnt = 0;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			cnt = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cnt;
	}

}
