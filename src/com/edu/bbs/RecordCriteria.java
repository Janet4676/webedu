package com.edu.bbs;

public class RecordCriteria {
	private int reqPage; //요청페이지
	private int numPerPage; // 한페이지에 보여줄 레코드 수 
	
	public RecordCriteria() {}
	
	public RecordCriteria(int reqPage, int numPerPage) {
		this.reqPage = reqPage;
		this.numPerPage = numPerPage;
	}
	
	public RecordCriteria(int reqPage) {
		this.reqPage = reqPage;
		this.numPerPage=10;
	}

	public int getReqPage() {
		return reqPage;
	}

	public void setReqPage(int reqPage) {
		if(reqPage <= 0) {
			this.reqPage = 1;
			return;
		}
		this.reqPage = reqPage;
	}

	public int getNumPerPage() {
		return numPerPage;
	}

	public void setNumPerPage(int numPerPage) {
		//한페이지에 보여줄 목록수는 최소 1~100
		if(numPerPage <=0 || numPerPage > 100) {
			this.numPerPage = 10;
			return;
		}
		this.numPerPage = numPerPage;
	}
	
	//시작 레코드 계산= ((요청페이지-1) * 한 페이지당 보여줄 레코드 수 ) +1
	public int getStartRecord() {
		return ((this.reqPage - 1) * this.numPerPage) + 1;
	}
	
	// 종료 레코드 계산 = 시작레코드 + 한페이지에 보여줄 레코드 수
	//					요청페이지 * 한페이지에 보여줄 레코드 수
	public int getEndRecord() {
	// return this.getStartRecord() + this. numPerPage -1 ;	
		return this.reqPage * this.numPerPage;
	}
	
	@Override
	public String toString() {
		return "PageCriteria [reqPage =" + reqPage + ", numPerPage" + numPerPage + "]" ;
		
	}
	

}
