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
		Cookie[] cookies = request.getCookies();

		for(int i =0; i<cookies.length; i++) {
//			쿠키만료시간 설정
			cookies[i].setMaxAge(60);

//			쿠키삭제
//			cookies[i].setMaxAge(0);
			response.addCookie(cookies[i]);
		}
//		response.sendRedirect("15_01_cookie02.jsp");
	%>
	<a href="15_01_cookie02.jsp">쿠키 정보 보기</a>
</body>
</html>