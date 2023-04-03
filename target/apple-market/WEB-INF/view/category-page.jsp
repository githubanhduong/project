<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security"%>
<!DOCTYPE html>
<link
	href="${pageContext.request.contextPath}/resources/css/category.css"
	rel="stylesheet" type="text/css" />
<html>
<body>
	<%@ include file="../../commons/_top.jspf"%>
	<%@ include file="../../commons/_category-side.jspf" %>

	<div id="category-main">
		<h2>판매상품타이틀</h2>
		<a href="writePost" class="goodsjoin"><Strong>상품등록</Strong></a>
		<c:forEach var="tempGoods" items="${goods}">
			<c:url var="detailpageLink" value="detailPage">
				<c:param name="goodsNo" value="${tempGoods.no}" />
			</c:url>
			<div class="post_box">
				<div class="box_title">
				<c:forEach var="tempCategory" items="${category}">
					<c:if test="${tempCategory.no == tempGoods.categoryNo}">
            							[${tempCategory.categoryName}]
            				</c:if>
				</c:forEach>
				<c:forEach var="tempSubCategory" items="${subCategory}">
					<c:if test="${tempSubCategory.no == tempGoods.subCategory_no}">
            						[${tempSubCategory.subCategoryName}]
            				</c:if>
				</c:forEach>
				</div>
				<img src="${pageContext.request.contextPath}/resources/images/" alt="No_Image"/>
				<div class="box_imfo">
				<h5>제목:${tempGoods.title}</h5>
				<p>가격:${tempGoods.price}원</p>
				<security:authorize access="isAuthenticated()">
					<a href="${detailpageLink}" 
						style="font-size: 12px">자세히보기</a>
				</security:authorize>
				<p style="text-align:right;">게시글등록일:${tempGoods.created}</p>
				
				</div>
			</div>
		</c:forEach>
	</div>
	</div>
	</div>

</body>
</html>