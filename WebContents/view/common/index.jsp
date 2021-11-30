<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style>
body { margin: -3px; overflow-x: hidden; }
	#header { 
		background-image: url("img/sw10.png"); 
		width: 1950px; height: 1000px ;
		background-size: cover; }
	#search { position : absolute; left: 33%; top: 65%; 
	display: flex;
    justify-content: center;
    align-items: center;
	background-color: white; opacity:0.8; width : 580px ;
	height : 50px ;
	border-radius: 10px;
	padding: 10px;
	padding-right: 50px;
	}
	input {
	font-size : 20px; 
	}
	#b_search {margin: -45px;}
	#b_div { margin: 50px; padding : 5px;  position : absolute; left: 65%; top: 3%;}
	#b_div button{ width: 150px; height: 50px;  }
	div:first-child button { border : 1px solid skyblue; border-radius: 20px; opacity: 0.9;}
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
<body >
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
