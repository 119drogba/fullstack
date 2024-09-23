<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html><html><head>
    </head><body>
        
			<%
	request.setCharacterEncoding("UTF-8");
	
	String id = request.getParameter("id");
	String passwd = request.getParameter("passwd");
	
	%>
	<h1>입력이 성공했습니다.</h1>
	<p> 아이디 : <%=id%></p>
	<p> 비밀번호 : <%=passwd%></p>
	
		
				
    </body></html>