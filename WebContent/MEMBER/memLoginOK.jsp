<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.edu.*" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	request.setCharacterEncoding("utf-8");
	String id = request.getParameter("id");
	String passwd = request.getParameter("passwd");
	
	MemberDAO mdao = MemberDAO.getInstance();
	SqlResult sqlresult = mdao.memberCheck(id, passwd);
	
	if(sqlresult == SqlResult.MEM_LOGIN_NOT) {	// 회원이 아님
%>
	<script>
		window.alert("아이디가 존재하지 않습니다.");
		window.history.go(-1); // window.history.back();
	</script>

<%		
	} else if (sqlresult == SqlResult.MEM_LOGIN_PW_NOT){ // 비밀번호가 틀림
%>
	<script>
		window.alert("비밀번호가 일치하지 않습니다.");
		window.history.go(-1);
	</script>

<%		
	} else if (sqlresult == SqlResult.MEM_LOGIN_SUCCESS) { // 로그인 성공
		MemDTO mdto = mdao.getMember(id);
		session.setAttribute("id",mdto.getId());
		session.setAttribute("name",mdto.getName());
		session.setAttribute("chkMember", "OK");
		response.sendRedirect("/webedu/main.jsp");	
	}
%>
</body>
</html>