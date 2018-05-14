<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원가입</title>
<!-- 자바스크립트 외부파일 불러오기 -->
<!-- <script src = "/webedu/MEMBER/js/member.js"></script> -->
<script src="/webedu/public/jquery/jquery-3.3.1.js"></script>
<script src="/webedu/MEMBER/js/member2.js"></script>
</head>
<body>
<hr>
<h2>회원가입</h2>
<hr>
<form action="/webedu/MEMBER/memJoinOK.jsp" method="post" name="join_frm">
아이디 : <input type="email" name="id" id="id" placeholder="abc@abc.com"/>	<br>
비밀번호 : <input type="password" name="passwd" id="passwd"/> <br>
비밀번호확인 : <input type="password" name="passwd_chk" id="passwd_chk"/> <br>
이름 : <input type="text" name="name" id="name"/> <br>
생년월일 : <select name="year" id="year">
			<option value="2000">2000</option>
			<option value="2001">2001</option>
			<option value="2002">2002</option>
			<option value="2003">2003</option>
			<option value="2004">2004</option>
			</select>년

			<select name="month" id="month">
				<option value="1">1</option>
				<option value="2">2</option>
				<option value="3">3</option>
				<option value="4">4</option>
				<option value="5">5</option>
				<option value="6">6</option>
				<option value="7">7</option>
				<option value="8">8</option>
				<option value="9">9</option>
				<option value="10">10</option>
				<option value="11">11</option>
				<option value="12">12</option>
			</select>월
			<select name="day" id="day">
				<option value="1">1</option>
				<option value="2">2</option>
				<option value="3">3</option>
				<option value="4">4</option>
				<option value="5">5</option>
				<option value="6">6</option>
				<option value="7">7</option>
				<option value="8">8</option>
				<option value="9">9</option>
				<option value="10">10</option>
			</select>일 <br>
전화번호 : <input type="text" name="phone" id="phone" /> <br>
<input type="button" value="회원가입" id="memJoin" onClick="mem_check()"/>
<input type="reset" value="취소" />
</form>
</body>
</html>