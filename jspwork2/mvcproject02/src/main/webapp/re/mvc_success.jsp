<%@ page contentType="text/html; charset=utf-8"%>
<%-- <%@page import="com.model.LoginBean"%> --%>
<html>
<head>
<title>MVC</title>
</head>
<body>
	<p>로그인 성공했습니다.</p>
	<p>아이디님, 안녕하세요</p>
	<p><%
// 		LoginBean bean = (LoginBean) request.getAttribute("bean");
// 		out.print("아이디 : " + bean.getId());
	%></p>
	로그인 성공<br>
	${memberVo.name}님 , 안녕하세요.<br>
</body>
</html>