<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
 	if(session.getAttribute("admin") != null ) {
 %>
 	<jsp:forward page="/ADMIN/admin.jsp" />
 <%
 	}
 %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>관리자 로그인</title>
</head>
<body>
	<hr />
	<h2>관리자 로그인</h2>
	<hr />
	<form action="/webedu/ADMIN/adminLoginOK.jsp" method="post">
	아이디: <input type="text" name="id"  /><br>
	비밀번호 <input type="password" name="passwd" /><br>
	<input type="submit" value="로그인" />
	<input type="reset" value="초기화" />
	</form>
</body>
</html>