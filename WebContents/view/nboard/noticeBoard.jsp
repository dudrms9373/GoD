<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	
</script>

<link rel="stylesheet" href="/css/common.css" />
</head>
<body>

<div style="width: 300px; height:300px;">
<%@ include file="/view/common/header.jsp"%>
</div>
	<div style="width: 300px; height:300px;margin-top: 20px;">
	<table>
	<caption style="text-align: center;">공지사항</caption>
		<tr>
		<td></td>
		<td></td>
		<td></td>
			<td colspan="4"><a href="/nboard?cmd=nboardWrite">글 쓰기</a></td>
		</tr>
		<tr>
			<td>번호</td>
			<td>제목</td>
			<td>작성자</td>
			<td>조회수</td>
		</tr>
		<c:forEach var="nboard" items="${nboardList}">
			<tr>
				<td><b id="nb_num" style="color : black">${nboard.nb_num}</b></td>
				<td><b id="nb_title" style="color : black"><a href="/nboard?cmd=nboardView&nb_num=${nboard.nb_num}" > ${nboard.nb_title}</a></b></td>
				<td><b id="nb_nick" style="color : black">${nboard.mem_nick}</b></td>
				<td><b id="nb_cnt" style="color : black">${nboard.nb_cnt}</b></td>

			</tr>
		</c:forEach>
	</table>
	</div>
</body>
</html>