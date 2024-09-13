<%@ page language="java" contentType="text/html; charset=UTF-8" %>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
		<!DOCTYPE html>
		<html>

		<head>
			<script type="text/javascript">
				function modify() {
					studentForm.submit();
				}
			</script>
			<meta charset="UTF-8">
			<title>마이페이지</title>

			<style>
				.error-message {
					color: red;
					font-size: 0.9em;
					margin-top: 5px;
					display: none;
					/* 기본적으로 메시지를 숨김 */
				}

				.valid-message {
					color: green;
					font-size: 0.9em;
					margin-top: 5px;
					display: none;
					/* 기본적으로 메시지를 숨김 */
				}

				#imagePreview {
					width: 105px;
					height: 135px;
					border: 2px solid black;
					background-color: #c4c4c4;
					background-size: cover;
					background-position: center;
					margin-right: 20px;
					display: inline-block;
					border-radius: 5px;
				}

				body {
					font-family: Arial, sans-serif;
					background-color: #e6e6e6;
					margin: 0;
					padding: 0;
				}

				#header {
					width: 100%;
					background-color: #f2f2f2;
					height: 60px;
					display: flex;
					justify-content: flex-end;
					align-items: center;
					padding: 0 20px;
					box-sizing: border-box;
				}

				#header .header-left {
					display: flex;
					align-items: center;
					margin-right: 10px;
				}

				#header .header-right {
					display: flex;
					align-items: center;
				}

				#header .header-right a {
					font-size: 0.9em;
					text-decoration: none;
					color: #333;
					margin-left: 5px;
				}

				#header h1 {
					font-size: 1.5em;
					font-weight: bold;
					margin: 0;
					white-space: nowrap;
				}

				#header a {
					white-space: nowrap;
				}


				#menu {
					background-color: #d9d9d9;
					width: 200px;
					padding-top: 0;
					float: left;
					box-sizing: border-box;
					height: 100vh;
					position: relative;
				}

				#menu ul {
					list-style-type: none;
					padding: 0;
				}


				#logo {
					background-color: #ff6666;
					text-align: center;
					padding: 20px 0;
					box-sizing: border-box;
					width: 100%;
				}

				#logo img {
					max-width: 100%;
					height: auto;
				}

				#menu li {
					margin: 10px 0;
				}

				#menu li a {
					text-decoration: none;
					font-size: 1.2em;
					color: #333;
					padding: 10px;
					display: block;
					text-align: center;
					background-color: #f2f2f2;
					width: 100%;
					box-sizing: border-box;
				}

				#menu li a:hover {
					background-color: #e0e0e0;
				}

				#menu li a.active {
					background-color: #ff6666;
					color: white;
				}


				#content {
					margin-left: 220px;
					padding: 20px;
					background-color: white;
					min-height: 100vh;
					box-sizing: border-box;
				}

				#content h2 {
					font-size: 2em;
					font-weight: bold;
					text-align: center;
					margin-bottom: 20px;
				}


				#memberInfoArea {
					background-color: #f2f2f2;
					width: 100%;
					max-width: 800px;
					margin: 0 auto;
					border: 1px solid #d9d9d9;
					padding: 30px;
					box-sizing: border-box;
				}

				#memberInfoArea table {
					width: 100%;
					border-collapse: collapse;
				}

				#memberInfoArea td {
					padding: 10px;
				}

				#memberInfoArea td:first-child {
					font-weight: bold;
					width: 150px;
				}

				input[type="text"] {
					width: calc(100% - 20px);
					padding: 8px;
					margin-top: 5px;
					margin-bottom: 15px;
					border: 1px solid #ccc;
					border-radius: 4px;
					box-sizing: border-box;
				}

				.actions {
					text-align: center;
					margin-top: 20px;
					margin-left: 290px;
					margin-bottom: 40px
				}

				.actions a {
					background-color: #ff6666;
					color: white;
					padding: 10px 30px;
					border-radius: 4px;
					text-decoration: none;
					margin: 0 20px;
				}

				.actions a:hover {
					background-color: #e60000;
				}


				@media (max-width: 1024px) {
					#menu {
						width: 180px;
					}

					#content {
						margin-left: 200px;
					}
				}

				@media (max-width: 768px) {
					#header {
						flex-direction: column;
						height: auto;
						text-align: center;
					}

					#menu {
						width: 100%;
						height: auto;
						position: relative;
						padding: 0;
					}

					#menu ul {
						display: flex;
						justify-content: space-around;
					}

					#menu li a {
						font-size: 1em;
					}

					#content {
						margin-left: 0;
						padding: 10px;
					}

					#memberInfoArea {
						width: 100%;
						max-width: none;
						padding: 20px;
					}
				}

				@media (max-width: 480px) {
					#header h1 {
						font-size: 1em;
					}

					#menu ul {
						flex-direction: column;
					}

					#memberInfoArea {
						padding: 15px;
					}
				}
			</style>
		</head>

		<body>
			<div id="header">
				<div class="header-left">
					<h1>${student.student_name} 님</h1>
				</div>
				<div class="header-right">
					<a href="#">로그아웃</a>
				</div>
			</div>

			<div id="menu">

				<div id="logo">
					<img src="로고이미지경로" alt="로고">
				</div>
				<ul>
					<li><a href="#">강의 정보</a></li>
					<li><a href="#">수강신청</a></li>
					<li><a href="#">공지사항</a></li>
					<li><a href="#">게시판</a></li>
				</ul>
			</div>
			<div id="content">
				<h2>학생정보</h2>
				<section id="memberInfoArea">

					<form action="StudentModify" method="post" id="studentForm" name="studentForm">
						<table>
							<tr>
								<td id="imagePreview">사진</td>
								<td>${student.student_image}</td>


							</tr>

							<tr>
								<td>학번</td>
								<td>${student.student_id }</td>
							</tr>
							<tr>
								<td>이름</td>
								<td>${student.student_name}</td>
							</tr>


							<tr>
								<td>이메일</td>
								<td>
									${student.student_email}
									<input type="text" name="STUDENT_EMAIL" id="STUDENT_EMAIL"
										placeholder="변경할 이메일 입력" />
									<div id="emailErrorMessage" class="error-message">유효한 이메일 주소를 입력해주세요.</div>
									<div id="emailValidMessage" class="valid-message">유효한 이메일 주소입니다.</div>
								</td>
							</tr>
							<tr>
								<td>전화번호</td>
								<td><label for="STUDENT_PH"></label>
									<input type="text" id="STUDENT_PH" name="STUDENT_PH" placeholder="전화번호를 입력하세요">
									<div id="phoneErrorMessage" class="error-message">유효한 전화번호를 입력해주세요. (예:
										010-1234-5678 또는 01012345678)</div>
									<div id="phoneValidMessage" class="valid-message">유효한 전화번호입니다.</div>

								</td>
							</tr>
							<tr>
								<td>주소</td>
								<td>${student.student_address}<input type="text" id="sample6_postcode" name="zipcode"
										placeholder="우편번호">
									<input type="button" onclick="sample6_execDaumPostcode()" value="우편번호 찾기"><br>
									<input type="text" id="sample6_address" name="addr1" placeholder="주소"><br>
									<input type="text" id="sample6_detailAddress" name="addr2" placeholder="상세주소">
									<input type="text" id="sample6_extraAddress" name="comment" placeholder="참고항목"><br>
									
								</td>
							</tr>

							<tr>
								<td>생년월일</td>
								<td>${student.student_birth}</td>
							</tr>
							<tr>
								<td>입학날짜</td>
								<td>${student.student_intoday}</td>
							</tr>
							<tr>
								<td>학년</td>
								<td>${student.student_year}</td>
							</tr>
							<tr>
								<td>전공</td>
								<td>${student.student_major}</td>
							</tr>
							<tr>
								<td>성별</td>
								<td>${student.student_gender}</td>
							</tr>
							<tr>
								<td>상태</td>
								<td>${student.student_status}</td>
							</tr>
						</table>




					</form>
				</section>
			</div>
			<div class="actions">
				<a href="javascript:modify()">수정</a> <a href="#">취소</a>

			</div>
			<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
			<script>


				// 이메일 유효성 검사 함수
				function validateEmail(email) {
					const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
					return emailRegex.test(email);
				}

				// 전화번호 유효성 검사 함수
				function validatePhoneNumber(phoneNumber) {
					const phoneRegex = /^01[0-9]-?\d{3,4}-?\d{4}$/;
					return phoneRegex.test(phoneNumber);
				}

				// 이메일 입력 필드 블러 이벤트 핸들러
				function handleEmailBlur() {
					const email = document.getElementById("STUDENT_EMAIL").value.trim();
					const errorMessage = document.getElementById("emailErrorMessage");
					const validMessage = document.getElementById("emailValidMessage");

					if (!validateEmail(email)) {
						errorMessage.style.display = "block";
						validMessage.style.display = "none";
					} else {
						errorMessage.style.display = "none";
						validMessage.style.display = "block";
					}
				}

				// 전화번호 입력 필드 블러 이벤트 핸들러
				function handlePhoneNumberBlur() {
					const phoneNumber = document.getElementById("STUDENT_PH").value.trim();
					const errorMessage = document.getElementById("phoneErrorMessage");
					const validMessage = document.getElementById("phoneValidMessage");

					if (!validatePhoneNumber(phoneNumber)) {
						errorMessage.style.display = "block";
						validMessage.style.display = "none";
					} else {
						errorMessage.style.display = "none";
						validMessage.style.display = "block";
					}
				}

				document.addEventListener("DOMContentLoaded", function () {
					// 블러 이벤트 리스너 추가
					document.getElementById("STUDENT_EMAIL").addEventListener("blur", handleEmailBlur);
					document.getElementById("STUDENT_PH").addEventListener("blur", handlePhoneNumberBlur);

					// 폼 제출 이벤트 리스너
					document.getElementById("studentForm").addEventListener("submit", function (event) {
						const email = document.getElementById("STUDENT_EMAIL").value.trim();
						const phoneNumber = document.getElementById("STUDENT_PH").value.trim();

						if (email && !validateEmail(email)) {
							alert("유효한 이메일 주소를 입력해주세요.");
							event.preventDefault(); // 폼 제출 중단
							return;
						}

						if (phoneNumber && !validatePhoneNumber(phoneNumber)) {
							alert("유효한 전화번호를 입력해주세요. (예: 010-1234-5678 또는 01012345678)");
							event.preventDefault(); // 폼 제출 중단
							return;
						}
					});
				});

				function modify() {
					var email = document.getElementById('STUDENT_EMAIL').value.trim();
					var phone = document.getElementById('STUDENT_PH').value.trim();
					var postcode = document.getElementById('sample6_postcode').value.trim();
					var address = document.getElementById('sample6_address').value.trim();
					var detailAddress = document.getElementById('sample6_detailAddress').value.trim();
					var extraAddress = document.getElementById('sample6_extraAddress').value.trim();

					// 이메일 유효성 검사
					if (email && !validateEmail(email)) {
						alert('유효한 이메일 주소를 입력해주세요.');
						return; // 함수 종료, 데이터 전송 중단
					}

					// 전화번호 유효성 검사
					if (phone && !validatePhoneNumber(phone)) {
						alert('유효한 전화번호를 입력해주세요. (예: 010-1234-5678 또는 01012345678)');
						return; // 함수 종료, 데이터 전송 중단
					}

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

						// 주소 관련 필드 추가
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

			






				function sample6_execDaumPostcode() {
					new daum.Postcode(
						{
							oncomplete: function (data) {
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
								if (data.userSelectedType === 'R') {
									// 법정동명이 있을 경우 추가한다. (법정리는 제외)
									// 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
									if (data.bname !== ''
										&& /[동|로|가]$/g.test(data.bname)) {
										extraAddr += data.bname;
									}
									// 건물명이 있고, 공동주택일 경우 추가한다.
									if (data.buildingName !== ''
										&& data.apartment === 'Y') {
										extraAddr += (extraAddr !== '' ? ', '
											+ data.buildingName
											: data.buildingName);
									}
									// 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
									if (extraAddr !== '') {
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
								document.getElementById("sample6_detailAddress")
									.focus();
							}
						}).open();
				}


			</script>
		</body>

		</html>