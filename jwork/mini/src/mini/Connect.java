package mini;

import java.sql.*;

public class Connect{
	static{
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {

		}
	}

	public static Connection getConnection() {
		Connection con = null;
		try {
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			con = DriverManager.getConnection(url, "lms", "1111");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
}
