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

public class BbsDAOImpl implements BbsDAO {
	private static BbsDAO bdao = new BbsDAOImpl();
	
	CallableStatement cst;
	Connection conn;
	Statement stmt;
	PreparedStatement pstmt;
	ResultSet rs;
	
	private BbsDAOImpl() {
		
	}
	
	public static BbsDAO getInstance() {
		return bdao;
	}
	
	// 글쓰기
	/* (non-Javadoc)
	 * @see com.edu.bbs.dao.BbsDAO#write(com.edu.bbs.dto.BbsDTO)
	 */
	@Override
	public void write(BbsDTO bbsdto) {
		int cnt = 0;
		StringBuffer sql = new StringBuffer();
		sql.append("insert into bbs (bnum, btitle, bname, bhit, bcontent, bgroup, bstep, bindent ) ")
		.append("values(bbsnum_seq.nextval,?,?,?,?,bbsnum_seq.currval,0,0)");
		
		try {
			conn = DataBaseUtil.getConnection();
			pstmt = conn.prepareStatement(sql.toString());
			
			pstmt.setString(1, bbsdto.getbTitle());
			pstmt.setString(2, bbsdto.getbName());
			pstmt.setInt(3, bbsdto.getbHit());
			pstmt.setString(4, bbsdto.getbContent());
			
			System.out.println("title:"+bbsdto.getbTitle() + " name:"+bbsdto.getbName() +
					" hit:"+bbsdto.getbHit() +" content:"+bbsdto.getbContent());
			
			cnt = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			DataBaseUtil.printSQLException(e, this.getClass().getName()+"void write(BbsDTO bbsdto)");
		} finally {
			DataBaseUtil.close(conn, pstmt);
		}
	}
	
	//글목록 가져오기
	/* (non-Javadoc)
	 * @see com.edu.bbs.dao.BbsDAO#list()
	 */
	@Override
	public ArrayList<BbsDTO> list() {
		ArrayList<BbsDTO> alist = new ArrayList<>();
		BbsDTO bbsdto = null;
		StringBuffer sql = new StringBuffer();
		sql.append("select bnum, btitle, bname, bhit, bcontent, bcdate, bgroup, bstep, bindent ")
		.append("from bbs ")
		.append("order by bgroup desc, bstep asc, bnum desc");
		
		try {
			conn = DataBaseUtil.getConnection();
			pstmt = conn.prepareStatement(sql.toString());
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
					bbsdto = new BbsDTO();
					bbsdto.setbNum(rs.getInt("bnum"));
					bbsdto.setbTitle(rs.getString("btitle"));
					bbsdto.setbName(rs.getString("bname"));
					bbsdto.setbHit(rs.getInt("bhit"));
					bbsdto.setbContent(rs.getString("bcontent"));
					bbsdto.setbCdate(rs.getDate("bcdate"));
					bbsdto.setbGroup(rs.getInt("bgroup"));
					bbsdto.setbStep(rs.getInt("bStep"));
					bbsdto.setbIndent(rs.getInt("bindent"));
					alist.add(bbsdto);
			}
			
		} catch (SQLException e) {
			DataBaseUtil.printSQLException(e, this.getClass().getName()+"ArrayList<BbsDTO> list()");
		} finally {
			DataBaseUtil.close(conn, pstmt,rs);
		}
		
		return alist;
	}
	
	//글목록 가져오기
	/* (non-Javadoc)
	 * @see com.edu.bbs.dao.BbsDAO#PageList(int, int)
	 */
	@Override
	public ArrayList<BbsDTO> PageList(int startRecord, int endRecord) {
		ArrayList<BbsDTO> alist = new ArrayList<>();
		BbsDTO bbsdto = null;
		StringBuffer sql = new StringBuffer();
		sql.append("select  t2.* ")
		.append("from (select row_number() over (ORDER BY bgroup desc, bstep asc) as num, t1.* FROM bbs t1) t2 ")
		.append("where num between ? and ?");
		
		try {
			conn = DataBaseUtil.getConnection();
			pstmt = conn.prepareStatement(sql.toString());
			
			pstmt.setInt(1, startRecord);
			pstmt.setInt(2, endRecord);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
					bbsdto = new BbsDTO();
					bbsdto.setbNum(rs.getInt("bnum"));
					bbsdto.setbTitle(rs.getString("btitle"));
					bbsdto.setbName(rs.getString("bname"));
					bbsdto.setbHit(rs.getInt("bhit"));
					bbsdto.setbContent(rs.getString("bcontent"));
					bbsdto.setbCdate(rs.getDate("bcdate"));
					bbsdto.setbGroup(rs.getInt("bgroup"));
					bbsdto.setbStep(rs.getInt("bStep"));
					bbsdto.setbIndent(rs.getInt("bindent"));
					alist.add(bbsdto);
			}
			
		} catch (SQLException e) {
			DataBaseUtil.printSQLException(e, this.getClass().getName()+"ArrayList<BbsDTO> list()");
		} finally {
			DataBaseUtil.close(conn, pstmt,rs);
		}
		
		return alist;
	}
