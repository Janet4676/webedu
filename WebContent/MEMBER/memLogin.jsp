<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
 	if(session.getAttribute("chkMember") != null ) {
 %>
 	<jsp:forward page="/main.jsp" />
 	<!-- forward에서의 root는 webContent임~! 그래서 경로지정할때 주의~
 	한 어플리케이션내에서 경로를 지정해 줄 때 사용함.. 다른 url인 어플리케이션의 범위는 갈수없음! webcontent안쪽이 root인느낌?
 	그래서 main.jsp의 절대경로는 /main.jsp임 상대경로는..
 	memLogin이 MEMBER폴더안에 있으니까 ../main.jsp임 -->
 <%
 	}
 %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>로그인</title>
<script src="/webedu/public/jquery/jquery-3.3.1.js"></script>
<script>

/* 	$(document).ready(function() {
		$("form").submit(function() {
			if($("#id").val()=="") {
				alert("아이디를 입력해주세요!");
				$("#id").focus();
				return false;
			} else if ($("#passwd").val()=="") {
				alert("비밀번호를 입력해주세요!");
				$("#passwd").focus();
				return false;
			}
		});
	}); */
	
	// 축약1)
/* 	jQuery(function() {
		$("form").submit(function() {
			if($("#id").val()=="") {
				alert("아이디를 입력해주세요!");
				$("#id").focus();
				return false;
			} else if ($("#passwd").val()=="") {
				alert("비밀번호를 입력해주세요!");
				$("#passwd").focus();
				return false;
			}
		});
	}); */

	//축약2
	$(function() {
		$("form").submit(function() {
			if($("#id").val()=="") {
				alert("아이디를 입력해주세요!");
				$("#id").focus();
				return false;
			} else if ($("#passwd").val()=="") {
				alert("비밀번호를 입력해주세요!");
				$("#passwd").focus();
				return false;
			}
		});
	});
	
</script>
</head>
<body>
	<hr />
	<h2>로그인</h2>
	<hr />
	<form action="/webedu/MEMBER/memLoginOK.jsp" method="post">
	아이디: <input type="text" name="id"  id="id"/><br>
	비밀번호 <input type="password" name="passwd"  id="passwd"/><br>
	<input type="submit" value="로그인" />
	<input type="button" value="회원가입" onClick="javascript:window.location='/webedu/MEMBER/memJoin.jsp' "/>	<!-- 함수로 안만들고 간단한건 이렇게도 처리 가능 -->
	</form>
</body>
</html>