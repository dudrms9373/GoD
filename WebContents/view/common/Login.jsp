<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style>
h2 {text-align: center;}
	.loginForm { text-align: center;}
	table { margin-left: auto; margin-right: auto; border: 1px solid black; padding-left: 50px; 
	padding-top:30px; padding-right: 50px; padding-bottom: 80px;}
	table td { padding: 6px; }
	.bottomText {padding-top: 15px;}
	div { text-align: center;}
</style>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<div>
	<a href="index.jsp" id="main"><img src="img/home.png" style="width: 50px; height: 50px;"></a>
</div>
<h2>로그인</h2>
	<form action="index.html" method="post" class="loginForm">
 <table>
 
 
 <tr>
 	<td colspan="3" class="idForm"> <input type="text" class="id" placeholder="ID"> </td>
 </tr>
 <tr>
 	<td colspan="3" class="pwdForm"><input type="password" class="pw" placeholder="PW"></td>
 </tr>
 <tr>
 	<td colspan="3"><button type="button" class="btn"> 로그인 </button></td>
 </tr>
 <tr>
 	<td colspan="3" style="color: #a68f8e; padding: 20px 0px; ">----------- 계정 만들기 -----------</a></td>
 </tr>
 <tr>
 	<td colspan="3" class="bottomText">계정 만들기 <a href="Create.jsp">회원가입</a></td>
 </tr>
     
  </table>
    </form>
    
</body>
</html>