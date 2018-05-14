<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String str = request.getParameter("v1");

	System.out.println(str);
	
	out.print("검색결과 :" + str + " 입니다.");
	
	

%>
