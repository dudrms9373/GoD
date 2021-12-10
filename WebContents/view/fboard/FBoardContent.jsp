<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<style>
	.WriteForm { text-align: center; border: 1px solid black;}
	table {margin-right: auto; margin-left: auto; }
	textarea { outline: none;}
	span {font-size: 13px;}
</style>
<link rel="stylesheet" href="../css/common.css" />
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script>
function Logincheck() {
	if( <%=session.getAttribute("LoginId")%> == null ){
		alert("로그인이 필요합니다");
		event.preventDefault();
		return false;
	}
}


</script>
<body>
<%@ include file="../common/header.jsp" %>

<div>
	<img alt="" src="/img/polynesia2.jpg" width="1919px" height="263px">
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
			<td colspan="3"><textarea rows="12" cols="50" name="writeContent"  readonly="readonly">${ cont }</textarea></td>
		</tr>
		<tr>
			<td align="center"><input type="submit" value="작성" class="button"></td>
			<td ><input type="button" value="게시판으로 이동" onclick="location.href='fboard?cmd=FreeBoard&id=${ LoginId }?pagenum=1'"></td>
			<td><input type="button" value="추천하기" onclick="location.href='fboard?cmd=FBLikeCnt&fbnum=${ fbnuma }'">추천수 : ${ like } </td>
		</tr>
	</table>
	
	<!-- 댓글영역 -->
	<div style="width: 400px; background-color : #F8F8F8; padding : 10px; margin-left: auto; margin-right: auto; margin-top: 20px;
	 margin-bottom: 20px; ">
		<form action="fboard?cmd=FBCInsert&fbnum=${ fbnum }" method="post" onsubmit="Logincheck()">
		댓글
		<textarea rows="7" cols="53" name="cont" placeholder="고운말 부탁드려요" onclick="Logincheck()"></textarea>
		<div style="display: flex; justify-content: flex-end;">
		<input type="submit" value="작성">
		</div>
		</form>
	</div>
	
	<div style="width: 400px; height:25px; padding : 10px; margin-left: auto; margin-right: auto; 
		border-bottom: 1px solid #848484; border-top: 1px solid #848484; font-weight: bold; ">
		댓글 수 (${ FBCTotal })
	</div>
	
	<c:forEach var="fbc" items="${ requestScope.fbcvo }">
		<div style="width: 400px; padding : 10px; margin-left: auto; margin-right: auto; 
		border-bottom: 1px solid #848484;  border-collapse: collapse; ">
		닉네임 : ${ fbc.nick } <span>( ${ fbc.tbc_date } )</span><br>
		내용 : ${ fbc.tbc_cont }<br><br>
		<div style="text-align: right;">
		<c:set var = "dd" scope = "request" value = "${ fbc.nick }"/>

		<c:choose>
			<c:when test="${LoginNick eq null}">
			<c:set var = "LoginNicka" scope = "request" value = "null"></c:set>
		<% if( request.getAttribute("LoginNicka").equals(request.getAttribute("dd")) ){ %>
				<button onclick="">수정</button>
				<button onclick=" location='fboard?cmd=FBCDelete&fbcnum=${ fbc.tbc_num }&id=${ sessionScope.LoginId }' ">삭제</button>
		<%}else { %>
				<button style="display: none;">수정</button>
				<button style="display: none;">삭제</button> 
		<% } %>
			</c:when>
			<c:otherwise>
		<% if( session.getAttribute("LoginNick").equals(request.getAttribute("dd")) ){ %>
				<button onclick="">수정</button>
				<button onclick=" location='fboard?cmd=FBCDelete&fbcnum=${ fbc.tbc_num }&id=${ sessionScope.LoginId }' ">삭제</button>
		<%}else { %>
				<button style="display: none;">수정</button>
				<button style="display: none;">삭제</button> 
		<% } %>	
			</c:otherwise>
		</c:choose>
		
		<c:if test="${LoginNick eq null}">
		</c:if>
		
		
		</div>
	</div>
		</c:forEach>
		
</body>
</html>
