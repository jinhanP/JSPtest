<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="memberone.*"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원가입 확인</title>
<link href="css/style.css" type="test/css" rel="stylesheet" />
</head>
<body bgcolor="#FFFFCC">
	<c:set var="flag" value="${flag}" />
	<br />
	<center>
		<c:choose>
			<c:when test="${flag}">
				<b>회원가입을 축하드립니다.</b>
				<br />
				<a href='member.mdo?cmd=login'>로그인</a>
			</c:when>
			<c:otherwise>
				<b>다시 입력하여 주십시오.</b>
				<br />
				<a href='member.mdo?cmd=regForm'>다시입력해주세요</a>
			</c:otherwise>
		</c:choose>
	</center>
</body>
</html>