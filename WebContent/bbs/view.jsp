<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="/webedu/public/bootstrap/dist/css/bootstrap.css">
<script src="/webedu/public/jquery/jquery-3.3.1.js"></script>
<script src="/webedu/public/bootstrap/dist/js/bootstrap.js"></script>
<title>Insert title here</title>
<script>
$(function(){
	$("#myLink_1").css({"display":""});
	$("#myLink_2").css({"display":"none"});
	$("#myLink_3").css({"display":""});
	
	//편집모드변환
	$("#modify").click(function(){
		var status = $("#myLink_2").css("display");
		if(status == "none"){
			
			$("#myLink_1").css({"display":"none"});
			$("#myLink_2").css({"display":""});
			$("#myLink_3").css({"display":"none"});
			$("[id^='m']").removeAttr("readonly");
		}
	});
	
	//열기모드변환
		$("#cModify").click(function(){
			var status = $("#myLink_1").css("display");
			if(status == "none"){
				
				$("#myLink_1").css({"display":""});
				$("#myLink_2").css({"display":"none"});
				$("#myLink_3").css({"display":""});
				$("[id^='m']").attr("readonly","readonly");
			}
			
		$("#myfrm1").attr("action","modify.do?bNum=${view.bNum}").submit();	
		});
});
</script>
</head>
<body>
<div class="container">
<p class="h2" align="center">글 내용보기</p>
<table class="table">
   <form action="" name="frm_1" id="myfrm1">
   <input type="hidden" name="reqPage" value="${recordCriteria.reqPage }"/>
      <tr>
         <th class="w-25 p-3">제목</th>
         <td scope="col"> 
            <input type="text" name="bTitle" readonly="readonly"  class="form-control" id="mTitle" value="${view.bTitle }" >
         </td>
      </tr>
      <tr>
         <th scope="col">작성자</th>
         <td scope="col">
            <input type="text" name="bName" readonly="readonly" class="form-control" id="" value="${view.bName }" >
         </td>
      </tr>
      <tr>
         <th class="w-25 p-3">글번호</th>
         <td scope="col"> 
            <input type="text" name="bNum" readonly="readonly" class="form-control" id="" value="${view.bNum}" >
         </td>
      </tr>
      <tr>
         <th class="w-25 p-3">조회수</th>
         <td scope="col"> 
            <input type="text" name="bHit" readonly="readonly" class="form-control" id="" value="${view.bHit }" >
         </td>
      </tr>
      <tr>
         <th class="w-25 p-3">작성일</th>
         <td scope="col"> 
            <input type="text" name="bUdate" readonly="readonly" class="form-control" id="" value="${view.bUdate }" >
         </td>
      </tr>
      <tr>
         <th class="w-25 p-3">내용</th>
         <td scope="col">
            <textarea name="bContent" readonly="readonly" class="form-control" id="mContent" rows="5" >${view.bContent }</textarea>
         </td>
      </tr>
      <tr id="myLink_1"><!-- 읽기모드일 경우 버튼 -->
         <td colspan=2 align="right">
         <a href="list.do?reqPage=${recordCriteria.reqPage }" class="btn btn-secondary" role="button" id="toList" aria-pressed="true">목록으로</a>
         <a href="#" class="btn btn-secondary" role="button" id="modify" aria-pressed="true">수정하기</a>
         <a href="replyView.do?reqPage${recordCriteria.reqPage }.bNum" class="btn btn-secondary" role="button" id="reply" aria-pressed="true">답글달기</a>
         <a href="delete.do?bNum=${recordCriteria.reqPage }" class="btn btn-secondary" role="button" id="delete" aria-pressed="true">삭제하기</a>
         </td>
      </tr>
      <tr id="myLink_2"><!-- 수정하기일 경우 버튼, hidden상태여야함,,,,처음에는 -->
         <td colspan=2 align="right">
         <a href="#" class="btn btn-secondary" role="button" id="cModify" aria-pressed="true">수정완료</a>
         <a href="list.do?reqPage=${recordCriteria.reqPage }" class="btn btn-secondary" role="button" id="toList2" aria-pressed="true">목록으로</a>
         </td>
      </tr>
     </form>
</table>
<div id="myLink_3">
 <p class="h3" align="center">댓글</p>
 <table class="table" >
 	<form action="" name="frm_1" id="myfrm1">
      <tr>
         <th class="w-25 p-3">댓글창</th>
         <td scope="col">
            <textarea name="bContent"  class="form-control" id="mContent" rows="5" ></textarea>
         </td>
      </tr>
      </form>
      </table>
     </div> 
      

</div>
</body>
</html>