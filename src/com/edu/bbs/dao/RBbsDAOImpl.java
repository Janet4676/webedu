package com.edu.bbs.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.edu.DataBaseUtil;
import com.edu.bbs.dto.BbsDTO;
import com.edu.bbs.dto.RBbsDTO;

public class RBbsDAOImpl implements RBbsDAO {
	
private static RBbsDAO rdao = new RBbsDAOImpl();
	
	CallableStatement cst;
	Connection conn;
	Statement stmt;
	PreparedStatement pstmt;
	ResultSet rs;

	private int startRecord;
	
	private RBbsDAOImpl() {
		
	}
	
	public static RBbsDAO getInstance() {
		return rdao;
	}

	@Override
	public void write(RBbsDTO rbbsdto) {
		int cnt = 0;
		StringBuffer sql = new StringBuffer();
		sql.append("insert into replybbs (rnum, bnum, rname, rcontent, rgroup, rstep ) ")
		.append("values(rbbsnum_seq.nextval,?,?,?,rbbsnum_seq.currval,0)");
		
		try {
			conn = DataBaseUtil.getConnection();
			pstmt = conn.prepareStatement(sql.toString());
			
			pstmt.setInt(1, rbbsdto.getbNum());
			pstmt.setString(2, rbbsdto.getrName());
			pstmt.setString(3, rbbsdto.getrContent());
			
			cnt = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			DataBaseUtil.printSQLException(e, this.getClass().getName()+"write(RBbsDTO rbbsdto)");
		} finally {
			DataBaseUtil.close(conn, pstmt);
		}

	}
	

	@Override
	public ArrayList<RBbsDTO> list(int startRecord, int endRecord) {
		ArrayList<RBbsDTO> alist = new ArrayList<>();
		RBbsDTO rbbsdto = null;
		StringBuffer sql = new StringBuffer();
		sql.append("select  t2.* ")
		.append("from (select row_number() over (ORDER BY rgroup desc, rstep asc) as num, t1.* FROM replybbs t1) t2 ")
		.append("where num between ? and ?");
		
		try {
			conn = DataBaseUtil.getConnection();
			pstmt = conn.prepareStatement(sql.toString());
			
			pstmt.setInt(1, startRecord);
			pstmt.setInt(2, endRecord);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
					rbbsdto = new RBbsDTO();
					rbbsdto.setrNum(rs.getInt("rnum"));
					rbbsdto.setbNum(rs.getInt("bnum"));
					rbbsdto.setrName(rs.getString("rname"));
					rbbsdto.setrContent(rs.getString("rcontent"));
					rbbsdto.setrCdate(rs.getDate("rcdate"));
					rbbsdto.setrUdate(rs.getDate("rUdate"));
					rbbsdto.setrGroup(rs.getInt("rgroup"));
					rbbsdto.setRstep(rs.getInt("rStep"));
					rbbsdto.setrIndent(rs.getInt("rindent"));
					alist.add(rbbsdto);
			}
			
		} catch (SQLException e) {
			DataBaseUtil.printSQLException(e, this.getClass().getName()+"ArrayList<RBbsDTO> list()");
		} finally {
			DataBaseUtil.close(conn, pstmt,rs);
		}
		
