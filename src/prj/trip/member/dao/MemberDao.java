package prj.trip.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import db.DBConn;
import memebr.vo.MemberVo;

public class MemberDao {
	
	private Connection conn;
	private PreparedStatement pstmt;
	
	public void InsertUser(MemberVo vo) {
		String gender ="";
		if(vo.getMem_gender().equals("f")) {
			gender = "여";
		}else if(vo.getMem_gender().equals("m")) {
			gender = "남";
		}
		try {
			System.out.println("진입 성공");
			DBConn db = new DBConn();
			conn = db.getConnection();
			
			String sql ="INSERT INTO MEM  VALUES ( (SELECT NVL( MAX(MEM_num),0 )+1 FROM MEM) ,0,?,?,?,?,?,?,?,?,?) ";
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
				if(pstmt != null )  pstmt.close();
				if(conn  != null )  conn.close();
			} catch (SQLException e) {
			}
		}
	}
	
public int IdCheck(String id) {
		
		ResultSet      rs         = null;
		
		try {
			DBConn    db   =  new DBConn();
			conn           =  db.getConnection();
			String    sql  =  " SELECT  MEM_num";
					  sql += " FROM   MEM ";
					  sql += " WHERE  MEM_num =  ? ";
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
public String getNick(String id) {  //닉네임 가져오기
	
	ResultSet      rs         = null;
	
	try {
		DBConn    db   =  new DBConn();
		conn           =  db.getConnection();
		String    sql  =  " SELECT  MEM_NICK";
		sql += " FROM   MEM ";
		sql += " WHERE  MEM_id =  ? ";
		pstmt          =  conn.prepareStatement(sql);
		
		pstmt.setString(1, id);
		
		rs       =  pstmt.executeQuery();
		if( rs.next() ) {
			return rs.getString("MEM_NICK");
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
	
	return   "아이디없음";
}


public int Login(String id, String pw) {
	ResultSet      rs         = null;
	String dbpw ="";
		try {
			DBConn db = new DBConn();
			conn = db.getConnection();
			String sql = " SELECT MEM_pwd FROM MEM WHERE MEM_id = ? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if ( rs.next() ) {
				dbpw = rs.getString("MEM_PWD");
				if( pw.equals(dbpw) ) {
					return 1; //로그인 성공
				}else {
					return 0; //아이디는 있지만 비밀번호 틀림
				}
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	return -1; //아이디 없음
	
}



}

