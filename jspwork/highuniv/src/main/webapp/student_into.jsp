<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html><head><meta charset="UTF-8"><title>학생 입력</title>
    <link rel="stylesheet" type="text/css" href="css/student_into.css">
	<script>
	// 파일 이미지 미리보기
     function setThumbnail(event) {
         var reader = new FileReader();
         var imageContainer = document.querySelector("div#image_container");
         
         // 기존 이미지가 있으면 제거
         while (imageContainer.firstChild) {
             imageContainer.removeChild(imageContainer.firstChild);
         }

         reader.onload = function(event) {
             var img = document.createElement("img");
             img.setAttribute("src", event.target.result);
             img.style.maxWidth = '200px';  // 이미지 크기 조정
             img.style.maxHeight = '200px'; // 이미지 크기 조정
             imageContainer.appendChild(img);
         };

         if (event.target.files.length > 0) {
             reader.readAsDataURL(event.target.files[0]);
         }
     }

     // 파일 이미지 한 개만 --제대로 안되긴함 나중에 하자...............
     document.getElementById('student_image').addEventListener('change', function(event) {
         var fileInput = event.target;
         var files = fileInput.files;
         var allowedExtensions = ['jpg', 'jpeg', 'png', 'gif'];

         // 파일 수가 1개가 아닌 경우
         if (files.length > 1) {
             alert('한 개의 파일만 선택할 수 있습니다.');
             fileInput.value = ""; // 선택된 파일을 제거
             document.querySelector("div#image_container").innerHTML = ""; // 미리보기 이미지 제거
             return;
         }

         if (files.length === 1) {
             var file = files[0];
             var fileType = file.type;
             var fileExtension = fileType.split('/')[1];

             // 파일 확장자가 허용된 형식인지 확인
             if (!allowedExtensions.includes(fileExtension)) {
                 alert('허용된 이미지 파일 형식은 .jpg, .jpeg, .png, .gif입니다.');
                 fileInput.value = ""; // 선택된 파일을 제거
                 document.querySelector("div#image_container").innerHTML = ""; // 미리보기 이미지 제거
             } else {
                 setThumbnail(event);
             }
         }
     });
    </script>
</head>
<body>
	<div id="image_container"></div>
	<form action="studentinto.pr" method="post" enctype="multipart/form-data">
		<div>
			<label for="student_id">학번</label><input type="text" name="student_id" id="student_id">
            <label for="student_pw">비밀번호</label><input type="text" name="student_pw" id="student_pw"><br>
		</div>
		<div>
            <label for="student_name">이름</label><input type="text" name="student_name" id="student_name"><br>
			<label for="student_major">전공</label><input type="text" name="student_major" id="student_major">
		</div>
        <div>
            <label for="student_ph">핸드폰번호</label><input type="text" name="student_ph" id="student_ph"><br>
            <label for="student_email">이메일</label><input type="text" name="student_email" id="student_email"><br>
        </div>
        <div>
            <label for="student_birth">생일</label><input type="text" name="student_birth" id="student_birth"><br>
            <label for="student_intoday">입학날짜</label><input type="text" name="student_intoday" id="student_intoday"><br>
        </div>
        <div>

        </div>
        <label for="student_gender">성별</label><input type="text" name="student_gender" id="student_gender"><br>
        
		<label for="student_year">학년</label><input type="text" name="student_year" id="student_year"><br>
		<label for="student_address">주소</label><input type="text" name="student_address" id="student_address"><br>
		
		<label for="student_status">상태</label><input type="text" name="student_status" id="student_status"><br>
		<label for="student_image">이미지 </label>
		<input type="file" name="student_image" id="student_image" onchange="setThumbnail(event)" accept=".jpg, .jpeg, .png, .gif" required><br>
		<input type="submit" value="전송">
	</form>
</body>
</html>