package com.edu.bbs.cmd;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.edu.bbs.FindCriteria;
import com.edu.bbs.PageCriteria;
import com.edu.bbs.RecordCriteria;
import com.edu.bbs.dao.BbsDAO;
import com.edu.bbs.dao.BbsDAOImpl;
import com.edu.bbs.dto.BbsDTO;

public class BbsListCmd implements BCommand {

   @Override
   public void execute(HttpServletRequest request, HttpServletResponse response) {

	  int reqPage = 0;
	try {
		reqPage = Integer.valueOf(request.getParameter("reqPage"));
	} catch (NumberFormatException e) {
		reqPage = 1;
	}
	  
      
      // 검색유무 조건에 따라 분기
      String option = request.getParameter("option");
      String keyword = request.getParameter("keyword");
      RecordCriteria rc;
      BbsDAO bbsdao = BbsDAOImpl.getInstance();
      int totalRec = bbsdao.totalRec();
      PageCriteria pc; 
      
      ArrayList<BbsDTO> alist;
      
      if(keyword == null || keyword.trim().equals("")) {
    	  rc= new RecordCriteria(reqPage);
    	  pc= new PageCriteria(rc,totalRec);
    	  
    	  
   	   	alist = bbsdao.PageList(rc.getStartRecord(), rc.getEndRecord());
	  
	   request.setAttribute("recordCriteria", rc);
	   request.setAttribute("pageCriteria", pc);
	   
      } else {
    	  
      rc = new FindCriteria(reqPage,option, keyword);
      
	   
	   alist = bbsdao.searchList(rc.getStartRecord(), rc.getEndRecord(), ((FindCriteria) rc).getOption(),((FindCriteria) rc).getKeyword());
	   totalRec = bbsdao.searchTotalRec(((FindCriteria) rc).getOption(),((FindCriteria) rc).getKeyword());
	   
      pc= new PageCriteria(rc,totalRec);
      request.setAttribute("findCriteria", (FindCriteria)rc);
      request.setAttribute("pageCriteria", pc);
      }
      request.setAttribute("list", alist);
      
      
   }

}
