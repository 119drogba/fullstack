<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
String ids = request.getParameter("id") != null ? request.getParameter("id") : "아이디없음";
%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="get">
		<!-- <form action="08_05_01_request01_process.jsp" method="get"> -->
		<p>
			아이디 : <input type="text" name="id" value="<%=ids%>">
		</p>
		<p>
			비밀번호 : <input type="password" name="passwd">
		</p>
		<input type="submit" value="전송" />


	</form>
	
	<!-- 
	request 객체 : Parameter => get영역
	속성명(name)		| 		속성값(value)
	-----------------------------------
	id						admin
	passwd					1234
	request.getParameter("id");
	request.getParameter("passwd");
	 -->
</body>
</html>