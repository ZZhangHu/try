package cab.db;

import java.sql.*;

public class DBCon {
	private String driver="com.mysql.jdbc.Driver";
	private String url="jdbc:mysql://localhost:3306/hh";
	private String user="root";
	private String password="admin";
	private Connection conn=null;
	
	public Connection getConnection(){
		try {
			Class.forName(driver);
			conn=DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	public ResultSet doQuery(String sql,Object[] params){
		ResultSet rs=null;
		conn=this.getConnection();
		try {
			PreparedStatement pstmt=conn.prepareCall(sql);
			//PreparedStatement pstmt=conn.prepareStatement(sql);
			for(int i=0;i<params.length;i++){
				pstmt.setObject(i+1, params[i]);
			}
			rs=pstmt.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	public int doUpdate(String sql,Object[] params){
		int res=0;
		conn=this.getConnection();
		try {
			PreparedStatement pstmt=conn.prepareCall(sql);
			//PreparedStatement pstmt=conn.prepareStatement(sql);
			for(int i=0;i<params.length;i++){
				pstmt.setObject(i+1, params[i]);
			}
			res=pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}
	public void close(){
		try {
			if(conn!=null)
				conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

