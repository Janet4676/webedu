package com.edu.bbs.cmd;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.edu.bbs.dao.RBbsDAO;
import com.edu.bbs.dao.RBbsDAOImpl;

public class RBbsDeleteCmd implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {

		String rNum = request.getParameter("rNum");
		
		RBbsDAO rbbsdao = RBbsDAOImpl.getInstance();
		rbbsdao.delete(rNum);

	}

}
