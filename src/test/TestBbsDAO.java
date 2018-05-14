package test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import com.edu.bbs.PageCriteria;
import com.edu.bbs.RecordCriteria;
import com.edu.bbs.dao.BbsDAO;
import com.edu.bbs.dao.BbsDAOImpl;
import com.edu.bbs.dao.RBbsDAO;
import com.edu.bbs.dao.RBbsDAOImpl;
import com.edu.bbs.dto.BbsDTO;
import com.edu.bbs.dto.RBbsDTO;

class TestBbsDAO {

/*	@Test
	void test() {
		RecordCriteria pc = new RecordCriteria(1,10);
		
		BbsDAO bbsdao = BbsDAO.getInstance();
		ArrayList<BbsDTO> alist = bbsdao.PageList(pc.getStartRecord(), pc.getEndRecord());
		for(BbsDTO bbsdto: alist) {
			System.out.println(bbsdto);
		}
	}*/
		
/*		@Test
		void test2() {
			
			BbsDAO bbsdao = BbsDAO.getInstance();
			int totalRec = bbsdao.totalRec();
			
			RecordCriteria rc = new RecordCriteria(157,10);
			
			PageCriteria pagecri = new PageCriteria(rc,totalRec);
			
			System.out.println("totlaRec : "+ totalRec);
			System.out.println("startPage : "+pagecri.getStartPage());
			System.out.println("endPage : " + pagecri.getEndPage());
			System.out.println("finalendPage : " + pagecri.getFinalEndPage());
			System.out.println("prev : " + pagecri.isPrev());
			System.out.println("next : " + pagecri.isNext());
		}*/
		
		
/*	@Test
	void test3() {
		
		BbsDAO bbsdao = BbsDAOImpl.getInstance();
		ArrayList<BbsDTO> alist = bbsdao.searchList(1,10,"제목+내용", "re");
		for(BbsDTO bbsdto: alist) {
			System.out.println(bbsdto);
		}
	}*/
	
	
/*	@Test
	void test4() {
		
		BbsDAO bbsdao = BbsDAO.getInstance();
		int count = bbsdao.searchTotalRec("제목+내용", "re");
			System.out.println(count);
		}*/
	
/*	@Test
	void test5() {
		
		RBbsDAO rbbsdao = RBbsDAOImpl.getInstance();
		RBbsDTO rbbsdto = new RBbsDTO();
		rbbsdto.setbNum(3);
		rbbsdto.setrName("Janet");
		rbbsdto.setrContent("까대기");
		rbbsdao.write(rbbsdto);
		
		System.out.println(rbbsdto.toString());
	}*/
	
/*	@Test
	void test6() {
		
		RBbsDAO rbbsdao = RBbsDAOImpl.getInstance();
		ArrayList<RBbsDTO> alist = rbbsdao.list(0,10);
		for(RBbsDTO rbbsdto: alist) {
			System.out.println(rbbsdto);
		}
	}*/
	
	@Test
	void modify() {
		
		RBbsDAO rbbsdao = RBbsDAOImpl.getInstance();
		int bnum=3;
		rbbsdao.modify("4", "내년에 다시 예비군 가요");
		ArrayList<RBbsDTO> alist = rbbsdao.list(3);
		for(RBbsDTO rbbsdto: alist) {
			System.out.println(rbbsdto);
		}
		}
	}
	
	


