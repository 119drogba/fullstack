<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.*,java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
		<tr><th>요청 파라미터 이름</th><th>요청 파라미터 값</th></tr>
		<%
			request.setCharacterEncoding("UTF-8");
			
			//아래의 Enumeration 자료형 수정하세요!!
			Enumeration<String> paramNames = request.getParameterNames();
			
			while (paramNames.hasMoreElements()) {
				String name = paramNames.nextElement();
				out.print("<tr><td>"+name+"</td>");
				
				String paramValue = request.getParameter(name);
				out.println("<td>"+paramValue+"</td></tr>");
				
				
			}
		
		%>
	</table>
</body>
</html>