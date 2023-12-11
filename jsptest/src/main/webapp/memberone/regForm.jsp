<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register Form</title>
<script lang="javascript" src="script.js"></script>
 <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"rel="stylesheet"/>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
	<div class="container">
	<!-- post 달라고 요청하고 regProc.jsp를 객체로 만들어서 보여달라고 요청  -->
    <form method="post" action="regProc.jsp" name="regForm">
      <h1>회원 가입</h1>
    <table border="1" >
      <tr>
        <td colspan="2" align="center">회원 가입 정보 입력 </td>
      </tr>
      <tr>
        <td align="right">아이디</td>
        <td><input type="text" name="id">&nbsp;&nbsp;
        <input type="button" value="중복확인" onclick="idCheck(this.form.id.value)"></td>
      </tr>
      <tr>
        <td align="right">패스워드</td>
        <td><input type="password" name="pass"></td>
      </tr>
      <tr>
        <td align="center">패스워드 확인</td>
        <td><input type="password" name="repass"></td>
      </tr>
      <tr>
        <td align="right">이름</td>
        <td><input type="text" name="name"></td>
      </tr>
      <tr>
        <td align="right">전화번호
          <select name="phone1">
            <option value="02">02</option>
            <option value="010">010</option>
          <td><input type="text" name="phone2" size="5">-
          <input type="text" name="phone3" size="5"></td>
          </select>
        </td>
      </tr>
      <tr>
        <td align="right">이메일</td>
        <td><input type="text" name="email"></td>
      </tr>
      <tr>
        <td align="right">우편번호</td>
        <td><input type="text" name="zipcode">&nbsp;&nbsp;
          <input type="button" value="찾기" onclick="zipCheck()">
        </td>
      </tr>
      <tr>
        <td align="right">주소</td>
        <td><input type="text" name="address1" size="30"></td>
      </tr>
      <tr>
        <td align="right">상세주소</td>
        <td><input type="text" name="address2" size="30"></td>
      </tr>
      <tr>
        <td colspan="2" align="center">&nbsp;
          <input type="submit" value="회원가입" onclick="inputCheck()">&nbsp;
          <input type="reset" value="다시입력">
        </td>
      </tr>
    </table>
  </form>
      </div>
</body>
</html>