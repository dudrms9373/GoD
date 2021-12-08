<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ include file="/view/common/header.jsp"%>
	<h2>공지사항</h2>
	<form action="/nboard?cmd=nboardUpdate&nb_num=${nbUpdate.nb_num}" method="post">
		<div style="border: solid 1px;">
			<table>
				<tr>
					<td>제목</td>
					<td><input type="text" name="nb_title" value="${nbUpdate.nb_title}"/></td>
				</tr>
				<tr>
					<td>작성자</td>
					<td>${nbUpdate.mem_nick}</td>
				</tr>
				<tr>
					<td><textarea name="nb_cont">${nbUpdate.nb_cont}</textarea></td>
				</tr>
			</table>
		</div>
	<div>
		<button >수정 </button>
		<button >취소</button>
	</div>
	</form>
</body>
</html>