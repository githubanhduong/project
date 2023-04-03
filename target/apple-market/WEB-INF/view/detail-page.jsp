<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%>

<!DOCTYPE html>
<html>
<head>


</head>
<body>
	<%@ include file="../../commons/_top.jspf"%>


	<h1>Apple Market</h1>






	<div>
		<div>
			<div>
				<security:authentication property="principal.username"
					var="principal" />
				<h1>제목:${goods.title}</h1>
				<hr>
				<p>가격:${goods.price}원</p>
				<hr>
				<p>상태:${goods.status}</p>
				<hr>
				<p>내용:${goods.description}</p>
				<br> <br> <br>
				<p>작성일:${goods.created}</p>
				<c:if test="${principal == customerId}">
					<c:url var="deleteGoodsLink" value="deleteGoods">
						<c:param name="goodsNo" value="${goods.no}" />
					</c:url>
					<a href="${deleteGoodsLink}" class="more float_r">삭제</a>
					<c:url var="modifyGoodsLink" value="writePost">
						<c:param name="goodsNo" value="${goods.no}" />
					</c:url>
					<a href="${modifyGoodsLink}" class="more float_r">수정</a>


				</c:if>
			</div>
			<div class="riveiw">
				<h2>댓글</h2>
			</div>
			<c:forEach var="tempreview" items="${review}">
				<div class="col_fw">
					<p>작성자:</p>
					<p>내용:${tempreview.review}</p>
					<p>작성일:${tempreview.created}</p>

					<div class="cleaner"></div>
				</div>
			</c:forEach>
			<security:authorize access="isAuthenticated()">
				<div class="col_fw">
					<form method="post" action="savereview">
						<input type="hidden" name="${_csrf.parameterName}"
							value="${_csrf.token}"> <input type="hidden"
							name="goodsNo" value="${goods.no}" /> <input type="text"
							name="review" style="width: 700px; height: 100px" />
						<button type="submit">작성하기</button>
					</form>
					<div class="cleaner"></div>
				</div>
			</security:authorize>

			<security:authorize access="isAnonymous()">
				<div class="col_fw">
					<p>
						<a href="showMyLoginPage"><span></span><strong>댓글작성은
								로그인 후 해주세요.</strong></a>
					<p>
				</div>
			</security:authorize>
		</div>
		<!-- end of content -->


	</div>
	<!-- end of main -->

	</div>

</body>






</html>