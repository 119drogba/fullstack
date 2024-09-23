package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//@WebServlet(name = "conservlet", urlPatterns = { "/conservlet" })
public class ConServlet extends HttpServlet {
	private static final long serialVersionUID = 1L; 
	/* 버전 확인 및 데이터 직렬화 */

	public ConServlet() {
		System.out.println("서블릿 객체 생성");
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet()메소드 실행");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8" );
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost()메소드 실행");
		request.setCharacterEncoding("UTF-8");
		doGet(request, response);
	}

}
