<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <jsp:useBean id="cnt" class="com.edu.CountBean" scope="application"/>
    <jsp:setProperty property="count" name="cnt" />	
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>cnt의 getCount호출(application)</title>
</head>
<body>
	<jsp:getProperty property="count" name="cnt"/>
	${cnt.count }
<%-- 	<jsp:forward page ="scope_result_4.jsp" /> --%>
<%-- 	<% response.sendRedirect("scope_result_4.jsp"); %> --%>
	<a href="scope_result_4.jsp">result_4</a>
</body>
</html>