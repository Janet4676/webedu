<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% response.setStatus(HttpServletResponse.SC_OK); %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>404 에러 페이지</title>
<style>
	* {
		text-align:center;
	}
	#404_err {
		line-height:200px;
	}
	#404_err img {
		vertical-align:middle;
	}
</style>
</head>
<body>
<div id="404_err">
	<table>
	<tr>
		<td><img src="/webedu/IMG/error_404.gif" alt="404 오류페이지" width="50%" height="50%" /></td>
	</tr>
	</table>
</div>
</body>
</html>