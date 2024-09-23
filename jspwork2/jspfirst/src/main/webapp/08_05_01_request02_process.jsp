<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- <%@ page import="com.dto.MemberBean" %> --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	// utf-8 : 아스키코드를 벗어난 문자 모든 것을 깨지지 않게 해준다.
	request.setCharacterEncoding("utf-8");
	
// 	// 	int id = request.getParameter("user_id"); // 값은 문자열로 반환하기 때문에 에러.
// 	String id = request.getParameter("user_id");
// 	String name = request.getParameter("user_name");
// 	// 	type="radio" / "checkbox"인 경우 1개만 선택해도 배열로 반환함.
// 	String[] hobby = request.getParameterValues("hobby"); 
	
// 	MemberBean memberBean = new MemberBean();
// 	memberBean.setId(Integer.parseInt(request.getParameter("user_id") != "" ? request.getParameter("user_id") : "0"));
	
	%>
	<%--  <%@ page import="com.dto.MemberBean"%> +  <% MemberBean memberBean= new MemberBean(); %> --%>
	<jsp:useBean id="memberBean" class="com.dto.MemberBean"/>
   	<!-- 
     	request Parameter
     	속성명(name)	|	속성값(value)
     	------------------------------------
     	id			|	5
   	 	name		|	관리자
     	hobby		|	["영화","독서","여행"]
     -->
	
	<!-- memberBean.* -> 파라미터의 속성명과 동일한 이름을 가진 멤버필드의 setter 메소드 기능을 함. ==> setId(), setName(), setHobby()의 역할   -->
	<jsp:setProperty name="memberBean" property="*"/>
	<!-- 파라미터명과 프로퍼티명이 다를 경우 param 속성을 사용해서 연결 -->
	<%-- <jsp:setProperty name="memberBean" property="id" param="user_id"/>  --%>
	<%-- <jsp:setProperty name="memberBean" property="name" param="user_name"/> --%>
	
	아이디: <jsp:getProperty property="id" name="memberBean"/><br> 
	이름: <jsp:getProperty property="name" name="memberBean"/><br> 
	취미: <jsp:getProperty property="hobby" name="memberBean"/><br>
	요청정보 컨텐츠타입 = <%= request.getContentType() %><br> <!--  Content-Type은 post방식만 사용 가능. -->
	
	<small style="color: red"> 클라이언트가 전송한 요청 정보(post로 보낸 데이터만)의 컨텐츠 타입을 구함. String으로 반환</small><br>
	<%
	String[] hobby = memberBean.getHobby();
	for(int i = 0; i < hobby.length; i++){
		if(hobby[i] != null){
			out.print(hobby[i]);
			if(i != (hobby.length -1)) out.write(",");
		} else {
			if(i == 0) out.print("입력된 취미 정보가 확인되지 않습니다.");
		}
	}
	%>
</body>
</html>