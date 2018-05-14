<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page import= "com.edu.*" %>
<% request.setCharacterEncoding("utf-8"); %>
<jsp:useBean id="mdto" class="com.edu.MemDTO" />
<jsp:setProperty name="mdto" property="*" />
<%
	String year = request.getParameter("year");	// request : 내장객체. 클라이언트의 요청을 관리한다.
	String month = request.getParameter("month");
	String day = request.getParameter("day");
	mdto.setBirth(year+""+month+""+day);

	String id = (String)session.getAttribute("id");
	MemberDAO mdao= MemberDAO.getInstance();	
	mdto.setId(id);
	
	int n = mdao.updateMember(mdto);
	if (n==1) {	// 수정 성공
		session.setAttribute("name",mdto.getName());
%>
	<script>
	alert("회원정보가 수정되었습니다.");
	document.location.href ="/webedu/main.jsp";
	
	</script>
<%
	} else {	// 수정 실패
%>
	<script>
	alert("회원정보 수정에 실패하였습니다.");
	document.history.back();
	</script>
<%		
	}
%>
