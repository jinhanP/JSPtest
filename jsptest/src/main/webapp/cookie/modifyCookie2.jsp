<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
 String name = "";
 String no = "";

 Cookie[] cookies = request.getCookies();
 if (cookies != null && cookies.length > 0) {
 		for (int i = 0 ; i < cookies.length ; i++) {
 			if (cookies[i].getName().equals("name")) {
 				name = cookies[i].getValue();
 				no = cookies[i].getAttribute("no");
 			}
 		}
 }
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>값 변경</title>
</head>
<body>
	<h1>name = <%= name %> , no = <%= no %> 입니다.</h1>
</body>
</html>