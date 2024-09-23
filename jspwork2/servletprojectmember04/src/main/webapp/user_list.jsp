<%@page import="vo.MemberBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>일반 유저 로그인</title>
<style>
	#memberListArea{
		width : 400px;
		border : 1px solid gray;
		margin : auto;
	}
	table{
		width : 380px;
		margin : auto;
		text-align: center;
	}
</style>
</head>
<body>
<section id = "memberListArea">
<table>
	<tr>
		<td colspan=2><h1>일반유저 로그인</h1></td>
	</tr>
	
	<tr>	
		<td>
			<a href="./memberViewAction.me?id=${id}">
				${id}님 환영합니다.
			</a>
		</td>	
	</tr>
	
	
	
	<tr>
	<td><a href="logout.me">로그아웃</a></td>
	</tr>
</table>
</section>
</body>
</html>