//글 내용보기
	/* (non-Javadoc)
	 * @see com.edu.bbs.dao.BbsDAO#view(int)
	 */
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
	
	/* (non-Javadoc)
	 * @see com.edu.bbs.dao.BbsDAO#delete(int)
	 */
	@Override
	public void delete(int bnum) {
		StringBuffer sql = new StringBuffer();
		sql.append("delete from bbs where bnum = ? ");
		
		try {
			conn = DataBaseUtil.getConnection();
			pstmt = conn.prepareStatement(sql.toString());
			
			pstmt.setInt(1, bnum);

			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			DataBaseUtil.printSQLException(e, this.getClass().getName()+"void delete(int bnum)");
		} finally {
			DataBaseUtil.close(conn, pstmt);
		}
		
	}

	/* (non-Javadoc)
	 * @see com.edu.bbs.dao.BbsDAO#modify(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public void modify(String bNum, String bTitle, String bContent) {
		int cnt = 0;
		StringBuffer sql = new StringBuffer();
		sql.append("update bbs set btitle = ?, bcontent=? ")
		.append("where bnum=?");
		
		
		try {
			conn = DataBaseUtil.getConnection();
			pstmt = conn.prepareStatement(sql.toString());
			
			pstmt.setString(1, bTitle);
			pstmt.setString(2, bContent);
			pstmt.setInt(3, Integer.parseInt(bNum));
			
			cnt = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			DataBaseUtil.printSQLException(e, this.getClass().getName()+"void modify(String bNum, String bTitle, String bContent)");
		} finally {
			DataBaseUtil.close(conn, pstmt);
		}
		
	}

	/* (non-Javadoc)
	 * @see com.edu.bbs.dao.BbsDAO#replyView(int)
	 */
	@Override
	public BbsDTO replyView(int bNum) {
	      BbsDTO bbsdto=null;
	      String sql = "select bnum, btitle, bname, bhit, bUdate,  bContent, bgroup, bstep, bindent from bbs where bnum = ?";

	      try {
	         conn = DataBaseUtil.getConnection();
	         pstmt = conn.prepareStatement(sql.toString());

	         pstmt.setInt(1, bNum);
	         rs = pstmt.executeQuery();
	         
	         if(rs.next()) {
	            bbsdto = new BbsDTO();
	            bbsdto.setbNum(rs.getInt("bNum"));
	            bbsdto.setbTitle(rs.getString("bTitle"));
	            bbsdto.setbName(rs.getString("bName"));
	            bbsdto.setbHit(rs.getInt("bHit"));
	            bbsdto.setbUdate(rs.getDate("bUdate"));
	            bbsdto.setbContent(rs.getString("bContent"));
	            bbsdto.setbGroup(rs.getInt("bGroup"));
	            bbsdto.setbStep(rs.getInt("bStep"));
	            bbsdto.setbIndent(rs.getInt("bIndent"));
	         }
	         
	      } catch (SQLException e) {
	         DataBaseUtil.printSQLException(e, this.getClass().getName() + "BbsDTO replyView(int bNum)");
	      } finally {
	         DataBaseUtil.close(conn, pstmt, rs);
	      }
	      return bbsdto;
	   }

	/* (non-Javadoc)
	 * @see com.edu.bbs.dao.BbsDAO#reply(com.edu.bbs.dto.BbsDTO)
	 */
	@Override
	public void reply(BbsDTO bbsdto) {
		
		//이전 댓글 step 업데이트
			updateStep(bbsdto.getbGroup(),bbsdto.getbStep());
	
		      StringBuffer sql = new StringBuffer();
		      sql.append("insert into bbs (bnum, btitle, bname, bHit, bcontent, bgroup, bstep, bindent) ")
		      .append("values(bbsnum_seq.nextval,?,?,?,?,?,?,?)");
		      
		      try {
		         conn = DataBaseUtil.getConnection();
		         pstmt = conn.prepareStatement(sql.toString());
		         
		         pstmt.setString(1, bbsdto.getbTitle());
		         pstmt.setString(2, bbsdto.getbName());
		         pstmt.setInt(3, bbsdto.getbHit());
		         pstmt.setString(4, bbsdto.getbContent());
		         pstmt.setInt(5, bbsdto.getbGroup());
		         pstmt.setInt(6, bbsdto.getbStep()+1);
		         pstmt.setInt(7, bbsdto.getbIndent()+1);
		         
		         pstmt.executeUpdate();
		         
		      } catch (SQLException e) {
		         DataBaseUtil.printSQLException(e, this.getClass().getName()+"void reply(BbsDTO bbsdto)");
		      } finally {
		         DataBaseUtil.close(conn, pstmt);
		      }
	}

	private void updateStep(int bGroup, int bStep) {
		int cnt = 0;
		StringBuffer sql = new StringBuffer();
		sql.append("update bbs set bstep = bstep+1 where bgroup =? and bstep > ?");

		try {
			conn = DataBaseUtil.getConnection();
			pstmt = conn.prepareStatement(sql.toString());
			
			pstmt.setInt(1, bGroup);
			pstmt.setInt(2, bStep);
			cnt = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			DataBaseUtil.printSQLException(e, this.getClass().getName()+"void UpdateStep(int bGroup, int bStep)");
		} finally {
			DataBaseUtil.close(conn, pstmt);
		}
		
	}
	
	/* (non-Javadoc)
	 * @see com.edu.bbs.dao.BbsDAO#totalRec()
	 */
	@Override
	public int totalRec() {
		
		int totalRec = 0;
		StringBuffer sql = new StringBuffer();
		sql.append("select count(*) totalRec from bbs");
		
		
		try {
			conn = DataBaseUtil.getConnection();
			pstmt = conn.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			while(rs.next()) {
				totalRec = rs.getInt("totalRec");
			}
		} catch (SQLException e) {
			DataBaseUtil.printSQLException(e, this.getClass().getName()+": totalRec()");
		} finally {
			DataBaseUtil.close(conn, pstmt, rs);
		}
		return totalRec;
	}
	
	/* (non-Javadoc)
	 * @see com.edu.bbs.dao.BbsDAO#searchList(int, int, java.lang.String, java.lang.String)
	 */
	@Override
	public ArrayList<BbsDTO> searchList(int startRec, int endRec, String option, String keyword) {
		ArrayList<BbsDTO> alist = new ArrayList<>();
		BbsDTO bbsdto = null;
		StringBuffer sql = new StringBuffer();
		
		
		sql.append("select  t2.* ")
		.append("from (select row_number() over (ORDER BY bgroup desc, bstep asc) as num, t1.* FROM bbs t1 where bnum>0 and ");
		
		switch(option) {
		case "작성자" : 
			sql.append("bname like '%'||?||'%') t2 where num between ? and ? ");
			break;
		case "제목" :
			sql.append("btitle like '%'||?||'%') t2 where num between ? and ? ");
			break;
		case "내용" :
			sql.append("bcontent like '%'||?||'%') t2 where num between ? and ? ");
			break;
		case "제목 내용" :
			sql.append("btitle like '%'||?||'%' or bcontent like '%'||?||'%') t2 where num between ? and ? ");
			break;
		}	
		try {
			conn = DataBaseUtil.getConnection();
			pstmt = conn.prepareStatement(sql.toString());
		if(option.equals("제목 내용")) {
			pstmt.setString(1, keyword);
			pstmt.setString(2, keyword);
			pstmt.setInt(3, startRec);
			pstmt.setInt(4, endRec);
		}else {
			pstmt.setString(1, keyword);
			pstmt.setInt(2, startRec);
			pstmt.setInt(3, endRec);
		}
			rs = pstmt.executeQuery();
		
		while(rs.next()) {
				bbsdto = new BbsDTO();
				bbsdto.setbNum(rs.getInt("bnum"));
				bbsdto.setbTitle(rs.getString("btitle"));
				bbsdto.setbName(rs.getString("bname"));
				bbsdto.setbHit(rs.getInt("bhit"));
				bbsdto.setbContent(rs.getString("bcontent"));
				bbsdto.setbCdate(rs.getDate("bcdate"));
				bbsdto.setbGroup(rs.getInt("bgroup"));
				bbsdto.setbStep(rs.getInt("bStep"));
				bbsdto.setbIndent(rs.getInt("bindent"));
				alist.add(bbsdto);
		}
		}catch(SQLException e){
			DataBaseUtil.printSQLException(e, this.getClass().getName()+"searchList(int startRec, int endRec, String option, String keyword)");
		}finally {
			DataBaseUtil.close(conn, pstmt,rs);
		}
		return alist;
	}
	
	/* (non-Javadoc)
	 * @see com.edu.bbs.dao.BbsDAO#searchTotalRec(java.lang.String, java.lang.String)
	 */
	@Override
	public int searchTotalRec(String option, String keyword) {
		
		int totalRec = 0;
		StringBuffer sql = new StringBuffer();
		conn = DataBaseUtil.getConnection();
		
		sql.append("select  count(*)")
		.append("FROM bbs where bnum>0 and ");
		
		switch(option) {
		case "작성자" : 
			sql.append("bname like '%'||?||'%' ");
			break;
		case "제목" :
			sql.append("btitle like '%'||?||'%' ");
			break;
		case "내용" :
			sql.append("bcontent like '%'||?||'%' ");
			break;
		case "제목 내용" :
			sql.append("btitle like '%'||?||'%' or bcontent like '%'||?||'%'");
			break;
		}	
		try {
		if(option.equals("제목 내용")) {

			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, keyword);
			pstmt.setString(2, keyword);
		}else {
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, keyword);
		}
			rs = pstmt.executeQuery();
		
		if(rs.next()) {
			totalRec = rs.getInt(1);
			
		}
		}catch(SQLException e){
			DataBaseUtil.printSQLException(e, this.getClass().getName()+"int searchTotalRec(String option, String keyword)");
		}finally {
			DataBaseUtil.close(conn, pstmt,rs);
		}
		return totalRec;
		
	}
}
