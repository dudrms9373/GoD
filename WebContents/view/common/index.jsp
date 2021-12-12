<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/css/common.css"/>
<style>
</style>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script>
	window.onload = function () {
		function login() {
			alert("로그인");
		}
	}
</script>
<body id="background">
<%@include file = "header.jsp" %>

 <div id="header"></div> 


<div id="search" >
	원하는 여행지를 검색하세요 !!  ▶ &nbsp;&nbsp; <input type="text" class="findtext">
	<button id="b_search">검색</button>
</div>
	

<%@include file = "footer.jsp" %>

</body>
</html>
