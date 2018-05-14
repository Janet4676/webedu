package com.edu.bbs.dao;

import java.util.ArrayList;

import com.edu.bbs.dto.BbsDTO;
import com.edu.bbs.dto.RBbsDTO;

public interface RBbsDAO {

	// 댓글쓰기
	void write(RBbsDTO bbsdto);

	//댓글목록 가져오기
	ArrayList<RBbsDTO> list(int startRecord, int endRecord);
	
	
	ArrayList<RBbsDTO> list(int bNum);

	//댓글목록 page 가져오기
	ArrayList<RBbsDTO> PageList(int startRecord, int endRecord);

	//댓글 내용보기
	BbsDTO view(int bNum);

	//댓글 삭제
	void delete(String rnum);

	//댓글 수정하기
	void modify(String rNum, String rContent);

	//대댓글 보기
	BbsDTO replyView(int bNum);

	void reply(RBbsDTO bbsdto);

	int totalRec();

	ArrayList<RBbsDTO> searchList(int startRec, int endRec, String option, String keyword);

	int searchTotalRec(String option, String keyword);

}