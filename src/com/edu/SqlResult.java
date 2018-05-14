package com.edu;

public enum SqlResult {
	MEM_EXIST,					// 회원 존재
	MEM_NOEXIST,				// 회원 부재
	MEM_JOIN_SUCCESS,			//회원 가입 성공
	
	MEM_LOGIN_SUCCESS,		// 로그인 성공
	MEM_LOGIN_PW_NOT,			// 비밀번호 틀림
	MEM_LOGIN_NOT				// 로그인 실패

}
