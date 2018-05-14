package com.edu.bbs.cmd;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.edu.bbs.dao.RBbsDAO;
import com.edu.bbs.dao.RBbsDAOImpl;

public class RbbsModifyCmd implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {

		String rNum = request.getParameter("rNum");
		String rContent = request.getParameter("rContent");
		
		RBbsDAO rbbsdao = RBbsDAOImpl.getInstance();
		rbbsdao.modify(rNum, rContent);
		
	}

}
