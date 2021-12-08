package prj.trip.nboard.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import prj.trip.db.DBConn;
import prj.trip.nboard.vo.NBoardVo;

public class NBoardDao {
	private Connection conn = null;
	private CallableStatement cstmt = null;

	// 게시글 삽입
	public void nboardInsert(NBoardVo vo) {

		try {
			DBConn db = new DBConn();
			conn = db.getConnection();
			String sql = "INSERT INTO NOTICE_BOARD VALUES((SELECT NVL(MAX(NB_NUM),0)+1 FROM NOTICE_BOARD),?,?,0,SYSDATE,NULL,NULL,?)";
			cstmt = conn.prepareCall(sql);

			cstmt.setString(1, vo.getNb_title());
			cstmt.setString(2, vo.getNb_cont());
			cstmt.setInt(3, vo.getMem_num());
			cstmt.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (cstmt != null)
					cstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
			}
		}

	}

	// 게시글 목록
	public List<NBoardVo> getnBoardList() {
		List<NBoardVo> vo = new ArrayList<>();
		ResultSet rs = null;

		try {
			DBConn db = new DBConn();
			conn = db.getConnection();
			String sql = "SELECT NB_NUM, NB_TITLE, M.MEM_NICK, NB_CNT, NB_DATE";
			sql += " FROM NOTICE_BOARD NB, MEMBER M";
			sql += " WHERE M.MEM_NUM = NB.MEM_NUM";

			cstmt = conn.prepareCall(sql);

			rs = cstmt.executeQuery();

			while (rs.next()) {
				int nb_num = rs.getInt("NB_NUM");
				String nb_title = rs.getString("NB_TITLE");
				int nb_cnt = rs.getInt("NB_CNT");
				String nb_date = rs.getString("NB_DATE");
				String mem_nick = rs.getString("MEM_NICK");

				NBoardVo nbvo = new NBoardVo(nb_num, nb_title, mem_nick, nb_cnt, nb_date);
				vo.add(nbvo);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (cstmt != null)
					cstmt.close();
				if (conn != null)
					conn.close();
				if (rs != null)
					rs.close();
			} catch (SQLException e) {
			}
		}
		return vo;
	}

	 //개인 식별번호 가져오기
	
	public int getMem_num(String nick) {
	  
	  ResultSet rs = null; int mem_num = 0;
	  
	  try { DBConn db = new DBConn(); conn = db.getConnection(); String sql =
	  "SELECT M.MEM_NUM FROM MEMBER M"; sql += " WHERE M.MEM_NICK = ?";
	  
	  cstmt = conn.prepareCall(sql);
	  
	  cstmt.setString(1,nick);
	  
	  rs = cstmt.executeQuery();
	  
	  if(rs.next()) mem_num = rs.getInt("MEM_NUM");
	  
	  
	  } catch (SQLException e) { e.printStackTrace(); } finally { try { if (cstmt
	  != null) cstmt.close(); if (conn != null) conn.close(); if(rs!=null)
	  rs.close(); } catch (SQLException e) { } } return mem_num;
	  
	  }
	 

	// 제목누르면 해당 게시글 들고옴
	public NBoardVo getnBoard(int getnb_num) {

		ResultSet rs = null;
		NBoardVo vo = new NBoardVo();

		try {
			DBConn db = new DBConn();
			conn = db.getConnection();
			String sql = "{CALL PKG_NBOARD.PROC_NBOARD_VIEW(?,?)}";

			cstmt = conn.prepareCall(sql);

			cstmt.setInt(1, getnb_num);
			cstmt.registerOutParameter(2, oracle.jdbc.OracleTypes.CURSOR);
			cstmt.execute();

			OracleCallableStatement ostmt = (OracleCallableStatement) cstmt;

			rs = ostmt.getCursor(2);

			if (rs.next()) {
				String nb_title = rs.getString("NB_TITLE");
				String mem_nick = rs.getString("MEM_NICK");
				int nb_cnt = rs.getInt("NB_CNT");
				String nb_date = rs.getString("NB_DATE");
				String nb_cont = rs.getString("NB_CONT");
				int nb_num = rs.getInt("NB_NUM");

				vo = new NBoardVo(nb_title, mem_nick, nb_cnt, nb_date, nb_cont, nb_num);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (cstmt != null)
					cstmt.close();
				if (conn != null)
					conn.close();
				if (rs != null)
					rs.close();
			} catch (SQLException e) {
			}
		}

		return vo;
	}
	
	//수정
	public void nboardUpdate(int nboardNum, String cont, String title) {


		try {
			DBConn db = new DBConn();
			conn = db.getConnection();
			String sql = "{CALL PKG_NBOARD.PROC_NBOARD_UPDATE(?,?,?)}";

			cstmt = conn.prepareCall(sql);

			cstmt.setInt(1, nboardNum);
			cstmt.setString(2, cont);
			cstmt.setString(3, title);
			
			cstmt.execute();


		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (cstmt != null)
					cstmt.close();
				if (conn != null)
					conn.close();

			} catch (SQLException e) {
			}
		}

	}

	//삭제
	public void nboardDelete(int nboardNum) {

		try {
			DBConn db = new DBConn();
			conn = db.getConnection();
			String sql = "{CALL PKG_NBOARD.PROC_NBOARD_DELETE(?)}";

			cstmt = conn.prepareCall(sql);

			cstmt.setInt(1, nboardNum);
			
			cstmt.execute();


		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (cstmt != null)
					cstmt.close();
				if (conn != null)
					conn.close();

			} catch (SQLException e) {
			}
		}
	}

}
