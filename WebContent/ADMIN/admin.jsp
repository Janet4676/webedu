<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String id = (String)session.getAttribute("id");
	String name = (String)session.getAttribute("name");
	String grade = (String)session.getAttribute("grade");
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>[<%=grade %>등급 관리자] <%=name %>(<%=id %>)님 환영합니다.</h2>
관리자 메인화면입니다.
<a href="MemberList.jsp">회원목록</a>
<form action="/webedu/ADMIN/adminLogout.jsp">
<input type="button" value="로그아웃"  onClick="javascript:window.location='/webedu/ADMIN/adminLogout.jsp'"/>
</form>
</body>
</html>