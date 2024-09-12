package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dto.StudentVO;

import svc.ModifyService;

@WebServlet("/StudentModify")
public class StudentModify extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("테스트 실행");

       
        request.setCharacterEncoding("utf-8");

        
        String email = request.getParameter("STUDENT_EMAIL");
        String phone = request.getParameter("STUDENT_PH");
        String zipcode = request.getParameter("zipcode");
        String addr1 = request.getParameter("addr1");
        String addr2 = request.getParameter("addr2");
        String comment = request.getParameter("comment");

       
        String studentId = (String)request.getSession().getAttribute("student_id");

       
        StudentVO student = new StudentVO();
        student.setStudent_id(studentId);
        student.setStudent_email(email);
        student.setStudent_ph(phone);
        student.setStudent_address(addr1 + " " + addr2 + " " + comment);

      
        ModifyService modifyService = new ModifyService();
        boolean isUpdated = modifyService.modifyStudentInfo(student);

       
        if (isUpdated) {
            System.out.println("수정 성공");
            response.sendRedirect("mypage.jsp"); 
        } else {
            System.out.println("수정 실패");
            
        }
    }
}
