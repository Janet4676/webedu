package com.edu.bbs.cmd;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.edu.bbs.RecordCriteria;
import com.edu.bbs.dao.BbsDAO;
import com.edu.bbs.dao.BbsDAOImpl;

public class BbsModifyCmd implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		String bNum = request.getParameter("bNum");
		String bTitle = request.getParameter("bTitle");
		String bContent = request.getParameter("bContent");
		String reqPage = request.getParameter("reqPage");
		
		BbsDAO bbsdao = BbsDAOImpl.getInstance();
		RecordCriteria rc = new RecordCriteria(Integer.parseInt(reqPage));
		
		
		bbsdao.modify(bNum,bTitle,bContent);
		request.setAttribute("recordCriteria", rc);
	}

}
