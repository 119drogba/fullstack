<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Delete</title>
</head>
<body>
	<%@ include file="20_01_dbconn.jsp" %>
	
	<%
	request.setCharacterEncoding("utf-8");
	String uid = request.getParameter("id");
	String upw = request.getParameter("passwd");
	String uname = null;
	
   	boolean hasId = false;
   	Statement st = null;
   	ResultSet rs = null;
   	
	try {
		String sql = "SELECT name FROM member WHERE id = '" + uid + "'AND passwd = '" + upw + "'";
	   	st = conn.createStatement();
	   	rs = st.executeQuery(sql);
	   	
	   	if (rs.next()) {
	   		uname = rs.getString("name");
	   		out.print("아이디가 존재합니다.<br>");
	   		hasId = true;
	   	}
	   	else out.print("해당 id가 존재하지 않거나 비밀번호가 틀립니다.<br>");
	   	
	} catch (SQLException ex) {
		out.print("insert 오류<br>");
	} finally {
		if (rs != null) rs.close();
		if (st != null) st.close();
	}
	
	if (hasId) {
	   	PreparedStatement ps = null;
	   	
		try {
			String sql = "DELETE FROM member WHERE id = ? AND passwd = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, uid);
			ps.setString(2, upw);
			int cnt = ps.executeUpdate();
			
			if (cnt > 0) out.print(uname + "의 계정이 정상적으로 삭제되었습니다.<br>");
			else out.print("계정 삭제 오류<br>");
		} catch (SQLException ex) {
			out.print("delete 오류<br>");
		} finally {
			if (ps != null) ps.close();
		}
	}
	%>
</body>
</html>