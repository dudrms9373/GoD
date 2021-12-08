<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<style>
	.WriteForm { text-align: center; border: 1px solid black;}
	table {margin-right: auto; margin-left: auto; }
</style>
<link rel="stylesheet" href="../css/common.css" />
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ include file="../common/header.jsp" %>
<div style="height: 75px"></div>
<div class="home">
	<a href="/view/common/index.jsp" id="main"><img src="../img/home.png" style="width: 50px; height: 50px;"></a>
</div>

<table>		
	<tr>
		<td>작성자</td>
		<td colspan="2"><input type="text"  name="loginid" value="${ nick }" readonly="readonly"></td>
	</tr>
		<tr>
			<td>제목</td>
			<td colspan="2"><input type="text" name="writeTitle" value="${ title }" readonly="readonly" id="title" />
			</td>
		</tr>
		<tr>
			<td colspan="3"><textarea rows="12" cols="50"
					name="writeContent"  readonly="readonly">${ cont }</textarea></td>
		</tr>
		<tr>
			<td align="center"><input type="submit" value="작성" class="button"></td>
			<td ><input type="button" value="게시판으로 이동" onclick="location.href='fboard?cmd=FreeBoard&id=${ LoginId }?pagenum=1'"></td>
			<td><input type="button" value="추천하기" onclick="location.href='fboard?cmd=FBLikeCnt&id=${ fbnum }'">추천수 : 
			<% if( session.getAttribute("like") == null ){ %>
				0
			<% }else{ %>
				${ like }
			<% } %></td>
		</tr>
	</table>
	
	<c:forEach var="fbc" items="${ requestScope.fbcvo }">
		<div style="width: 400px; background-color: #EBFBFF; padding : 10px; margin-left: auto; margin-right: auto; margin-top: 20px;">
		닉네임 : ${ fbc.nick } <br>
		댓글 작성 시간 : ${ fbc.tbc_date }<br><br>
		내용 : ${ fbc.tbc_cont }<br><br>
	</div>
		</c:forEach>
</body>
</html>
