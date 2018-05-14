package com.edu.bbs.dto;

import java.util.Date;

public class RBbsDTO {
	
	private int rNum;
	private int bNum;
	private String rName;
	private Date rCdate;
	private Date rUdate;
	private String rContent;
	private int rgood;
	private int rhate;
	private int rGroup;
	private int rstep;
	private int rIndent;
	
	public RBbsDTO() {}

	public RBbsDTO(int rbNum, int bNum, String rName, Date rCdate, Date rUdate, String rContent, int rgood, int rhate,
			int rGroup, int rstep, int rIndent) {
		super();
		this.rNum = rbNum;
		this.bNum = bNum;
		this.rName = rName;
		this.rCdate = rCdate;
		this.rUdate = rUdate;
		this.rContent = rContent;
		this.rgood = rgood;
		this.rhate = rhate;
		this.rGroup = rGroup;
		this.rstep = rstep;
		this.rIndent = rIndent;
	}

	public int getrNum() {
		return rNum;
	}

	public void setrNum(int rNum) {
		this.rNum = rNum;
	}

	public int getbNum() {
		return bNum;
	}

	public void setbNum(int bNum) {
		this.bNum = bNum;
	}

	

	public String getrName() {
		return rName;
	}

	public void setrName(String rName) {
		this.rName = rName;
	}

	public Date getrCdate() {
		return rCdate;
	}

	public void setrCdate(Date rCdate) {
		this.rCdate = rCdate;
	}

	public Date getrUdate() {
		return rUdate;
	}

	public void setrUdate(Date rUdate) {
		this.rUdate = rUdate;
	}

	public String getrContent() {
		return rContent;
	}

	public void setrContent(String rContent) {
		this.rContent = rContent;
	}

	public int getRgood() {
		return rgood;
	}

	public void setRgood(int rgood) {
		this.rgood = rgood;
	}

	public int getRhate() {
		return rhate;
	}

	public void setRhate(int rhate) {
		this.rhate = rhate;
	}

	public int getrGroup() {
		return rGroup;
	}

	public void setrGroup(int rGroup) {
		this.rGroup = rGroup;
	}

	public int getRstep() {
		return rstep;
	}

	public void setRstep(int rstep) {
		this.rstep = rstep;
	}

	public int getrIndent() {
		return rIndent;
	}

	public void setrIndent(int rIndent) {
		this.rIndent = rIndent;
	}

	@Override
	public String toString() {
		return "RBbsDTO [rNum=" + rNum + ", bNum=" + bNum + ", rName=" + rName + ", rCdate=" + rCdate + ", rUdate="
				+ rUdate + ", rContent=" + rContent + ", rgood=" + rgood + ", rhate=" + rhate + ", rGroup=" + rGroup
				+ ", rstep=" + rstep + ", rIndent=" + rIndent + "]";
	}
	

}
