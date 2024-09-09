<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ajax Test</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.0/jquery.js"></script>
<script>
// $(function() {
// 	$("button").click(function() {
// 		let idval = {"id" : document.frm.id.value}; // {"id" : "admin"}
// 		$.ajax({
// 			url : "loginCheck", 
// 			type : "post",
// // 			data : { id: document.frm.id.value },
// 			data : idval,
// 			//클라이언트에서 서버로 보내는 데이터 타입
// 			contentType: 'application/x-www-form-urlencoded; charset=utf-8 ', 
// // 			contentType: 'application/json; charset=utf-8', 
// // 			data : JSON.stringify(idval),
// 			 , //서버에서 클라이언트로 전송 받는 자료의 데이터타입 
// 			cache : false,			
// 			success : function(data) {
// 				console.log('success');
// 				alert(data.map.id +'는 '+ data.map.str); 
// 			},
// 			error : function() {
// 				alert('error');
// 			}
// 		});
// 	});
// });

window.onload = function(){
	document.getElementsByTagName("button")[0].onclick = function(){
		alert('클릭');
		var xhttp = new XMLHttpRequest();		
		xhttp.responseType ="json"; //dataType : "json"동일한 의미
		xhttp.onreadystatechange = function() {
			if (this.readyState == 4 && this.status == 200) {
				console.log('response: ',xhttp.response);
				let data = xhttp.response;
				alert(data.map.id +'는 '+ data.map.str);
			}
		};
		
		xhttp.open("POST", "loginCheck", true);		
// 		var formElement = document.getElementsByName("frm")[0];
// 		var formdata = new FormData(formElement);
// 		xhttp.send(formdata);
		
		xhttp.setRequestHeader('content-type', 'json');	
		var formdata = {"id" : document.frm.id.value};
		xhttp.send(JSON.stringify(formdata));
	};
};
</script>
</head>
<body>
	<form name="frm">
		<input type="text" name="id"> <button type="button">아이디 중복체크</button>
	</form>
</body>
</html>


