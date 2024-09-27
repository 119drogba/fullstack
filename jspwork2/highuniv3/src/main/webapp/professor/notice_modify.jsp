<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="vo.NoticeBean"%>
<%
	NoticeBean notice = (NoticeBean)request.getAttribute("notice");
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항 수정</title>
<script type="text/javascript">
	function modifyNotice(){
		modifyform.submit();
	}
</script>
<link rel="stylesheet" type="text/css" href="../css/notice_list.css">
<style type="text/css">
</style>
</head>
<body>

<jsp:include page="../header.jsp"></jsp:include>

<section id = "writeForm">
<h2>공지사항 수정</h2>
<form action="noticeModifyPro.nt" method="post" enctype="multipart/form-data" name ="modifyform" >
	<input type = "hidden" name = "NOTICE_ID" value = "<%=notice.getNotice_id()%>">
	<input type = "hidden" name = "page" value = "${page}">
	<table>
		<tr>
			<td class="td_left">
				<label for = "NOTICE_WRITER">글쓴이</label>
			</td>
			<td class="td_right">
				<input type = "text" name="NOTICE_WRITER" id = "NOTICE_WRITER" value = "<%=notice.getNotice_writer()%>">
			</td>
		</tr>
		<tr>
			<td class="td_left">
				<label for = "NOTICE_PASS">비밀번호</label>
			</td>
			<td class="td_right">
				<input name="NOTICE_PASS" type="password" id = "NOTICE_PASS">
			</td>
		</tr>
		<tr>
		    <td class="td_left"><label for="NOTICE_TITLE">제 목</label></td>
		    <td class="td_right">
		        <input name="NOTICE_TITLE" type="text" id="NOTICE_TITLE" value="${notice.notice_title}" required>
		        
		        
		        <c:if test="${sessionScope.id == 'admin'}">
				    <label for="IS_NOTICE">
				        <input type="checkbox" id="IS_NOTICE" name="IS_NOTICE" value="1"> 공지로 설정
				    </label>
				</c:if>

				
			
		    </td>
		</tr>

		<tr>
			<td class="td_left">
				<label for = "NOTICE_CONTENT">내 용</label>
			</td>
			<td>
				<textarea id = "NOTICE_CONTENT" name="NOTICE_CONTENT" cols="40" rows="15"><%=notice.getNotice_content()%></textarea>
			</td>
		</tr>
		<!-- 파일 첨부 -->
		<tr>
		            <td class="td_left"><label for="NOTICE_FILE"> 파일 첨부 </label></td>
		            <td class="td_right"><input name="NOTICE_FILE[]" type="file" id="NOTICE_FILE" multiple></td>
		</tr>
		
		<!-- 이미지 첨부 -->
		        <tr>
		            <td class="td_left"><label for="NOTICE_IMG"> 본문에 이미지 삽입 </label></td>
		            <td class="td_right"><input name="NOTICE_IMG[]" type="file" id="NOTICE_IMG" multiple></td>
		        </tr>
	</table>
		<section id = "commandCell">
				<a href="javascript:modifyNotice()">[수정]</a>&nbsp;&nbsp;
				<a href="javascript:history.go(-1)">[뒤로]</a>
		</section>
</form>
</section>





</body>
</html>