package com.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.MemberSVC;
import com.model.MemberVO;


//@WebServlet(name = "member", urlPatterns = { "/member" })
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MemberSVC svc = new MemberSVC();

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberVO vo = svc.login(request.getParameter("id"),request.getParameter("password"));
		
		
		
		if(vo != null) {
			//if : 전송할 데이터가 있으면 포워딩방식으로 re/mvc_sucess.jsp
			request.setAttribute("memberVO", vo);
			RequestDispatcher dis = request.getRequestDispatcher("/re/mvc_success.jsp");
			dis.forward(request, response);
			
		}else {
			//전송할 데이터가 없으면 리다이렉트 방식으로 re/mvc_fail.jsp
			response.sendRedirect("./re/mvc_fail.jsp");
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		doGet(request, response);
	}

}
