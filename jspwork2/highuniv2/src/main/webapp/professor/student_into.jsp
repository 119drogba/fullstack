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
             img.style.maxHeight = '250px'; // 이미지 크기 조정
             imageContainer.appendChild(img);
         };

         if (event.target.files.length > 0) {
             reader.readAsDataURL(event.target.files[0]);
         }
     }

     // 파일 이미지 한 개만 --제대로 안되긴함 나중에 하자...............
 /*     document.getElementById('student_image').addEventListener('change', function(event) {
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
     }); */
    </script>
</head>
<body>
    
    <div class="student_into_main">
    	<h1>학생등록</h1>
        <div id="image_container"></div>
        <div class="into_form">
            <form action="studentinto.pr" method="post" enctype="multipart/form-data">
                <div>
                    <label for="student_id">학번<input type="text" name="student_id" id="student_id"></label>
                    <label for="student_pw">비밀번호<input type="text" name="student_pw" id="student_pw"></label>
                </div>
                
                <div>
                    <label for="student_name">이름<input type="text" name="student_name" id="student_name"></label>
                    <input type="radio" name="student_gender" id="male" value="M">
                    <label for="male">남자</label>
                    <input type="radio" name="student_gender" id="female" value="F">
                    <label for="female">여자</label>
                </div>

                <div>                
                    <label for="student_major">전공
                        <select id="student_major" name="student_major">
                            <option value="컴퓨터소프트웨어과" selected>컴퓨터소프트웨어과</option>
                            <option value="천문우주학과">천문우주학과</option>
                            <option value="체육과">체육과</option>
                            <option value="산업디자인과">산업디자인과</option>
                            <option value="간호학과">간호학과</option>
                            <option value="디지털디자인과">디지털디자인과</option>
                        </select>
                    </label>
                </div>

                <div>
                    <label for="student_ph">핸드폰번호<input type="text" name="student_ph" id="student_ph"></label>
                    <label for="student_email">이메일<input type="text" name="student_email" id="student_email"></label>
                </div>

                <div>
                    <label for="student_birth">생일<input type="text" name="student_birth" id="student_birth"></label>
                    <label for="student_intoday">입학날짜<input type="text" name="student_intoday" id="student_intoday"></label>
                </div>

                <div>
                    <label for="student_year">학년<input type="number" name="student_year" id="student_year" value="1" min="1" max="4"></label>
                    <input type="radio" name="student_status" id="student_live" value="재학">
                    <label for="student_live">재학</label>
                    <input type="radio" name="student_status" id="student_rest" value="휴학">
                    <label for="student_rest">휴학</label>
                    <input type="radio" name="student_status" id="student_graduation" value="졸업">
                    <label for="student_graduation">졸업</label>
                    <input type="radio" name="student_status" id="student_out" value="자퇴">
                    <label for="student_out">자퇴</label>
                </div>
                
                <div>
                    <label for="student_address">주소<input type="text" name="student_address" id="student_address"></label>    
                </div>

                <label for="student_image">이미지 </label>
                <input type="file" name="student_image" id="student_image" onchange="setThumbnail(event)" accept=".jpg, .jpeg, .png, .gif"><br>
	            <input type="submit" value="입력"> <input type="submit" value="취소">
	        </form>
        </div>
    </div>
</body>
</html>