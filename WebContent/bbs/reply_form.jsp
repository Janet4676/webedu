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

</head>
<body>
<div class="container">
<p class="h2" align="center">답글 내용보기</p>
<table class="table">
   <form action="reply.do" name="frm_1" id="myfrm1" method = "post">
   <input type="hidden" name="bNum" value="${replyView.bNum }" id="" />
   <input type="hidden" name="bGroup" value="${replyView.bGroup }" id="" />
   <input type="hidden" name="bStep" value="${replyView.bStep }" id="" />
   <input type="hidden" name="bIndent" value="${replyView.bIndent }" id="" />
   <input type="hidden" name="reqPage" value="${recordCriteria.reqPage }" id="" />
   
      <tr>
         <th class="w-25 p-3">제목</th>
         <td scope="col"> 
            <input type="text" name="bTitle"  class="form-control" id="mTitle" value="re ${replyView.bTitle }" >
         </td>
      </tr>
      <tr>
         <th scope="col">작성자</th>
         <td scope="col">
            <input type="text" name="bName"  class="form-control" id="" value="${replyView.bName }" >
         </td>
      </tr>
      <tr>
         <th class="w-25 p-3">글번호</th>
         <td scope="col"> 
            <input type="text" name="bNum" readonly="readonly" class="form-control" id="" value="${replyView.bNum}" >
         </td>
      </tr>
      <tr>
         <th class="w-25 p-3">조회수</th>
         <td scope="col"> 
            <input type="text" name="bHit" readonly="readonly" class="form-control" id="" value="${replyView.bHit }" >
         </td>
      </tr>
      <tr>
         <th class="w-25 p-3">작성일</th>
         <td scope="col"> 
            <input type="text" name="bUdate" readonly="readonly" class="form-control" id="" value="${replyView.bUdate }" >
         </td>
      </tr>
      <tr>
         <th class="w-25 p-3">내용</th>
         <td scope="col">
            <textarea name="bContent"  class="form-control" id="mContent" rows="5" > RE: ${replyView.bContent }
---------------------------------------            
</textarea>
         </td>
      </tr>
      
      <tr id="">
         <td colspan=2 align="right">
         <a href="list.do?reqPage=${recordCriteria.reqPage }" class="btn btn-secondary" role="button" id="toList" aria-pressed="true">목록으로</a>
         <input class="btn btn-secondary" type="submit"  value="답글등록">
         </td>
      </tr>

</form>
</table>
</div>
</body>
</html>