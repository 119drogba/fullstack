<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% 
String userId =  session.getAttribute("userId")!=null?session.getAttribute("userId").toString():"";
%>
<nav id="stNav" class="navbar navbar-expand-sm bg-dark navbar-dark fixed-top">
  <a class="navbar-brand" href="index.jsp">Home</a>
  <ul class="navbar-nav">
    <li class="nav-item">
      <a class="nav-link" href="getBoardList.do">글목록</a>
    </li>    
    <li class="nav-item">
      <a class="nav-link" <c:if test="${userId ne NULL}">href="insertBoard.jsp"</c:if>>글쓰기</a>
    </li>    
  </ul>
 <c:choose>
 	<c:when test='${userId ne NULL}' >
 		<ul class="navbar-nav nav-right">    
		    <li class="nav-item"><a class="nav-link">${userName}님</a></li>
		    <li class="nav-item">
		      <c:choose>
		      	<c:when test='${ userId eq "admin" }'>
			      <a class="nav-link" href="userList.do">회원관리</a>
		      	</c:when>
		      	<c:otherwise>
			      <a class="nav-link" href="selUser.do?id=${userId}">마이페이지</a>
		      	</c:otherwise>
		      </c:choose>
		    </li>
		    <li class="nav-item">
		      <a class="nav-link" href="logout.do">로그아웃</a>
		    </li>
		  </ul>
 	</c:when>
 	<c:otherwise>
 		<ul class="navbar-nav nav-right">    
		   <li class="nav-item">
		     <a class="nav-link" href="login.do">로그인</a>
		   </li>
		 </ul>
 	</c:otherwise>
 </c:choose>
</nav>

	<nav id="subNav" class="navbar navbar-expand-sm bg-dark navbar-dark fixed-top">
	  <a class="navbar-brand" href="index.jsp"><i class="fas fa-home"></i></a>
	  <ul class="navbar-nav nav-right">    
	    <li id="clMenu" class="nav-item">
	      <i class="fa fa-bars" style="font-size:36px;color:#fff;"></i>
	    </li>
	  </ul>
	</nav>
	
	<div id="subNavMenu" style="top:55.82px;" class="container-fluid bg-primary navbar-dark fixed-top">
	  <ul class="navbar-nav nav-right">  
	  	<li class="nav-item">
	      <a class="nav-link" href="getBoardList.do">글목록</a>
	    </li>
	    <li class="nav-item">
	      <a class="nav-link" <c:if test='${ userId ne null}'>href="insertBoard.jsp"</c:if>>글쓰기</a>
	    </li>
<c:choose>
 	<c:when test='${userId ne null}' >
	    <li class="nav-item">
	    	<c:choose>	
	      	<c:when test='${ userId eq "admin" }'>
		      <a class="nav-link" href="userList.do">회원관리</a>
	      	</c:when>
	      	<c:otherwise>
		      <a class="nav-link" href="selUser.do?id=${userId}">마이페이지</a>
	      	</c:otherwise>
	      </c:choose>
	    </li>
	    <li class="nav-item">
	      <a class="nav-link" href="logout.do">로그아웃</a>
	    </li>
 	</c:when>
 	<c:otherwise>
	   <li class="nav-item">
	     <a class="nav-link" href="login.do">로그인</a>
	   </li>
 	</c:otherwise>
</c:choose> 
	  </ul>
	</div>
<br><br>