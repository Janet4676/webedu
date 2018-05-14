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
	Cookie[] cookies = request.getCookies();
	for(Cookie c : cookies) {
		String str = c.getName();
			/*if(str.equals("id")) {
				out.println(c.getValue());
			} */
		out.println("쿠키이름:"+c.getName()+":"+c.getValue());
		out.println("<br>");
	}
%>
</body>
</html>