		return alist;
	}
	

	@Override
	public ArrayList<RBbsDTO> PageList(int startRecord, int endRecord) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BbsDTO view(int bNum) {
		BbsDTO bbsdto = new BbsDTO();
		String sql = "{call Clist_callbbs(?,?,?,?,?,?)}";
		
		try {
			conn = DataBaseUtil.getConnection();
			cst = conn.prepareCall(sql);
			
			cst.setInt(1, bNum);
			cst.setString(2, "");
			cst.setString(3, "");
			cst.setDate(4, null);
			cst.setInt(5, 0);
			cst.setString(6, "");
			
			cst.registerOutParameter(2, java.sql.Types.VARCHAR);
			cst.registerOutParameter(3, java.sql.Types.VARCHAR);
			cst.registerOutParameter(4, java.sql.Types.DATE);
			cst.registerOutParameter(5, java.sql.Types.INTEGER);
			cst.registerOutParameter(6, java.sql.Types.VARCHAR);
			
			cst.executeQuery();
			
			
			bbsdto.setbNum(bNum);
			bbsdto.setbTitle(cst.getNString(2));
			bbsdto.setbName(cst.getNString(3));
			bbsdto.setbUdate(cst.getDate(4));
			bbsdto.setbHit(cst.getInt(5));
			bbsdto.setbContent(cst.getNString(6));
			
			
		}catch (SQLException e) {
			DataBaseUtil.printSQLException(e, this.getClass().getName()+"BbsDTO view(int bNum)");
		} finally {
			DataBaseUtil.close(conn, pstmt);
			if (cst != null) {
				try {
					cst.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		return bbsdto;
	}

	@Override
	public void delete(String rnum) {
		StringBuffer sql = new StringBuffer();
		sql.append("delete from replybbs where rnum = ? ");
		
		try {
			conn = DataBaseUtil.getConnection();
			pstmt = conn.prepareStatement(sql.toString());
			
			pstmt.setInt(1, Integer.parseInt(rnum));

			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			DataBaseUtil.printSQLException(e, this.getClass().getName()+"void delete(int rnum)");
		} finally {
			DataBaseUtil.close(conn, pstmt);
		}

	}

	@Override
	public void modify(String rNum, String rContent) {
		int cnt = 0;
		StringBuffer sql = new StringBuffer();
		sql.append("update replybbs set rcontent=? ")
		.append("where rnum=?");
		
		
		try {
			conn = DataBaseUtil.getConnection();
			pstmt = conn.prepareStatement(sql.toString());
			
			pstmt.setString(1, rContent);
			pstmt.setInt(2, Integer.parseInt(rNum));
			
			cnt = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			DataBaseUtil.printSQLException(e, this.getClass().getName()+"void modify(String rNum, String rContent)");
		} finally {
			DataBaseUtil.close(conn, pstmt);
		}
	}

	@Override
	public BbsDTO replyView(int bNum) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void reply(RBbsDTO bbsdto) {
		// TODO Auto-generated method stub

	}

	@Override
	public int totalRec() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<RBbsDTO> searchList(int startRec, int endRec, String option, String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int searchTotalRec(String option, String keyword) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<RBbsDTO> list(int bnum) {
		ArrayList<RBbsDTO> alist = new ArrayList<>();
		RBbsDTO rbbsdto = null;
		StringBuffer sql = new StringBuffer();
		sql.append("select  t2.* ")
		.append("from (select row_number() over (ORDER BY rgroup desc, rstep asc) as num, t1.* FROM replybbs t1) t2 ")
		.append("where bnum = ? ");
		
		try {
			conn = DataBaseUtil.getConnection();
			pstmt = conn.prepareStatement(sql.toString());
			
			pstmt.setInt(1, bnum);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
					rbbsdto = new RBbsDTO();
					rbbsdto.setrNum(rs.getInt("rnum"));
					rbbsdto.setbNum(rs.getInt("bnum"));
					rbbsdto.setrName(rs.getString("rname"));
					rbbsdto.setrContent(rs.getString("rcontent"));
					rbbsdto.setrCdate(rs.getDate("rcdate"));
					rbbsdto.setrUdate(rs.getDate("rUdate"));
					rbbsdto.setrGroup(rs.getInt("rgroup"));
					rbbsdto.setRstep(rs.getInt("rStep"));
					rbbsdto.setrIndent(rs.getInt("rindent"));
					alist.add(rbbsdto);
			}
			
		} catch (SQLException e) {
			DataBaseUtil.printSQLException(e, this.getClass().getName()+"ArrayList<RBbsDTO> list()");
		} finally {
			DataBaseUtil.close(conn, pstmt,rs);
		}
		
		return alist;
	}

}
