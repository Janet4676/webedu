<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="/webedu/public/bootstrap/dist/css/bootstrap.css">


<script src="/webedu/public/jquery/jquery-3.3.1.js"></script>
<script src="/webedu/public/bootstrap/dist/js/bootstrap.js"></script>
<script>
$(function(){
	var str;
	$("#search").click(function(){
		self.location="list.do?reqPage=1"+"&option="+$("select[name=option]").val()+
				"&keyword="+$("input[name=keyword]").val();
		console.log(self.location.toString());
				
	});
});

	</script>
<title>Insert title here</title>
</head>
<body>
<div class="container" >
  <p class="h2" align="center"> 글내용보기 </p>         
  <table class="table table-hover">
  <thead class="thead-dark">
    <tr>
      <th scope="col">#</th>
      <th scope="col">제목</th>
      <th scope="col">작성자</th>
      <th scope="col">작성일</th>
      <th scope="col">조회수</th>
    </tr>
  </thead>
  <tbody>
  
  	<c:forEach items="${list }" var="dto">
    <tr>
		<th scope="row">${dto.bNum }</th>
		<td>
		<c:forEach begin="1" end="${dto.bIndent }">ㄴ</c:forEach>
		<a class="text-dark" href="view.do?bNum=${dto.bNum }&${pageCriteria.getmakeURL(pageCriteria.recordCriteria.reqPage) }">${dto.bTitle }</a></td>
		<td>${dto.bName }</td>
		<td>${dto.bCdate }</td>
		<td>${dto.bHit }</td>
    </tr>
    </c:forEach>
  </tbody>
</table>

			<nav aria-label="Page navigatio example">
				<ul class="pagination pagination justify-content-center" >
					<c:if test="${pageCriteria.prev }">
						<li class="page-item" >
						<a class="page-link" href="list.do?${pageCriteria.getmakeURL(pageCriteria.startPage-1) }"> Previous</a>
						</li>
					</c:if>
					<c:forEach begin="${pageCriteria.startPage }" end="${pageCriteria.endPage }" var="pageNum">
						<c:if test="${pageCriteria.recordCriteria.reqPage == pageNum }">
							<li class="page-item active">
							<a class="page-link" href="#">${pageNum}</a>
							</li>
						</c:if>
						<c:if test="${pageCriteria.recordCriteria.reqPage != pageNum }">
							<li class="page-item"><a class="page-link"
								href="list.do?${pageCriteria.getmakeURL(pageNum) }">${pageNum}</a></li>
						</c:if>

					</c:forEach>
					<c:if test="${pageCriteria.next }">
						<li class="page-item"><a class="page-link"
							href="list.do?${pageCriteria.getmakeURL(pageCriteria.endPage+1)}">Next</a></li>
					</c:if>
				</ul>
			</nav>


			<div align = "right">
    		<a href="/webedu/bbs/write_view.do?pageReq=${pageCriteria.recordCriteria.reqPage }" target="iframe_content" >글쓰기</a>
			
      <div class="col-sm-12 pull-center well" >
        <form class="form-inline" action="#" method="POST">
                        <select class="form-control" name="option">
                            <option value="작성자"
                            <c:out value="${findCriteria.option == '작성자' ? 'selected' : '' }"/>>작성자</option>
                            <option value="제목"
                            <c:out value="${findCriteria.option == '제목' ? 'selected' : '' }"/>>제목</option>
                            <option value ="내용"
                            <c:out value="${findCriteria.option == '내용' ? 'selected' : '' }"/>>내용</option>
                            <option value ="제목+내용"
                            <c:out value="${findCriteria.option == '제목 내용' ? 'selected' : '' }"/>>제목+내용</option>
                        </select>
                    
                    
                       <div class="input-group custom-search-form" >
                            <input type="text" class="form-control" placeholder="Search..." value="${findCriteria.keyword }" name="keyword">
                                <span class="input-group-btn">
                                    <button class="btn btn-default" type="button" id="search">
                                      <i>search</i>
                                    </button>
                                </span>
                        </div>
        </form>
    </div>
    	
	</div>

</div>

</body>


<!------ Include the above in your HEAD tag ---------->

		


</html>