<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- JSP 특징
-동적 웹어플리케이션 컴포넌트
-확장자는 jsp
-클라이언트의 요청에 동적으로 동작을 하며 응답은 html
-jsp 파일은 서블릿으로 변환되어 실행된다.
-MVC 패턴에서 view로 이용됨.

JSP 동작과정
1.클라이언트가 jsp 파일 요청
2.jsp 컨테이너로 전송:웹컨테이너로 jsp파일을 넘긴다.
3.jsp 파일 파싱 : 해당 jsp파일이 처음 요청된 것이면 파일을 파싱한다. 
4.jsp파일을 읽어들여서 서블릿으로 변환 : 새로운 자바파일을 생성한다.
5.클래스 파일 생성 : 서블릿 파일(자바파일)은 실행 가능한 상태의 클래스 파일로
					 컴파일된다.
6.메모리에 로딩됨 : 클래스 파일은 메모리에 로딩된다.
7.html 전송 : 클래스 파일에 대한 실행 결과는 다시 웹서버로 넘겨진다.(클라이언트로)
			  웹서버는 html형태로 사용자에게 응답을 한다.
8.브라우저에 html 실행 되어짐.
-->

Hello JSP~!

</body>
</html>