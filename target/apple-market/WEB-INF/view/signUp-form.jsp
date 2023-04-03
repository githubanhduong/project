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
		<div id="tooplate_menu">
	<%@ include file="../../commons/_top.jspf" %>
		</div>
	<form:form action="SignUpCustomer" modelAttribute="customer" method="GET">
		<form:hidden path="no"/>
		<form:input type="hidden" value="ROLE_CUSTOMER" path="customerRole"/>
		<form:input type="hidden" value="true" path="customerActivated"/>
    <div class="wrap">
        <div class="login">
            <h2>회원가입</h2>
            <div class="login_id">
                <h4>이름</h4>
                <form:input placeholder="이름을 입력해주세요." path="customerName" />
            </div>  
            <div class="login_id">
                <h4>ID</h4>
                <form:input  placeholder="ID를 입력해주세요." path="customerId" />
            </div>
            <div class="login_pw">
                <h4>Password</h4>
                <form:input type="password"  placeholder="Password를 입력해주세요." path="customerPw"/>
            </div>
            <div class="login_id">
                <h4>연락처</h4>
                <form:input   placeholder="연락처를 입력해주세요." path="customerPhone"/>
            </div> 
             <div class="login_id">
         		<h4>주소</h4>
         		<form:input id="address_kakao" name="address" placeholder="주소를 입력해주세요." path="customerAddress"  />
         		
         	</div>
         	<div class="login_id">
                <h4>상세주소</h4>
               <form:input class="addressdetail" name="address_detail" placeholder="주소를 입력해주세요."  path="customerAddressDetail" />
            </div>  
            <div class="submit">
                <input type="submit" value="submit">
            </div>
        </div>
    </div>
    </form:form>
</body>
	<script>
	window.onload = function(){
    document.getElementById("address_kakao").addEventListener("click", function(){ //주소입력칸을 클릭하면
        //카카오 지도 발생
        new daum.Postcode({
            oncomplete: function(data) { //선택시 입력값 세팅
                document.getElementById("address_kakao").value = data.address; // 주소 넣기
                	
            }
        		}).open();
    		});
		}
	</script>
</html>