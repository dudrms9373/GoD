<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="../../css/common.css"/>
<style>
</style>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ include file="header.jsp" %>
<div style="height: 75px"></div>

<div class="home">
	<a href="index.jsp" id="main"><img src="/img/home.png" style="width: 50px; height: 50px;"></a>
</div>
<h2 class="logintitle">로그인</h2>



<form action="/mboard?cmd=Login" method="post" class="loginForm">
	
 <table class="logintable">
 
 
 <tr>
 	<td colspan="3" class="idForm"> <input type="text" class="id" name="id" placeholder="ID"> </td>
 </tr>
 <tr>
 	<td colspan="3" class="pwdForm"><input type="password" class="pw" name="pwd" placeholder="PW"></td>
 </tr>
 <tr>
 	<td colspan="3"><input type="submit" class="btn" value="로그인"></td>
 </tr>
 <tr>
 	<td colspan="3" style="color: #a68f8e; padding: 20px 0px; ">----------- 계정 만들기 -----------</a></td>
 </tr>
 <tr>
 	<td colspan="3" class="bottomText">계정 만들기 <a href="Create.jsp">회원가입</a></td>
 </tr>
     
  </table>
    </form>

<% 
    String msg = request.getParameter("msg");
	if( msg!=null && msg.equals("0") ){
		out.print("<h2>비밀번호가 틀렸습니다<h2>");
	}else if( msg!=null && msg.equals("-1") ){
		out.print("<h2>아이디가 틀렸습니다<h2>");
	}

%>
    
</body>
</html>
