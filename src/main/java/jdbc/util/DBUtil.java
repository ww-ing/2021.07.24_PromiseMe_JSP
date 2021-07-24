package jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	
	private static String url = "jdbc:oracle:thin:@10.211.55.4:1521:xe";
	private static String user = "promise_me";
	private static String password = "tiger";
	
	private DBUtil() {
		
	}
	
	static{
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버 연결됨");
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		
	}//--static
	
	public static Connection getCon() 
	throws SQLException 
	{
		Connection con = DriverManager.getConnection(url, user, password);
		System.out.println("db연결됨");
		return con;
		
	}

}
