<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="/webedu/public/bootstrap/dist/css/bootstrap.css">
<script src="/public/jquery/jquery-3.3.1.js"></script>
<script src="/webedu/public/bootstrap/dist/js/bootstrap.js"></script>
<title>게시판 쓰기 양식</title>
</head>
<body>
<div class="container">
<p class="h2" align="center">글쓰기</p>
<table class="table">
	<form action="write.do" method="post">
	<input type ="hidden" name ="reqPage" value="${param.reqPage }" />
		<tr>
			<th class="w-25 p-3">제목</th>
			<td scope="col"> 
				<input type="text" class="form-control" name="bTitle" placeholder="제목을 입력하세요." />
			</td>
		</tr>
		<tr>
			<th scope="col">작성자</th>
			<td scope="col">
			<input type="text" class="form-control" name="bName" placeholder="이름을 입력하세요." />
			</td>
		</tr>
		<tr>
			<th scope="col">내용</th>
			<td scope="col">
				<textarea class="form-control" name="bContent" rows="10"></textarea>
			</td>
		</tr>
		<tr><!-- 버튼 들어갈곳 -->
			<td colspan=2 align="center">
			<input class="btn btn-primary" type="submit" value="등록">
			<a href="list.do?reqPage=${param.reqPage }" class="btn btn-secondary" role="button" aria-pressed="true">목록으로</a>
			</td>
		</tr>
	</form>
</table>
</div>
</body>
</html>