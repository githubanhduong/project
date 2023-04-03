<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%>
<!DOCTYPE html>
<html>
<link
	href="${pageContext.request.contextPath}/resources/css/category.css"
	rel="stylesheet" type="text/css" />


<body id="subpage">
	<div id="tooplate_wrapper">
		<div id="tooplate_header">
			<%@ include file="../../commons/_top.jspf"%>
				<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
			<h1>공지사항</h1>
    	<table  style= "text-align: center; background-color: #eee;
			color: #444; width:100%;">
    <thead>
      <tr style="border:1px solid black;">
        <th style="text-align: center; background-color: #eee;
			color: #444; width:10%; font-size:15px;">번호</th>
        <th style="text-align: center; background-color: #eee;
			color: #444; width:75%; font-size:15px;">제목</th>
        <th style="text-align: center; background-color: #eee;
			color: #444; width:15%; font-size:15px;">작성일</th>
      	</tr>
    </thead>
    <c:forEach var="tempAnnouncement" items="${announcement}">
    	<c:url var ="announcementLink" value="announcementdetail">
			<c:param name="announcementNo" value="${tempAnnouncement.no}"/>
		</c:url> 
    <tbody>
      <tr>
        <td>${tempAnnouncement.no}</td>
        <td><a href="${announcementLink}">${tempAnnouncement.title}</a></td>
        <td>${tempAnnouncement.created}</td>
      </tr>
      </tbody>
      </c:forEach>
    </table>
  	<button type="button" onclick="window.location.href='${pageContext.request.contextPath}/'; return false;">뒤로가기</button>
			<!-- end of main -->

		</div>
			<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
		<!-- end of wrapper -->
		<div id="tooplate_footer_wrapper">
			<div id="tooplate_footer">
				Copyright © 2048 <a href="#">Company Name</a>
				<div class="cleaner"></div>
			</div>
		</div>
</body>
</html>