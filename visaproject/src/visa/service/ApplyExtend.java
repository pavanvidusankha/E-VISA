package visa.service;

import java.sql.*;

import visa.model.*;
import visa.util.DBConnect;

public class ApplyExtend {
	
	public void extend(Extend extend) {
		Connection connection;
		PreparedStatement preparedStatement;
		try {
			connection = DBConnect.getDBConnection();

			preparedStatement = connection.prepareStatement("UPDATE payment SET extday=?,extvisa=2 where id=?");
			preparedStatement.setInt(1, extend.getExtday());
			preparedStatement.setInt(2, extend.getId());
			preparedStatement.execute();
			//connection.commit();
			
			
			
		} catch (ClassNotFoundException | SQLException  e) {

			System.out.println(e.getMessage());
			
		}

	}

}
