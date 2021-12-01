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
<div id="header">

<div id="b_div">
	
	<button onClick="location.href='main.jsp'"><b>둘러보기</b></button>
	<button onClick="location.href='Login.jsp'"><b>로그인</b></button>
	<button onClick="location.href='Create.jsp'"><b>회원가입</b></button>
	
</div>
<div id="search" >
	원하는 여행지를 검색하세요 !!  ▶ &nbsp;&nbsp; <input type="text" >
	<button id="b_search">검색</button>
</div>
</div>
<%@include file = "main.jsp" %>
<%@include file = "footer.jsp" %>

</body>
</html>
