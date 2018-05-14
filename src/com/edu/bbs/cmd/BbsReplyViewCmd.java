package com.edu.bbs.cmd;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.edu.bbs.RecordCriteria;
import com.edu.bbs.dao.BbsDAO;
import com.edu.bbs.dao.BbsDAOImpl;
import com.edu.bbs.dto.BbsDTO;

public class BbsReplyViewCmd implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		
		int bNum = Integer.valueOf(request.getParameter("bNum"));
		String reqPage = request.getParameter("reqPage");
		
		RecordCriteria recordCriteria = new RecordCriteria(Integer.parseInt(reqPage));
		
		BbsDAO bbsdao = BbsDAOImpl.getInstance();
		BbsDTO bbsdto = bbsdao.replyView(bNum);
		
		request.setAttribute("replyView", bbsdto);
		request.setAttribute("recordCriteria", recordCriteria);
		
	}

}
