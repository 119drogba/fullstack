<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <!DOCTYPE html>
    <html>

    <head>
        <meta charset="UTF-8">
        <title>Insert title here</title>
        <style>
            * {
                margin: 0;
                padding: 0;
                box-sizing: border-box;
                list-style: none;
                user-select: none;
            }

            div#wrap {
                width: 100%;
                max-width: 2560px;
                /* border: 1px solid red; */
            }

            body {
                background: #EAEAED;
            }

            /* class */
            .pretendard {
                font-family: "Pretendard Variable";
            }

            .clear {
                clear: both;
            }

            .btn {
                cursor: pointer !important;
            }

            /* header */
            header {
                position: fixed;
                top: 0;
                left: 0;
                width: 100%;
                height: 60px;
                display: flex;
                justify-content: space-between;
                padding-right: 40px;
                font-weight: 700;
                color: #EAEAED;
                background: #0B4DA2;
            }

            header .logo-box {
                width: 250px;
                height: 100%;
                display: flex;
                align-items: center;
                justify-content: center;
                /* border: 1px solid red; */
            }

            header .logo-box img {
                width: 60px;
                height: 100%;
                /* border: 1px solid red; */
            }

            header .logo-box p {
                display: inline;
                margin-left: 10px;
                font-size: 24px;
            }

            header .user-box {
                width: 200px;
                display: flex;
                align-items: center;
                text-align: center;
                /* border: 1px solid red; */
            }

            header .user-box p:first-child {
                display: inline;
                margin: 0 10px;
            }

            header .user-box p {
                font-size: 22px;
            }
        </style>
    </head>

    <body>
        <header>
            <!-- 로고 이미지 영역 -->
            <div class="logo-box">
                <img src="" alt="로고">
                <p>하이대학교</p>
            </div>
            <!-- 사용자 영역 -->
            <div class="user-box">
                <p>
<%
    String userName = (String) session.getAttribute("name");
    String role = (String) session.getAttribute("role");
    if (userName != null) {
%>
    <!-- 역할에 따라 다른 호칭 사용 -->
    <a href="<%=request.getContextPath()%>/mypage.jsp"><%= userName %><%= "professor".equals(role) ? " 교수님" : "님" %></a>
<% } else { %>
    <a href="<%=request.getContextPath()%>/login.jsp">로그인</a>
<% } %>
                </p>
                <p class="btn" onclick="location.href='<%=request.getContextPath() %>/index.jsp';">로그아웃</p>
            </div>
        </header>
        <jsp:include page="aside.jsp"/>
        <!-- 콘텐츠영역 -->
        <main>
            <section class="content">
                <!-- 실제 콘텐츠영역 -->
                <div class="inner">
        
    </body>

    </html>