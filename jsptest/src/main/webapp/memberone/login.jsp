<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<%
 String loginID = (String)session.getAttribute("loginID");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Log in</title>
<link href="style.css" type="text/css" rel="stylesheet"/>
 <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"rel="stylesheet"/>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
	<h1>미래IT</h1>
<div class="container" id="container">
  <div class="form-container sign-up-container">
    <form action="#">
      <h1>Create Account</h1>
      <div class="social-container">
        <a href="#" class="social"><i class="fab fa-facebook-f"></i></a>
        <a href="#" class="social"><i class="fab fa-google-plus-g"></i></a>
        <a href="#" class="social"><i class="fab fa-linkedin-in"></i></a>
      </div>
    </form>
  </div>
  
  <div class="form-container sign-in-container">
    <form method="post" action="loginProc.jsp">
      <h1>Sign in</h1>
      <div class="social-container">
        <a href="#" class="social"><i class="fab fa-facebook-f"></i></a>
        <a href="#" class="social"><i class="fab fa-google-plus-g"></i></a>
        <a href="#" class="social"><i class="fab fa-linkedin-in"></i></a>
      </div>
      <span>or use your account</span>
      
  <% //로그인 했을 때 세션을 만들어서 로그인 성공했는지 알 수있다.
  if(loginID == null){
	  %>
	  <table >
      <tr>
        <td align="center" width="100">아이디</td>
        <td width="200">&nbsp;&nbsp;<input type="text" name="id" size="20"></td>
      </tr>
      <tr>
        <td align="center" width="100">비밀번호</td>
        <td width="200">&nbsp;&nbsp;<input type="password" name="pass" size="20"></td>
      </tr>
      <tr>
        <td colspan="2" align="center">
          <input type="submit" value="로그인">&nbsp;&nbsp;
          <input type="button" value="회원가입" onclick="javascript:window.location='regForm.jsp'">
        </td>
      </tr>
    </table>
  </form>
	  
	  <%
  }else{
  %>
    <h3>미래IT에 오신 걸 환영합니다.</h3>
    
     <%} %>
<% if(loginID != null){ %>
	<table border="1" width="300">
			<tr><td colspan="3" align="center">
				<%=loginID %>님 환영합니다.</td></tr>
			<tr>
		<td align="center" width="100">
			<a href="modifyForm.jsp">정보수정</a></td>
		<td align="center" width="100">
			<a href="deleteForm.jsp">회원탈퇴</a></td>
		<td align="center" width="100">
			<a href="logout.jsp">로그아웃</a></td>
	</tr>
</table>
<%}else{ %>
<!-- 기존의 login.jsp 페이지의 내용 -->
<% } %>

  </div>
  <div class="overlay-container">
    <div class="overlay">
      <div class="overlay-panel overlay-left">
        <h1>Welcome Back!</h1>
        <p>To keep connected with us please login with your personal info</p>
        <button class="ghost" id="signIn">Sign In</button>
      </div>
      <div class="overlay-panel overlay-right">
        <h1>Hello, Friend!</h1>
        <p>Enter your personal details and start journey with us</p>
      </div>
    </div>
  </div>
</div>
</body>
</html>