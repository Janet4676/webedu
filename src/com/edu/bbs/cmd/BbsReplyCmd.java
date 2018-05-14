package com.edu.bbs.cmd;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.edu.bbs.dao.BbsDAO;
import com.edu.bbs.dao.BbsDAOImpl;
import com.edu.bbs.dto.BbsDTO;

public class BbsReplyCmd implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		BbsDTO bbsdto = new BbsDTO();
		bbsdto.setbNum(Integer.parseInt(request.getParameter("bNum")));
		bbsdto.setbName(request.getParameter("bName"));
		bbsdto.setbTitle(request.getParameter("bTitle"));
		bbsdto.setbContent(request.getParameter("bContent"));
		bbsdto.setbGroup(Integer.parseInt(request.getParameter("bGroup")));
		bbsdto.setbStep(Integer.parseInt(request.getParameter("bStep")));
		bbsdto.setbIndent(Integer.parseInt(request.getParameter("bIndent")));
		
		BbsDAO bbsdao = BbsDAOImpl.getInstance();
		bbsdao.reply(bbsdto);
	}

}
