package cab.db;

import java.sql.*;

public class JDBCTrans {
	private DBCon dbc=new DBCon();
	
	public void trans() throws SQLException{
		Connection conn=dbc.getConnection();
		try {
			
			conn.setAutoCommit(false);
			String sql="insert into admin(username,password) values(?,?)";
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setObject(1, "star1");
			pstmt.setObject(2, "star1");
			pstmt.executeUpdate();
			System.out.println("插入第1条数据");
			
			pstmt.setObject(1, "star2");
			pstmt.setObject(2, "star2");
			pstmt.executeUpdate();
			System.out.println("插入第2条数据");
			
			int i=10/0;
			
			pstmt.setObject(1, "star3");
			pstmt.setObject(2, "star3");
			pstmt.executeUpdate();
			System.out.println("插入第3条数据");
			
			conn.commit();
		} catch (Exception e) {
			// TODO: handle exception
			conn.rollback();
		}
		
		
	}

}
