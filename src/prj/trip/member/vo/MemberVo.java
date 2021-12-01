package memebr.vo;

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
		if(vo.getGender().equals("f")) {
			gender = "여";
		}else if(vo.getGender().equals("m")) {
			gender = "남";
		}
		try {
			System.out.println("진입 성공");
			DBConn db = new DBConn();
			conn = db.getConnection();
			
			String sql ="INSERT INTO MEM  VALUES ( (SELECT NVL( MAX(MEM_num),0 )+1 FROM MEM) ,0,?,?,?,?,?,?,?,?,?) ";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, vo.getUname());
			pstmt.setString(2, vo.getUid());
			pstmt.setString(3, vo.getUpw());
			pstmt.setString(4, gender);
			pstmt.setString(5, vo.getAddr());
			pstmt.setString(6, vo.getTel());
			pstmt.setString(7, vo.getBirth());
			pstmt.setString(8, vo.getNick());
			pstmt.setString(9, vo.getUemail());
			
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
}
