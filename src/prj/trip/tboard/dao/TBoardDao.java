package prj.trip.tboard.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import prj.trip.db.DBConn;
import prj.trip.comment.vo.CommentVo;
import prj.trip.tboard.vo.TBoardVo;




// close()를 이용해 Connection을 끊는 걸로
public class TBoardDao {
	private DBConn db;
	private Connection conn;
	private PreparedStatement pstmt;
	private CallableStatement cstmt;
	private ResultSet rs;
	
	
	
	// 미완성 (테이블 불안정)
	public List<TBoardVo> getTripList() {
		ArrayList<TBoardVo> tripList = new ArrayList<TBoardVo>();
		String sql  = " SELECT * FROM TBOARD";
		try {
			db      = new DBConn();
			conn    = db.getConnection();
			pstmt   = conn.prepareStatement(sql);
			rs      = pstmt.executeQuery();
			while( rs.next() ) {
				int boardNum = rs.getInt("BOARD_NUM");
				int readcnt  = rs.getInt("READCOUNT");
				TBoardVo tVo=new TBoardVo();
				tripList.add(tVo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
		
		return tripList;
	}
	
	//게시물 불러오기
	public TBoardVo getTBoard(int boardNum) {
		TBoardVo board = new TBoardVo();
		String sql = "SELECT TRIP_BOARD_NUM, TRIP_BOARD_TITLE,";
		sql		  += " TRIP_BOARD_CONT, TRIP_BOARD_CNT, TRIP_BOARD_DATE,";
		sql	      += " TRIP_BOARD_LIKE, TRIP_BOARD_ADDR, TRIP_BOARD_IMG1,";
		sql		  += " TRIP_BOARD_IMG2, TRIP_BOARD_IMG3, TRIP_BOARD_IMG4,";
		sql		  += " TRIP_BOARD_VIEDO1, TRIP_BOARD_VIDEO2, MEM_NICK";
		sql		  += " FROM TRIP_BOARD T JOIN MEMBER M";
		sql 	  += " ON T.MEM_NUM = M.MEM_NUM";
		sql		  += " WHERE TRIP_BOARD_NUM = ?";
		try {
			db     = new DBConn();
			conn   = db.getConnection();
			pstmt  = conn.prepareStatement(sql);
			pstmt.setInt(1, boardNum);
			rs = pstmt.executeQuery();
			if( rs.next() ) {
			   board.setTripNum(rs.getInt("TRIP_BOARD_NUM"));
			   board.setTripTitle(rs.getString("TRIP_BOARD_TITLE"));  
			   board.setTripCont(rs.getString("TRIP_BOARD_CONT"));  
			   board.setReadCnt(rs.getInt("TRIP_BOARD_CNT"));
			   board.setWrite_date(rs.getString("TRIP_BOARD_DATE"));
			   board.setLike(rs.getInt("TRIP_BOARD_LIKE"));
			   board.setTripAddr(rs.getString("TRIP_BOARD_ADDR"));
			   String[] imgs = new String[4];
			   for (int i = 8; i <= 11; i++) {
				   if(rs.getString(i)!=null) {
					   imgs[i-8] = rs.getString(i);
				   }
			   }
			   board.setImg(imgs);
			   String[] videos = new String[2];
			   for (int i = 12; i <= 13; i++) {
				if(rs.getString(i)!=null) {
					videos[i-12] = rs.getString(i);
				}
			  }  
			}
			ArrayList<CommentVo> cmtList = getcmtList(boardNum);
			if(cmtList!=null)
				board.setCmtlist( cmtList );
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
		return board;
	}
	
	// 댓글목록 가져오기
	private ArrayList<CommentVo> getcmtList(int boardNum) {
		ArrayList<CommentVo> cmtList = new ArrayList<CommentVo>();
		String sql = "SELECT TRIP_COMMENT_NUM, TRIP_COMMENT_CONT,";
		sql		  += " TRIP_COMMENT_DATE, M.MEM_NICK";
		sql		  += " FROM MEMBER M JOIN TRIP_BOARD T";
		sql		  += " ON M.MEM_NUM = T.MEN_NUM";
		sql		  += " JOIN TRIP_COMMENT R ON T.TRIP_BOARD_NUM = R.TRIP_BOARD_NUM";
		sql		  += " WHERE T.TRIP_BOARD_NUM = ?";
		sql		  += " AND R.MEM_NUM = M.MEM_NUM";
		
		try {
			db    = new DBConn();
			conn  = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardNum);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int 	cmtNum = rs.getInt("TRIP_COMMENT_NUM");
				String cmtCont = rs.getString("TRIP_COMMENT_CONT");
				String cmtDate = rs.getString("TRIP_COMMENT_DATE");
				String cmtNick = rs.getString("MEM_NICK");
				CommentVo cmtVo = new CommentVo();
				cmtVo.setCmtCont(cmtCont);
				cmtVo.setCmtNum(cmtNum);
				cmtVo.setCmtWriter(cmtNick);
				cmtVo.setCmtdate(cmtDate);
				cmtList.add(cmtVo);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
		
		return cmtList;
	}

	//DB CLOSE
	public void close() {
		try {
			if(rs!=null)rs.close();
			if(pstmt!=null)pstmt.close();
			if(cstmt!=null)cstmt.close();
			if(conn!=null)conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}



}
