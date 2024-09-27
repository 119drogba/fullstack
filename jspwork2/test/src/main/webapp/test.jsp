<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>

.image-container {
  position: relative;
  display: inline-block;
  width: 300px; /* 이미지의 너비 설정 */
  overflow: hidden; /* 오버플로우 방지 */
}

.hover-image {
  width: 100%;
  height: auto;
  display: block;
}

.hover-overlay {
  position: absolute;
  bottom: -100%; /* 화면 아래쪽에 배경을 숨김 */
  left: 0;
  width: 100%;
  height: 100%;
  background-color: rgba(0, 0, 0, 0.7); /* 투명도가 있는 검은색 배경 */
  transition: bottom 1s ease; /* 부드러운 전환 효과 */
  display: flex;
  justify-content: center;
  align-items: center;
}

.hover-text {
  color: white; /* 텍스트 색상 */
  font-size: 20px; /* 텍스트 크기 */
  text-align: center;
}

.image-container:hover .hover-overlay {
  bottom: 0; /* 호버 시 아래에서 위로 올라감 */
}


.aa {
	font-size:25px;
	font-weight:bold;
	margin-bottom:20px
}

.aa1{

	font-size:13px;
	text-align:center;
}

.aa2 {
	
	font-size:13px;
	font-weight:bold;
	border:1px solid;
	margin-top:60px;
	display: inline-block;
	padding: 3px;
}

</style>
</head>
<body>
<div class="image-container">
  <img src="./image/abc.png" alt="기본 사진" class="hover-image">
  <div class="hover-overlay">
  <div class="hover-text">
  
<div class="aa">DARLING POINT STRIP</div>  
  <div class="aa1">깊고 담백한 풍미가 가득한 육즙과 제대로 두툼한</div> 
  <div class="aa1">채끝등심 스테이크(스프 또는 샐러드 제공)</div>
  <div class="aa2">소고기, 미국산, 채끝등심, 420g</div>
  </div>
</div>
</div>
</body>
</html>