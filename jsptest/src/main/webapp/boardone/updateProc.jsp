<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "boardone.BoardDAO" %>
<%@ page import = "java.sql.Timestamp" %>
<jsp:useBean id="article" scope="page" class="boardone.BoardVO">
 <jsp:setProperty name="article" property="*"/>
</jsp:useBean>
<%
int num = 0; // 기본값 또는 응용 프로그램에 적합한 기본값
String pageNum = request.getParameter("pageNum");

// 변환 전에 파라미터가 null이 아닌지 확인
String numParam = request.getParameter("num");
if (numParam != null && !numParam.isEmpty()) {
    try {
        num = Integer.parseInt(numParam);
    } catch (NumberFormatException e) {
        // 예외 처리 (예: 로깅 또는 오류 메시지 표시)
        e.printStackTrace();
    }
%>
 <meta http-equiv="Refresh" content="0;url=list.jsp?pageNum=<%=pageNum%>" >
<% }else{%>
 <script lang="JavaScript">
 <!--
 alert("비밀번호가 맞지 않습니다");
 history.go(-1);
 --> </script>
<%
 }
%>