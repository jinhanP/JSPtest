<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
 Date date = new Date();
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>Hello Jsp</h2>
	<h2>현재날짜 시간은 <%= date.toString()%> </h2>
	<!-- 출력하는 법  -->
</body>
</html>