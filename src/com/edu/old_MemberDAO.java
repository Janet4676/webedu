package com.edu;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class old_MemberDAO {
	private DataSource ds;

	old_MemberDAO() {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/Oracle11g");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	public String getName() {
		Connection dbcon = null;
		Statement stmt = null;
		ResultSet rs = null;
		String name = null;
		
		String sql = "select * from member where name= '관리자'";
		
		try {
			dbcon = ds.getConnection();
			stmt = dbcon.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				name = rs.getString("name");
				System.out.println(name);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) rs.close();
				if (stmt != null) stmt.close();
				if(dbcon != null) dbcon.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return name;
	}
}
