<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="color.jsp"%>
<%
String id = "";
try {
	Cookie[] cookies = request.getCookies();//쿠키값 가져와서
	if (cookies != null) {
   for (int i = 0; i < cookies.length; i++) {
		if (cookies[i].getName().equals("memId")) { // 쿠키값 찾는다
			id = cookies[i].getValue();
				break;
			}
		}
		if (id.equals("")) {
			response.sendRedirect("cookieMemberLogIn.jsp"); //찾으면 cookieMemberLogIn 간다.
		}
	} else {
		response.sendRedirect("cookieMemberLogIn.jsp");
	}
} catch (Exception e) {}
%>
<html>
<head>
<title>쿠키를 사용한 간단한 회원인증</title>
</head>
<body bgcolor="<%=bodyback_c%>">
	<form method="post" action="cookieLogOut.jsp">
		<table width="300" border="1" align="center">
			<tr>
				<td align="center" bgcolor="<%=value_c%>"><b><%=id%></b>님이
					로그인 하셨습니다.</td>
			</tr>
			<tr>
				<td align="center" bgcolor="<%=value_c%>"><input type="submit"
					value="로그아웃"></td>
			</tr>
		</table>
	</form>
</body>
</html>