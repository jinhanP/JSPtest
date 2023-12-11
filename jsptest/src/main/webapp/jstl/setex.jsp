<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:useBean id="vo" class="jstl.MemberVO" />
<%
vo.setName("홍길동");
int age_ = 30;
%>

<html>
<head>
<title>JSTL Example</title>
</head>
<body>
	<c:set target="${vo}" property="name" value="홍길동" />
	<c:set target="${vo}" property="email">
	pjh@naver.com
</c:set>
	<c:set var="age" value="30" />
	<c:set target="${vo}" property="age" value="${age}" />
	<h3>회원정보</h3>
	<ul>
		<li>이름 : ${vo.name}</li>
		<li>메일 : ${vo.email}</li>
		<li>나이 : ${vo.age}</li>
	</ul>
</body>
</html>