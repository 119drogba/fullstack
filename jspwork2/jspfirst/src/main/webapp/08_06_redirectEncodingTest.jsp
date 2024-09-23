<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.net.URLEncoder" %>
<!DOCTYPE html>
<%
//http://localhost:8090/jspfirst/08_06_redirectEncodingTest.jsp
	String value = "자바";
	String encodedValue = URLEncoder.encode(value, "utf-8");
//  response.sendRedirect("08_06_index.jsp?name="+value);

//// http://localhost:8090/jspfirst/08_06_index.jsp
	out.print("<script>alert('페이지 이동전')</script>");
	response.sendRedirect("08_06_index.jsp?name="+encodedValue);
%>