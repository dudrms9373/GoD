package prj.trip.member.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import prj.trip.FBoard.Vo.FreeBoardVo;
import prj.trip.db.DBConn;
import prj.trip.member.vo.MemberVo;

public class MemberDao {

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	public void InsertUser(MemberVo vo) {
		String gender = "";
		if (vo.getMem_gender().equals("f")) {
			gender = "여";
		} else if (vo.getMem_gender().equals("m")) {
			gender = "남";
		}
		try {
			System.out.println("진입 성공");
			DBConn db = new DBConn();
			conn = db.getConnection();

			String sql = "INSERT INTO MEMBER  VALUES ( (SELECT NVL( MAX(MEM_num),0 )+1 FROM MEMBER) ,0,?,?,?,?,?,?,?,?,?) ";
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, vo.getMem_name());
			pstmt.setString(2, vo.getMem_id());
			pstmt.setString(3, vo.getMem_pwd());
			pstmt.setString(4, gender);
			pstmt.setString(5, vo.getMem_addr());
			pstmt.setString(6, vo.getMem_tel());
			pstmt.setString(7, vo.getMem_birth());
			pstmt.setString(8, vo.getMem_nick());
			pstmt.setString(9, vo.getMem_email());

			pstmt.executeUpdate();

			conn.commit();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
			}
		}
	}

	public int IdCheck(String id) {
		
		ResultSet      rs         = null;
		
		try {
			DBConn    db   =  new DBConn();
			conn           =  db.getConnection();
			String    sql  =  " SELECT  MEM_id";
					  sql += " FROM   MEMBER ";
					  sql += " WHERE  MEM_id =  ? ";
			pstmt          =  conn.prepareStatement(sql);
			
			pstmt.setString(1, id);
			
			rs       =  pstmt.executeQuery();
			if( rs.next() ) {
				return  0 ;
				}else {
				return  1 ;
				}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs    != null )  rs.close();
				if(pstmt != null )  pstmt.close();
				//if(conn  != null )  conn.close();
			} catch (SQLException e) {
			}
		}

		return   -1;
	}

	public String getNick(String id) { // 닉네임 가져오기

		try {
			DBConn db = new DBConn();
			conn = db.getConnection();
			String sql = " SELECT  MEM_NICK";
			sql += " FROM   MEMBER ";
			sql += " WHERE  MEM_id =  ? ";
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, id);

			rs = pstmt.executeQuery();
			if (rs.next()) {
				return rs.getString("MEM_NICK");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				// if(conn != null ) conn.close();
			} catch (SQLException e) {
			}
		}

		return "아이디없음";
	}

	public int Login(String id, String pw) {
		String dbpw = "";
		try {
			DBConn db = new DBConn();
			conn = db.getConnection();
			String sql = " SELECT MEM_PWD FROM MEMBER WHERE MEM_ID = ? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				dbpw = rs.getString("MEM_PWD");
				if (pw.equals(dbpw)) {
					return 1; // 로그인 성공
				} else {
					return 0; // 아이디는 있지만 비밀번호 틀림
				}

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1; // 아이디 없음

	}

//테이블에 저장할 회원번호를 가져오기
	public int getMemNum(String loginId) {
		int memNum = 0;
		String sql = "SELECT MEM_NUM FROM MEMBER WHERE MEM_ID = ? ";

		try {
			DBConn db = new DBConn();
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, loginId);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				memNum = rs.getInt("MEM_NUM");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return memNum;
	}
	
	//테이블에 저장할 회원번호를 가져오기
	public String getMemNumm(String loginId) {
		ResultSet rs=null;
	 String memNum = "";
	 String sql = "SELECT MEM_NUM FROM MEMBER WHERE MEM_ID = ? ";
	 
	 try {
	    DBConn db         = new DBConn();
	    conn       = db.getConnection();
	    pstmt      = conn.prepareStatement(sql);
	    pstmt.setString(1, loginId);
	    rs = pstmt.executeQuery();
	    
	    if(rs.next()){
	       memNum = rs.getString("MEM_NUM");
	    }
	 } catch (SQLException e) {
	    e.printStackTrace();
	 } finally {
	    try {
	  	  if(rs!=null)rs.close();
	  	  if(pstmt!=null)pstmt.close();
	  	  if(conn!=null)conn.close();
	 } catch (SQLException e) {
	    e.printStackTrace();
	 }
	 }
	       return memNum;
	}
	

	//내 정보 가져오기
	public MemberVo getmemInfo(String loginId) {

		MemberVo vo = null;
		try {
			DBConn db = new DBConn();
			conn = db.getConnection();
			String sql = "SELECT MEM_NAME, MEM_ID, MEM_GENDER, MEM_ADDR, MEM_TEL, MEM_BIRTH, MEM_NICK, MEM_EMAIL";
				   sql += " FROM MEMBER WHERE MEM_ID = ? ";
		
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, loginId);
			rs = pstmt.executeQuery();

			if (rs.next()) {

				String mem_name   = rs.getString("MEM_NAME");
				String mem_id     = rs.getString("MEM_ID");
				String mem_gender = rs.getString("MEM_GENDER");
				String mem_addr   = rs.getString("MEM_ADDR");
				String mem_tel    = rs.getString("MEM_TEL");
				String mem_birth  = rs.getString("MEM_BIRTH");
				String mem_nick   = rs.getString("MEM_NICK");
				String mem_email  = rs.getString("MEM_EMAIL");
			
				vo = new MemberVo(mem_name,mem_id,mem_gender,mem_addr,mem_tel,mem_birth, mem_nick, mem_email);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
		return vo;
	}
	
	

//DB CLOSE
	public void close() {
		try {
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//밑으로 자유게시판 (임시)

	public List<FreeBoardVo> getFreeBoardList(int startNum, int endNum){
		
		ResultSet rs = null;
		List<FreeBoardVo> FreeBoardList = new ArrayList<FreeBoardVo>();
		
		try {
			DBConn db = new DBConn();
			conn = db.getConnection();
			 String sql =" SELECT AA.FB_NUM, AA.FB_TITLE, M.MEM_NICK , AA.FB_DATE, AA.FB_CNT , NVL((SELECT COUNT(*) OVER   FROM FB_LIKE f WHERE f.FB_NUM= AA.FB_NUM ),0)AS LIKECNT "
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
				String likecnt = rs.getString("LIKECNT");	
				
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
