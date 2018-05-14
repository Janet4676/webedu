<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	// 쿠키삭제 : 쿠키값은 null로 유효시간은 '0'
	Cookie c = new Cookie("id", null);
	c.setMaxAge(0);
	response.addCookie(c);
	
	Cookie c2 = new Cookie("JSESSIONID", null);
	c2.setMaxAge(0);
	c2.setPath("/webedu");
	response.addCookie(c2);
%>
</body>
</html>