<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이페이지</title>
<style>
	#memberInfoArea{
		width : 400px;
		margin : auto;
		border : 1px solid gray;
	}
	table{
		width : 380px;
		margin : auto;
		text-align: center;
	}
</style>
</head>
<body>

<section id = "memberInfoArea">
<table>
	<tr>
		<td>학번 : </td>
		<td>${student.student_id }</td>
	</tr>
	<tr>
		<td>이름 : </td>
		<td>${student.student_name}</td>
	</tr>
	<tr>
		<td>이메일 : </td>
		<a href="#">이메일 변경</a>
		<td>${student.student_email}</td>
		
	</tr>
	
	<tr>
		<td>전화번호 : </td>
		<a href="#">전화번호 변경</a>
		<td>${student.student_ph}</td>
	</tr>
	<tr>
		<td>생년월일 : </td>
		<td>${student.student_birth}</td>
	</tr>
	<tr>
		<td>입학 날짜 : </td>
		<td>${student.student_intoday}</td>
	</tr>
	<tr>
		<td>학년 : </td>
		<td>${student.student_year}</td>
	</tr>
	<tr>
		<td>전공 : </td>
		<td>${student.student_major}</td>
	</tr>
	<tr>
		<td>주소 : </td>
		<a href="#">주소 변경</a>
		<td>${student.student_address}</td>
	</tr>
	<tr>
		<td>성별 : </td>
		<td>${student.student_gender}</td>
	</tr>
	<tr>
		<td>상태 : </td>
		<td>${student.student_status}</td>
	</tr>
	<tr>
		<td colspan=2>
			<a href="#">리스트로 돌아가기</a>
		</td>
	</tr>
</table>
</section>
</body>
</html>