<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import = "javax.naming.*" %>
    <%@ page import = "javax.sql.*" %>
    <%@ page import = "java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
Connection conn = null;
try {
	Context initContext = new InitialContext();
	Context envContext = (Context)initContext.lookup("java:comp/env");
	DataSource ds = (DataSource)envContext.lookup("jdbc/Oracle11g");
	conn = ds.getConnection();
	out.println("success!");
} catch(Exception e) {
	e.printStackTrace();
	out.println("fail");
}finally {
	conn.close();
}
%>

</body>
</html>