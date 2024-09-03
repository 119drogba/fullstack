<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <c:if test="${errorMsg ne null}">
        <small style="color:#f00;">${errorMsg}</small>
    </c:if>
<%--  <form action="${pageContext.request.contextPath}/18_01_login.jsp" method="post"> --%>
    <form action="<%= request.getContextPath()%>/18_01_login.jsp" method="post">
        아이디: <input type="text" name="memberId" required><br>
        암호: <input type="password" name="password" required><br>
        <input type="submit" value="로그인">
    </form>    
    <br><br>
    <a href="<%=request.getContextPath()%>/board/boardList.jsp">게시판 보기</a>
</body>
</html>