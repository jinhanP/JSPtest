<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript" src="script.js?ver=1"></script>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>

<title>우편번호 검색</title>
</head>
<body>
	<table>
		<tr>
			<td>
			<input type="button" onclick="sample6_execDaumPostcode()"value="우편번호 찾기"><br />
			<td>
			<input type="text" id="sample6_address" placeholder="주소"size="30"><br /> 
			<input type="text" id="sample6_detailAddress" placeholder="상세주소" size="30"><br />
			<input type="text" id="sample6_extraAddress" placeholder="참고항목"size="30"><br /> 
			<input type="text" id="sample6_postcode"placeholder="우편번호" size="30" /></td>
		</tr>
	
		<tr>
			<td align="center"><a href="javascript:this.close();">닫기</a></td>
		</tr>
	</table>
</body>
</html>