package DataBase;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBconnection {
	private static Connection connection;
	
	public static Connection getConnection() {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital","root","root");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return connection;
	}
	
}
