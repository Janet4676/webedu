<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "com.edu.*" %>
<%
	request.setCharacterEncoding("utf-8");
	String id = (String)session.getAttribute("id");
	
	MemberDAO mdao = MemberDAO.getInstance();
	int n = mdao.deleteMember(id);
	
	if (n==1) {
		session.invalidate();	// 세션제거
%>
	<script>
	alert("회원탈퇴가 정상적으로 수행되었습니다.");
	document.location.href ="/webedu/MEMBER/memLogin.jsp";
	</script>
<%
	} else {	
%>
	<script>
	alert("회원탈퇴 실패!");
	document.history.back();
	</script>
<%		
	}
%>
