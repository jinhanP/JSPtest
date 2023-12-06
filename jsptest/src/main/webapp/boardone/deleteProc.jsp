<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "boardone.BoardDAO" %>
<%@ page import = "java.sql.Timestamp" %>
<% request.setCharacterEncoding("euc-kr");%>
<%
String numParam = request.getParameter("num");
int num = 0;

if (numParam != null && !numParam.isEmpty()) {
    num = Integer.parseInt(numParam);

String pageNum = request.getParameter("pageNum");
%>
<meta http-equiv="Refresh"
content="0;url=list.jsp?pageNum=<%=pageNum%>" >
<% }else{%>
 <script language="JavaScript">
 <!--
 alert("비밀번호가 맞지 않습니다");
 history.go(-1);
 -->
 </script>
<%
 }
%>