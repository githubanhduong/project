<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>
<%@ taglib uri="http://www.springframework.org/security/tags"  prefix="security"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@400;500;700&display=swap" rel="stylesheet">
    <script src="https://kit.fontawesome.com/53a8c415f1.js" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/login.css">
</head>
<body>
	
		<div id="tooplate_menu">
	<%@ include file="../../commons/_top.jspf" %>
		</div>
	 <form:form action="${pageContext.request.contextPath}/authenticateTheUser" method="POST">
    <div class="wrap">
        <div class="login">
            <h2>로그인</h2>
            <div class="login_sns">
            </div>
            <div class="login_id">
                <h4>ID</h4>
                <input type="text" name="username" id="" placeholder="ID를 입력해주세요." required>
            </div>
            <div class="login_pw">
                <h4>Password</h4>
                <input type="password" name="password" id=""  placeholder="Password를 입력해주세요." required >
            </div>
            <div class="login_etc">
                <div class="checkbox">
                <input type="checkbox" name="" id=""> Remember Me?
                </div>
                <div class="forgot_pw">
                <a href="">Forgot Password?</a>
            	</div>
            </div>
          
            <div class="submit">
                <input type="submit" value="submit">
            </div>
        </div>
    </div>
    </form:form>

</body>
</html>