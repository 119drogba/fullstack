<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Ajax Test</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.0/jquery.js"></script>

<script>
// 	function loadDoc() {
// 		var xhttp = new XMLHttpRequest(); //비동기객체 생성
// 		var currentState = ""; //"XMLHttpRequest 객체의 현재 상태는 UNSET(0) 입니다. - XMLHttpRequest 객체가 생성됨.<br>";

// 		if (this.readyState == XMLHttpRequest.UNSET)
// 			currentState += "XMLHttpRequest 객체의 현재 상태는 UNSET(0) 입니다. - XMLHttpRequest 객체가 생성됨.<br>";
		
// 		xhttp.onreadystatechange = function() {
// switch (this.readyState) {
// 	case XMLHttpRequest.UNSET:
// 		currentState += 
// 		"XMLHttpRequest 객체 상태는 UNSET(0) - XMLHttpRequest 객체가 생성됨.<br>";
// 		break;
// 	case XMLHttpRequest.OPENED:
// 		currentState += 
// 		"XMLHttpRequest 객체 상태는 OPENED(1) - open() 메소드가 성공적으로 실행됨.<br>";
// 		break;
// 	case XMLHttpRequest.HEADERS_RECEIVED:
// 		currentState += 
// 		"XMLHttpRequest 객체 상태는 HEADERS_RECEIVED(2) - 모든 요청의 응답 도착.<br>";
// 		break;
// 	case XMLHttpRequest.LOADING:
// 		currentState += 
// 		"XMLHttpRequest 객체 상태는 LOADING(3) - 요청한 데이터를 처리(대기) 중<br>";
// 		break;
// 	case XMLHttpRequest.DONE:
// 		currentState += 
// 		"XMLHttpRequest 객체 상태는 DONE(4) - 요청한 데이터의 처리가 완료되어 응답할 준비가 완료됨.<br>";
// 		break;
// }
// 			document.getElementById("status").innerHTML = currentState;

// 			if (this.readyState == 4 && this.status == 200) {
// 				document.getElementById("demo").innerHTML = xhttp.responseText;
// 			}
// 		};
		
// // 		xhttp.open("GET", "ajax_info.txt", true); //형식: open(전달방식, URL주소, 동기여부);
// 		xhttp.open("GET", "Gesipan/test.do", true);

// 		xhttp.send(); //작성된 Ajax 요청을 서버로 전달한다.
// 	}

		function loadDoc() {
// 			$("#demo").load("ajax_info.txt"); 
	//형식: load("url", {id: "admin", pw : "1111" }, 콜백함수) => post방식
	//형식: load("url?id=admin&pw=1111" , 콜백함수) => get방식
			$("#demo").load("Gesipan/test.do", {id:"admin", pw: "1234"}); 
		}
</script></head><body>
	<div id="status"></div><br><hr><br>
	<div id="demo">
		<h2>The XMLHttpRequest Object</h2>
		<button type="button" onclick="loadDoc()">Change Content</button>
	</div>
</body>
</html>







