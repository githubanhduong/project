<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>
<!DOCTYPE html>
<html>

<body>
   <%@ include file="../../commons/_top.jspf" %>
  
  <%--   <div>
    	<div>
        	<div>
            	<h2>카테고리</h2>
                <ul>
                	 <c:forEach var="tempCategory" items="${category}">
   					 	 <li class=dropdown><a class="dropdown-toggle" href="#" data-toggle="dropdown">${tempCategory.categoryName}</a>
   							<div class="dropdown-menu">
   								<c:forEach var="tempSubCategory" items="${subCategory}">
   										<c:if test="${tempCategory.no == tempSubCategory.categoryNo}"> 
   											<a class="dropdown-item" href="#">${tempSubCategory.subCategoryName}</a>
   										</c:if>
   								</c:forEach>
   							</div>
   						</li>   
               		 </c:forEach>
                </ul>
            </div>
        </div> <!-- end of sidebar --> --%>
        
        <div id="tooplate_content">
       	  
			<h2>판매물품 등록하기</h2>
            <div class="cleaner h20"></div>
        	
            <div>
                <div class="col_w400 float_l">	
               <div id="contact_form">
                    <form method="POST" name="contact"  action="${pageContext.request.contextPath}/goodsUpload" enctype="multpart/form-data" accept-charset="utf-8"> 
                     <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
                     <h4><Strong>카테고리</Strong></h4>
                     <select name="mainCategory">  	
   						  <option value="">전체</option>
  					</select>
                   	
                   	<select name="subCategory">
        				<option value="">전체</option>
   					</select>
                   
                   
                    <hr>
                    	<h4><Strong>상태</Strong></h4>
                    		<select name="status" >
                    			<option value="중고">중고</option>
                    			<option value="미개봉">미개봉</option>
                    			<option value="무료나눔">무료나눔</option>
                    		</select>
					<hr>
                            <label>제목:</label> <input  type="text"  name="title" placeholder="제목을 입력해주세요." style="width: 300px; padding: 5px; color: #666; border: 1px solid #a7a7a7;  background: #e8e8e8; font-family: Tahoma, Geneva, sans-serif; font-size: 12px;margin-top: 5px;"/>
                            <div class="cleaner h10"></div>                               
                            <label >가격:</label> <input  type="text" name="price" style="width: 300px; padding: 5px; color: #666; border: 1px solid #a7a7a7;  background: #e8e8e8; font-family: Tahoma, Geneva, sans-serif; font-size: 12px; margin-top: 5px;"  />
                            <div class="cleaner h10"></div>
                            <label >내용:</label> <input  name="text" placeholder="내용을 입력해주세요." style="width: 390px; height: 200px; padding: 5px; color: #666; border: 1px solid #a7a7a7;  background: #e8e8e8; font-family: Tahoma, Geneva, sans-serif; font-size: 12px; margin-top: 5px;"/>
                            <label >이미지:</label><input type="file" class="validate-email required input_field" name="email" id="email" />
                            <div class="cleaner h10"></div>			
                            <input type="submit" value="업로드" name="upload" style="margin: 10px 0px; padding: 5px 14px; border: 1px solid #a7a7a7;  background: #e8e8e8; font-size: 14px; "/>                           
 					</form>
           
                </div>  
                </div>            
              
			</div>
                   
        </div> <!-- end of content -->
        
        <div class="cleaner h20"></div>
    </div> <!-- end of main -->
    
</div> <!-- end of wrapper -->
<div id="tooplate_footer_wrapper">
    <div id="tooplate_footer">
        Copyright © 2048 <a href="#">Company Name</a>
        <div class="cleaner"></div>
    </div>
