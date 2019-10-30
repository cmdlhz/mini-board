<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jspf" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SIGN UP</title>
</head>
<body>
<!-- event는 무조건 소문자로 통일! 그래서 onSubmit이 아님! -->
<form method="POST" action="/user/signup" onsubmit="return checkForm()">
	<table border="1">
		<tr>
			<th>이름</th>
			<td><input type="text" name="ui_name" id="uiName"></td>
		</tr>
		<tr>
			<th>아이디</th>
			<td><input type="text" name="ui_id" id="uiId"></td>
		</tr>
		<tr>
			<th>비밀번호</th>
			<td><input type="password" name="ui_pwd" id="uiPwd"></td>
		</tr>
		<tr>
			<th>비밀번호 확인</th>
			<td><input type="password" name="ui_pwd_check" id="uiPwdCheck"></td>
		</tr>
		<tr>
			<th colspan="2"><button>회원 가입</button></th>
		</tr>
	</table>
</form>
<script>
function checkForm(){
	// getElementById 대신 querySelector를 더 많이 씀
	var uiName = document.getElementById("uiName");
	var uiId = document.getElementById("uiId");
	var uiPwd = document.getElementById("uiPwd");
	var uiPwdCheck = document.getElementById("uiPwdCheck");
	
	if(uiName.value.trim().length < 2){
		alert("A name should contain more than 2 characters.");
		uiName.value = "";
		uiName.focus();
		return false;
	}
	if(uiId.value.trim().length < 5){
		alert("An ID should contain more than 5 characters.");
		uiId.value = "";
		uiId.focus();
		return false;
	}
	if(uiPwd.value.trim().length < 5){
		alert("A password should contain more than 5 characters.");
		uiPwd.value = "";
		uiPwd.focus();
		return false;
	}
	if(uiPwd.value != uiPwdCheck.value){
		alert("Passwords do not match!");
		uiPwdCheck.value = "";
		uiPwdCheck.focus();
		return false;
	}	
	return true;
}
</script>
</body>
</html>