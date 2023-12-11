function sample6_execDaumPostcode() {
	new daum.Postcode({
		oncomplete: function(data) {
			// 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.
			// 각 주소의 노출 규칙에 따라 주소를 조합한다.
			// 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로,이를 참고하여 분기
			var addr = ''; // 주소 변수
			var extraAddr = ''; // 참고항목 변수
			//사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
			if (data.userSelectedType === 'R') { //사용자가 도로명주소를 선택경우
				addr = data.roadAddress;
			} else { // 사용자가 지번 주소를 선택했을 경우(J)
				addr = data.jibunAddress;

			}
			// 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
			if (data.userSelectedType === 'R') {
				// 법정동명이 있을 경우 추가한다. (법정리는 제외)
				// 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
				// test() ㅡ 찾는 문자열이, 들어있는지 아닌지를 알려준다.
				// var reg = /패턴/; var testing = reg.test( string );
				// g 플래그가 붙으면 패턴과 일치하는 모든 것들을 찾음
				if (data.bname !== '' && /[동|로|가]$/g.test(data.bname)) {
					extraAddr += data.bname;
				}
				// 건물명이 있고, 공동주택일 경우 추가한다.
				if (data.buildingName !== '' && data.apartment === 'Y') {
					extraAddr +=
						(extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
				}
				// 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
				if (extraAddr !== '') {
					extraAddr = ' (' + extraAddr + ')';
				}
				// 조합된 참고항목을 해당 필드에 넣는다.
				document.getElementById("sample6_extraAddress").value = extraAddr;

			} else {
				document.getElementById("sample6_extraAddress").value = '';
			}

			// 우편번호와 주소 정보를 해당 필드에 넣는다. 
			document.getElementById('sample6_postcode').value = data.zonecode; document.getElementById("sample6_address").value = addr;
			// 커서를 상세주소 필드로 이동한다. 
			document.getElementById("sample6_detailAddress").focus();
		}
	}).open();
}



function idCheck(id) {
	if (id == "") {
		alert("아이디를 입력해 주세요.");
		document.regForm.id.focus();
	} else {
		url = "member.mdo?cmd=idCheck&id=" + id;
		window.open(url, "post", "width=300,height=150");
	}
}
function zipCheck() {
	url = "member.mdo?cmd=zipCheck&check=y";
	window.open(url, "post", "toolbar=no, width=500, height=300,directories = no, status = yes, scrollbars = yes, menubar = no");
}
function inputCheck() {
	var theForm = document.regForm;
	if (!theForm.id.value) {
		alert("아이디를 입력해 주세요");
		theForm.id.focus();
		return;
	}
	if (!theForm.pass.value) {
		alert("비밀번호를 입력해 주세요");
		theForm.pass.focus();
		return;
	}
	if (!theForm.repass.value) {
		alert("비밀번호를 확인해 주세요");
		theForm.repass.focus();
		return;
	}
	if (theForm.repass.value != theForm.pass.value) {
		alert("비밀번호가 일치하지 않습니다.");
		theForm.repass.focus();
		return;
	}
	if (!theForm.name.value) {
		alert("이름을 입력해 주세요.");
		theForm.name.focus();
		return;
	}
	if (!theForm.phone1.value) {
		alert("통신사를 선택해 주세요.");
		theForm.phone1.focus();
		return;
	}
	if (!theForm.phone2.value) {
		alert("전화번호 앞자리를 입력해 주세요.");
		theForm.phone2.focus();
		return;
	}
	if (!theForm.phone3.value) {
		alert("전화번호 뒷자리를 입력해 주세요.");
		theForm.phone3.focus();
		return;
	}
	if (!theForm.email.value) {
		alert("이메일을 입력해 주세요.");
		theForm.email.focus();
		return;
	}

	/*var regExp =/^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;*/
/*	if (!regExp.test(theForm.email.value)) {
		alert("잘못된 이메일 주소입니다.");
		theForm.email.focus();
		return;
	}*/


	if (!theForm.zipcode.value) {
		alert("우편번호를 입력해 주세요");
		theForm.zipcode.focus();
		return;
	}
	if (!theForm.address1.value) {
		alert("주소를 입력해 주세요");
		theForm.address1.focus();
		return;
	}
	if (!theForm.address2.value) {
		alert("세부주소를 입력해 주세요");
		theForm.address2.focus();
		return;
	}
	theForm.submit();
}

