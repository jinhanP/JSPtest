<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="memberone.StudentDAO"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Refresh" content="1;url=member.mdo?cmd=login">
<title>delect process</title>
</head>
<body>
	<c:set var="result" value="${result}" />
	<center>
		<c:if test="${result eq 0}">
			<script type='text/javascript'>
				alert('비밀번호가 틀렸습니다.');
				history.go(-1);
			</script>
		</c:if>
		<font size="5" face="바탕체"> 회원정보가 삭제 되었습니다.<br /> 안녕히 가세요.<br />1초후에
			login page로 이동합니다.
		</font>
	</center>
</body>
</html>