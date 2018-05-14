<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="el04.jsp" method="get">
	아이디 : <input type="text" name="id" id="" /><br>
	비밀번호 : <input type="password" name="passwd" id="" /><br>
	<input type="submit" value="로그인" />
	</form>
	<%
	// 임시저장하는 내장객체, getAttribute가 실행되는 우선순위는 request -> session -> application
		application.setAttribute("appName", "appValue");
		session.setAttribute("sessionName", "sessionValue");
		pageContext.setAttribute("pageName", "pageValue");
		request.setAttribute("requestName", "requestValue");
	%>
</body>
</html>