package svc;

import java.util.List;

import static util.JdbcUtil.close;
import static util.JdbcUtil.commit;
import static util.JdbcUtil.getConnection;
import static util.JdbcUtil.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import dao.SubjectDAO;
import vo.Subject;

public class SubjectService {
    private SubjectDAO subjectDAO;


    // 모든 강의 목록 가져오기
    public List<Subject> getAllSubjects() {
		Connection con = getConnection();
		SubjectDAO subjectDAO = SubjectDAO.getInstance();
		subjectDAO.setConnection(con);
		
		List<Subject> subject = null;
		
		subject = subjectDAO.getAllSubjects();
		
		close(con);
		
		return subject;
    }

    // 강의 추가 메서드
    public boolean addSubject(Subject subject) {
        return subjectDAO.addSubject(subject);
    }

    // 강의 삭제 메서드
    public boolean deleteSubject(String subjectId) {
    	Connection con = getConnection();
		SubjectDAO subjectDAO = SubjectDAO.getInstance();
		subjectDAO.setConnection(con);
    	
		boolean tf = subjectDAO.deleteSubject(subjectId);
		
		if(tf) {
			commit(con);		
		}else {
			rollback(con);
		}
		
		
		close(con);
		
        return tf;
    }
}
