<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="join.do" method="post">
	
	<label for="id" >아이디</label>
	<input type="text" placeholder="ID" name="id">
	
	<label for="password" >비밀번호</label>
	<input type="password" placeholder="비밀번호" name="password">
	
	
	<label for="name" >이름</label>
	<input type="text" placeholder="이름" name="name">
	
	
	<label for="role" >역할</label>
	<input type="text" placeholder="역할" name="role">
	
	
	<button type="submit">회원가입</button>
	
	
	</form>
</body>
</html>