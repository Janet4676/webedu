	function mem_check() {
		if (document.join_frm.id.value.length == 0) {
			window.alert("아이디를 입력해주세요.");
			document.join_frm.id.focus();
			return;
		}
		if (document.join_frm.id.value.length < 4) {
			window.alert("아이디는 최소 4글자 이상이어야합니다.");
			document.join_frm.id.focus();
			return;
		}
		if (document.join_frm.passwd.value.length == 0) {
			window.alert("비밀번호를 입력해주세요.");
			document.join_frm.passwd.focus();
			return;
		}
		if (document.join_frm.passwd.value != document.join_frm.passwd_chk.value) {
			window.alert("비밀번호가 일치하지 않습니다.");
			document.join_frm.passwd_chk.focus();
			return;
		}
		document.join_frm.submit();
	}

	function updateInfo() {
		if(document.modify_frm.passwd.value == "") {
			window.alert("패스워드를 입력하세요 !");
			document.modify_frm.focus();
			return;
		} 
		if(document.modify_frm.passwd.value != document.modify_frm.passwd_chk.value) {
			window.alert("패스워드가 일치하지 않습니다.");
			document.modify_frm.focus();
			return;
		}
		document.modify_frm.submit();
	}
	
