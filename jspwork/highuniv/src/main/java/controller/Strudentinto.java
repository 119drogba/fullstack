package controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dto.StudentVO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import svc.StudentIntoService;

@WebServlet("/studentinto.pr")
public class Strudentinto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("테스트 실행");
		
		request.setCharacterEncoding("utf-8");
		StudentVO stu = new StudentVO();
		
		String saveFolder = "/image/studentimg";
		int fileSize = 5 * 1024 * 1024;
		ServletContext context = request.getServletContext();
//		String realFolder = context.getRealPath(saveFolder);
		String realFolder = "C:\\jspwork\\highuniv\\src\\main\\webapp\\"+saveFolder;
		
		
		File f = new File(realFolder);
		if(!f.exists()) f.mkdirs();
		
		MultipartRequest multi = new MultipartRequest(request, realFolder, fileSize, "UTF-8",new DefaultFileRenamePolicy()); 
		
		System.out.println(realFolder);
		
		stu.setStudent_id(multi.getParameter("student_id"));
		stu.setStudent_pw(multi.getParameter("student_pw"));
		stu.setStudent_name(multi.getParameter("student_name"));
		stu.setStudent_email(multi.getParameter("student_email"));
		stu.setStudent_ph(multi.getParameter("student_ph"));
		stu.setStudent_birth(multi.getParameter("student_birth"));
		stu.setStudent_intoday(multi.getParameter("student_intoday"));
		stu.setStudent_year(Integer.parseInt(multi.getParameter("student_year")));
		stu.setStudent_major(multi.getParameter("student_major"));
		stu.setStudent_address(multi.getParameter("student_address"));
		stu.setStudent_gender(multi.getParameter("student_gender"));
		stu.setStudent_status(multi.getParameter("student_staus"));
		stu.setStudent_use("Y");
		stu.setStudent_image(multi.getOriginalFileName((String) multi.getFileNames().nextElement()));
		
		System.out.println(stu);
		StudentIntoService studentintoservice = new StudentIntoService();
		studentintoservice.insertStudent(stu);
		
	}

}
