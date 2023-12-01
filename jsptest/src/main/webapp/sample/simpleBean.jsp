<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    request.setCharacterEncoding("UTF-8");
    //String message = request.getParameter("message");
%>
<!-- 객체 만드는거 -->
<jsp:useBean id="msg" class="sample.SimpleData"/>
<%-- SimpleData msg = new SimpleData(); --%>
<jsp:setProperty name="msg" property="message"/>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>간단한 빈즈 프로그램 결과</h1>
<hr color="red"></hr><br></br>
	<font size="5">
		메세지 : <jsp:getProperty name="msg" property="message"/>
		<%--<%=message%> --%>
</font>
</body>
</html>