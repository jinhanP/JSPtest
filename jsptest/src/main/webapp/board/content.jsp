<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>게시판</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<link href="style.css" rel="stylesheet" type="text/css">
</head>
<body bgcolor="${bodyback_c}">
	<b>글내용 보기</b>
	<br>
	<form>
		<table width="500" border="1" cellspacing="0" cellpadding="0"
			align="center">
			<tr height="30">
				<td align="center" width="125" bgcolor="${value_c}">글번호</td>
				<td align="center" width="125" align="center">${article.num}</td>
				<td align="center" width="125" bgcolor="${value_c}">조회수</td>
				<td align="center" width="125" align="center">
					${article.readcount}</td>
			</tr>
			<tr height="30">
				<td align="center" width="125" bgcolor="${value_c}">작성자</td>
				<td align="center" width="125" align="center">${article.writer}</td>
				<td align="center" width="125" bgcolor="${value_c}">작성일</td>
				<td align="center" width="125" align="center">${article.regdate}</td>
			</tr>
			<tr height="30">
				<td align="center" width="125" bgcolor="${value_c}">글제목</td>
				<td align="center" width="375" align="center" colspan="3">
					${article.subject}</td>
			</tr>
			<tr>
				<td align="center" width="125" bgcolor="${value_c}">글내용</td>
				<td align="left" width="375" colspan="3"><pre>${article.content}</pre></td>
			</tr>
			<tr height="30">
				<td colspan="4" bgcolor="${value_c}" align="right"><input
					type="button" value="글수정"
					onclick="document.location.href='/jsptest/board/updateForm.do?num=${article.num}&pageNum=${pageNum}'">
					&nbsp;&nbsp;&nbsp;&nbsp; 
					<input type="button" value="글삭제"onclick="document.location.href='/jsptest/board/deleteForm.do?num=${article.num}&pageNum=${pageNum}'">
					&nbsp;&nbsp;&nbsp;&nbsp; 
					<input type="button" value="답글쓰기"onclick="document.location.href='/jsptest/board/writeForm.do?num=${article.num}&ref=${article.ref}&step=${article.step}&depth=${article.depth}'">
					&nbsp;&nbsp;&nbsp;&nbsp; 
					<input type="button" value="글목록"onclick="document.location.href='/jsptest/board/list.do?pageNum=${pageNum}'">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>