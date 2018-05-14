<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="member" class="com.edu.MemDTO" scope="page"></jsp:useBean>	<!-- page : 해당페이지(.jsp)에서만 사용 가능 -->
<jsp:setProperty property="name" name="member" value="홍길동"/>
<jsp:setProperty property="id" name="member" value="abc@naver.com"/>
<jsp:setProperty property="passwd" name="member" value="1234"/>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
이름 : <jsp:getProperty property="name" name="member"/><br />
아이디 : <jsp:getProperty property="id" name="member"/><br />
비밀번호 : <jsp:getProperty property="passwd" name="member"/><br />
<%-- 
	[EL Expression Language]
	: 표현식) <%= %>또는 액션태그(표준태그,커스텀태그)를 대신해서 값을 표현하는 언어
															>> 표준화 : JSTL
--%>
<hr />
이름 : ${member.name } <br />
아이디 : ${member.id } <br />
비밀번호 : ${member.passwd } <br />

</body>
</html>