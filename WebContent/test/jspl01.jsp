<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- JSTL : 표준화된 태그 라이브러리, 우리가 시스템을 개발할 때 개발자들이 공통으로 많이 사용하는 기능을 미리 구현해놓은 커스텀 태그들이다. -->
	<!-- 변수선언 -->
	<C:set var="num1" value="10" />
	<C:set var="num2" value="5" />
	<C:set var="result" value="${num1*num2 }" ></C:set>
	
	<!-- 출력 -->
	<C:out value="${result }" ></C:out><br />
	${num1}와 ${num2}의 곱은 ${result}입니다.<br />
	
	<!-- 예외처리 -->
	<C:catch var="except">
		<%= 10/0 %>
	</C:catch>
	<C:out value="${except }"></C:out><br />
	
	<!-- if제어문 , true일 경우 실행,  false일 경우 실행되지 않는다.-->
	<C:if test="${10+10 == 100 }"><br />
	if 제어문
	</C:if>
	
	<!-- ForEac 반복문 -->
	<C:forEach var="aa" begin="0" end="10" step="2">
		<font size=${aa }>안녕하세요! </font> <br />
	</C:forEach>





</body>
</html>