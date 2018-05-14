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
	// 쿠키 설정
	Cookie cookie = new Cookie("id", "id_value");

	// 유효기간 설정
	cookie.setMaxAge(60*10); // 10분
	
	// 클라이언트로 전송
	response.addCookie(cookie);
%>
<h2>쿠키 생성 페이지</h2>
<form action="cookie02.jsp" method="post">
	<input type="submit" value="생성된 쿠키확인" />
</form>
</body>
</html>