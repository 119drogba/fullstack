<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.text.NumberFormat" %>
<%@ page import="java.text.DateFormat" %>
<%@ page import="java.util.*" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>현재 지역의 국가, 날짜, 통화</h3>
<%
Locale locale = request.getLocale();   //사용자의 지역정보 받아와
Date currentDate = new Date(); 

DateFormat dateFormat1 = DateFormat.getDateInstance(DateFormat.FULL,locale);
DateFormat dateFormat2 = DateFormat.getDateTimeInstance(DateFormat.FULL,DateFormat.SHORT, locale);
DateFormat dateFormat3 = DateFormat.getDateTimeInstance(DateFormat.FULL,DateFormat.FULL, locale);

NumberFormat numberFormat1 = NumberFormat.getNumberInstance(locale);

NumberFormat numberFormat2 = NumberFormat.getCurrencyInstance(locale);
NumberFormat numberFormat2_1 = NumberFormat.getCurrencyInstance(Locale.KOREA);
NumberFormat numberFormat3 = NumberFormat.getPercentInstance(locale);
/*
https://ko.wikipedia.org/wiki/국제_통화_기호
국제 통화 기호(Currency sign, ¤)는 블특정 통화를 표기할 때 쓰는 기호이다.
사용하려는 폰트에서 특정 통화 기호가 설정되어 있지 않을 때 대신하여 쓴다.
'스카랩' (scarab)'이라고도 한다.

Internationalization (국제화 :i18n)
: 언어와 화폐단위, 기능 등을 해당 국가에 대응하여 변화할 수 있도록 처리하는 기능을 말한다.
예) 화폐단위의 자동인식 처리, 언어 자동인식 처리등(다국어지원)
*/

%>
<p> 언어 : <%=locale.getDisplayLanguage() %></p>
<p> dateFormat1 날짜(요일까지) : <%=dateFormat1.format(currentDate) %></p>
<p> dateFormat2 날짜시간(분까지만) : <%=dateFormat2.format(currentDate) %></p>

<p> dateFormat3 날짜시간(모두) : <%=dateFormat3.format(currentDate) %>
	<small style="color:red">(한국 표준시(KST, korea Standard Time))</small>
</p>
<hr>
<p> numberFormat1 숫자 (천단위 구분) : <%=numberFormat1.format(12345.67) %></p>
<p> numberFormat2 숫자 (지역의 통화 형식) : <%=numberFormat2.format(12345.67) %></p>
<p> numberFormat2_1 숫자 (지역의 통화 형식) : <%=numberFormat2_1.format(12345.67) %></p>
<p> numberFormat3 숫자 (지역의 비율 형식) : <%=numberFormat3.format(0.45)%></p>
</body>
</html>