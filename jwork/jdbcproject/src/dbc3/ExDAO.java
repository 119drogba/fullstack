package dbc3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ExDAO {
	// 멤버필드 선언 및 초기화

	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
	String userid = "test";
	String passwd = "1111";

//기본 생성자 선언문
	public ExDAO() {   //2
		try {
			Class.forName(driver);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

//selece() 메소드 선언문

	public ArrayList<ExDTO> select() {
		ArrayList<ExDTO> list = new ArrayList<ExDTO>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = DriverManager.getConnection(url, userid, passwd);

			String query = "SELECT deptno,dname,loc FROM dept";
			pstmt = con.prepareStatement(query);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				ExDTO dto = new ExDTO();
				dto.setDeptno(rs.getInt("deptno"));
				dto.setDname(rs.getNString("dname"));
				dto.setLoc(rs.getNString("loc"));
				list.add(dto);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				con.close();

			} catch (SQLException e)

			{
				e.printStackTrace();
			}
		}

		return list;

	}

	public int insert(int deptno, String dname, String loc) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = DriverManager.getConnection(url, userid, passwd);
			String sql = "INSERT INTO dept (deptno,dname,loc)" + "VALUES (?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, deptno);
			pstmt.setString(2, dname);
			pstmt.setString(3, loc);
			int n = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			try {
				pstmt.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return deptno;
	}
}