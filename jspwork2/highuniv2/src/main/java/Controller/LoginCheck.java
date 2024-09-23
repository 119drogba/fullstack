	package Controller;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.ProfessorDAO;
import DAO.StudentDAO;
import VO.ProfessorVO;
import VO.StudentVO;
import util.JdbcUtil;

public class LoginCheck extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 로그인 폼에서 입력받은 아이디, 비밀번호, 역할을 가져옵니다.
        String id = request.getParameter("id");
        String password = request.getParameter("password");
        String role = request.getParameter("role");

        HttpSession session = request.getSession();

        Connection con = null;
        try {
            con = JdbcUtil.getConnection(); // 데이터베이스 연결

            if ("student".equals(role)) {
                // 학생 로그인 처리
                StudentDAO studentDAO = StudentDAO.getInstance();
                studentDAO.setConnection(con);
                StudentVO student = studentDAO.authenticate(id, password);

                if (student != null) {
                    // 로그인 성공 시 세션에 정보 저장
                    session.setAttribute("student_id", student.getStudent_id());
                    session.setAttribute("name", student.getStudent_name());
                    session.setAttribute("role", "student");
                    response.sendRedirect("main.jsp"); // 학생 메인 페이지로 리다이렉트
                } else {
                    // 로그인 실패 시
                    response.sendRedirect("login.jsp?error=invalid");
                }
            
            } else if ("professor".equals(role)) {
                // 교수 로그인 처리
                ProfessorDAO professorDAO = ProfessorDAO.getInstance();
                professorDAO.setConnection(con);
                ProfessorVO professor = professorDAO.authenticate(id, password);

                if (professor != null) {
                    // 로그인 성공 시 세션에 정보 저장
                    session.setAttribute("professor_id", professor.getProfessor_id());
                    session.setAttribute("name", professor.getProfessor_name());
                    session.setAttribute("role", "professor");
                    response.sendRedirect("professorMain.jsp"); // 교수 메인 페이지로 리다이렉트
                } else {
                    // 로그인 실패 시
                    response.sendRedirect("login.jsp?error=invalid");
                }
            } else {
                // 역할이 유효하지 않은 경우
                response.sendRedirect("login.jsp?error=invalidRole");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("login.jsp?error=exception");
        } finally {
            if (con != null) try { con.close(); } catch (Exception ignore) {}
        }
    }
}