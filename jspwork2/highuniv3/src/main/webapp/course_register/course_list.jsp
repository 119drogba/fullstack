<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>수강 리스트</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<style>


* {
	box-sizing: border-box;
}

.container {
	text-align: center;
	width: 80%;
	margin: 0 auto;
}


.student_search_form {
    width: 250px;
    float: right;
    margin-bottom: 10px;
}

.student_search_form input[type=text] {
	padding: 5px;
}

table {
	border-collapse: collapse;
	width: 100%;
	margin: 0 auto;
}

 table tr:nth-child(1) { 
 	border-bottom: 1px solid #0b4da2; 
 	border-top: 1px solid #0b4da2; 
 	background-color: aliceblue; 
 } 

table tr {
	border-bottom: 1px solid #ccc;
}

button {
	color: white;
	background-color: #0b4da2;
	border-radius: 5px;
	border: none;
	width: 50px;
	padding: 4px;
	cursor: pointer;
}

tr td {
	padding: 10px 0 10px 0;
}
td{
	cursor: pointer;
}
.search{
	width: 200px;
}
</style>
</head>
<body>
<script>
function Checkbox(event) {
  const checkbox = event.currentTarget.querySelector('.subjectCheckbox');
  checkbox.checked = !checkbox.checked;
  if (event.target !== checkbox) {
    checkbox.click();
  }
}
</script>
	<jsp:include page="../header.jsp"></jsp:include>
	<div class="container">
		<h1>강의정보</h1>
		<div class=""></div>
		<c:choose>
			<c:when test="${ not empty courseList}">
				<div class="student_list">
				<form action="Courselist.cl" method="get">
					<div style="text-align: left; float: left;"><input type="text"  style="padding: 3px; width: 250px;" name= "subjectSearch" class="search" placeholder="과목명, 교수명, 수강요일을 입력하세요." value="${param.subjectSearch}"> <button type="submit">검색</button></div>
					</form> 
					<form action="courseinto.cl" method="get" id="courseForm">
					<div style="text-align: right; "><button type="submit">신청</button></div>
					<br>
						<table>
							<tr>
								<th>신청여부</th>
								<th>강의코드</th>
								<th>과목코드</th>
								<th>과목명</th>
								<th>인원현황</th>
								<th>학기</th>
								<th>학점</th>
								<th>시작시간</th>
								<th>종료시간</th>
								<th>강의날짜</th>
								<th>교수명</th>
								<th>강의실</th>
							</tr>
							<c:forEach var="courselist" items="${courseList}"
								varStatus="status">
								<tr onmouseover="this.style='background-color:#c6c3c3;'" onmouseout="this.style='background:none'" onclick="this.querySelector('.subjectCheckbox').checked = !this.querySelector('.subjectCheckbox').checked; ">
									<td>
										<c:choose>
											<c:when test="${courselist.maxCount < courselist.courseMaxPeople && courselist.courseStatus eq '가능'}">
												<label onclick="Checkbox(event)">
												<input name="subjectId" type="checkbox" class="subjectCheckbox" value="${courselist.subjectId}">
												</label>
											</c:when>
											<c:otherwise>
												<span class="input_text" style="color:red">정원초과</span>
												<c:if test="${courselist.courseStatus eq '완료'}">
													<script>
														$('.input_text').text("신청완료").css("color", "blue");
													</script>
												</c:if>
											</c:otherwise>
										</c:choose>
									</td>
									<td>${courselist.courseId}</td>
									<td>${courselist.subjectId}</td>
									<td>${courselist.subjectName}</td>
									<td><input style="display: none;" type="text"
										name="courseId" value="${courselist.courseId}">${courselist.maxCount}/${courselist.courseMaxPeople}</td>
									<td>${courselist.subjectSemester}</td>
									<td>${courselist.subjectCredit}</td>
									<td>${courselist.subjectStartTime}</td>
									<td>${courselist.subjectEndTime}</td>
									<td>${courselist.subjectDay}</td>
									<td>${courselist.professorName}</td>
									<td>${courselist.subjectRoom}</td>
								</tr>
							</c:forEach>
						</table>
					</form>
				</div>
				<br>
				<br>

								<form action="coursemylist.cl" method="get">
									<button type="submit" style="width: 120px; float: right;">내	수강목록 보기</button>
								</form>
				<!--페이지 네비게이션-->
			</c:when>
			<c:otherwise>
				<!-- 데이터가 없을경우  -->
				<div class="student_list">
					<table>
						<tr>
							<th>신청여부</th>
							<th>과목코드</th>
							<th>과목명</th>
							<th>학기</th>
							<th>학점</th>
							<th>강의시간</th>
							<th>강의날짜</th>
							<th>교수명</th>
							<th>강의실</th>
							<th>수강인원</th>
							<th>상태</th>
						</tr>
						<tr>
							<td colspan="11">수강 가능한 과목이 없습니다.</td>
						</tr>
					</table>
				</div>
			</c:otherwise>
		</c:choose>
	</div>
	<jsp:include page="../footer.jsp"></jsp:include>
</body>
</html>
