<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	session.invalidate();	// 세션제거
	response.sendRedirect("/webedu/MEMBER/memLogin.jsp");
%>
