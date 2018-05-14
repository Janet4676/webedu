package com.edu.bbs;

public class PageCriteria {
	private final int pageNumPerPage=10; //현재페이지에 보여줄 페이지수
	private int reqPage; // 현재 페이지


	private int startPage; // 현재페이지에 시작페이지
	private int endPage; // 현재페이지에 종료페이지
	
	private int totalRec; //전체 레코드 수
	private int finalEndPage; // 최종페이지
	
	private boolean prev; //이전페이지
	private boolean next; // 다음페이지
	
	private RecordCriteria recordCriteria;
	
	private PageCriteria(RecordCriteria recordCriteria) {
		this.recordCriteria = recordCriteria;
	}
	
	
	public PageCriteria(RecordCriteria recordCriteria, int totalRec) {
		this(recordCriteria);
		this.totalRec = totalRec;
		init();
	}
	
	private void init() {
		//1) endPage 계산
		this.endPage = (int) ((Math.ceil(this.recordCriteria.getReqPage()/(double)this.pageNumPerPage))*pageNumPerPage);
		
		//2) startPage 계산
		this.startPage = (this.endPage-this.pageNumPerPage) + 1;
		
		//3) finalEndPage 계산
		this.finalEndPage = (int)(Math.ceil(this.totalRec/(double)this.recordCriteria.getNumPerPage()));
		if(endPage > finalEndPage) {
			endPage = finalEndPage;
		}
		
		//4) prev 계산
		this.prev = this.startPage == 1 ? false : true;
		
		//5) next 계산
		this.next =
				(this.endPage * this.recordCriteria.getNumPerPage()> this.totalRec) ? false : true;
		
	}
	
	
	public int getReqPage() {
		return reqPage;
	}


	public void setReqPage(int reqPage) {
		this.reqPage = reqPage;
	}


	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public int getTotalRec() {
		return totalRec;
	}

	public void setTotalRec(int totalRec) {
		this.totalRec = totalRec;
	}

	public int getFinalEndPage() {
		return finalEndPage;
	}

	public void setFinalEndPage(int finalEndPage) {
		this.finalEndPage = finalEndPage;
	}

	public boolean isPrev() {
		return prev;
	}

	public void setPrev(boolean prev) {
		this.prev = prev;
	}

	public boolean isNext() {
		return next;
	}

	public void setNext(boolean next) {
		this.next = next;
	}

	public RecordCriteria getRecordCriteria() {
		return recordCriteria;
	}

	public void setRecordCriteria(RecordCriteria recordCriteria) {
		this.recordCriteria = recordCriteria;
	}
	
	public String getmakeURL(int reqPage) {
		StringBuffer str = new StringBuffer();
		/*if(recordCriteria.getReqPage() != 0) {
			str.append("reqPage="+recordCriteria.getReqPage());
		}*/
		
		str.append("reqPage="+reqPage);
		
		if(recordCriteria instanceof FindCriteria) { 
			//instanceof -- 형변환이 가능한지 확인해주는 연산자 앞(recordCriteria 부모객체) 뒤(FindCriteria)자식객체, 앞을 기준으로 자식클래스 확인
		if(((FindCriteria) recordCriteria).getOption() != null || ((FindCriteria) recordCriteria).getOption().trim().equals("")) {
			str.append("&option="+((FindCriteria) recordCriteria).getOption());
		}
		if(((FindCriteria) recordCriteria).getKeyword() != null || ((FindCriteria) recordCriteria).getKeyword().trim().equals("")) {
			str.append("&keyword="+((FindCriteria) recordCriteria).getKeyword());
		}}
		return str.toString();
	}

	public int getPageNumPerPage() {
		return pageNumPerPage;
	}

	
	
	
	
	

}
