<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html >
    <head>
        <Title>Category</Title> 
        <script src="http://code.jquery.com/jquery-3.4.1.min.js"></script>
    </head>
 <body>
<script>
    $(function() {
        $("#showBtn").on("click", function() {
            $("#text").show();
        })
        $("#hideBtn").on("click", function() {
            $("#text").hide();
        })
    })
</script>

<h1>요소의 표시와 숨김</h1>
<button id="showBtn">요소 표시하기!</button>
<button id="hideBtn">요소 숨기기!</button>
<p>CSS의 display 속성값이 none으로 설정되기 때문에 웹 페이지의 레이아웃에서 아예 사라져 버려요!</p>
<p id="text">이 단락을 숨기거나 나타나게 할 거에요!</p>
 
 
 </body>
 
 </html>
 

