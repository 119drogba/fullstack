package dbc2;

import java.sql.*;

public class Ex05 {
	static PreparedStatement ps;
	static ResultSet rs;
	static Connection conn;
	static String tname = "TB_TEST";

	public static int cntResult(Connection conn) throws SQLException {

		String sql = "SELECT COUNT(*) AS CNT FROM USER_TABLES WHERE TABLE_NAME=?";
		ps = conn.prepareStatement(sql);
		ps.setString(1, tname);
		rs = ps.executeQuery();

		int cnt = 0;
		while (rs.next()) {
			cnt = rs.getInt("cnt");
		}

		return cnt;
	}

	public static void main(String[] args) {
		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String id = "test";
			String pass = "1111";

			Connection conn = DriverManager.getConnection(url, id, pass);
			System.out.println("데이터베이스 연결 성공");
			
			
//			Statement st = conn.createStatement();
//			boolean tf = st.execute("select * from dept");
//			if(tf ) {
//				System.out.println("결과 성공");
//			}else {
//				System.out.println("결과 실패");
//			}

			PreparedStatement ps;
			ResultSet rs = null;

			String sql = "SELECT COUNT(*) AS CNT FROM USER_TABLES WHERE TABLE_NAME=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, tname);
			rs = ps.executeQuery();
	

			int cnt = cntResult(conn);

			if (cnt <= 0) {
				sql = "CREATE TABLE" + tname;
				sql += "(TEST1 VARCHAR(10) PRIMARY KEY,";
				sql += "TEST2 NUMBER NOT NULL)";
				System.out.println(sql + "문 실행!");

				boolean tf = ps.execute(sql);
				cnt = cntResult(conn);

				if (cnt > 0)
					System.out.println("테이블 생성 성공");
				else
					System.out.println("테이블생성실패");

			} else {
				System.out.println("테이블이 이미 생성되어 있습니다.");
			}

			rs.close();
			ps.close();
			conn.close();

		} catch (ClassNotFoundException e) {
			System.out.println("예외: 드라이버 로드 실패" + e.getMessage());
			e.printStackTrace();

		} catch (SQLException e) {
			System.out.println("예외:" + e.getMessage());
			e.printStackTrace();

		}

	}

}
