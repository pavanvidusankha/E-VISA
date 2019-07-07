package visa.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import visa.model.*;
import visa.util.DBConnect;

public class ExtendService {
	
	public void saveExtend(Extend extend) {
		
		Connection connection;
		PreparedStatement preparedStatement,preparedStatement1;
		
		try {
			connection = DBConnect.getDBConnection();
			
			preparedStatement1=connection.prepareStatement("SELECT DATE_ADD(exvisa, INTERVAL ? DAY) FROM payment where id=?");
			preparedStatement1.setInt(1, extend.getExtday());
			preparedStatement1.setInt(2, extend.getId());
			ResultSet rs = preparedStatement1.executeQuery();
			
			
			while(rs.next())
			{
				extend.setExvisa(rs.getString(1));
				
				preparedStatement = connection.prepareStatement("update payment set days=?,total=?,exvisa=?,extvisa=null,extday=null where id=?");
				preparedStatement.setInt(1, (extend.getDays()+extend.getExtday()));
				preparedStatement.setDouble(2, extend.getExtotal());
				preparedStatement.setString(3, extend.getExvisa());
				preparedStatement.setInt(4, extend.getId());
				preparedStatement.execute();
				preparedStatement.close();
				
			}
			
			preparedStatement1.close();
			connection.close();
			
			
		} catch (ClassNotFoundException | SQLException  e) {

			System.out.println(e.getMessage());
		}

	}

}
