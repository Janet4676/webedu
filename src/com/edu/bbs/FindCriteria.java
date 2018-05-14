package com.edu.bbs;

public class FindCriteria extends RecordCriteria {
	private String option; //검색타입
	private String keyword; //키워드
	
	
	public FindCriteria() {
		
	}
	
	public FindCriteria(int reqPage) {
		super(reqPage);
	}
	
	public FindCriteria(int reqPage, String option, String keyword) {
		
		super(reqPage);
		this.option = option;
		this.keyword = keyword;
	}


	public String getOption() {
		return option;
	}

	public void setOption(String option) {
		this.option = option;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	

	
	
	@Override
	public String toString() {
		return "FindCriteria [option=" + option + ", keyword=" + keyword + "]";
	}

}
