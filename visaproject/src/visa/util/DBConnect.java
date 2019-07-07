package visa.util;

import java.sql.*;

public class DBConnect {
	
	private static Connection connection;

	public static Connection getDBConnection() throws ClassNotFoundException, SQLException {

		// This creates new connection object when connection is closed or it is null
		if (connection == null || connection.isClosed()) {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/visa", "root", "");
		}
		
		return connection;
	}

}
