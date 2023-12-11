<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:if test="${4>3}">
	1.이 내용은 화면에 나타나지 않습니다.<br>
</c:if>
	<c:if test="${param.type eq 'guest'}">
	2.홈페이지 방문을 환영합니다<br></br>
	2.회원가입을 하기 바랍니다. 
</c:if>
	<c:if test="${param.type eq 'member'}">
	3.회원님 방문을 환영합니다<br></br>
	3.더 나은 서비스로 보답하겠습니다. 
</c:if>
<h1>위에 조건들이 맞지 않습니다.</h1>
</body>
</html>