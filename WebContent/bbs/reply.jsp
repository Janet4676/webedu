<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
   href="/webedu/public/bootstrap/dist/css/bootstrap.css">
<script src="/webedu/public/jquery/jquery-3.3.1.js"></script>
<script src="/webedu/public/bootstrap/dist/js/bootstrap.js"></script>
<title>댓글</title>
<style>
	#modifyDiv{
	width:400px; height:200px;
	background-color:gray;
	position:absolute;
	top:20%;left:40%;
	padding:20px;
	z-index:10;
	}
</style>
<script>
   $(function() {
	   //댓글 수정양식 숨기기
	   $("#modifyDiv").hide();
	   //댓글목록 가져오기
	   replyList();
	   var bNum = 3;
	   //댓글 목록처리
	   $("#reply").on("click",".reList button",function(){
		   
		  var li = $(this).parent();
		  console.log(li);
		  var rNum = li.attr("data-rNum");
		  console.log(rNum);
		  var reContent = li.text();
		  
		  $(".title-dialog").html(rNum);
		  $("#reContent").val(reContent); 
		  $("#modifyDiv").show("slow");
	   });
	   
	   //댓글 수정
	   $("#reModifyBtn").on("click",function(){
		   var rNum = $(".title-dialog").html();
		   var rContent = $("#reContent").val();
		   $.ajax({
			   type:'POST',
			   url:"/webedu/rbbs/modify",
			   dataType:"text",
			   data:{
				   rNum : rNum,
				   rContent : rContent
			   },
			   success:function(result){
				   alert("댓글 수정 성공");
				   $("#modifyDiv").hide();
				   replyList();
			   },
			   error:function(e){
				   console.log("실패"+e);
			   }
		   })
	   });
	   
	   //댓글 삭제
	   $("#reDelBtn").on("click",function(){
		   var rNum = $(".title-dialog").html();
		   alert("*"+rNum);
		   $.ajax({
			   type:'POST',
			   url:"/webedu/rbbs/delete",
			   dataType:"text",
			   data:{
				   rNum : rNum,
			   },
			   success:function(result){
				   alert("댓글 삭제 성공");
				   replyList();
			   },
			   error:function(e){
				   console.log("실패"+e);
			   }
		   })
	   });
	   
	   
	   
	   //댓글수정  닫기
	   $("#closeBtn").click(function(){
		   alert("*");
		   $("#modifyDiv").hide();
	   });
	   
	   //댓글 작성 클릭시 수행로직
	   $("#replyBtn").click(function(){
		   var writer = $("#writer").val();
		   var replyContent = $("#replyContent").val();
		   
		   $.ajax({
			   type:"POST",
			   url:"/webedu/rbbs/write",
			   dataType:"text",
			   data:{
				   bNum : bNum,
				   rName : writer,
				   rContent : replyContent
			   },
		   		success:function(){
		   			
		   			replyList();
		   		},
			   error:function(e){
				   console.log("실패"+e)
			   }
		   });
	   });
	   
   });
	   

//댓글목록 가져오기	   
	   function replyList(){
      var bNum = 3;
      var str = "";
      $.ajax({
         type : "GET",
         url : "/webedu/rbbs/list?bNum=" + bNum,
         dataType : "json",
         success : function(data) {
            console.log(data);
            console.log(data.result);
            $.each(data.result, function(idx,rec){
            	console.log(rec);
            	console.log(rec.RNUM);
            	//html에 사용자 정의 속성 입력하기 [data-'지정속성'] 
            	str += "<li data-rNum='"+rec.RNUM+"' class='reList' >" 
            		+ rec.RCDATE + "|"
            		+ rec.RCONTENT + "|"
            		+ rec.RNAME +"|"
            		+ rec.RGOOD +"|"
            		+ rec.RBAD +"|"
            		+"<button>수정</button>"
            		+ "</li>";
            		
            });
            
            $("#reply").html(str);
            
         },
         error : function(error) {
            console.log("실패"+error);       
         }
      });
}
 
</script>

</head>
<body>
<div id="modifyDiv">
	<span class="title-dialog"></span>번 댓글
	<div>
		<textarea id="reContent" cols="30" rows="3"></textarea>
	</div>
	<div>
		<button id="reReplyBtn">댓글</button>
		<button id="reModifyBtn">수정</button>
		<button id="reDelBtn">삭제</button>
		<button id="closeBtn">닫기</button>
	</div>
</div>
작성자 : <input type= "text" id ="writer"/><br>
댓글 : <textarea name="" id="replyContent" cols="30" rows="3"></textarea><br>
<button id="replyBtn">댓글작성</button>
   <h4>댓글리스트</h4>
   <ul id="reply">
   </ul>

</body>
</html>