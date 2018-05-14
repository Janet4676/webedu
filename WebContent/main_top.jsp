<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>Document</title>
  <style>
    * { margin: 0; text-align: center; }
    html, body { margin:0; padding:0; height:100%;  }
    #header1 { background: rgb(5, 213, 245); height:10%;}
    #nav1 { background-color: rgb(189, 142, 108); height:10%;}
    #section1 { background-color: rgb(148, 29, 196); width:70%; height:30%;
                float:left;}
    #article1 { background-color: rgb(207, 63, 18); width:30%; height:20%;
                float:right;}
    #aside { background-color: rgb(57, 210, 33); width:30%; height:50%;
              float:right;}
    #section2 { background-color: rgb(244, 229, 33); width:70%; height:40%;
                float:left;}
    #header2 { background-color: rgb(200, 206, 207); height:10%}
    #footer1 { background-color: rgb(92, 190, 15); height:10%}
    #footer2 { position: fixed; background-color: rgb(47, 120, 230); height:10%; width:100%; float:clear;}
    #p1 { height: 65%;}
  </style>
</head>
<body>
<header id="header1">&lt;header1&gt;</header>
<nav id="nav1">
	<table>
		<tr>
			<td><a href="/webedu/index.jsp">홈으로</a></td>
			<td><a href="/webedu/MEMBER/memLogin.jsp" target="iframe_content" >로그인</a></td>
			<td><a href="/webedu/MEMBER/memJoin.jsp" target="iframe_content" >회원가입</a></td>
			<td></td>
			<td><a href="/webedu/ADMIN/adminLogin.jsp" target="iframe_content" >관리자로그인</a></td>
			<td><a href="/webedu/bbs/list.do" target="iframe_content" >게시판</a></td>
		</tr>
	</table>
</nav>