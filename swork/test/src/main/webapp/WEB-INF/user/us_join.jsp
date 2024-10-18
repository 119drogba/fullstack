<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/common.css">
</head>
<body id="US_JOIN">
	<div id="US_JOIN_DIV">
		<h1>회원 가입</h1>
		<form name="US_JOIN_FRM" action="us_join" method="post">
			<input type="text" name="id" placeholder="아이디 입력"> <input
				type="password" name="password" placeholder="비밀번호 입력"> <input
				type="text" name="name" placeholder="이름 입력"> <select
				type="text" name="role">
				<option value="User">사용자</option>
				<option value="Admin">관리자</option>
			</select>
			<input type="submit" value="회원가입">
		</form>
	</div>
</body>
</html>