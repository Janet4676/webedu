<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <jsp:useBean id="cnt" class="com.edu.CountBean" scope="request"/>
    <jsp:setProperty property="count" name="cnt" />	
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>cnt의 getCount호출(request)</title>
</head>
<body>
	<jsp:getProperty property="count" name="cnt"/>
	${cnt.count }
	<jsp:forward page ="scope_result_2.jsp" />	scope적용됨
<%-- 	<% response.sendRedirect("scope_result_2.jsp"); %>  scope적용안됨--%>
<!-- 	<a href="scope_result_2.jsp">result_2</a> scope적용안됨-->

<!-- 
	1. jsp:forward
	(공유할 수 있는 것 :request, session(한번 커넥션되면 브라우저에 대해서는 session유지), application)
	    client(scope_test01.html) ㅡ> page1(scope_test02.jsp) ㅡ> page2(scope_result02.jsp)
		요청1회 응답1회임. 구간에 있는 request가 공유된다.
	
	2.response.sedRedirect , a 
	(공유할 수 있는 것 : session, application)
		client(scope_test01.html) ┌─> page1(scope_test02.jsp)
								  └─> page2(scope_result02.jsp)
		요청2회 응답2회임. request가 공유되지 못한다. 

 -->
</body>
</html>