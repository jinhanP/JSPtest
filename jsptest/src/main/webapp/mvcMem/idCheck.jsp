<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="memberone.StudentDAO"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ID 중복체크</title>
<link href="style.css" type="test/css" rel="stylesheet" />
<script type="text/javascript" src="script.js"></script>
</head>
<body bgcolor="#FFFFCC">
	<br>
	<center>
		<b>${id}</b>
		<c:if test="${check eq true}">
		는 이미 존재하는 ID입니다.<br />
		</c:if>
		<c:if test="${check ne true}">는 사용 가능 합니다.<br />
		</c:if>
		<a href="#" onClick="javascript:self.close()">닫기</a>
	</center>
</body>
</html>