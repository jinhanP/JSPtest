<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>게시판</title>
<link href="style.css" rel="stylesheet" type="text/css">
</head>
<body bgcolor="${bodyback_c}">
		<b>글삭제</b> <br>
		<form method="POST" name="delForm"
			action="/jsptest/board/deletePro.do?pageNum=${pageNum}"
			onsubmit="return deleteSave()">
			<table border="1" align="center" cellspacing="0" cellpadding="0"
				width="360">
				<tr height="30">
					<td align=center bgcolor="${value_c}"><b>비밀번호를 입력해 주세요.</b></td>
				</tr>
				<tr height="30">
					<td align=center>비밀번호 : <input type="password" name="pass"
						size="8" maxlength="12"> <input type="hidden" name="num"
						value="${num}"></td>
				</tr>
				<tr height="30">
					<td align=center bgcolor="${value_c}"><input type="submit"
						value="글삭제"> <input type="button" value="글목록"
						onclick="document.location.href=
 '/jsptest/board/list.do?pageNum=${pageNum}'">
					</td>
				</tr>
			</table>
		</form>
</body>
</html>