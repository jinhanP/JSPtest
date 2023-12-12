<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript" src="script.js"></script>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<title>가입폼</title>
</head>
<body>
	<form method="post" action="member.mdo?cmd=regProc" name="regForm">
		<table border="1">
			<tr>
				<td colspan="2" align="center">회원 가입 정보 입력</td>
			</tr>
			<tr>
				<td align="right">아이디 :</td>
				<td><input type="text" name="id" size="20" />&nbsp; 
				<!-- onClick="idCheck(this.form.id.value) script 함수로 넘어간다. this 페이지 form 양식 id form안에있는 id id값이 value -->
					<input type="button" value="중복확인"onClick="idCheck(this.form.id.value)" /></td>
			</tr>
			<tr>
				<td align="right">패스워드 :</td>
				<td><input type="password" name="pass" /></td>
			</tr>
			<tr>
				<td align="right">패스워드 확인 :</td>
				<td><input type="password" name="repass" /></td>
			</tr>
			<tr>
				<td align="right">이름 :</td>
				<td><input type="text" name="name" /></td>
			</tr>
			<tr>
				<td align="right">전화번호 :</td>
				<td><select name="phone1">
						<option value="02">02</option>
						<option value="011">011</option>
				</select>&nbsp;-&nbsp; <input type="text" name="phone2" size="5" />
					&nbsp;-&nbsp; <input type="text" name="phone3" size="5" /></td>
			</tr>
			<tr>
				<td align="right">이메일 :</td>
				<td><input type="text" name="email" /></td>
			</tr>
			<tr>
				<tr>
			<td>
			<p align="right">우편번호:</p><br />
			<td>
			<input type="text" id="sample6_address" placeholder="주소"size="30"><br /> 
			<input type="text" id="sample6_postcode"placeholder="우편번호" size="30" /><br />
			<input type="text" id="sample6_detailAddress" placeholder="상세주소" size="30"><br />
			<input type="text" id="sample6_extraAddress" placeholder="참고항목"size="30"><br /> 
			<input type="button" onclick="sample6_execDaumPostcode()"value="찾기"></td>
		</tr>
			<tr>
				<td colspan="2" align="center">
				&nbsp;&nbsp; 
				<input type="submit" value="회원가입"onClick="inputCheck()" />&nbsp;&nbsp; 
				<input type="reset"value="다시입력" /></td>
			</tr>
		</table>
	</form>
</body>
</html>