package com.edu.bbs.cmd;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.edu.bbs.dao.BbsDAO;
import com.edu.bbs.dao.BbsDAOImpl;
import com.edu.bbs.dto.BbsDTO;

public class BbsDeleteCmd implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		int bNum = Integer.valueOf(request.getParameter("bNum"));
		BbsDAO bbsdao = BbsDAOImpl.getInstance();
		bbsdao.delete(bNum);
		
	}

}
