<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
// 컨텍스트 자료 가져오기(객채를 만들고 가져오기는 여기서)
Enumeration<String> em = application.getInitParameterNames();
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<ul>
			<%
			while (em.hasMoreElements()) {
				String paramName = em.nextElement();
				String paramValue = application.getInitParameter(paramName);
			%>
			<li class="licolor"><%=paramName%> = <%=paramValue%></li>
			<%
			}
			%>
		</ul>
	</div>
</body>
</html>