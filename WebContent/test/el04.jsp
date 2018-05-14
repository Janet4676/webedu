<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%--
	<%
		String id = request.getParameter("id");
		String passwd = request.getParameter("passwd");
	%>
아이디 : <%=id %> <br>
비밀번호 : <%=passwd %><br> --%>

<hr />
아이디 : ${param.id }<br>	<!-- 내장객체 param : 웹브라우저에서 전송된 질의문자열(get방식?)에 대하여 작업을 쉽게 할 수 있다. -->
아이디 : ${param["id"] }<br>
비밀번호 : ${param.passwd }<br>
<hr />
applicationScope : ${applicationScope.appName }<br> <!-- 프로그램이 종료될때까지 -->
sessionScope : ${sessionScope.sessionName }<br>
pageScope : ${pageScope.pageName }<br> <!-- 페이지가 바뀌었기 때문에 나오지 않음  -->
requestScope : ${requestScope.requestName}<br> <!-- 리퀘스트요청이 끊겨서 나오지 않음  -->
<hr />



- context 초기화 파라미터<br />
<!-- 
	설정은 web.xml에서
	<context-param>
		<param-name>key값</param-name>
		<param-value>value값</param-value>
	</context-param>
 	어플리케이션에서 공통적으로 가지고갈 값들을 web.xml에 설정해놓고 사용하기 위해 설정한다.
 --> 
 ${initParam.key_1 }<br />
 ${initParam.key_2 }<br />
 ${initParam.key_3 }<br />
</body>
</html>