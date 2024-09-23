<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
		String addr3 = request.getParameter("addr3");
		String zipcode = request.getParameter("zipcode");
		String addr2 = request.getParameter("addr2");
		String addr1 = request.getParameter("addr1");
		String comment = request.getParameter("comment");
	%>
	<br>우편번호:<%=zipcode %>
	<br>상세주소:<%=addr3 %>
	<br>지번주소:<%=addr2 %>
	<br>도로명주소:<%=addr1 %>
	<br>참고항목:<%=comment %>
	
	${param.zipcode }
	${param.addr1 }
	${param.addr2 }
	${param.addr3 }
	${param.comment }
	
<jsp:useBean id="add" class="com.dto.AddrVO"/>	
<jsp:setProperty property="*" name="add"/>
<br><jsp:getProperty property="zipcode" name="add"/>
<br><jsp:getProperty property="addr1" name="add"/>
<br><jsp:getProperty property="addr2" name="add"/>
<br><jsp:getProperty property="addr3" name="add"/>
<br><jsp:getProperty property="comment" name="add"/>
	
</body>
</html>