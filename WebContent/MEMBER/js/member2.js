/*jQuery 이용한 유효성체크*/
$(function() {
	/*$("#memJoin").click(function() {*/
	$("input[value='회원가입']").click(function() {
		if ($("#id").val() == "") {
			alert("아이디를 입력해주세요!");
			$("#id").focus();
			return false;
		}
		if ($("#id").val().length < 4) {
			alert("아이디는 최소 4글자 이상 입력해주세요!");
			$("#id").focus();
			return false;
		}
		if ($("#passwd").val() == "") {
			alert("비밀번호를 입력해주세요!");
			$("#passwd").focus();
			return false;
		} 
		if ($("#passwd").val() != $("#passwd_chk").val()) {
			alert("비밀번호가 일치하지 않습니다!");
			$("#passwd").focus();
			return false;
		}
		document.join_frm.submit();
	});
	
	
	$("#memModify").click(function() {
		if ($("#passwd").val() == "") {
			alert("비밀번호를 입력해주세요!");
			$("#passwd").focus();
			return false;
		} 
		if ($("#passwd").val() != $("#passwd_chk").val()) {
			alert("비밀번호가 일치하지 않습니다!");
			$("#passwd").focus();
			return false;
		}
		document.modify_frm.submit();
	});
	
});

