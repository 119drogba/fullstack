package dbc1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertTest {
//멤버필드들
	private Connection con;
	private Statement st;
	private PreparedStatement ps;
	private ResultSet rs;

	public static void main(String[] args) {
		new InsertTest(1, "Tom", 100);
		new InsertTest(2, "Javaking", 500);

	}

//기타 생성자
	public InsertTest(int empno, String ename, double sal) {

		try {
			User user = new User();
			Class.forName(user.getDriver());
			con = DriverManager.getConnection(user.getUrl(), user.getUser(), user.getPwd());
			System.out.println("DB 연결 성공");

			// insert into emp(empno, ename, sal) values(9999,'홍길동',5000)
			String sql = "insert into emp(empno,ename,sal)" + "values" + "(" + empno + ",'" + ename + "'," + sal + ")";
			st = con.createStatement();
			int result = st.executeUpdate(sql);
			// update, insert, delete는 executeUpdate() 메소드 사용 : 처리한 행 수 반환
			System.out.println("처리된 레코드 개수:" + result);
			st.close();

			sql = "insert into emp(empno,ename,sal) values (?,?,?)";
		//	sql = "insert into emp(empno,ename,sal) values (:a,:b,:c)";
			ps = con.prepareStatement(sql);

			ps.setInt(1, 9999);
			ps.setString(2, "TEST");
			ps.setDouble(3, 2500.0);
			int rowCount = ps.executeUpdate();
			ps.close();

		} catch (ClassNotFoundException e) {
			System.out.println(e + "=>드라이버 로드 실패");
		} catch (SQLException e) {
			System.out.println(e + "=>Sql 예외");

		} catch (Exception e) {
			System.out.println(e + "=>일반 예외");
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				System.out.println("연결객체닫기 오류");
			}
		}

	}

	public InsertTest(int empno, String ename, String string) {
		// TODO Auto-generated constructor stub
	}
}
