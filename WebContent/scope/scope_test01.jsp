<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>cnt의 getCount호출(page)</title>
</head>
<body>
<jsp:useBean id="cnt" class="com.edu.CountBean" scope="page"/>
<jsp:setProperty property="count" name="cnt" />	<!-- count는 CountBean에서 setCount의 count를 불러줌 -->
	<jsp:getProperty property="count" name="cnt"/>
	${cnt.count}
	<a href="scope_result_1.jsp">result_1</a>
</body>
</html>