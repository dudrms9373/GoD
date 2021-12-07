<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	section {background-color: #EBFBFF; min-height: 1200px;}
	.list_no {width: 50px;}
	.list_title {width: 400px; }
	.list_writer {width: 100px;}
	.list_time {width: 120px;}
	.list_hit {width: 55px;}
	.list_likecount {width: 55px;}
	td:not(.list_title) {text-align: center;}
	th {height: 46px; }
	td {height: 40px; }
	.choice {
	background-color:#42454c;
	color:#fff;
	border:1px solid #42454c;}
</style>
</head>
<link rel="stylesheet" href="../css/common.css" />
<script>
	window.onload = function () {
	
	}
</script>
<body>
<%@ include file="../common/header.jsp" %>
<div style="height: 270px">

</div>
<section>
	<div style=" width: 65%; min-height: 1200px; background-color: #F0FFF0; margin-left: auto; margin-right: auto; ">
	<div style="padding-top: 60px;">
	<table style="width: 90%;  border-collapse: collapse; margin-left: auto; margin-right: auto;">
		<tr style=" border: 1px solid black;">
			<th class="list_no">No</th>
			<th class="list_title">제목</th>
			<th class="list_writer">글쓴이</th>
			<th class="list_time">작성시간</th>
			<th class="list_hit">조회수</th>
			<th class="list_likecount">추천수</th>			
		</tr>
		
		<c:forEach var="fb" items="${ requestScope.fbvo }">
		<tr style=" border: 1px solid black;">
			<td class="list_no">${ fb.num }</td>
			<td class="list_title">${ fb.title }</td>
			<td class="list_writer">${ fb.nick }</td>
			<td class="list_time">${ fb.date }</td>
			<td class="list_hit">${ fb.cnt }</td>
			<td class="list_likecount">${ fb.likecnt }</td>
		</tr>
		</c:forEach>
		
	</table>
	
	<div style="height: 150px; text-align: center;"> <!-- 페이징 기능 -->
<jsp:include page="paging.jsp" flush="true">
    <jsp:param name="firstPageNo" value="${pvo.firstPageNo}" />
    <jsp:param name="prevPageNo" value="${pvo.prevPageNo}" />
    <jsp:param name="startPageNo" value="${pvo.startPageNo}" />
    <jsp:param name="pageNo" value="${pvo.pageNo}" />
    <jsp:param name="endPageNo" value="${pvo.endPageNo}" />
    <jsp:param name="nextPageNo" value="${pvo.nextPageNo}" />
    <jsp:param name="finalPageNo" value="${pvo.finalPageNo}" />
</jsp:include>
   

	</div>
	
	</div>
	</div>
</section>
<%@include file = "../common/footer.jsp" %>
</body>
</html>