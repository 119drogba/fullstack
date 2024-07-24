package dbc1;

import java.sql.*;

import java.util.Date;

public class FirstJDBC {

	public static void main(String[] args) {
		try {
			// 오라클 드라이버 설치
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Driver Loading Success!");

			// Connection 객체 생성
			String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
			String user = "test";
			String pw = "1111";
			Connection conn = DriverManager.getConnection(url, user, pw);
			System.out.println("DB Connected Success!");

			// Statement 객체 생성(명령문담고 실행할 수 있는 객체 생성)
//			Statement st = conn.createStatement();
//			//PreparedStatement = > PrepareStatement()
//			PreparedStatement ps = conn.prepareStatement("select * from DEPT where DEPTNO =?");
			// SELECT * FROM DEPT
			ResultSet ps = st.executeQuery("SELECT * FROM EMP WHERE DEPTNO=10 and DNAME =?");
			ps.setInt(1,20);
			ps.setString(2,"RESEARCH")
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				
				int dno = rs.getInt(1);
				String dnm = rs.getString(2);
				String loc = rs.getNString(3);
				System.out.println(dno+","+dnm+","+loc);
				// 10 ACCOUNTING NEW YORK
				// 20 RESEARCH DALLS
				// 30 SALES CHICAGO
				// 40 OPERATIONS BOSTON
				int EMPNO = rs.getInt("EMPNO");
				String ENAME = rs.getString("ENAME");
				String JOB = rs.getString("JOB");
				int MGR = rs.getInt("MGR");
				Date HIREDATE = rs.getDate("HIREDATE");
				double SAL = rs.getDouble("SAL");
				double COMM = rs.getDouble("COMM");
				int deptno = rs.getInt("DEPTNO");

				System.out.println(EMPNO + " " + ENAME + " " + JOB + " " + MGR + " " + HIREDATE + " " + SAL + " " + COMM
						+ " " + " " + deptno);
			}

			rs.close();
	 st.close();
			conn.close();
			
			
		} catch (ClassNotFoundException e) {

			System.out.println("드라이버 오류입니다.");
		} catch (SQLException e) {
			System.out.println("SQL명령 오류 및 Connection객체 오류입니다.");
		}

	}

}
