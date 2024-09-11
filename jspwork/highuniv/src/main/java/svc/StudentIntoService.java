package svc;

import static util.JdbcUtil.*;

import java.sql.Connection;

import dao.StudentDAO;
import com.dto.StudentVO;

public class StudentIntoService {
	public int insertStudent(StudentVO stu) {
		
		Connection con = getConnection();
		StudentDAO studentDAO = StudentDAO.getInstance();
		studentDAO.setConnection(con);
		
		int insertCount = studentDAO.insertStudent(stu);
		
		if(insertCount>0) {
			commit(con);
			System.out.println("DB입력성공");
		}else {
			rollback(con);
			System.out.println("DB입력실패");
		}
		
		close(con);
		
		return insertCount; 
	}
}
