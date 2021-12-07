<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/css/common.css" />
</head>
<body>

	<%@ include file="/view/common/header.jsp"%>
	<table>
		<tr>
			<td>제목</td>
			<td>${nboardView.nb_title}</td>
		</tr>
		<tr>
			<td>작성자</td>
			<td>${nboardView.mem_nick }</td>
		</tr>
		<tr>
			<td>조회수</td>
			<td>${nboardView.nb_cnt }</td>
		</tr>
		<tr>
			<td>작성일</td>
			<td>${nboardView.nb_date }</td>
		</tr>
		<tr>
			<td>내용</td>
			<td>${nboardView.nb_cont }</td>
		</tr>
		<tr>
		<td><a href="/nboard?cmd=nboardUpdate&mem_nick=${nboardView.mem_nick}&nb_num=${nboardView.nb_num}">수정</a></td>
		<td><a href="/nboard?cmd=nboardDelete&mem_nick=${nboardView.mem_nick}">삭제</a></td>
		</tr>
	</table>

</body>
</html>