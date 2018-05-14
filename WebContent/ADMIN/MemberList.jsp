<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "com.edu.*" %>
<%@ page import ="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
	html,body {
		text-align: center;
	}
	table,td {
		border: 1px solid black;
		border-collapse:collapse;
	}
	#table_top {
		background-color: pink;
	}
</style>
</head>
<body>
	<%
		request.setCharacterEncoding("utf-8");
		int pageSize = 10;	
	
		String pageNum = request.getParameter("pageNum");
		if (pageNum == null) {   // 클릭한게 없으면 1번 페이지
		      pageNum = "1";
		}
		
		// 연산을 하기 위한 pageNum 형변환 / 현재 페이지
		int currentPage = Integer.parseInt(pageNum);
		
		int startRow = (currentPage - 1) * pageSize  + 1; // 해당 페이지에서 시작할 레코드
		int endRow = currentPage * pageSize ; // 마지막 레코드
		
		int count = 0;
		MemberDAO mdao = MemberDAO.getInstance();
		count = mdao.getCount();   // 데이터 베이스에 저장된 총 갯수
		
		ArrayList<MemDTO> pagedto = null;
		if(count > 0){
		   // getList()메서드 호출 / 해당 레코드 반환
		   pagedto = mdao.getAllPage(startRow, endRow);
		}
	%>
	<table>
		<tr id = "table_top">
			<td></td>
			<td>ID</td>
			<td>PASSWD</td>
			<td>NAME</td>
			<td>BIRTH</td>
			<td>PHONE</td>
			<td>CDATE</td>
			<td>UDATE</td>
		</tr>
			<%
			
			if(count > 0) {
				for(int i =0; i<pagedto.size(); i++) {
					int number = i+1+(currentPage-1)*10;
			%>
				<tr>
					<td><%=number %></td>
					<td>
						<%= pagedto.get(i).getId() %>
					</td>
					<td>
						<%= pagedto.get(i).getPasswd() %>
					</td>
					<td>
						<%= pagedto.get(i).getName() %>
					</td>
					<td>
						<%= pagedto.get(i).getBirth() %>
					</td>
					<td>
						<%= pagedto.get(i).getPhone() %>
					</td>
					<td>
						<%= pagedto.get(i).getCdate() %>
					</td>
					<td>
						<%=pagedto.get(i).getUdate() %>
					</td>
				</tr>
		<%
				}
			}
		%>
		<tr>
			<td colspan="8" align="center">
				  <%   // 페이징  처리
                  if(count > 0){
                     // 총 페이지의 수
                     int pageCount = count / pageSize + (count%pageSize == 0 ? 0 : 1);
                     // 한 페이지에 보여줄 페이지 블럭(링크) 수
                     int pageBlock = 10;
                     // 한 페이지에 보여줄 시작 및 끝 번호(예 : 1, 2, 3 ~ 10 / 11, 12, 13 ~ 20)
                     int startPage = ((currentPage-1)/pageBlock)*pageBlock+1;
                     int endPage = startPage + pageBlock - 1;
                     
                     // 마지막 페이지가 총 페이지 수 보다 크면 endPage를 pageCount로 할당
                     if(endPage > pageCount){
                        endPage = pageCount;
                     }
                     
                     if(startPage > pageBlock){ // 페이지 블록수보다 startPage가 클경우 이전 링크 생성
               %>
                        <a href="MemberList.jsp?pageNum=<%=startPage - 10%>">[이전]</a>   
               <%         
                     }
                     
                     for(int i=startPage; i <= endPage; i++){ // 페이지 블록 번호
                        if(i == currentPage){ // 현재 페이지에는 링크를 설정하지 않음
               %>
                           [<%=i %>]
               <%                           
                        }else{ // 현재 페이지가 아닌 경우 링크 설정
               %>
                           <a href="MemberList.jsp?pageNum=<%=i%>">[<%=i %>]</a>
               <%   
                        }
                     } // for end
                     
                     if(endPage < pageCount){ // 현재 블록의 마지막 페이지보다 페이지 전체 블록수가 클경우 다음 링크 생성
               %>
                        <a href="MemberList.jsp?pageNum=<%=startPage + 10 %>">[다음]</a>
               <%         
                     }
                  }
               %>

		</tr>
	</table>
	<br>
</body>
</html>