<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%
	
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/css/common.css" />
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script>
	$(function(){
		$('#like').on('click',function(){
			$.ajax({
				url:'/tboard',
				data:{cmd=LIKEUPDATEACTION,
					  boardNum=${tboard.boardNum}},
				}
				datatype:json,
				success:function( data ){
					$('')html(data.likecnt);
				},
				error:function(xhr){
					alert(xhr.status+''+xhr.statusText);
				}
			})
		})
		
	});
</script>
</head>
<body>
	<table class="tboard">
	<tr>
	<td><button id="tripupdate">수정</button><button id="tripdelete">삭제</button></td>	
	</tr>
	<tr>
	<td>여행지추천<b id="triptitle">${tboard.title }</b>
	<b id="tripaddr">${ tboard.addr }</b></td>
	</tr>
	<tr>
	<td>${ tboard.writer } 님</td>
	</tr>
	<tr>
	<td>작성일<b id="wdate">${ tboard.wdate }</b>
	</tr>
	<tr>
	<b id="cnt">추천수  ${ tboard.like }  조회수 ${tboard.cnt }  댓글수  ${tboard.cmtCnt }  + '</b></td>
	</tr>
	<tr>
	<td><textarea>${ tboard.cont }</textarea></td>
	</tr>
	<tr>
	<td><button id="like">좋아요</button><button id="report">신고</button></td>
	</tr>
	
	</table>
	<div class="comment">
	<div class="cmtwrite">
	<h2>댓글 작성</h2>
	<textarea class="cmtCont" name ="cmtCont">
	</textarea>
	<button id="cmtsubmit">작성 완료</button>
	</div>
	<table class="cmtlist">
	<h2>댓글(${ tboard.cmtCnt })</h2>
	<c:forEach var="cmt" items="${ tboard.cmtList }">
	<tr>
	<input type="hidden" name="cmtname${cmt.cmtNum }" value="${cmt.cmtNum }"/>
	<td>${ cmt.writer }<b>${ cmt.rdate }</b>
	<button id="cmtupdate">수정</button>
	<button id="cmtdelete">삭제</button>
	<button id="report">신고</button><br>
		${ cmt.cont } 
	</td>
	</tr>
	</c:forEach>
	</table>
	</div>
</body>
</html>