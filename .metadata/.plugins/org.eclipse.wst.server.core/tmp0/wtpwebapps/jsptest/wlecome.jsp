<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="./css/min.css">
<!-- <style type="text/css">
	h1 {
	 	color: red;
	}
</style> -->
<%
	Date date = new Date();
	String displayDate = date.toString();
%>
</head>
<body>
    <h1>안녕하세요. 자바서버페이지에 오신 것을 환영합니다.</h1>
    <%	for (int i = 0; i < 10; i++) {	%>
    <h2><%=displayDate + " " + i%></h2>
    <% } %>
</body>
</html>