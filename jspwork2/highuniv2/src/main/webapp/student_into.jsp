<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<title>학생 입력</title>
<style>
.error-message {
	color: red;
	font-size: 0.9em;
	margin-top: 5px;
	display: none;
}

.valid-message {
	color: green;
	font-size: 0.9em;
	margin-top: 5px;
	display: none;
}
</style>
<link rel="stylesheet" type="text/css" href="css/student_into.css">
</head>
<body>
	<div id="image_container"></div>
	<form id="studentForm" action="studentinto.pr" method="post" enctype="multipart/form-data">

		<label for="student_id">학번</label> <input type="text"
			name="student_id" id="student_id">
		<div id="idErrorMessage" class="error-message">유효한 학번을 입력해주세요.</div>
		<div id="idValidMessage" class="valid-message">유효한 학번입니다.</div>
		<label for="student_pw">비밀번호</label> <input type="password"
			name="student_pw" id="student_pw">
		<div id="passwordErrorMessage" class="error-message">비밀번호는 최소
			8자, 대문자, 소문자, 숫자, 특수문자를 포함해야 합니다.</div>
		<div id="passwordValidMessage" class="valid-message">유효한
			비밀번호입니다.</div>
		<div>
			<label for="student_name">이름</label> <input type="text"
				name="student_name" id="student_name">
			<div id="nameErrorMessage" class="error-message">한글 또는 영문 이름만
				입력할 수 있습니다.</div>
			<div id="nameValidMessage" class="valid-message">유효한 이름입니다.</div>

			<div>
				<label for="student_major">전공</label> <select name="student_major"
					id="student_major">
					<option value="">전공을 선택하세요</option>

					<option value="Computer Science">컴퓨터 과학</option>
					<option value="Mechanical Engineering">기계공학</option>
					<option value="Electrical Engineering">전기공학</option>
					<option value="Business Administration">경영학</option>
					<option value="Biotechnology">생명공학</option>
				</select>
				<div id="majorErrorMessage" class="error-message">전공을 선택해주세요.
				</div>
				<div id="majorValidMessage" class="valid-message">유효한 전공입니다.</div>
			</div>
		</div>
		<div>
			<label for="student_ph">핸드폰번호</label> <input type="text"
				name="student_ph" id="student_ph">
			<div id="phoneErrorMessage" class="error-message">유효한 전화번호를
				입력해주세요. (예: 010-1234-5678 또는 01012345678)</div>
			<div id="phoneValidMessage" class="valid-message">유효한 전화번호입니다.
			</div>
			<label for="student_email">이메일</label> <input type="text"
				name="student_email" id="student_email"><br>
			<div id="emailErrorMessage" class="error-message">유효한 이메일 주소를
				입력해주세요.</div>
			<div id="emailValidMessage" class="valid-message">유효한 이메일
				주소입니다.</div>
		</div>


		<div>
			<label for="student_birth">생년월일 선택</label> <input type="date"
				id="student_birth" name="student_birth">
			<div id="birthErrorMessage" class="error-message">유효한 생년월일을
				입력하세요.</div>
			<div id="birthValidMessage" class="valid-message">유효한 생년월일입니다.
			</div>
		</div>

		<div>
			<label for="student_intoday">입학 날짜 선택</label> <input type="date"
				id="student_intoday" name="student_intoday">
			
		</div>


		<div class="radio_group">
			<input type="radio" id="g_male" name="ugender" class="hide"
				value="male"><label for="g_male">남자</label><input
				type="radio" id="g_female" name="ugender" class="hide"
				value="female"><label for="g_female">여자</label>

			<div>
				<label for="student_year">학년 선택</label> <select name="student_year"
					id="student_year" onblur="handleYearBlur()">
					<option value="">학년을 선택하세요</option>
					<option value="1학년">1학년</option>
					<option value="2학년">2학년</option>
					<option value="3학년">3학년</option>
					<option value="4학년">4학년</option>
				</select>
				<div id="yearErrorMessage" class="error-message">학년을 선택하세요.</div>
				<div id="yearValidMessage" class="valid-message">유효한 학년입니다.</div>
			</div>
			<input type="text" id="sample6_postcode" name="zipcode"
				placeholder="우편번호"> <input type="button"
				onclick="sample6_execDaumPostcode()" value="우편번호 찾기"><br>
			<input type="text" id="sample6_address" name="addr1" placeholder="주소"><br>
			<input type="text" id="sample6_detailAddress" name="addr2"
				placeholder="상세주소"> <input type="text"
				id="sample6_extraAddress" name="comment" placeholder="참고항목">
			<div>
				<label for="student_status">상태</label> <select name="student_status"
					id="student_status">
					<option value="">상태를 선택하세요</option>
					<option value="재학">재학</option>
					<option value="휴학">휴학</option>
					<option value="졸업">졸업</option>
					<option value="자퇴">자퇴</option>
				</select>
				<div id="statusErrorMessage" class="error-message"
					style="display: none;">상태를 선택하세요.</div>
				<div id="statusValidMessage" class="valid-message"
					style="display: none;">유효한 상태입니다.</div>
			</div>

			<div>
				<label for="student_use">사용 가능 여부</label> <select name="student_use"
					id="student_use">
					<option value="">사용 가능 여부를 선택하세요</option>
					<option value="Y">Y</option>
					<option value="N">N</option>
				</select>
				<div id="useErrorMessage" class="error-message">사용 가능 여부를
					선택하세요.</div>
				<div id="useValidMessage" class="valid-message">유효한 선택입니다.</div>
			</div>
			<label for="student_image">이미지 </label> <input type="file"
				name="student_image" id="student_image"
				accept=".jpg, .jpeg, .png, .gif" required><br> <input type="button" value="전송" onclick="validateAndSubmit()">
		</div>
		
		
	</form>
	
	
	<script
		src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
	<script>
	// 전송 버튼을 눌렀을 때 유효성 검사를 확인한 후 폼을 제출하는 함수
	function validateAndSubmit() {
		// 개별 유효성 검사 함수 호출
		handleIdBlur();
		handlePasswordBlur();
		handleNameBlur();
		handleMajorBlur();
		handlePhoneNumberBlur();
		handleEmailBlur();
		handleBirthDateBlur();
		handleYearBlur();
		handleStatusBlur();
		handleUseBlur();

		// 모든 에러 메시지가 display: block인 경우 경고 메시지를 표시, 아니면 폼 제출
		if (document.querySelectorAll('.error-message[style*="display: block"]').length === 0) {
			// 폼이 유효한 경우 제출
			document.getElementById("studentForm").submit();
		} else {
			alert("모든 필드를 올바르게 입력해주세요.");
		}
	}
	
		/* 사용 가능 여부 유효성 */

		function validateUse() {
			const useElement = document.getElementById("student_use");
			const use = useElement.value;
			return use !== "";
		}

		function handleUseBlur() {
			const errorMessage = document.getElementById("useErrorMessage");
			const validMessage = document.getElementById("useValidMessage");

			if (!validateUse()) {
				errorMessage.style.display = "block";
				validMessage.style.display = "none";
			} else {
				errorMessage.style.display = "none";
				validMessage.style.display = "block";
			}
		}

		/*상태 유효성 */

		function validateStatus() {
			const statusElement = document.getElementById("student_status");
			const status = statusElement.value;
			return status !== "";
		}

		function handleStatusBlur() {
			const errorMessage = document.getElementById("statusErrorMessage");
			const validMessage = document.getElementById("statusValidMessage");

			if (!validateStatus()) {
				errorMessage.style.display = "block";
				validMessage.style.display = "none";
			} else {
				errorMessage.style.display = "none";
				validMessage.style.display = "block";
			}
		}

		/* 생년월일 유효성	 */

		function validateBirthDate() {
			const birthElement = document.getElementById("student_birth");
			const birthDate = new Date(birthElement.value);
			const today = new Date();

			if (!birthElement.value || birthDate >= today) {
				return false;
			}
			return true;
		}

		function handleBirthDateBlur() {
			const errorMessage = document.getElementById("birthErrorMessage");
			const validMessage = document.getElementById("birthValidMessage");

			if (!validateBirthDate()) {
				errorMessage.style.display = "block";
				validMessage.style.display = "none";
			} else {
				errorMessage.style.display = "none";
				validMessage.style.display = "block";
			}
		}

		/* 학년 유효성 */
		function validateYear(year) {
			return year !== "";
		}

		function handleYearBlur() {
			const yearElement = document.getElementById("student_year");
			const year = yearElement.value;
			const errorMessage = document.getElementById("yearErrorMessage");
			const validMessage = document.getElementById("yearValidMessage")

			if (!validateYear(year)) {
				errorMessage.style.display = "block";
				validMessage.style.display = "none";
			} else {
				errorMessage.style.display = "none";
				validMessage.style.display = "block";
			}
		}

		/* 전공 유효성 */
		function validateMajor(major) {
			return major !== "";
		}
		function handleMajorBlur() {
			const majorElement = document.getElementById("student_major");
			const major = majorElement.value;
			const errorMessage = document.getElementById("majorErrorMessage");
			const validMessage = document.getElementById("majorValidMessage");

			if (!validateMajor(major)) {
				errorMessage.style.display = "block";
				validMessage.style.display = "none";
			} else {
				errorMessage.style.display = "none";
				validMessage.style.display = "block";
			}
		}

		/* 이메일 유효성 */

		function validateEmail(email) {
			const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
			return emailRegex.test(email);
		}

		function handleEmailBlur() {
			const emailElement = document.getElementById("student_email");
			const email = emailElement.value.trim();
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

		/* 비밀번호 유효성 */
		function validatePassword(password) {
			const passwordRegex = /^(?=.*[A-Za-z])(?=.*\d)(?=.*[@$!%*#?&])[A-Za-z\d@$!%*#?&]{8,}$/;
			return passwordRegex.test(password);
		}
		function handlePasswordBlur() {
			const passwordElement = document.getElementById("student_pw");
			const password = passwordElement.value.trim();
			const errorMessage = document
					.getElementById("passwordErrorMessage");
			const validMessage = document
					.getElementById("passwordValidMessage");

			if (!validatePassword(password)) {
				errorMessage.style.display = "block";
				validMessage.style.display = "none";
			} else {
				errorMessage.style.display = "none";
				validMessage.style.display = "block";
			}
		}

		/* 이름 유효성 */
		function validateName(name) {
			const nameRegex = /^[가-힣a-zA-Z]+$/;
			return nameRegex.test(name);
		}
		function handleNameBlur() {
			const nameElement = document.getElementById("student_name");
			const name = nameElement.value.trim();
			const errorMessage = document.getElementById("nameErrorMessage");
			const validMessage = document.getElementById("nameValidMessage");

			if (!validateName(name)) {
				errorMessage.style.display = "block";
				validMessage.style.display = "none";
			} else {
				errorMessage.style.display = "none";
				validMessage.style.display = "block";
			}
		}

		/* 학번 유효성 검사 */
		function validateId(id) {
			const idRegex = /^\d{8}$/;
			return idRegex.test(id);
		}
		function handleIdBlur() {
			const idElement = document.getElementById("student_id");
			const id = idElement.value.trim();
			const errorMessage = document.getElementById("idErrorMessage");
			const validMessage = document.getElementById("idValidMessage");
			if (!validateId(id)) {
				errorMessage.style.display = "block";
				validMessage.style.display = "none";
			} else {
				errorMessage.style.display = "none";
				validMessage.style.display = "block";
			}
		}
		/* 핸드폰번호 유효성 검사 */
		function validatePhoneNumber(phoneNumber) {
			const phoneRegex = /^01[0-9]-?\d{3,4}-?\d{4}$/;
			return phoneRegex.test(phoneNumber);
		}
		function handlePhoneNumberBlur() {
			console.log("Blur event triggered"); // 디버깅을 위해 추가
			const phoneElement = document.getElementById("student_ph");
			const phoneNumber = phoneElement.value.trim();
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
		// 파일 이미지 미리보기
		function setThumbnail(event) {
			var reader = new FileReader();
			var imageContainer = document.querySelector("div#image_container");
			while (imageContainer.firstChild) {
				imageContainer.removeChild(imageContainer.firstChild);
			}
			reader.onload = function(event) {
				var img = document.createElement("img");
				img.setAttribute("src", event.target.result);
				img.style.maxWidth = '200px';
				img.style.maxHeight = '200px';
				imageContainer.appendChild(img);
			};
			if (event.target.files.length > 0) {
				reader.readAsDataURL(event.target.files[0]);
			}
		}
		document
				.getElementById('student_image')
				.addEventListener(
						'change',
						function(event) {
							var fileInput = event.target;
							var files = fileInput.files;
							var allowedExtensions = [ 'jpg', 'jpeg', 'png',
									'gif' ];
							if (files.length > 1) {
								alert('한 개의 파일만 선택할 수 있습니다.');
								fileInput.value = "";
								document.querySelector("div#image_container").innerHTML = "";
								return;
							}
							if (files.length === 1) {
								var file = files[0];
								var fileType = file.type;
								var fileExtension = fileType.split('/')[1];
								if (!allowedExtensions.includes(fileExtension)) {
									alert('허용된 이미지 파일 형식은 .jpg, .jpeg, .png, .gif입니다.');
									fileInput.value = "";
									document
											.querySelector("div#image_container").innerHTML = "";
								} else {
									setThumbnail(event);
								}
							}
						});
		// 이벤트 리스너 설정
		document.getElementById("student_ph").addEventListener("blur",
				handlePhoneNumberBlur);
		document.getElementById("student_id").addEventListener("blur",
				handleIdBlur);
		document.getElementById("student_name").addEventListener("blur",
				handleNameBlur);
		document.getElementById("student_pw").addEventListener("blur",
				handlePasswordBlur);
		document.getElementById("student_email").addEventListener("blur",
				handleEmailBlur);

		document.getElementById("student_major").addEventListener("blur",
				handleMajorBlur);

		document.getElementById("student_year").addEventListener("blur",
				handleYearBlur);
		document.getElementById("student_birth").addEventListener("blur",
				handleBirthDateBlur);

		document.getElementById("student_status").addEventListener("blur",
				handleStatusBlur);

		document.getElementById("student_use").addEventListener("blur",
				handleUseBlur);
		
		function sample6_execDaumPostcode() {
			new daum.Postcode(
					{
						oncomplete : function(data) {
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
