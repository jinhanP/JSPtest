<%@page import="java.io.IOException"%>
<%@page import="java.io.FileReader"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	FileReader reader = null;
	try{
	String path = request.getParameter("path");
	// path 를 통해 파일을 가져온다.
	reader = new FileReader(getServletContext().getRealPath(path));
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- <pre> 안에 쓰면 그대로 나온다. -->
	<pre>
		소스코드: <%= path %> 입니다.
		<!-- reader 출력 -->
		<c:out value="<%=reader%>" escapeXml="true"/>
	</pre>
<%
	}catch(IOException e){
%>
	에러 발생 =<%= e.toString() %>
<% 
	}finally{
		if(reader != null){
			reader.close();
		}
	}
%>
</body>
</html>