<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="/webedu/public/bootstrap/dist/css/bootstrap.css">
<script src="/webedu/public/jquery/jquery-3.3.1.js"></script>
<script src="/webedu/public/bootstrap/dist/js/bootstrap.js"></script>
<style>
body {
	margin: 20px;
	padding: 20px;
	line-height: 1;
	font-family: "Open Sans", sans-serif;
	font-size: 1em;
	background: #555;
	color: #000;
}
ul, li {
	margin: 0;
	padding: 0;
	list-style: none;
}
li {
	margin-top: 20px;
}
.title {
	margin: 0;
	padding: 0;
	font-size: 1.5em;
	font-weight: 300;
}
.container {
	margin-top: 35px;
}
</style>	
<script>
$(function(){

});
</script>
<title>Insert title here</title>
<script>
$(function(){ $("li").css({"background-color":"#666"}); });
$(function()
		{ console.log('$("li").css("background-color") :', $("li").css("background-color")); $("li").css({"background-color":"#666"}); });
$(function(){ $("#tutorial").css({"background-color":"#666"}); });
$(function(){ var $jquery=$(".jquery").detach(); console.log("$jquery : ", $jquery);
$("#portfolio").click(function(){ if($jquery != ""){ $("#tutorial").append($jquery); $jquery=""; }else{ $jquery=$(".jquery").detach(); } });
});
</script>



</head>
<body>
<h1 class="title">basic :: jQuery node access</h1>
<div class="container">
	<ul id="tutorial">
		<li class="html">HTML</li>
		<li class="css">CSS</li>
		<li class="css3">CSS3</li>
		<li class="javascript">JavaScript</li>
		<li class="jquery">jQuery</li>
		<li class="blank"></li>
	</ul>
	<p id="portfolio">portfolio</p>
</div>
</body>
</html>