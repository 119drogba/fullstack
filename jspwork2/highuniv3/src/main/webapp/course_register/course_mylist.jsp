<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="../css/student_list.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js">
	</script>
<style>
td, h1 {
	text-align: center;
}

.mylist td {
	cursor: pointer;
}

button {
	cursor: pointer;
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
	<h1>나의 수강신청 목록</h1>
	<br>
	<c:choose>
		<c:when test="${ not empty myCourseList}">
			<div class="student_list">
				<form action="coursedelete.cl" method="get">
					<%-- 			<input type="hidden" value="${myCourseList.courseId}"> --%>
					<div style="text-align: right;">
						<button type="submit" style="width: 70px">수강취소</button>
					</div>
					<br>
					<table>
						<tr>
							<th></th>
							<th>수강코드</th>
							<th>과목코드</th>
							<th>과목명</th>
							<th>학기</th>
							<th>학점</th>
							<th>시작시간</th>
							<th>종료시간</th>
							<th>강의날짜</th>
							<th>교수명</th>
							<th>강의실</th>
						</tr>
						<c:forEach var="myCourseList" items="${myCourseList}">
							<tr class="mylist" onmouseover="this.style='background-color:#c6c3c3;'"
								onmouseout="this.style='background:none'"
								onclick="this.querySelector('.subjectCheckbox').checked = !this.querySelector('.subjectCheckbox').checked; ">

								<td><label onclick="Checkbox(event)"> <input
										name="courseId" type="checkbox" class="subjectCheckbox"
										value="${myCourseList.courseId}">
								</label></td>

								<td>${myCourseList.courseId}</td>
								<td>${myCourseList.subjectId}</td>
								<td>${myCourseList.subjectName}</td>
								<td>${myCourseList.subjectSemester}</td>
								<td class="totalcredit">${myCourseList.subjectCredit}</td>
								<td>${myCourseList.subjectStartTime}</td>
								<td>${myCourseList.subjectEndTime}</td>
								<td>${myCourseList.subjectDay}</td>
								<td>${myCourseList.professorName}</td>
								<td>${myCourseList.subjectRoom}</td>
							</tr>
						</c:forEach>

						<tr>
							<td colspan="10" style="text-align: right;">총학점 :</td>
							<td class="totalcredits"></td>
						</tr>
					</table>
				</form>
			</div>
			<!--페이지 네비게이션-->

		</c:when>

		<c:otherwise>
			<!-- 데이터가 없을경우  -->
			<div class="student_list">
				<table>
					<tr>
						<th>수강코드</th>
						<th>과목코드</th>
						<th>과목명</th>
						<th>학기</th>
						<th>시작시간</th>
						<th>종료시간</th>
						<th>강의날짜</th>
						<th>교수명</th>
						<th>강의실</th>
					</tr>
					<tr>
						<td colspan="9">수강 신청 목록이 없습니다.</td>
					</tr>
				</table>
			</div>
		</c:otherwise>
	</c:choose>
	<script>
							let totalcredits = 0;
							document.querySelectorAll(".totalcredit").forEach(element=>{
								if (totalcredits == 0){
									totalcredits = parseInt(element.innerText);
								} else {
									totalcredits += parseInt(element.innerText);
								}
							});
							console.log(totalcredits);
							document.getElementsByClassName("totalcredits")[0].innerText = totalcredits;
						</script>



	<jsp:include page="../footer.jsp"></jsp:include>

</body>
</html>