package visa.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import visa.model.*;
import visa.util.DBConnect;

public class ViewMsg {
	
public ArrayList<Message> getMsgs() {
		
		ArrayList<Message> msgList = new ArrayList<Message>();
		Connection connection;
		PreparedStatement preparedStatement;
		try {
			
			connection = DBConnect.getDBConnection();
			preparedStatement = connection.prepareStatement("select id,name,mail,msg from message");
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				
				Message msg = new Message();
				
				msg.setId(Integer.parseInt(resultSet.getString(1)));
				msg.setName(resultSet.getString(2));
				msg.setMail(resultSet.getString(3));
				msg.setMsg(resultSet.getString(4));
				
				
				msgList.add(msg);
				
			}
			
			preparedStatement.close();
			connection.close();
		} catch (ClassNotFoundException | SQLException  e) {

			System.out.println(e.getMessage());
		}

		return msgList;
	}

}
