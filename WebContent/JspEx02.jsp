<%-- [스크립트형요소 (스크립틀릿, 익스프레션, 선언부)]
 스크립틀릿 : <%	%> : 자바코드가 온다.
 익스프레션 : <%=	%> : 결과값 출력
 선언부      : <%!	%> : 변수나 메소드 선언 --%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<!--스크립틀릿-->
<%
	int i =0;
	while(true) {
		i++;
		out.println("하이"+i);
%>
	<br>
<%
		if (i>10)
			break;
	}
%>
<%!
	int i = 100;
	String str ="test";
	int hap(int a, int b) {
	return a+b;
	}
%>
	<br>
<%
	out.println("i="+i+"<br>");
	out.println("str="+str+"<br>");
	out.println("hap="+hap(2,10));
%>
<br>
i=<%=i %> <br>
str=<%=str %><br>
hap=<%=hap(10,2) %>
</body>
</html>