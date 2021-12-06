package FBoard.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import FBoard.Vo.FreeBoardVo;
import db.DBConn;

public class FreeBoardDao {
	
	private Connection conn;
	private PreparedStatement pstmt;
	
	

//밑으로 자유게시판 (임시)

public List<FreeBoardVo> getFreeBoardList(int startNum, int endNum){
	
	ResultSet rs = null;
	List<FreeBoardVo> FreeBoardList = new ArrayList<FreeBoardVo>();
	
	try {
		DBConn db = new DBConn();
		conn = db.getConnection();
		 String sql =" SELECT AA.FB_NUM, AA.FB_TITLE, M.MEM_NICK , AA.FB_DATE, AA.FB_CNT , (SELECT COUNT(*) OVER   FROM FB_LIKE FBL,FREE_BOARD FBA  WHERE FBA.FB_NUM = FBL.FB_NUM )AS LIKECNT "
		 		+ " FROM ( SELECT ROWNUM AS RNUM, Z.* FROM ( SELECT * from FREE_BOARD A  order by A.FB_NUM asc ) Z WHERE ROWNUM <= ? ) AA , MEMBER M "
		 		+ " WHERE RNUM >= ? "
		 		+ " AND M.MEM_NUM = AA.MEM_NUM "
		 		+ " order by FB_NUM asc "; 
				
		pstmt = conn.prepareStatement(sql);
		
		pstmt.setInt(1, startNum);
		pstmt.setInt(2, endNum);
		
		rs = pstmt.executeQuery();
		
		while( rs.next() ) {
			String num = rs.getString(1);	
			String title = rs.getString(2);	
			String nick = rs.getString(3);	
			String date = rs.getString(4);	
			String cnt = rs.getString(5);	
			String likecnt = rs.getString(6);	
			
			FreeBoardVo fbvo = new FreeBoardVo(num, title, nick, date, cnt, likecnt);
			
			FreeBoardList.add(fbvo);
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}finally {
		try {
			if(rs    != null )  rs.close();
			if(pstmt != null )  pstmt.close();
			if(conn  != null )  conn.close();
		} catch (SQLException e) {
		}
	}
	
	return FreeBoardList;
	
}

public int getCount(){
	ResultSet rs = null;
	int count = 0;
	String sql = "select count(*) from FREE_BOARD";
	try {
		DBConn db = new DBConn();
		conn = db.getConnection();
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		if(rs.next()){
			count = rs.getInt(1);
		}
	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		try {
			if(rs    != null )  rs.close();
			if(pstmt != null )  pstmt.close();
			if(conn  != null )  conn.close();
		} catch (SQLException e) {
		}
	}
	return count; // 총 레코드 수 리턴
}



}
