<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
	
</script>

<link rel="stylesheet" href="/css/common.css" />
</head>
<body>

	<%@ include file="/view/common/header.jsp"%>
	<h2>공지사항</h2>
	<form action="/nboard?cmd=nboardWriteInsert" method="post">
		<div style="border: solid 1px;">
			<table>
				<tr>
					<td>제목</td>
					<td><input type="text" name="nTitle"/></td>
				</tr>
				<tr>
					<td>작성자</td>
					<td>${nboardVo.mem_nick}</td>
					<td>조회수</td>
					<td>${nboardvo.nb_cnt}</td>
				</tr>
				<tr>
					<td><textarea name="nCont"></textarea></td>
				</tr>
			</table>
		</div>
	<div>
		<button name="ninsert">등록 </button>
		<button name="nrecord">추천</button>
		<button name="nreport">신고</button>
	</div>
	</form>
</body>
</html>