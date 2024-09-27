package Controller;

import dao.SubjectDAO;
import vo.Subject;
import static util.JdbcUtil.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet("/EditLectureServlet")
public class EditLectureServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String subjectId = request.getParameter("subjectId");
        Subject subject = null;
        
        Connection conn = getConnection();
        
        
        if (subjectId != null) {
        	// 강의 정보를 불러오기
	        SubjectDAO subjectDAO = SubjectDAO.getInstance();
	        subjectDAO.setConnection(conn);
	        subject = subjectDAO.getSubject(subjectId);
	       // close(conn);
        }
        
        if (subject != null) {
         // JSP로 강의 정보 전달
        request.setAttribute("subject", subject);
        RequestDispatcher dispatcher = request.getRequestDispatcher("editLecture.jsp");
        dispatcher.forward(request, response);
	    } else {
		    // subjectId가 없을 경우 처리
	    	
		    response.sendRedirect("ProfessorLectureServlet");
		}
}



    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// 요청과 응답의 인코딩을 UTF-8로 설정
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");

        // 폼에서 전달된 값들 받기
        String subjectId = request.getParameter("subjectId");
        String subjectName = request.getParameter("subjectName");
        String subjectContent = request.getParameter("subjectContent");
        String subjectDay = request.getParameter("subjectDay");
        String subjectStartTime = request.getParameter("subjectStartTime");
        String subjectEndTime = request.getParameter("subjectEndTime");
        int subjectCredit = Integer.parseInt(request.getParameter("subjectCredit"));

        // Subject 객체 생성 및 값 설정
        Subject subject = new Subject();
        subject.setSUBJECT_ID(subjectId);
        subject.setSUBJECT_NAME(subjectName);
        subject.setSUBJECT_CONTENT(subjectContent);
        subject.setSUBJECT_DAY(subjectDay);
        subject.setSUBJECT_STARTTIME(subjectStartTime);
        subject.setSUBJECT_ENDTIME(subjectEndTime);
        subject.setSUBJECT_CREDIT(subjectCredit);
        
        Connection conn = null;
        try {
            // 데이터베이스 연결
            conn = getConnection();
            conn.setAutoCommit(false); // 자동 커밋 비활성화
           
        // SubjectDAO를 통해 데이터베이스 업데이트 수행
        SubjectDAO subjectDAO = SubjectDAO.getInstance();
        subjectDAO.updateSubject(conn, subject);
        
        conn.commit(); // 트랜잭션 커밋


        // 수정 후 강의 목록으로 포워드 (forward)
        request.getRequestDispatcher("/ProfessorLectureServlet").forward(request, response);
    }catch (Exception e) {
    	 // 예외 발생 시 롤백
        if (conn != null) {
            try {
                conn.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        e.printStackTrace(); // 예외 스택 트레이스 출력
    } finally {
        close(conn); // 자원 해제
    }
}}
