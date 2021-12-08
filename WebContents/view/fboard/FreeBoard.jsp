<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	section { min-height: 1200px;}
	.list_no {width: 50px;}
	.list_title {width: 400px; }
	.list_writer {width: 100px;}
	.list_time {width: 120px;}
	.list_hit {width: 55px;}
	.list_likecount {width: 55px;}
	td:not(.list_title) {text-align: center;}
	th {height: 46px; background-color: #FAFAFA;}
	td {height: 40px; }
	tr:hover { background-color: #FAFAFA;  }
	tr:hover:not(.table_th) .list_title { color: #59B1E6; text-decoration: underline; font-weight: bold; }
	.choice {
	color:#fff;
	border:1px solid #42454c;}
	.f_search {background-color: #59B1E6; color: white; border: 1px solid #59B1E6; border-radius: 3px;}
</style>
</head>
<link rel="stylesheet" href="../css/common.css" />
<script>
function searchLogincheck() {
	if( <%=session.getAttribute("LoginId")%> == null ){
		alert("로그인이 필요합니다");
		event.preventDefault();
		return false;
	}
}
	window.onload = function () {
	
	}
</script>
<body>
<%@ include file="../common/header.jsp" %>
<div style="height: 270px">
<div style="height: 75px"></div>

<div class="home">
	<a href="/view/common/index.jsp"><img src="/img/home.png" style="width: 50px; height: 50px;"></a>
</div>

</div>
<section>

	<div style=" width: 65%; min-height: 1200px; margin-left: auto; margin-right: auto; ">
	<div style="padding-top: 60px;">
	<table style="width: 90%;  border-collapse: collapse; margin-left: auto; margin-right: auto;">
		<tr class="table_th" >
			<th class="list_no">No</th>
			<th class="list_title">제목</th>
			<th class="list_writer">글쓴이</th>
			<th class="list_time">작성시간</th>
			<th class="list_hit">조회수</th>
			<th class="list_likecount">추천수</th>			
		</tr>

		<c:forEach var="fb" items="${ requestScope.fbvo }">
		<tr>
			<td class="list_no">${ fb.num }</td>
			<td class="list_title"><a href="fboard?cmd=FBoardClick&fbnum=${ fb.num }">${ fb.title }</a> </td>
			<td class="list_writer">${ fb.nick }</td>
			<td class="list_time">${ fb.date }</td>
			<td class="list_hit">${ fb.cnt }</td>
			<td class="list_likecount">${ fb.likecnt }</td>
		</tr>
		</c:forEach>
		
	</table>
	
	<div style="height: 50px; text-align: center;"> <!-- 페이징 기능 -->
<jsp:include page="paging.jsp" flush="false">
    <jsp:param name="firstPageNo" value="${pvo.firstPageNo}" />
    <jsp:param name="prevPageNo" value="${pvo.prevPageNo}" />
    <jsp:param name="startPageNo" value="${pvo.startPageNo}" />
    <jsp:param name="pageNo" value="${pvo.pageNo}" />
    <jsp:param name="endPageNo" value="${pvo.endPageNo}" />
    <jsp:param name="nextPageNo" value="${pvo.nextPageNo}" />
    <jsp:param name="finalPageNo" value="${pvo.finalPageNo}" />
    <jsp:param name="main" value="${main}" />
    <jsp:param name="Keyword" value="${Keyword}" />
</jsp:include>
	</div>

<div>
<form action="fboard?cmd=FBoardSearch" method="post" onsubmit="return searchLogincheck()" style="text-align: center;">
			<table style="border: 1px solid black; width: 700px; margin-left: auto; margin-right: auto;">
				<tr>
					<td style="border: 1px solid black;">
						<select id="searchCondition" name="searchCondition">
							<option value="Title">제목</option>
							<option value="Nick">닉네임</option>
						</select>
						<input id="searchKeyword" name="searchKeyword" type="text">
						<input type="submit" class="f_search" value="검색 " >
					</td>
				</tr>		
			</table>
		</form>
</div>   

	
	</div>
	</div>
</section>
<%@include file = "../common/footer.jsp" %>
</body>
</html>
