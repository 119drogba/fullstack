<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Form processing</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script>
	
	$(function(){
		let btn = $("input[type=button]");

		btn.on('click', ()=>{
			let uid = $("input[name=id]").val();
			if(uid == 'admin') alert('중복값이 있습니다.');
			else alert("중복값이 없습니다.");
		});
	});
</script>
</head>
<body>
	<h3>회원가입</h3>
	    <form action="08_05_02_form06_process.jsp" name="member" method="post">
	        <p>아이디 : <input type="text" name="id"><input type="button" value="아이디 중복검사">
	        </p>
	        <p>비밀번호 : <input type="password" name="passwd"></p>
	        <p>이름 : <input type="text" name="name"></p>
	        <p>연락처 :
	            <select name="phone1">
	                <option value="010" selected>010</option>
	                <option value="011">011</option>
	                <option value="016">016</option>
	                <option value="017">017</option>
	                <option value="019">019</option>
	            </select>
	            -
	            <input type="text" maxlength="4" size="4" name="phone2">
	            -
	            <input type="text" maxlength="4" size="4" name="phone3">
	        </p>
	        <p>성별 :
	            <input type="radio" name="gender" value="남성" checked>남성
	            <input type="radio" name="gender" value="여성">여성
	        </p>
	        <p>취미 :
	            <input type="checkbox" name="hobby" value="독서" checked>독서
	            <input type="checkbox" name="hobby" value="운동">운동
	            <input type="checkbox" name="hobby" value="영화">영화
	        </p>
	        <p>
	            <textarea name="comment" cols="30" rows="3" placeholder="가입인사를 입력해주세요"></textarea>
	        </p>
	        <p>
	            <input type="submit" value="가입하기">
	            <input type="reset" value="다시쓰기">
	        </p>
	    </form>
	    
</body>
</html>