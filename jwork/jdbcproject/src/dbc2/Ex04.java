package dbc2;

import java.sql.*;

public class Ex04 {

	public static void main(String[] args) {

		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String user = "TEST";
		String pass = "1111";
		Connection con = null;

		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, pass);

			// DatebaseMetaData는 Connection getMetaData()를 이용, instance를 얻고
			// 해당 객체를 이용하여 DBMS에 관련된 사항을 얻을 수 있다.
			DatabaseMetaData data = con.getMetaData();
			System.out.println("1.데이터베이스종류:" + data.getDatabaseProductName());
			System.out.println("2.데이터베이스 버전정보:" + data.getDatabaseProductVersion());
			System.out.println("3.데이터베이스 드라이버명 :" + data.getDriverName());
			System.out.println("4.데이터베이스 url정보 :" + data.getURL());
			System.out.println("5.데이터베이스 연결된 계정정보 :" + data.getUserName());

			// 현재 데이터베이스에서 사용할 수 있는 스키마 이름들(계정명들)을 검색함.
			ResultSet rs = data.getSchemas();

			while (rs.next()) {
				System.out.println("계정명:" + rs.getString(1));
			}

			rs.close();

		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

}
