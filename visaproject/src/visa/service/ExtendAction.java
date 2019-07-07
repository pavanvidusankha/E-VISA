package visa.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import visa.model.Action;
import visa.util.DBConnect;

public class ExtendAction {
	
	public void checkAction(Action action) {
		Connection connection;
		PreparedStatement preparedStatement;
		
		
		
		try {
			connection = DBConnect.getDBConnection();

			if(action.getAction()==1) {
				
				preparedStatement = connection.prepareStatement("UPDATE payment SET extvisa=1 WHERE id=?");
				preparedStatement.setInt(1, action.getId());
				preparedStatement.execute();
				
			}else if(action.getAction()==2) {
				
				preparedStatement = connection.prepareStatement("UPDATE payment SET extvisa=0 WHERE id=?");
				preparedStatement.setInt(1, action.getId());
				preparedStatement.execute();
				
			}else if(action.getAction()==3) {
				
				preparedStatement = connection.prepareStatement("UPDATE payment SET extvisa=null,extday=null WHERE id=?");
				preparedStatement.setInt(1, action.getId());
				preparedStatement.execute();
				
			}
			
			
			
		} catch (ClassNotFoundException | SQLException  e) {

			System.out.println(e.getMessage());
		}

	}

}
