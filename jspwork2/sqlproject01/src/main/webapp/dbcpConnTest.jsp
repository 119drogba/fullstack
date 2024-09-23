<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*, javax.sql.*,javax.naming.*" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
//META-INF폴더안의 context.xml파일의 Context태그를 객체화 시켜서 가져오는 작업
Context ctx = new InitialContext();

//위에서 받아온 Context태그객체가 담고 있는 Resource태그 객체들 중에
//이름이 jdbc/OracleDB 인 Resource태그 객체를 받는 작업
//Resource태그 객체의 자료형(type속성)이 javax.sql.DataSource이므로
//받아오는 자료형도 (DataSource)여야 한다.
//다만 lookup메소드는 DataSource자료형을 Object로 포장해서 오기 때문에
//반드시 (DataSource)자료형으로 형변환 해주어야 한다.
DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/OracleDB");

//Resource객체를 받은 ds객체는 Connection Pool(여러 개의 Connection객체를 가지고 있는)객체이기때문에
//그 중에서 필요한 Connection객체 하나를 ds(풀장객체에서)
//getConnection() =>한 개의 connection객체를 얻어와야한다.
Connection conn = ds.getConnection();
out.print("데이터베이스 연결완료<br>");
out.print("데이터베이스 연결 객체(conn): " + conn);


%>
	
</body>
</html>