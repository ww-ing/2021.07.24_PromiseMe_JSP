package jdbc.util;

import java.sql.*;

public class DAOBase {
	
	protected Connection con;
	protected PreparedStatement ps;
	protected ResultSet rs;
	
	public void close() {
		try {
		if(rs!=null) rs.close();
		if(ps!=null) ps.close();
		if(con!=null) con.close();
		
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}	
	

}