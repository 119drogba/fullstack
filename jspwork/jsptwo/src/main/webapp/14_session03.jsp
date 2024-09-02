<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Enumeration" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <%
        String name, value;

        Enumeration en = session.getAttributeNames();
        /* getAttributeNames = 속성명들 가져와  */
        int i = 0;

        while (en.hasMoreElements()) {
            i++;
            name = (String) en.nextElement();
            value = session.getAttribute(name).toString();
            out.println("설정된 세션의 속성 이름 ["+ i +"]:"+ name +"<br>");
            out.println("설정된 세션의 속성 값 ["+ i +"]:"+ value +"<br>");
        }
    %>
</body>
</html>