<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="javax.servlet.http.HttpSession" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <h4>----- 세션을 삭제하기 전 -------</h4>
    <%
        /* request.getSession()   => request.getSession(false)와 동일
        기존의 session객체가 있으면 가져오고, 없으면 null값 반환
        request.getSession(true) : 기존의 session객체가 있으면 가져오고, 없으면 새로운 세션객체 생성
        HttpSession ss = request.getSession(); */
        
        String user_id = (String) session.getAttribute("userID");
        String user_pw = (String) session.getAttribute("userPW");
        out.println("설정된 세션 이름 userID: " +user_id+"<br>");
        out.println("설정된 세션 값 userPW: " +user_pw+"<br>");

        /* out.print("만료전 세션id: " + session.getId()+"<br><hr>") */

        if(request.isRequestedSessionIdValid() == true){
            out.print("세션이 유효합니다.");
        }else {
            out.print("세션이 유효하지 않습니다. ");
        }
        /*  다중 세션삭제(로그아웃) 
        (Attribute속성 및 세션id까지 제거함. session객체 안의 데이터 모두 초기화) 
        session.invalidate(); */
    %>
    <h4>----- 세션을 삭제한 후 ------</h4>
    <%

    /* out.print("만료후 세션id: " + session.getId()+"<br><hr>") */
        if(request.isRequestedSessionIdValid() == true) {
            out.print("세션이 유효합니다.");
        }else {
            out.print("세션이 유효하지 않습니다.");
        }

    %>
</body>
</html>