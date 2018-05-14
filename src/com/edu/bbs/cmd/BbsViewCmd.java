package com.edu.bbs.cmd;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.edu.bbs.RecordCriteria;
import com.edu.bbs.dao.BbsDAO;
import com.edu.bbs.dao.BbsDAOImpl;
import com.edu.bbs.dto.BbsDTO;

public class BbsViewCmd implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		int bNum = Integer.valueOf(request.getParameter("bNum"));
		String reqPage = request.getParameter("reqPage");
		
		RecordCriteria rc = new RecordCriteria(Integer.parseInt(reqPage));
		BbsDTO bbsdto = new BbsDTO();
		BbsDAO bbsdao = BbsDAOImpl.getInstance();
		bbsdto = bbsdao.view(bNum);
		
		System.out.println(bbsdto.getbName());
		
		request.setAttribute("view", bbsdto);
		request.setAttribute("recordCriteria", rc);

	}

}
