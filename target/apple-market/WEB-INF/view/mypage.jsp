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
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/signUp.css">
    <script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
</head>
<body>

	<%@ include file="../../commons/_top.jspf" %>
	<form:form action="${pageContext.request.contextPath}/" method="get">
    <div class="wrap">
        <div class="login">
            <h2>내정보</h2>
            <div class="login_id">
                <h4>이름: ${customer.customerName}</h4>
            </div>  
            <div class="login_id">
                <h4>ID: ${customer.customerId}</h4>
            </div>
            <div class="login_id">
                <h4>연락처: ${customer.customerPhone}</h4>
            </div> 
             <div class="login_id">
         		<h4>주소: ${customer.customerAddress}</h4>
         	</div>
         	<div class="login_id">
                <h4>상세주소: ${customer.customerAddressDetail}</h4>
            </div>
            <button class="delete" onclick="window.location.href='${pageContext.request.contextPath}/'; return false; ">회원탈퇴</button>
            <div class="submit">
                <input type="submit" value="확인">
            </div>
        </div>
    </div>
    </form:form>
 
</body>
</html>