</div>  
<script type="text/javascript">
$(document).ready(function() {
    
    //Main 카테고리를 선택 할때 마다 AJAX를 호출할 수 있지만 DB접속을 매번 해야 하기 때문에 main, sub카테고리 전체을 들고온다.
    
    //****************이부분은 DB로 셋팅하세요.
    //Main 카테고리 셋팅 (DB에서 값을 가져와 셋팅 하세요.)
    var mainCategoryArray = new Array();
    var mainCategoryObject = new Object();
   
    mainCategoryObject = new Object();
    mainCategoryObject.main_category_id = "1";
    mainCategoryObject.main_category_name = "수입명품";
    mainCategoryArray.push(mainCategoryObject);
    
    mainCategoryObject = new Object();
    mainCategoryObject.main_category_id = "2";
    mainCategoryObject.main_category_name = "패션의류";
    mainCategoryArray.push(mainCategoryObject);
    
    mainCategoryObject = new Object();
    mainCategoryObject.main_category_id = "3";
    mainCategoryObject.main_category_name = "패션잡화";
    mainCategoryArray.push(mainCategoryObject);
    
    mainCategoryObject = new Object();
    mainCategoryObject.main_category_id = "4";
    mainCategoryObject.main_category_name = "뷰티";
    mainCategoryArray.push(mainCategoryObject);
 
    mainCategoryObject = new Object();
    mainCategoryObject.main_category_id = "5";
    mainCategoryObject.main_category_name = "출산/유아동";
    mainCategoryArray.push(mainCategoryObject);
    
    mainCategoryObject = new Object();
    mainCategoryObject.main_category_id = "6";
    mainCategoryObject.main_category_name = "모바일/태블릿";
    mainCategoryArray.push(mainCategoryObject);
    
    mainCategoryObject = new Object();
    mainCategoryObject.main_category_id = "7";
    mainCategoryObject.main_category_name = "가전제품";
    mainCategoryArray.push(mainCategoryObject);
    
    mainCategoryObject = new Object();
    mainCategoryObject.main_category_id = "8";
    mainCategoryObject.main_category_name = "노트북/PC";
    mainCategoryArray.push(mainCategoryObject);
    
    mainCategoryObject = new Object();
    mainCategoryObject.main_category_id = "9";
    mainCategoryObject.main_category_name = "카메라/캠코더";
    mainCategoryArray.push(mainCategoryObject);
    
   
    //Sub 카테고리 셋팅 (DB에서 값을 가져와 셋팅 하세요.)
    var subCategoryArray = new Array();
    var subCategoryObject = new Object();
    
    //스포츠에 해당하는 sub category 리스트
    subCategoryObject = new Object();
    subCategoryObject.main_category_id = "1";
    subCategoryObject.sub_category_id = "2"
    subCategoryObject.sub_category_name = "여성신발"    
    subCategoryArray.push(subCategoryObject);
    
    subCategoryObject = new Object();
    subCategoryObject.main_category_id = "1";
    subCategoryObject.sub_category_id = "3"
    subCategoryObject.sub_category_name = "남성신발"    
    subCategoryArray.push(subCategoryObject);
    
    subCategoryObject = new Object();
    subCategoryObject.main_category_id = "1";
    subCategoryObject.sub_category_id = "4"
    subCategoryObject.sub_category_name = "가방/핸드백"    
    subCategoryArray.push(subCategoryObject);
    
    //공연에 해당하는 sub category 리스트
    subCategoryObject = new Object();
    subCategoryObject.main_category_id = "1";
    subCategoryObject.sub_category_id = "5"
    subCategoryObject.sub_category_name = "지갑/벨트"    
    subCategoryArray.push(subCategoryObject);
    
    subCategoryObject = new Object();
    subCategoryObject.main_category_id = "1";
    subCategoryObject.sub_category_id = "6"
    subCategoryObject.sub_category_name = "여성의류"    
    subCategoryArray.push(subCategoryObject);
    
    subCategoryObject = new Object();
    subCategoryObject.main_category_id = "1";
    subCategoryObject.sub_category_id = "7"
    subCategoryObject.sub_category_name = "남성의류"    
    subCategoryArray.push(subCategoryObject);
    
    subCategoryObject = new Object();
    subCategoryObject.main_category_id = "1";
    subCategoryObject.sub_category_id = "8"
    subCategoryObject.sub_category_name = "패션잡화"    
    subCategoryArray.push(subCategoryObject);
    
    subCategoryObject = new Object();
    subCategoryObject.main_category_id = "1";
    subCategoryObject.sub_category_id = "9"
    subCategoryObject.sub_category_name = "시계/쥬얼리"    
    subCategoryArray.push(subCategoryObject);
    
    subCategoryObject = new Object();
    subCategoryObject.main_category_id = "1";
    subCategoryObject.sub_category_id = "10"
    subCategoryObject.sub_category_name = "유아동"    
    subCategoryArray.push(subCategoryObject);
    
    subCategoryObject = new Object();
    subCategoryObject.main_category_id = "1";
    subCategoryObject.sub_category_id = "11"
    subCategoryObject.sub_category_name = "기타 수입명품"    
    subCategoryArray.push(subCategoryObject);
    
    subCategoryObject = new Object();
    subCategoryObject.main_category_id = "1";
    subCategoryObject.sub_category_id = "7"
    subCategoryObject.sub_category_name = "남성의류"    
    subCategoryArray.push(subCategoryObject);
    
    subCategoryObject = new Object();
    subCategoryObject.main_category_id = "2";
    subCategoryObject.sub_category_id = "13"
    subCategoryObject.sub_category_name = "여성의류"    
    subCategoryArray.push(subCategoryObject);
    
    subCategoryObject = new Object();
    subCategoryObject.main_category_id = "2";
    subCategoryObject.sub_category_id = "14"
    subCategoryObject.sub_category_name = "남성의류"    
    subCategoryArray.push(subCategoryObject);
    
    subCategoryObject = new Object();
    subCategoryObject.main_category_id = "2";
    subCategoryObject.sub_category_id = "15"
    subCategoryObject.sub_category_name = "교복/체육복/단복"    
    subCategoryArray.push(subCategoryObject);
    
    subCategoryObject = new Object();
    subCategoryObject.main_category_id = "2";
    subCategoryObject.sub_category_id = "16"
    subCategoryObject.sub_category_name = "클로젯셰어"    
    subCategoryArray.push(subCategoryObject);
    
    subCategoryObject = new Object();
    subCategoryObject.main_category_id = "3";
    subCategoryObject.sub_category_id = "18"
    subCategoryObject.sub_category_name = "운동화"    
    subCategoryArray.push(subCategoryObject);
    
    subCategoryObject = new Object();
    subCategoryObject.main_category_id = "3";
    subCategoryObject.sub_category_id = "19"
    subCategoryObject.sub_category_name = "여성신발"    
    subCategoryArray.push(subCategoryObject);
    
    subCategoryObject = new Object();
    subCategoryObject.main_category_id = "3";
    subCategoryObject.sub_category_id = "20"
    subCategoryObject.sub_category_name = "남성신발"    
    subCategoryArray.push(subCategoryObject);
    
    subCategoryObject = new Object();
    subCategoryObject.main_category_id = "3";
    subCategoryObject.sub_category_id = "21"
    subCategoryObject.sub_category_name = "가방/핸드백"    
    subCategoryArray.push(subCategoryObject);
    
    subCategoryObject = new Object();
    subCategoryObject.main_category_id = "3";
    subCategoryObject.sub_category_id = "22"
    subCategoryObject.sub_category_name = "지갑/벨트"    
    subCategoryArray.push(subCategoryObject);
    
    subCategoryObject = new Object();
    subCategoryObject.main_category_id = "3";
    subCategoryObject.sub_category_id = "23"
    subCategoryObject.sub_category_name = "악세서리/귀금속"    
    subCategoryArray.push(subCategoryObject);
    
    subCategoryObject = new Object();
    subCategoryObject.main_category_id = "3";
    subCategoryObject.sub_category_id = "24"
    subCategoryObject.sub_category_name = "시계"    
    subCategoryArray.push(subCategoryObject);
    
    subCategoryObject = new Object();
    subCategoryObject.main_category_id = "3";
    subCategoryObject.sub_category_id = "25"
    subCategoryObject.sub_category_name = "선글라스/안경"    
    subCategoryArray.push(subCategoryObject);
    
    subCategoryObject = new Object();
    subCategoryObject.main_category_id = "3";
    subCategoryObject.sub_category_id = "26"
    subCategoryObject.sub_category_name = "모자"    
    subCategoryArray.push(subCategoryObject);
    
    subCategoryObject = new Object();
    subCategoryObject.main_category_id = "3";
    subCategoryObject.sub_category_id = "27"
    subCategoryObject.sub_category_name = "기타잡화/관련용품"    
    subCategoryArray.push(subCategoryObject);
    
    subCategoryObject = new Object();
    subCategoryObject.main_category_id = "4";
    subCategoryObject.sub_category_id = "29"
    subCategoryObject.sub_category_name = "스킨케어"    
    subCategoryArray.push(subCategoryObject);
    
    subCategoryObject = new Object();
    subCategoryObject.main_category_id = "4";
    subCategoryObject.sub_category_id = "30"
    subCategoryObject.sub_category_name = "메이크업"    
    subCategoryArray.push(subCategoryObject);
    
    subCategoryObject = new Object();
    subCategoryObject.main_category_id = "4";
    subCategoryObject.sub_category_id = "31"
    subCategoryObject.sub_category_name = "팩/클렌징/필링"    
    subCategoryArray.push(subCategoryObject);
    
    subCategoryObject = new Object();
    subCategoryObject.main_category_id = "4";
    subCategoryObject.sub_category_id = "32"
    subCategoryObject.sub_category_name = "헤어/바디"    
    subCategoryArray.push(subCategoryObject);
    
    subCategoryObject = new Object();
    subCategoryObject.main_category_id = "4";
    subCategoryObject.sub_category_id = "33"
    subCategoryObject.sub_category_name = "향수"    
    subCategoryArray.push(subCategoryObject);
    
    subCategoryObject = new Object();
    subCategoryObject.main_category_id = "4";
    subCategoryObject.sub_category_id = "34"
    subCategoryObject.sub_category_name = "네일케어"    
    subCategoryArray.push(subCategoryObject);
    
    subCategoryObject = new Object();
    subCategoryObject.main_category_id = "4";
    subCategoryObject.sub_category_id = "35"
    subCategoryObject.sub_category_name = "남성화장품"    
    subCategoryArray.push(subCategoryObject);
    
    subCategoryObject = new Object();
    subCategoryObject.main_category_id = "4";
    subCategoryObject.sub_category_id = "36"
    subCategoryObject.sub_category_name = "가발/기타용품"    
    subCategoryArray.push(subCategoryObject);
    
    subCategoryObject = new Object();
    subCategoryObject.main_category_id = "5";
    subCategoryObject.sub_category_id = "38"
    subCategoryObject.sub_category_name = "출산/육아용품"    
    subCategoryArray.push(subCategoryObject);
    
    subCategoryObject = new Object();
    subCategoryObject.main_category_id = "5";
    subCategoryObject.sub_category_id = "39"
    subCategoryObject.sub_category_name = "유아동안전/실내용품"    
    subCategoryArray.push(subCategoryObject);
    
    subCategoryObject = new Object();
    subCategoryObject.main_category_id = "5";
    subCategoryObject.sub_category_id = "40"
    subCategoryObject.sub_category_name = "유아동의류"    
    subCategoryArray.push(subCategoryObject);
    
    subCategoryObject = new Object();
    subCategoryObject.main_category_id = "5";
    subCategoryObject.sub_category_id = "41"
    subCategoryObject.sub_category_name = "유아동잡화"    
    subCategoryArray.push(subCategoryObject);
    
    subCategoryObject = new Object();
    subCategoryObject.main_category_id = "5";
    subCategoryObject.sub_category_id = "42"
    subCategoryObject.sub_category_name = "유아동가구"    
    subCategoryArray.push(subCategoryObject);
    
    subCategoryObject = new Object();
    subCategoryObject.main_category_id = "5";
    subCategoryObject.sub_category_id = "43"
    subCategoryObject.sub_category_name = "유아동교구/완구"    
    subCategoryArray.push(subCategoryObject);
    
    subCategoryObject = new Object();
    subCategoryObject.main_category_id = "5";
    subCategoryObject.sub_category_id = "44"
    subCategoryObject.sub_category_name = "기타 유아동용품"    
    subCategoryArray.push(subCategoryObject);
    
    subCategoryObject = new Object();
    subCategoryObject.main_category_id = "5";
    subCategoryObject.sub_category_id = "45"
    subCategoryObject.sub_category_name = "코너마켓"    
    subCategoryArray.push(subCategoryObject);
    
    subCategoryObject = new Object();
    subCategoryObject.main_category_id = "6";
    subCategoryObject.sub_category_id = "47"
    subCategoryObject.sub_category_name = "스마트폰"    
    subCategoryArray.push(subCategoryObject);
    
    subCategoryObject = new Object();
    subCategoryObject.main_category_id = "6";
    subCategoryObject.sub_category_id = "48"
    subCategoryObject.sub_category_name = "태블릿PC"    
    subCategoryArray.push(subCategoryObject);
    
    subCategoryObject = new Object();
    subCategoryObject.main_category_id = "6";
    subCategoryObject.sub_category_id = "49"
    subCategoryObject.sub_category_name = "스마트워치/밴드"    
    subCategoryArray.push(subCategoryObject);
    
    subCategoryObject = new Object();
    subCategoryObject.main_category_id = "6";
    subCategoryObject.sub_category_id = "50"
    subCategoryObject.sub_category_name = "일반/피쳐폰"    
    subCategoryArray.push(subCategoryObject);
    
    subCategoryObject = new Object();
    subCategoryObject.main_category_id = "6";
    subCategoryObject.sub_category_id = "51"
    subCategoryObject.sub_category_name = "케이스/거치대/보호필름"    
    subCategoryArray.push(subCategoryObject);
    
    subCategoryObject = new Object();
    subCategoryObject.main_category_id = "6";
    subCategoryObject.sub_category_id = "52"
    subCategoryObject.sub_category_name = "배터리/충전기/케이블"    
    subCategoryArray.push(subCategoryObject);
    
    subCategoryObject = new Object();
    subCategoryObject.main_category_id = "6";
    subCategoryObject.sub_category_id = "53"
    subCategoryObject.sub_category_name = "메모리/젠더/리더기"    
    subCategoryArray.push(subCategoryObject);
    
    subCategoryObject = new Object();
    subCategoryObject.main_category_id = "7";
    subCategoryObject.sub_category_id = "55"
    subCategoryObject.sub_category_name = "냉장고"    
    subCategoryArray.push(subCategoryObject);
    
    subCategoryObject = new Object();
    subCategoryObject.main_category_id = "7";
    subCategoryObject.sub_category_id = "56"
    subCategoryObject.sub_category_name = "TV"    
    subCategoryArray.push(subCategoryObject);
    
    subCategoryObject = new Object();
    subCategoryObject.main_category_id = "7";
    subCategoryObject.sub_category_id = "57"
    subCategoryObject.sub_category_name = "세탁기/건조기"    
    subCategoryArray.push(subCategoryObject);
    
    subCategoryObject = new Object();
    subCategoryObject.main_category_id = "7";
    subCategoryObject.sub_category_id = "58"
    subCategoryObject.sub_category_name = "주방가전"    
    subCategoryArray.push(subCategoryObject);
    
    subCategoryObject = new Object();
    subCategoryObject.main_category_id = "7";
    subCategoryObject.sub_category_id = "59"
    subCategoryObject.sub_category_name = "스마트홈"    
    subCategoryArray.push(subCategoryObject);
    
    subCategoryObject = new Object();
    subCategoryObject.main_category_id = "7";
    subCategoryObject.sub_category_id = "60"
    subCategoryObject.sub_category_name = "영상가전"    
    subCategoryArray.push(subCategoryObject);
    
    subCategoryObject = new Object();
    subCategoryObject.main_category_id = "7";
    subCategoryObject.sub_category_id = "61"
    subCategoryObject.sub_category_name = "음향가전"    
    subCategoryArray.push(subCategoryObject);
    
    subCategoryObject = new Object();
    subCategoryObject.main_category_id = "7";
    subCategoryObject.sub_category_id = "62"
    subCategoryObject.sub_category_name = "계절가전"    
    subCategoryArray.push(subCategoryObject);
    
    subCategoryObject = new Object();
    subCategoryObject.main_category_id = "7";
    subCategoryObject.sub_category_id = "63"
    subCategoryObject.sub_category_name = "생활가전"    
    subCategoryArray.push(subCategoryObject);
    
    subCategoryObject = new Object();
    subCategoryObject.main_category_id = "7";
    subCategoryObject.sub_category_id = "64"
    subCategoryObject.sub_category_name = "미용가전"    
    subCategoryArray.push(subCategoryObject);
    
    subCategoryObject = new Object();
    subCategoryObject.main_category_id = "7";
    subCategoryObject.sub_category_id = "65"
    subCategoryObject.sub_category_name = "기타 가전제품"    
    subCategoryArray.push(subCategoryObject);
    
    subCategoryObject = new Object();
    subCategoryObject.main_category_id = "8";
    subCategoryObject.sub_category_id = "67"
    subCategoryObject.sub_category_name = "노트북/넷북"    
    subCategoryArray.push(subCategoryObject);
    
    subCategoryObject = new Object();
    subCategoryObject.main_category_id = "8";
    subCategoryObject.sub_category_id = "68"
    subCategoryObject.sub_category_name = "데스크탑/본체"    
    subCategoryArray.push(subCategoryObject);
    
    subCategoryObject = new Object();
    subCategoryObject.main_category_id = "8";
    subCategoryObject.sub_category_id = "69"
    subCategoryObject.sub_category_name = "모니터"    
    subCategoryArray.push(subCategoryObject);
    
    subCategoryObject = new Object();
    subCategoryObject.main_category_id = "8";
    subCategoryObject.sub_category_id = "70"
    subCategoryObject.sub_category_name = "CPU/메인보드"    
    subCategoryArray.push(subCategoryObject);
    
    subCategoryObject = new Object();
    subCategoryObject.main_category_id = "8";
    subCategoryObject.sub_category_id = "71"
    subCategoryObject.sub_category_name = "HDD/SSD/ODD"    
    subCategoryArray.push(subCategoryObject);
    
    subCategoryObject = new Object();
    subCategoryObject.main_category_id = "8";
    subCategoryObject.sub_category_id = "72"
    subCategoryObject.sub_category_name = "RAM/VGA/SOUND"    
    subCategoryArray.push(subCategoryObject);
    
    subCategoryObject = new Object();
    subCategoryObject.main_category_id = "8";
    subCategoryObject.sub_category_id = "73"
    subCategoryObject.sub_category_name = "USB/케이블"    
    subCategoryArray.push(subCategoryObject);
    
    subCategoryObject = new Object();
    subCategoryObject.main_category_id = "8";
    subCategoryObject.sub_category_id = "74"
    subCategoryObject.sub_category_name = "케이스/파워/쿨러"    
    subCategoryArray.push(subCategoryObject);
    
    subCategoryObject = new Object();
    subCategoryObject.main_category_id = "8";
    subCategoryObject.sub_category_id = "75"
    subCategoryObject.sub_category_name = "키보드/마우스/스피커"    
    subCategoryArray.push(subCategoryObject);
    
    subCategoryObject = new Object();
    subCategoryObject.main_category_id = "8";
    subCategoryObject.sub_category_id = "76"
    subCategoryObject.sub_category_name = "프린터/복합기/잉크/토너"    
    subCategoryArray.push(subCategoryObject);
    
    subCategoryObject = new Object();
    subCategoryObject.main_category_id = "8";
    subCategoryObject.sub_category_id = "77"
    subCategoryObject.sub_category_name = "공유기/랜카드"    
    subCategoryArray.push(subCategoryObject);
    
    subCategoryObject = new Object();
    subCategoryObject.main_category_id = "8";
    subCategoryObject.sub_category_id = "78"
    subCategoryObject.sub_category_name = "소프트웨어"    
    subCategoryArray.push(subCategoryObject);
    
    subCategoryObject = new Object();
    subCategoryObject.main_category_id = "8";
    subCategoryObject.sub_category_id = "79"
    subCategoryObject.sub_category_name = "기타 주변기기"    
    subCategoryArray.push(subCategoryObject);
    
    subCategoryObject = new Object();
    subCategoryObject.main_category_id = "9";
    subCategoryObject.sub_category_id = "81"
    subCategoryObject.sub_category_name = "DSLR"    
    subCategoryArray.push(subCategoryObject);
    
    subCategoryObject = new Object();
    subCategoryObject.main_category_id = "9";
    subCategoryObject.sub_category_id = "82"
    subCategoryObject.sub_category_name = "미러리스"    
    subCategoryArray.push(subCategoryObject);
    
    subCategoryObject = new Object();
    subCategoryObject.main_category_id = "9";
    subCategoryObject.sub_category_id = "83"
    subCategoryObject.sub_category_name = "디지털카메라"    
    subCategoryArray.push(subCategoryObject);
    
    subCategoryObject = new Object();
    subCategoryObject.main_category_id = "9";
    subCategoryObject.sub_category_id = "84"
    subCategoryObject.sub_category_name = "필름/즉석카메라"    
    subCategoryArray.push(subCategoryObject);
    
    subCategoryObject = new Object();
    subCategoryObject.main_category_id = "9";
    subCategoryObject.sub_category_id = "85"
    subCategoryObject.sub_category_name = "캠코더/액션캠"    
    subCategoryArray.push(subCategoryObject);
    
    subCategoryObject = new Object();
    subCategoryObject.main_category_id = "9";
    subCategoryObject.sub_category_id = "86"
    subCategoryObject.sub_category_name = "기타 카메라"    
    subCategoryArray.push(subCategoryObject);
    
    subCategoryObject = new Object();
    subCategoryObject.main_category_id = "9";
    subCategoryObject.sub_category_id = "87"
    subCategoryObject.sub_category_name = "카메라렌즈"    
    subCategoryArray.push(subCategoryObject);
    
    subCategoryObject = new Object();
    subCategoryObject.main_category_id = "9";
    subCategoryObject.sub_category_id = "88"
    subCategoryObject.sub_category_name = "삼각대/조명/플래시"    
    subCategoryArray.push(subCategoryObject);
    
    subCategoryObject = new Object();
    subCategoryObject.main_category_id = "9";
    subCategoryObject.sub_category_id = "89"
    subCategoryObject.sub_category_name = "기타 악세서리"    
    subCategoryArray.push(subCategoryObject);
    
 
    //****************이부분은 DB로 셋팅하세요.
    
    
    //메인 카테고리 셋팅
    var mainCategorySelectBox = $("select[name='mainCategory']");
    
    for(var i=0;i<mainCategoryArray.length;i++){
        mainCategorySelectBox.append("<option value='"+mainCategoryArray[i].main_category_id+"'>"+mainCategoryArray[i].main_category_name+"</option>");
    }
    
    //*********** 1depth카테고리 선택 후 2depth 생성 START ***********
    $(document).on("change","select[name='mainCategory']",function(){
        
        //두번째 셀렉트 박스를 삭제 시킨다.
        var subCategorySelectBox = $("select[name='subCategory']");
        subCategorySelectBox.children().remove(); //기존 리스트 삭제
        
        //선택한 첫번째 박스의 값을 가져와 일치하는 값을 두번째 셀렉트 박스에 넣는다.
        $("option:selected", this).each(function(){
            var selectValue = $(this).val(); //main category 에서 선택한 값
            subCategorySelectBox.append("<option value=''>전체</option>");
            for(var i=0;i<subCategoryArray.length;i++){
                if(selectValue == subCategoryArray[i].main_category_id){
                    
                    subCategorySelectBox.append("<option value='"+subCategoryArray[i].sub_category_id+"'>"+subCategoryArray[i].sub_category_name+"</option>");
                    
                }
            }
        });
        
    });
    //*********** 1depth카테고리 선택 후 2depth 생성 END ***********
        
});
</script>


        
</body>
</html>