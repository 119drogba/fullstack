<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이페이지</title>
 <style>
      #memberInfoArea {
        width: 400px;
        margin: auto;
        border: 1px solid gray;
      }
      table {
        width: 380px;
        margin: auto;
        text-align: center;
      }
      .change-link {
        font-size: 0.9em;
        margin-left: 10px;
      }
      td {
        text-align: left;
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
	<form action="StudentModify" method="post">
	<tr>
		<td>이메일 : </td>
		
		<td>${student.student_email}
		<input type="text" name="STUDENT_EMAIL" id = "STUDENT_EMAIL" placeholder="변경할 이메일 입력"/>
	
		</td>
		
	</tr>
	
	
	<tr>
		<td>전화번호 : </td>
		
		<td>${student.student_ph}
		<input type="text" name="STUDENT_PH" id = "STUDENT_PH" placeholder="변경할 전화번호 입력" />
		</td>
	</tr>
	</form>
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
		
		<td>${student.student_address}
		
	<form action="mypage.jsp" method="post">
		<input type="text" id="sample6_postcode" name="zipcode" placeholder="우편번호">
		<input type="button" onclick="sample6_execDaumPostcode()" value="우편번호 찾기"><br>
		<input type="text" id="sample6_address" name="addr1" placeholder="주소"><br>
		<input type="text" id="sample6_detailAddress" name="addr2" placeholder="상세주소">
		<input type="text" id="sample6_extraAddress" name="comment" placeholder="참고항목"><br>
		
	</form>
	</td>
	</tr>
	<tr>
		<td>성별 : </td>
		<td>${student.student_gender}</td>
	</tr>
	<tr>
		<td>상태 : </td>
		<td>${student.student_status}</td>
	</tr>
	
</table>
</section>
<button type="button" onclick="modify()">수정</button>
</form>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
	<script>
		function sample6_execDaumPostcode() {
			new daum.Postcode({
				oncomplete: function(data) {
					// 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

					// 각 주소의 노출 규칙에 따라 주소를 조합한다.
					// 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
					var addr = ''; // 주소 변수
					var extraAddr = ''; // 참고항목 변수

					//사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
					if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
						addr = data.roadAddress;
					} else { // 사용자가 지번 주소를 선택했을 경우(J)
						addr = data.jibunAddress;
					}

					// 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
					if(data.userSelectedType === 'R'){
						// 법정동명이 있을 경우 추가한다. (법정리는 제외)
						// 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
						if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
							extraAddr += data.bname;
						}
						// 건물명이 있고, 공동주택일 경우 추가한다.
						if(data.buildingName !== '' && data.apartment === 'Y'){
							extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
						}
						// 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
						if(extraAddr !== ''){
							extraAddr = ' (' + extraAddr + ')';
						}
						// 조합된 참고항목을 해당 필드에 넣는다.
						document.getElementById("sample6_extraAddress").value = extraAddr;
					
					} else {
						document.getElementById("sample6_extraAddress").value = '';
					}

					// 우편번호와 주소 정보를 해당 필드에 넣는다.
					document.getElementById('sample6_postcode').value = data.zonecode;
					document.getElementById("sample6_address").value = addr;
					// 커서를 상세주소 필드로 이동한다.
					document.getElementById("sample6_detailAddress").focus();
				}
			}).open();
		}
		
		function modify() {
	        var email = document.getElementById('STUDENT_EMAIL').value.trim();
	        var phone = document.getElementById('STUDENT_PH').value.trim();
	        var postcode = document.getElementById('sample6_postcode').value.trim();
	        var address = document.getElementById('sample6_address').value.trim();
	        var detailAddress = document.getElementById('sample6_detailAddress').value.trim();
	        var extraAddress = document.getElementById('sample6_extraAddress').value.trim();
	        
	        if (email || phone || postcode || address || detailAddress || extraAddress) {
	            
	            var form = document.createElement('form');
	            form.method = 'post';
	            form.action = 'StudentModify';
	            
	            if (email) {
	                var emailField = document.createElement('input');
	                emailField.type = 'hidden';
	                emailField.name = 'STUDENT_EMAIL';
	                emailField.value = email;
	                form.appendChild(emailField);
	            }

	            if (phone) {
	                var phoneField = document.createElement('input');
	                phoneField.type = 'hidden';
	                phoneField.name = 'STUDENT_PH';
	                phoneField.value = phone;
	                form.appendChild(phoneField);
	            }

	            if (postcode) {
	                var postcodeField = document.createElement('input');
	                postcodeField.type = 'hidden';
	                postcodeField.name = 'zipcode';
	                postcodeField.value = postcode;
	                form.appendChild(postcodeField);
	            }

	            if (address) {
	                var addressField = document.createElement('input');
	                addressField.type = 'hidden';
	                addressField.name = 'addr1';
	                addressField.value = address;
	                form.appendChild(addressField);
	            }

	            if (detailAddress) {
	                var detailAddressField = document.createElement('input');
	                detailAddressField.type = 'hidden';
	                detailAddressField.name = 'addr2';
	                detailAddressField.value = detailAddress;
	                form.appendChild(detailAddressField);
	            }

	            if (extraAddress) {
	                var extraAddressField = document.createElement('input');
	                extraAddressField.type = 'hidden';
	                extraAddressField.name = 'comment';
	                extraAddressField.value = extraAddress;
	                form.appendChild(extraAddressField);
	            }

	            document.body.appendChild(form);
	            form.submit();
	        } else {
	            alert('변경할 정보를 입력해 주세요.');
	        }
	    }
	</script>
	</body>
	</html>