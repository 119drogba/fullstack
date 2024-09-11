package dao;

import static util.JdbcUtil.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.sql.DataSource;

import com.dto.StudentVO;

public class StudentDAO {
	public static StudentDAO instance;
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	DataSource ds;
	private StudentDAO() {
		
	}
	public static StudentDAO getInstance(){
		if(instance == null){
			instance = new StudentDAO();
		}
		return instance;
	}
	public void setConnection(Connection con){
		this.con = con;
	}
	
	public int insertStudent(StudentVO stu) {
		pstmt =  null;
		String sql ="";
		int insertCount = 0;
		
		try {
			sql = "insert into student (student_id, student_pw , student_name, student_email, student_ph, student_birth, student_intoday, student_year, student_major, student_address, student_gender, student_status, student_use, student_image)";
			sql += "values (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, stu.getStudent_id());
			pstmt.setString(2, stu.getStudent_pw());
			pstmt.setString(3, stu.getStudent_name());
			pstmt.setString(4, stu.getStudent_email());
			pstmt.setString(5, stu.getStudent_ph());
			pstmt.setString(6, stu.getStudent_birth());
			pstmt.setString(7, stu.getStudent_intoday());
			pstmt.setInt(8, stu.getStudent_year());
			pstmt.setString(9, stu.getStudent_major());
			pstmt.setString(10, stu.getStudent_address());
			pstmt.setString(11, stu.getStudent_gender());
			pstmt.setString(12, stu.getStudent_status());
			pstmt.setString(13, stu.getStudent_use());
			pstmt.setString(14,stu.getStudent_image());
			
			insertCount = pstmt.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("StudentInsert 에러 : "+e);
		}finally {
			close(pstmt);
		}
		return insertCount;
	}
	
}
