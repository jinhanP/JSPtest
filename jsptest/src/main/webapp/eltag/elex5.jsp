<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("utf-8");%>
<HTML>
<HEAD>
<TITLE>표현언어의 사용예제</TITLE>
</HEAD>
<BODY>
<H3>파라미터값 처리</H3>
<br></br>
<FORM action="elex5.jsp" method="post">
 이름 : <input type="text" name="name" value="${param['name']}">
 <input type="submit" value="확인">
</FORM>
<P>
이름은: ${param.name} 입니다. </P>
</BODY>
</HTML>