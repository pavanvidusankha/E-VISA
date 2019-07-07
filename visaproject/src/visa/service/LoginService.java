package visa.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.*;

import visa.model.*;
import visa.util.DBConnect;

public class LoginService {
	
	private int passUser;
	
	public void checkLogin(Login login) {
		Connection connection;
		PreparedStatement preparedStatement;
		
		try {
			connection = DBConnect.getDBConnection();
			
			String dbUserame = null;
			String dbPassword = null;
			int dbAdmin = 0;

			preparedStatement = connection.prepareStatement("select * from user where username=? and password=?");
			//preparedStatement.setInt(1, user.getId());
			preparedStatement.setString(1, login.getUsername());
			preparedStatement.setString(2, login.getPassword());
			ResultSet rs = preparedStatement.executeQuery();
			
			while(rs.next())
			{
				dbUserame = rs.getString(3);
				dbPassword = rs.getString(4);
				dbAdmin = rs.getInt(5);
				
			}
			if(login.getUsername().equals(dbUserame)&&login.getPassword().equals(dbPassword)&&(dbAdmin==1)) {
				
				setPassUser(1);
				preparedStatement.close();
				connection.close();
				
			}else if(login.getUsername().equals(dbUserame)&&login.getPassword().equals(dbPassword)&&(dbAdmin==0)){
				
				setPassUser(2);
				preparedStatement.close();
				connection.close();
				
			}else {
				
				setPassUser(3);
				preparedStatement.close();
				connection.close();
				
			}
			//connection.commit();
			
		} catch (ClassNotFoundException | SQLException  e) {

			System.out.println(e.getMessage());
		}

	}

	public int getPassUser() {
		return passUser;
	}

	public void setPassUser(int passUser) {
		this.passUser = passUser;
	}

}
