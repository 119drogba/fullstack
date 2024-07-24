package dbc1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteTest {

	public static void main(String[] args) {
		new DeleteTest(2);

	}

	private Connection con;
	private Statement st;
	private PreparedStatement ps;
	private ResultSet rs;

	public DeleteTest(int empno) {
		try {
			User user = new User();
			Class.forName(user.getDriver());
			con = DriverManager.getConnection(user.getUrl(), user.getUser(), user.getPwd());
			System.out.println("DB 연결 성공");
			String sql = "delete from emp where empno=" + empno;
			st = con.createStatement();
			int result = st.executeUpdate(sql);
			System.out.println("처리된 레코드 개수:" + result);
			st.close();

			//preparedStatement ps = conn.prepareStatement("delete from emp where empno= ?");
			//ps.setInt(1,empno);
			//rowCount =ps.ps.executeUpdate();
			
			
			
			sql = "delete from emp where empno= ?";
			//sql = "delete from emp where empno=:a";
			ps = con.prepareStatement(sql);
			ps.setInt(1, 2);

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

}
