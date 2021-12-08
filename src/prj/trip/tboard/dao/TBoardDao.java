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
	
	

	//게시물 불러오기(전면 수정 필요)
	public TBoardVo getTBoard(int boardNum) {
		TBoardVo board = new TBoardVo();
		
		
		return board;
	}
	
	// 댓글목록 가져오기(전면 수정 필요)
	private ArrayList<CommentVo> getcmtList(int boardNum) {
		ArrayList<CommentVo> cmtList = new ArrayList<CommentVo>();
		
		
		return cmtList;
	}

	//여행지 추천 게시글 삽입
	public int insertTBoard(int memNum, String title, String addr, String bcontbox, ArrayList<String> filenames) {
		int aftcnt = 0;
		
		String sql = "INSERT INTO TRIP_BOARD(TB_NUM, TB_TITLE, TB_ADDR, TB_CONT, TB_IMG1, TB_IMG2, TB_IMG3, TB_IMG4, MEM_NUM)";
		sql		  += " VALUES ((SELECT NVL(MAX(TB_NUM),0)+1 FROM TRIP_BOARD), ?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			db    = new DBConn();
			conn  = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, title);
			pstmt.setString(2, addr);
			pstmt.setString(3, bcontbox);
			pstmt.setString(4, filenames.get(1));
			pstmt.setString(5, filenames.get(0));
			pstmt.setString(6, filenames.get(3));
			pstmt.setString(7, filenames.get(2));
			pstmt.setInt(8, memNum);
			aftcnt = pstmt.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			close();
		}
		return aftcnt;
		
	}

	
	
	// 페이징 겸 게시판 목록 가져오기
	public List<TBoardVo> getPagingData(int currentPage,int dpp) {
		ArrayList<TBoardVo> boardList = new ArrayList<>();
		String sql =  "SELECT *  ";
		sql       +=  " FROM (SELECT TB.TB_NUM, TB_TITLE, TB_CNT, TB_DATE, TB_ADDR,";
		sql		  +=  " TB_IMG1, MEM_NICK, COUNT(L.TB_NUM),";
		sql	      +=  " ROW_NUMBER() OVER(ORDER BY TB.TB_NUM DESC NULLS LAST) RN";           
		sql       +=  " FROM TRIP_BOARD TB JOIN MEMBER M ON TB.MEM_NUM = M.MEM_NUM";
		sql       +=  " LEFT JOIN TB_LIKE L ON TB.TB_NUM = L.TB_NUM";
		sql		  +=  " GROUP BY TB.TB_NUM, TB_TITLE, TB_CNT, TB_DATE, TB_ADDR, TB_IMG1,  MEM_NICK) T";
		sql	      +=  "	WHERE RN BETWEEN 1 + (10)*(?+?) AND 10 + (10)*(?+?)";
		
		try {
			db     = new DBConn();
			conn   = db.getConnection();
			pstmt  = conn.prepareStatement(sql);
			pstmt.setInt(1, currentPage-1); //첫번째 ?= 세번째 ? :누른 버튼의 번호-1
			pstmt.setInt(2, dpp); //두번째 ?=네번째? :보여줄 자료 수(기본 10개씩 보여주나 -5,+10 으로 조절 가능) 
			pstmt.setInt(3, currentPage-1);
			pstmt.setInt(4, dpp); 
			rs     = pstmt.executeQuery();
			// 작성자 추천수, 메인 이미지
			while( rs.next() ){
				int    tb_num   = rs.getInt(1);    //테이블 번호 
				String tb_title = rs.getString(2); //테이블 제목
				int    tb_cnt   = rs.getInt(3);    // 조회수
				String tb_date  = rs.getString(4); // 작성일
				String tb_addr  = rs.getString(5); // 관광지 주소
				String mainImg  = rs.getString(6); // 메인이미지
				String nickname = rs.getString(7); // 작성자
				int    likeCnt  = rs.getInt(8);    // 추천수
				int    number   = rs.getInt(9);	   // 검색순대로 번호 붙이기 
				
				TBoardVo tVo = new TBoardVo();
				tVo.setTbNum(tb_num);
				tVo.setTitle(tb_title);
				tVo.setReadCnt(tb_cnt);
				tVo.setwDate(tb_date);
				tVo.setAddr(tb_addr);
				tVo.setImg1(mainImg);
				tVo.setNickName(nickname);
				tVo.setLikeCnt(likeCnt);
				tVo.setNumber(number);
				boardList.add(tVo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
		return boardList;
	}
	
	//총 자료수 조회
	public int getDataCount() {
		int    dataCnt = 0;
		String sql     = "SELECT COUNT(*) FROM TRIP_BOARD";
		try {
			db    = new DBConn();
			conn  = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs    = pstmt.executeQuery();
			if(rs.next()){
				dataCnt = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return dataCnt;
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
