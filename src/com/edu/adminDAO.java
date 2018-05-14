package com.edu;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class adminDAO {
	
	private static adminDAO adao = new adminDAO();
	
	Connection conn;
	Statement stmt;
	PreparedStatement pstmt;
	ResultSet rs;
	
	private adminDAO() {
	}
	
	public static adminDAO getInstance() {
		return adao;
	}
	
	//관리자 로그인 체크
	public AdminSqlResult adminCheck(String id, String passwd) {
			AdminSqlResult sqlresult = null;
			StringBuffer sql = new StringBuffer();
			sql.append("select passwd from admin where id = ?");
			
			try {
				conn = DataBaseUtil.getConnection();
				pstmt = conn.prepareStatement(sql.toString());
				pstmt.setString(1, id);
				
				rs = pstmt.executeQuery();
				
				if(rs.next()) {
					if (rs.getString("passwd").equals(passwd) ) {
						// 로그인 성공
						sqlresult = AdminSqlResult.ADMIN_LOGIN_SUCCESS;
					}else {
						// 비밀번호 불일치
						sqlresult = AdminSqlResult.ADMIN_LOGIN_PW_NOT;
					}
				} else {
					// 회원이 아님
					sqlresult = AdminSqlResult.ADMIN_LOGIN_NOT;
				}
			} catch (SQLException e) {
				e.printStackTrace();
				DataBaseUtil.printSQLException(e, this.getClass().getName() + "SqlResult adminCheck(String id, String passwd)");
			} finally {
				DataBaseUtil.close(conn, pstmt, rs);
			}
			return sqlresult;
		}
		
	// 정보 얻어오기
	public adminDTO getAdmin(String id) {
			adminDTO mdto= null;
			StringBuffer sql = new StringBuffer();
			sql.append("select id, passwd, name, phone, email, grade From admin where id = ?");
			
			try {
				conn = DataBaseUtil.getConnection();
				pstmt = conn.prepareStatement(sql.toString());
				pstmt.setString(1, id);
				
				rs = pstmt.executeQuery();
				
				if(rs.next()) {
					mdto = new adminDTO();
					mdto.setId(rs.getString("id"));
					mdto.setPasswd(rs.getString("Passwd"));
					mdto.setName(rs.getString("Name"));
					mdto.setPhone(rs.getString("Phone"));
					mdto.setEmail(rs.getString("email"));
					mdto.setGrade(rs.getString("grade"));
				}
			} catch (SQLException e) {
				e.printStackTrace();
				DataBaseUtil.printSQLException(e, this.getClass().getName() + "adminDTO getAdmin(String id)");
			} finally {
				DataBaseUtil.close(conn, pstmt, rs);
			}
			
			return mdto;
		}
}
