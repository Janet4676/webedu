<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.edu.*" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<% request.setCharacterEncoding("utf-8"); %>
<!-- jsp:useBean 액션을 주는거? -->
<jsp:useBean id="mdto" class="com.edu.MemDTO"></jsp:useBean>
<jsp:setProperty name="mdto" property="*"></jsp:setProperty>
<%
	String year = request.getParameter("year");	// request : 내장객체. 클라이언트의 요청을 관리한다.
	String month = request.getParameter("month");
	String day = request.getParameter("day");
	mdto.setBirth(year+month+day);
%>
<%-- 
<%=mdto.getId() %>
<%=mdto.getPasswd() %>
<%=mdto.getName() %>
<%=mdto.getBirth() %>
<%=mdto.getPhone() %> --%>

<%
	MemberDAO mdao = MemberDAO.getInstance();
	if (mdao.checkID(mdto.getId()) == SqlResult.MEM_EXIST) {
%>
	<script>
	window.alert("이미 존재하는 아이디입니다!");
	window.history.back();	// 이전화면
	</script>
<%
	} else {
		if(mdao.insertMember(mdto) == SqlResult.MEM_JOIN_SUCCESS) {
			session.setAttribute("id", mdto.getId());	// id를 session에 담음
%>  
	<script>
	window.alert("회원가입이 완료되었습니다.");
	document.location.href="/webedu/MEMBER/memLogin.jsp";
	</script>
<%
		} else {
%>
	<script>
	window.alert("회원가입에 실패하였습니다.");
	document.location.href="/webedu/MEMBER/memLogin.jsp";
	</script>
<%
		};
	}
%>
</body>
</html>