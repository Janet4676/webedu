package com.edu.bbs.cmd;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.edu.bbs.dao.RBbsDAO;
import com.edu.bbs.dao.RBbsDAOImpl;
import com.edu.bbs.dto.RBbsDTO;

public class RbbsWriteCmd implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		RBbsDTO rbbsdto = new RBbsDTO();
		System.out.println(request.getParameter("bNum"));
		System.out.println(request.getParameter("rName"));
		System.out.println(request.getParameter("rContent"));
		rbbsdto.setbNum(Integer.parseInt(request.getParameter("bNum")));
		rbbsdto.setrName(request.getParameter("rName"));
		rbbsdto.setrContent(request.getParameter("rContent"));
	
		
		RBbsDAO rbbsdao = RBbsDAOImpl.getInstance();
		rbbsdao.write(rbbsdto);
	}

}
