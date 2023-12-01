<%@page import="member.PersonVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    request.setCharacterEncoding("UTF-8");
    PersonVO p = new PersonVO();
    String id =	request.getParameter("id");
    String name =	request.getParameter("name");
    String email =	request.getParameter("email");
    p.setEmail(email);
    p.setId(id);
    p.setName(name);
%>
<!-- 화면설계  jsp:useBean 이걸 만들어놓으면 하나씩 가져올수 있다 만약 안쓰면 위에처럼 하나씩 써야된다.-->
<jsp:useBean id="person" class="member.PersonVO"/>
<jsp:setProperty name="person" property="*"/>

    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1><jsp:getProperty name="person" property="id"/></h1>
	<h1><jsp:getProperty name="person" property="name"/></h1>
	<h1><jsp:getProperty name="person" property="email"/></h1>
	<h1><%= p.getEmail() %></h1>
	<h1><%= p.getName() %></h1>
	<h1><%= p.getId() %></h1>
</body>
</html>