package visa.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import visa.model.*;
import visa.util.DBConnect;

public class CheckPassport {
	
public void checkPassport(Passport passport) {
		
		Connection connection;
		PreparedStatement preparedStatement;
		
		try {
			connection = DBConnect.getDBConnection();

			preparedStatement = connection.prepareStatement("SELECT a.fname,p.fname,a.lname,p.lname,p.passportid,p.idate,p.exdate from applyvisa a, passport p where p.passportid=a.passportid and p.idate=a.iday and p.bday=a.bday and id=?");
			preparedStatement.setInt(1, passport.getId());
			ResultSet rs = preparedStatement.executeQuery();
			
			while(rs.next())
			{
				passport.setFname(rs.getString(1));
				passport.setPfname(rs.getString(2));
				passport.setLname(rs.getString(3));
				passport.setPlname(rs.getString(4));
				passport.setPassportid(rs.getInt(5));
				passport.setIdate(rs.getString(6));
				passport.setExdate(rs.getString(7));
				
				
			}
			
			preparedStatement.close();
			connection.close();
			
			
		} catch (ClassNotFoundException | SQLException  e) {

			System.out.println(e.getMessage());
		}

	}

}
