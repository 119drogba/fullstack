<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ include file="20_01_dbconn.jsp" %>

<%
        request.setCharacterEncoding("utf-8");

        String id = request.getParameter("id");
        String passwd = request.getParameter("passwd");
        String name = request.getParameter("name");

        Statement stmt = null;
		/* 지역변수 null */
		PreparedStatement ps = null;
	      try{
	            /* String sql = "INSERT INTO Member(id,passwd,name)" +"VALUES('"+id+"','"+passwd+"','"+name+"')"; */
	            															/* 오라클은 문자열 작은따옴표 */
	            /* stmt = conn.createStatement(); */
	            
	            String sql2 = "SELECT id, passwd FROM member WHERE id = '"+id+"'";															
	            String sql = "UPDATE member SET name = ? WHERE id = ?";
	            ps = conn.prepareStatement(sql);
	            ps.setString(1,id);
	          
	            ps.setString(3,name);
	            int cnt = ps.executeUpdate();
	            
	            if(cnt>0) out.println("Member 테이블 삽입이 성공했습니다.<br>");
	            else out.println("해당 id가 존재하지 않습니다");
	        } catch (SQLException ex) {
	            
	            out.println("SQLException: " + ex.getMessage());
	        }finally{
	            if (stmt != null)
	                stmt.close();
	            if (conn != null)    
	                conn.close();
	        }
	    %>
</body>
</html>