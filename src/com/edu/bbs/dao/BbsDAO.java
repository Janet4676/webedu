package com.edu.bbs.dao;

import java.util.ArrayList;

import com.edu.bbs.dto.BbsDTO;

public interface BbsDAO {

	// 글쓰기
	void write(BbsDTO bbsdto);

	//글목록 가져오기
	ArrayList<BbsDTO> list();

	//글목록 가져오기
	ArrayList<BbsDTO> PageList(int startRecord, int endRecord);

	//글 내용보기
	BbsDTO view(int bNum);

	void delete(int rnum);

	void modify(String bNum, String bTitle, String bContent);

	BbsDTO replyView(int bNum);

	void reply(BbsDTO bbsdto);

	int totalRec();

	ArrayList<BbsDTO> searchList(int startRec, int endRec, String option, String keyword);

	int searchTotalRec(String option, String keyword);

}