<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("UTF-8"); %>
<!-- page = this 여기서 찾겠다 -->
<jsp:useBean id="customer" class="actiontag.Customer" scope="page"/>
<jsp:setProperty name="customer" property="*" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<ul>
    <li>이름 : 
    <!-- get -->
       <jsp:getProperty name="customer" property="name"/></li>
    <li>이메일 : 
       <jsp:getProperty name="customer" property="email"/></li>
    <li>전화 : 
       <jsp:getProperty name="customer" property="phone"/></li>
   </ul>
	
</body>
</html>