package visa.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import visa.model.*;
import visa.util.DBConnect;

public class SendMessage {
	
	public void sendMsg(Message massage) {
		Connection connection;
		PreparedStatement preparedStatement;
		try {
			connection = DBConnect.getDBConnection();

			preparedStatement = connection.prepareStatement("insert into message(name,mail,msg) values(?,?,?)");
			preparedStatement.setString(1, massage.getName());
			preparedStatement.setString(2, massage.getMail());
			preparedStatement.setString(3, massage.getMsg());
			preparedStatement.execute();
			//connection.commit();
			
			
			
		} catch (ClassNotFoundException | SQLException  e) {

			System.out.println(e.getMessage());
			
		}

	}

}
