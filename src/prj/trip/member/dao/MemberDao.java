package prj.trip.member.dao;

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
			DBConn db = new DBConn();
			conn = db.getConnection();
			
			String sql ="INSERT INTO AAA2 VALUES (?,?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, vo.getUid());
			pstmt.setString(2, vo.getUpw());
			pstmt.setString(3, vo.getUname());
			pstmt.setString(4, vo.getUemail());
			pstmt.setString(5, vo.getBirth());
			pstmt.setString(6, vo.getTel());
			pstmt.setString(7, gender);
			
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
}
