package visa.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import visa.model.*;
import visa.util.DBConnect;

public class ActionService {
	
	public void checkAction(Action action) {
		Connection connection;
		PreparedStatement preparedStatement;
		
		
		
		try {
			connection = DBConnect.getDBConnection();

			if(action.getAction()==0) {
				
				preparedStatement = connection.prepareStatement("UPDATE applyvisa SET verify=1 WHERE id=?");
				preparedStatement.setInt(1, action.getId());
				preparedStatement.execute();
				
			}else if(action.getAction()==2) {
				
				preparedStatement = connection.prepareStatement("UPDATE applyvisa SET verify=0 WHERE id=?");
				preparedStatement.setInt(1, action.getId());
				preparedStatement.execute();
				
			}else if(action.getAction()==3) {
				
				preparedStatement = connection.prepareStatement("DELETE FROM applyvisa WHERE id=?");
				preparedStatement.setInt(1, action.getId());
				preparedStatement.execute();
				
			}
			
			
			
		} catch (ClassNotFoundException | SQLException  e) {

			System.out.println(e.getMessage());
		}

	}

}
