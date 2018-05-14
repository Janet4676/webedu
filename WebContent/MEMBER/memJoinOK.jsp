<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.edu.*" %>
 <%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<% request.setCharacterEncoding("utf-8"); %>
<jsp:useBean id="mdto" class="com.edu.MemDTO"></jsp:useBean>
<jsp:setProperty name="mdto" property="*"></jsp:setProperty>
	<C:set var="birth" value="${param.year}${param.month}${param.day }" />
	${mdto.setBirth(birth)}
<%
	MemberDAO mdao = MemberDAO.getInstance();

	pageContext.setAttribute("set_sqlresult1", mdao.checkID(mdto.getId()));
	pageContext.setAttribute("set_sqlresult2", mdao.insertMember(mdto));
%>
<C:set var="sqlresult" value="${set_sqlresult1}"/>
<C:set var="sqlresult2" value="${set_sqlresult2}"/>
	<C:choose>
		<C:when test="${ sqlresult == SqlResult.MEM_EXIST }">
			<script>
				window.alert("이미 존재하는 아이디입니다!");
				window.history.back(); // 이전화면
			</script>
		</C:when>
		<C:otherwise>
			<C:choose>
				<C:when test="${ sqlresult2 == SqlResult.MEM_JOIN_SUCCESS }">
					session.setAttribute("id", mdto.getId());
					<script>
						window.alert("회원가입이 완료되었습니다.");
						document.location.href = "/webedu/MEMBER/memLogin.jsp";
					</script>
				</C:when>
				<C:otherwise>
					<script>
						window.alert("회원가입에 실패하였습니다.");
						document.location.href="/webedu/MEMBER/memLogin.jsp";
					</script>
				</C:otherwise>
			</C:choose>
		</C:otherwise>
	</C:choose>
<%-- 
	<C:if test="${ sqlresult == SqlResult.MEM_EXIST }">
		<script>
			window.alert("이미 존재하는 아이디입니다!");
			window.history.back(); // 이전화면
		</script>
	</C:if>
	<C:if test="${ sqlresult2 == SqlResult.MEM_JOIN_SUCCESS }">
			session.setAttribute("id", mdto.getId());
				<script>
					window.alert("회원가입이 완료되었습니다.");
					document.location.href = "/webedu/MEMBER/memLogin.jsp";
				</script>
	</C:if>
	<C:if test="${ sqlresult2 != SqlResult.MEM_JOIN_SUCCESS }">
		<script>
			window.alert("회원가입에 실패하였습니다.");
			document.location.href = "/webedu/MEMBER/memLogin.jsp";
		</script>
	</C:if>
 --%>
	<%--
	if (mdao.checkID(mdto.getId()) == SqlResult.MEM_EXIST) {
		<script>
		window.alert("이미 존재하는 아이디입니다!");
		window.history.back();	// 이전화면
		</script>
		} else {
			if(mdao.insertMember(mdto) == SqlResult.MEM_JOIN_SUCCESS) {
				session.setAttribute("id", mdto.getId());	// id를 session에 담음
				<script>
				window.alert("회원가입이 완료되었습니다.");
				document.location.href="/webedu/MEMBER/memLogin.jsp";
				</script>
			} else {
				<script>
				window.alert("회원가입에 실패하였습니다.");
				document.location.href="/webedu/MEMBER/memLogin.jsp";
				</script>
		};
	}
--%>
</body>
</html>