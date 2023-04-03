<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%>
<!DOCTYPE html>
<html>
<body>
<%@ include file="../../commons/_top.jspf"%>
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
    <tbody>
      <tr>
        <td>${announcement.no}</td>
        <td>${announcement.title}</td>
        <td>${announcement.created}</td>
      </tr>
      </tbody>
      <tr>
      <td colspan="3" style="text-align: center;">내용:${announcement.text}</td>
      </tr>
   
    </table>
    <button type="button" onclick="window.location.href='${pageContext.request.contextPath}/announcement'; return false;">뒤로가기</button>
   </div>
		</div>
			<br>
	
</body>
</html>