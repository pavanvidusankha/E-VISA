package visa.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import visa.model.*;
import visa.util.DBConnect;

public class DeleteMessage {

	public void deleteMsg(Message msg) {
		Connection connection;
		PreparedStatement preparedStatement;
		try {
			connection = DBConnect.getDBConnection();

			preparedStatement = connection.prepareStatement("DELETE FROM message WHERE id=?");
			preparedStatement.setInt(1, msg.getId());
			preparedStatement.execute();
			//connection.commit();
			
			
		} catch (ClassNotFoundException | SQLException  e) {

			System.out.println(e.getMessage());
			
		}

	}
	
	
}
