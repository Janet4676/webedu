package com.edu;

public class MemberDAO_Main {

	public static void main(String[] args) {
		old_MemberDAO dao = new old_MemberDAO();
		String name = dao.getName();
		System.out.println(name);
	}

}
