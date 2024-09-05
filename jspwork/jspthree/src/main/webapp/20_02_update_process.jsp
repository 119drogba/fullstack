<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
	<title>Update</title>
</head>
<body>
	<%@ include file="20_01_dbconn.jsp" %>
<!-- SELECT id, passwd from member where id = 내가 보낸 id값 받아서 처리 
	=> 해당 id가 존재하면 update/존재하지 않으면 "해당 id가 존재하지 않습니다."라는 메세지 띄우기 -->
<!-- UPDATE member SET name = 내가보낸값 WHERE id = 내가보낸값 -->
<!-- DELETE FROM member WHERE id = 내가보낸값 AND passwd = 내가보낸값 -->
	<%
	request.setCharacterEncoding("utf-8");
	String uid = request.getParameter("id");
	String upasswd = request.getParameter("passwd");
	String uname = request.getParameter("name");
	
   	boolean hasId = false;
   	Statement st = null;
   	ResultSet rs = null;
   	
	try {
		String sql = "SELECT id, passwd FROM member WHERE id = '" + uid + "'AND passwd = '" + upasswd + "'";
	   	st = conn.createStatement();
	   	rs = st.executeQuery(sql);
	   	
	   	if (rs.next()) {
	   		hasId = true;
	   		out.print("아이디가 존재합니다.<br>");
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
			String sql = "UPDATE member SET name = ? WHERE id = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, uname);
			ps.setString(2, uid);
			int cnt = ps.executeUpdate();
			
			if (cnt > 0) out.print("이름이 " + uname + "으로 변경되었습니다.<br>");
			else out.print("이름 변경 오류<br>");
		} catch (SQLException ex) {
			out.print("update 오류<br>");
		} finally {
			if (ps != null) ps.close();
		}
	}
	%>
</body>
</html>