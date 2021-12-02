package prj.trip.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import prj.trip.db.DBConn;
import prj.trip.member.vo.MemberVo;

public class MemberDao {
	private Connection conn;
	private PreparedStatement pstmt;

	public void InsertUser(MemberVo vo) {
		String gender = "";
		if (vo.getMem_gender().equals("f")) {
			gender = "여";
		} else if (vo.getMem_gender().equals("m")) {
			gender = "남";
		}
		try {
			DBConn db = new DBConn();
			conn = db.getConnection();

			String sql = "INSERT INTO MEMBER VALUES (?,?,?,?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, vo.getMem_name());
			pstmt.setString(2, vo.getMem_id());
			pstmt.setString(3, vo.getMem_pwd());
			pstmt.setString(4, vo.getMem_gender());
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

	public int IdCheck(String mem_id) {

		ResultSet rs = null;

		try {
			DBConn db = new DBConn();
			conn = db.getConnection();
			String sql = " SELECT  MEM_ID";
			sql += " FROM   MEMBER ";
			sql += " WHERE  MEM_ID =  ? ";
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, mem_id);

			rs = pstmt.executeQuery();
			if (rs.next()) {
				return 0;
			} else {
				return 1;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
			}
		}

		return -1;
	}
}
