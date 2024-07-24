package dbc2;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Ex01 {


	public static void main(String[] args) {
		Connection conn = null;
		Statement st = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			// 1.드라이버 설치
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// 2. Connection객체 생성

			String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
			String user = "test";
			String pw = "1111";
			conn = DriverManager.getConnection(url, user, pw);
			System.out.println("DB Connected Success!");

			// 3. 명령문 객체 생성
			String sql = "SELECT empno,ename,job,hiredate FROM emp where deptno=10";
			 st = conn.createStatement();
			// PreparedStatement = > PrepareStatement()
			// PreparedStatement ps = conn.prepareStatement("select * from DEPT where DEPTNO
			// =?");
			// SELECT * FROM DEPT

			String sql1 = "SELECT empno,ename,job,hiredate FROM emp where deptno=?";
			 ps = conn.prepareStatement(sql1);

			// 4. 명령문 객체 실행
			 rs = st.executeQuery(sql);

			ps.setInt(1, 10);
			rs = ps.executeQuery();

			while (rs.next()) {

				System.out.printf("%d \t %s \t %s \n", rs.getInt("EMPNO"), rs.getString("ename"), rs.getString("job"),
						rs.getString("hiredate"));
			}

			rs.close();
			st.close();
			conn.close();

		} catch (ClassNotFoundException e) {
			
		}catch (SQLException e) {

		} finally {
			// 5.객체 닫기
			try {
				if(rs!=null) rs.close();
				if(ps!=null)ps.close();
				if(st!=null)st.close();
				if(conn!=null)conn.close();

			} catch (Exception e) {
				System.out.println("객체닫기오류");

			}
		}

	}

}
