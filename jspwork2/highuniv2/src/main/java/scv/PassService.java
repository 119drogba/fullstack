package scv;

import static util.JdbcUtil.close;
import static util.JdbcUtil.getConnection;

import java.sql.Connection;

import DAO.StudentDAO;
import VO.StudentVO;

public class PassService {
	
	public StudentVO selectStudent(String student_id) {
		StudentVO student = null;
		
		Connection con =getConnection();
		StudentDAO studentDAO = StudentDAO.getInstance();
		studentDAO.setConnection(con);
		student = studentDAO.selectStudent(student_id);
		close(con);
		
		return student;
	}

}
