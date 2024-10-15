<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>

<body>
<%@ include file="menu.jsp" %>
<div class="container">
  <h2>회원가입</h2>
  <form action="join.do" method="post">
    <div class="form-group">
      
      <input type="text" class="form-control" id="id" placeholder="아이디입력" name="id">
    </div>
    <div class="form-group">
      
      <input type="password" class="form-control" id="pwd" placeholder="비밀번호입력" name="password">
    </div>
    
    <div class="form-group">
      
      <input type="text" class="form-control" id="name" placeholder="이름입력" name="name">
    </div>
    <div class="form-group">
    <select class="form-control" id="role" name="role">
        <option value="Admin">관리자</option>
        <option valuse="User">사용자</option>
      
      </select>
    </div>
    <button type="submit" class="btn btn-primary">회원가입</button>
  </form>
</div>
</body>
</html>