package com.edu;

public class CountBean {
	// 멤버 필드
	private int cntNumber;
	
	// 기본 생성자
	public CountBean() {
		System.out.println("CountBean 생성!");
	}
	
	public void setCount(int n) {
		cntNumber +=n;
	}
	
	public int getCount() {
		return cntNumber;
	}
}
