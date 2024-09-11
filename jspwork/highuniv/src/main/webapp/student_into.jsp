<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html><head><meta charset="UTF-8"><title>학생 리스트</title>

</head>
<body>
	<form action="studentinto.pr" method="post" enctype="multipart/form-data">
		<label for="student_id">학번</label><input type="text" name="student_id" id="student_id"><br>
		<label for="student_pw">비밀번호</label><input type="text" name="student_pw" id="student_pw"><br>
		<label for="student_name">이름</label><input type="text" name="student_name" id="student_name"><br>
		<label for="student_email">이메일</label><input type="text" name="student_email" id="student_email"><br>
		<label for="student_ph">핸드폰번호</label><input type="text" name="student_ph" id="student_ph"><br>
		<label for="student_birth">생일</label><input type="text" name="student_birth" id="student_birth"><br>
		<label for="student_intoday">입학일</label><input type="text" name="student_intoday" id="student_intoday"><br>
		<label for="student_year">학년</label><input type="text" name="student_year" id="student_year"><br>
		<label for="student_major">전공</label><input type="text" name="student_major" id="student_major"><br>
		<label for="student_address">주소</label><input type="text" name="student_address" id="student_address"><br>
		<label for="student_gender">성별</label><input type="text" name="student_gender" id="student_gender"><br>
		<label for="student_staus">상태</label><input type="text" name="student_staus" id="student_staus"><br>
		<label for="student_image">이미지 </label><input type="file" name="student_image" id="student_image"><br>
		<input type="submit" value="전송">
	</form>
</body>
</html>