<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String name = request.getParameter("name");
		String name1 = (String) request.getAttribute("name");
	%>
	<p> 입력된 파라미터 name 값 : <%=name%></p>
	<p> 입력된 속성 name 값 : ${name}</p>
	 <!-- el태그 attribute 가져옴 -->
	<p> 입력된 속성 name 값 : <%=name1%></p>
</body>
</html>