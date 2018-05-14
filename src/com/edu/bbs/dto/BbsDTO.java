package com.edu.bbs.dto;

import java.sql.Date;

public class BbsDTO {
	private int bNum;			// 게시글번호
	private String bTitle;	// 제목
	private String bId;		// 작성자ID
	private String bName;	// 작성자이름
	private Date bCdate;		// 작성일시
	private Date bUdate;		// 수정일시
	private int bHit;			// 조회수
	private String bContent;// 글내용
	private int bGroup;		// 답글그룹
	private int bStep;	// 답변글의 단계
	private int bIndent;	// 답변글 들여쓰기
	
	public BbsDTO() {
		
	}
	
	public BbsDTO(int bNum, String bTitle, String bId, String bName, Date bCdate, Date bUdate, int bHit, String bContent,
			int bGroup, int bStep, int bIndent) {
		super();
		this.bNum = bNum;
		this.bTitle = bTitle;
		this.bId = bId;
		this.bName = bName;
		this.bCdate = bCdate;
		this.bUdate = bUdate;
		this.bHit = bHit;
		this.bContent = bContent;
		this.bGroup = bGroup;
		this.bStep = bStep;
		this.bIndent = bIndent;
	}

	/**
	 * @return the bNum
	 */
	public int getbNum() {
		return bNum;
	}

	/**
	 * @param bNum the bNum to set
	 */
	public void setbNum(int bNum) {
		this.bNum = bNum;
	}

	/**
	 * @return the bTitle
	 */
	public String getbTitle() {
		return bTitle;
	}

	/**
	 * @param bTitle the bTitle to set
	 */
	public void setbTitle(String bTitle) {
		this.bTitle = bTitle;
	}

	/**
	 * @return the bId
	 */
	public String getbId() {
		return bId;
	}

	/**
	 * @param bId the bId to set
	 */
	public void setbId(String bId) {
		this.bId = bId;
	}

	/**
	 * @return the bName
	 */
	public String getbName() {
		return bName;
	}

	/**
	 * @param bName the bName to set
	 */
	public void setbName(String bName) {
		this.bName = bName;
	}

	/**
	 * @return the bCdate
	 */
	public Date getbCdate() {
		return bCdate;
	}

	/**
	 * @param bCdate the bCdate to set
	 */
	public void setbCdate(Date bCdate) {
		this.bCdate = bCdate;
	}

	/**
	 * @return the bUdate
	 */
	public Date getbUdate() {
		return bUdate;
	}

	/**
	 * @param bUdate the bUdate to set
	 */
	public void setbUdate(Date bUdate) {
		this.bUdate = bUdate;
	}

	/**
	 * @return the bHit
	 */
	public int getbHit() {
		return bHit;
	}

	/**
	 * @param bHit the bHit to set
	 */
	public void setbHit(int bHit) {
		this.bHit = bHit;
	}

	/**
	 * @return the bContent
	 */
	public String getbContent() {
		return bContent;
	}

	/**
	 * @param bContent the bContent to set
	 */
	public void setbContent(String bContent) {
		this.bContent = bContent;
	}

	/**
	 * @return the bGroup
	 */
	public int getbGroup() {
		return bGroup;
	}

	/**
	 * @param bGroup the bGroup to set
	 */
	public void setbGroup(int bGroup) {
		this.bGroup = bGroup;
	}

	/**
	 * @return the bStep
	 */
	public int getbStep() {
		return bStep;
	}

	/**
	 * @param bStep the bStep to set
	 */
	public void setbStep(int bStep) {
		this.bStep = bStep;
	}

	/**
	 * @return the bIndent
	 */
	public int getbIndent() {
		return bIndent;
	}

	/**
	 * @param bIndent the bIndent to set
	 */
	public void setbIndent(int bIndent) {
		this.bIndent = bIndent;
	}

	@Override
	public String toString() {
		return "BbsDTO [bNum=" + bNum + ", bTitle=" + bTitle + ", bId=" + bId + ", bName=" + bName + ", bCdate="
				+ bCdate + ", bUdate=" + bUdate + ", bHit=" + bHit + ", bContent=" + bContent + ", bGroup=" + bGroup
				+ ", bStep=" + bStep + ", bIndent=" + bIndent + "]";
	}
	
	
	
}
