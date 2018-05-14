package com.edu.bbs;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.edu.bbs.cmd.BCommand;
import com.edu.bbs.cmd.BbsDeleteCmd;
import com.edu.bbs.cmd.BbsListCmd;
import com.edu.bbs.cmd.BbsModifyCmd;
import com.edu.bbs.cmd.BbsReplyCmd;
import com.edu.bbs.cmd.BbsReplyViewCmd;
import com.edu.bbs.cmd.BbsViewCmd;
import com.edu.bbs.cmd.BbsWriteCmd;

/**
 * Servlet implementation class FrontController
 */
@WebServlet("*.do")
// @WebServlet(value="*.do") , 기본엘리먼트니까 위처럼 써도 되고 ..이것도가능..
public class FrontController extends HttpServlet {
   private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FrontController() {
        super();
        // TODO Auto-generated constructor stub
    }

   /**
    * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
    */
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      System.out.println("doGet 호출");
      actionDo(request, response);
   }

   /**
    * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
    */
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      System.out.println("doPost 호출");
      actionDo(request, response);
   }

   private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      System.out.println("actionDo 호출");
      
      request.setCharacterEncoding("UTF-8");
      BCommand command = null;
      String viewPage = null; //view 이동경로
      
      String uri = request.getRequestURI();
      String conPath = request.getContextPath();
      String cmd = uri.substring(conPath.length());
      
      System.out.println(uri);
      System.out.println(conPath);
      System.out.println(cmd);
      
      switch (cmd) {
         // 글쓰기 이동
      case "/bbs/write_view.do":
          viewPage = "/bbs/write_form.jsp";
         break;
         
      // 글쓰기 등록
      case "/bbs/write.do":
         // 글쓰기명령을 실제로 수행하는 command
         command = new BbsWriteCmd();
         command.execute(request, response);
         viewPage = "/bbs/list.do";   // 게시판 목록 가져오기로 이동(내부적으로)
         break;
      
      case "/bbs/list.do":
         // 게시판글목록을 뿌려주는 command
         command = new BbsListCmd();
         command.execute(request, response);
          viewPage = "/bbs/list.jsp"; // 게시판 목록으로 이동
         break;
         
      case "/bbs/view.do":
         // 글내용 뿌려주는 command
         command = new BbsViewCmd();
         command.execute(request, response);
          viewPage = "/bbs/view.jsp"; // 게시판 목록으로 이동
         break;
         
      case "/bbs/modify.do":
         command = new BbsModifyCmd();
         command.execute(request, response);
         viewPage = "/bbs/view.do";
         break;
         
      case "/bbs/delete.do":
         command = new BbsDeleteCmd();
         command.execute(request, response);
         viewPage = "/bbs/list.do";
         break;
/*      case "/bbs/pageNav.do":
         command = new BbsPagenavCmd();
         command.execute(request, response);
         viewPage = "/bbs/view.jsp";
         break;*/
         
         //답글작성양식으로 이동
      case "/bbs/replyView.do":
         command = new BbsReplyViewCmd();
         command.execute(request, response);
         viewPage = "/bbs/replyForm.jsp";
         break;
         
      case "/bbs/reply.do":
         command = new BbsReplyCmd();
         command.execute(request, response);
         viewPage = "/bbs/list.do";
         break;


      default:
         break;
      }
/*      요청디스패치 방식(RequestDispatcher) 
      Server 또는 JSP에서 요청을 받은 후 다른 컴포넌트로 요청을 위임할 수 있다.
      위임할때 요청객체 (request)를 동일하게 전달할 수 있다.*/
      RequestDispatcher dispat = request.getRequestDispatcher(viewPage);
      dispat.forward(request, response);
   }
}