<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%-- <%@ page import="com.dao.Calculator"%>
<%
Calculator bean = new Calculator();
%> --%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Action tag</title>
</head>
<body>
	<jsp:useBean id="bean" class="com.dao.Calculator" />

	<%
	int m = bean.process(5);
	out.print("5의 3제곱 :" + m);
	%>

</body>
</html>