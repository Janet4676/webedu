package com.edu;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class MemberDAO {

	private static MemberDAO mdao = new MemberDAO();
	
	Connection conn;
	Statement stmt;
	PreparedStatement pstmt;
	ResultSet rs;

	public static MemberDAO getInstance() {
		return mdao;
	}
	
	private MemberDAO() {
	}

	// id 존재유무
	public SqlResult checkID(String id) {

		String sql = "select id from member where id = ?";
		SqlResult sqlresult = null;
		try {
			conn = DataBaseUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				sqlresult = SqlResult.MEM_EXIST;
			} else {
				sqlresult = SqlResult.MEM_NOEXIST;
			}

		} catch (SQLException e) {
			DataBaseUtil.printSQLException(e, this.getClass().getName()+"int checkID(String id)");
		} finally {
			DataBaseUtil.close(conn, pstmt, rs);
		}
		return sqlresult;
	}

	// 회원등록
	public SqlResult insertMember(MemDTO member) {
		SqlResult sqlresult = null;
		StringBuffer sql = new StringBuffer();
		sql.append("insert into member ").append("(id,passwd,name,birth,phone) ").append("values (?,?,?,?,?)");
		try {
			conn = DataBaseUtil.getConnection();
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPasswd());
			pstmt.setString(3, member.getName());
			pstmt.setString(4, member.getBirth());
			pstmt.setString(5, member.getPhone());

			pstmt.executeUpdate(); // executeUpdate : 업데이트한 row 수를 반환
			sqlresult = SqlResult.MEM_JOIN_SUCCESS;
			
		} catch (SQLException e) {
			DataBaseUtil.printSQLException(e, this.getClass().getName() + "int insertMember(MemberDTO member)");
		} finally {
			DataBaseUtil.close(conn, pstmt);
		}
		return sqlresult;
	}
	
	//회원 유무 체크
	public SqlResult memberCheck(String id, String passwd) {
		SqlResult sqlresult = null;
		StringBuffer sql = new StringBuffer();
		sql.append("select passwd from member where id = ?");
		
		try {
			conn = DataBaseUtil.getConnection();
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				if (rs.getString("passwd").equals(passwd) ) {
					// 로그인 성공
					sqlresult = SqlResult.MEM_LOGIN_SUCCESS;
				}else {
					// 비밀번호 불일치
					sqlresult = SqlResult.MEM_LOGIN_PW_NOT;
				}
			} else {
				// 회원이 아님
				sqlresult = SqlResult.MEM_LOGIN_NOT;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			DataBaseUtil.printSQLException(e, this.getClass().getName() + "SqlResult memCheck(String id, String passwd)");
		} finally {
			DataBaseUtil.close(conn, pstmt, rs);
		}
		return sqlresult;
	}
	
	// 회원정보 session에 올리기 용
	public MemDTO getMember(String id) {
		MemDTO mdto= null;
		StringBuffer sql = new StringBuffer();
		sql.append("select id, passwd, name, birth, phone From member where id = ?");
		
		try {
			conn = DataBaseUtil.getConnection();
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				mdto = new MemDTO();
				mdto.setId(rs.getString("id"));
				mdto.setPasswd(rs.getString("Passwd"));
				mdto.setName(rs.getString("Name"));
				mdto.setBirth(rs.getString("Birth"));
				mdto.setPhone(rs.getString("Phone"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			DataBaseUtil.printSQLException(e, this.getClass().getName() + "MemDTO getMember(String id)");
		} finally {
			DataBaseUtil.close(conn, pstmt, rs);
		}
		
		return mdto;
	}
	
	// 회원정보수정
	public int updateMember(MemDTO mdto) {
		int n = 0;
		StringBuffer sql = new StringBuffer();
		sql.append("update member set passwd =?, name =?, birth=?,phone =?,udate =sysdate where id=?");
		try {
			conn = DataBaseUtil.getConnection();
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, mdto.getPasswd());
			pstmt.setString(2, mdto.getName());
			pstmt.setString(3, mdto.getBirth());
			pstmt.setString(4, mdto.getPhone());
			pstmt.setString(5, mdto.getId());
			
			
			n = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			DataBaseUtil.printSQLException(e, this.getClass().getName() + "int updateMember(MemDTO mdto)");
		} finally {
			DataBaseUtil.close(conn, pstmt);
		}
		
		return n;
	}
	
	// 회원탈퇴
	public int deleteMember(String id) {
		int n = 0;
		StringBuffer sql = new StringBuffer();
		sql.append("delete from member where id=?");
		try {
			conn = DataBaseUtil.getConnection();
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, id);
			
			n = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			DataBaseUtil.printSQLException(e, this.getClass().getName() + "int deleteMember(String id)");
		} finally {
			DataBaseUtil.close(conn, pstmt);
		}
		return n;
	} 
	
	
	public int getCount() {
	    int count = 0;
	      String sql = "SELECT COUNT(*) FROM MEMBER";
	      try {
	         conn = DataBaseUtil.getConnection(); // 커넥션을 얻어옴
	         pstmt = conn.prepareStatement(sql);
	         rs = pstmt.executeQuery();
	         if(rs.next()){
	            count = rs.getInt(1);
	         }
	      } catch (SQLException e) {
	         DataBaseUtil.printSQLException(e, this.getClass().getName() + " : public int getCount()");
	      } finally {
	         DataBaseUtil.close(conn, pstmt, rs);
	      }
	      return count; // 총 레코드 수 리턴
	}
	/*
	// 총 회원 수
	public ArrayList<MemDTO> getAll() {
		ArrayList<MemDTO> MemberList = new ArrayList<MemDTO>();
		MemDTO mdto = null;
		StringBuffer sql = new StringBuffer();
		sql.append("select id,passwd,name,birth,phone,cdate,udate from member");
		
		try {
			conn = DataBaseUtil.getConnection();
			pstmt = conn.prepareStatement(sql.toString());
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				mdto = new MemDTO();
				mdto.setId(rs.getString("id"));
				mdto.setPasswd(rs.getString("Passwd"));
				mdto.setName(rs.getString("Name"));
				mdto.setBirth(rs.getString("Birth"));
				mdto.setPhone(rs.getString("Phone"));
				mdto.setCdate(rs.getString("cdate"));
				mdto.setUdate(rs.getString("Udate"));
				MemberList.add(mdto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DataBaseUtil.close(conn, pstmt, rs);
		}
		
		return MemberList;
	}
	*/
	
	
	public ArrayList<MemDTO> getAllPage(int startRow, int endRow) {
		ArrayList<MemDTO> MemberList = new ArrayList<MemDTO>();
		MemDTO mdto = null;
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT * FROM (SELECT ROWNUM RN, ID, PASSWD, NAME, BIRTH, PHONE, CDATE, UDATE FROM (SELECT * FROM MEMBER)) WHERE RN BETWEEN ? AND ?");
		
		try {
			conn = DataBaseUtil.getConnection();
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rs = pstmt.executeQuery();
			
//			if (rs.next()) {
				while(rs.next()) {
					mdto = new MemDTO();
					mdto.setId(rs.getString("id"));
					mdto.setPasswd(rs.getString("passwd"));
					mdto.setName(rs.getString("name"));
					mdto.setBirth(rs.getString("birth"));
					mdto.setPhone(rs.getString("phone"));
					mdto.setCdate(rs.getString("cdate"));
					mdto.setUdate(rs.getString("udate"));
					MemberList.add(mdto);
				}
			//}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DataBaseUtil.close(conn, pstmt, rs);
		}
		
		return MemberList;
	}

}
