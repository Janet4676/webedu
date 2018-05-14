package com.edu.bbs.cmd;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.edu.bbs.dao.BbsDAO;
import com.edu.bbs.dao.RBbsDAO;
import com.edu.bbs.dao.RBbsDAOImpl;
import com.edu.bbs.dto.RBbsDTO;

public class RBbsListCmd implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html);charSet=utf-8");
		
		int bNum = Integer.valueOf(request.getParameter("bNum"));
		RBbsDAO rbbsdao = RBbsDAOImpl.getInstance();
		StringBuffer str = new StringBuffer();
		ArrayList<RBbsDTO> alist = new ArrayList();
		
		
		
		alist = rbbsdao.list(bNum);
		
		str.append("{\"result\" : [");
	      int i = 0;
	      for (RBbsDTO rbbsdto : alist) {
	         i += 1;
	         str.append("{\"RNUM\":\"" + rbbsdto.getrNum() + "\",");
	         str.append("\"BNUM\":\"" + rbbsdto.getbNum() + "\",");
	         str.append("\"RCDATE\":\"" + rbbsdto.getrCdate() + "\",");
	         str.append("\"RCONTENT\":\"" + rbbsdto.getrContent() + "\",");
	         str.append("\"RNAME\":\"" + rbbsdto.getrName() + "\",");
	         str.append("\"RGOOD\":\"" + rbbsdto.getRgood() + "\",");

	         if (alist.size() == i) {
	            str.append("\"RBAD\":\"" + rbbsdto.getRhate() + "\"}");
	         } else {
	            str.append("\"RBAD\":\"" + rbbsdto.getRhate() + "\"},");
	         }
	      }
	      str.append("]}");
		response.getWriter().write(str.toString());

	}

}
