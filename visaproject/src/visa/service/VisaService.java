package visa.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import visa.model.*;
import visa.util.DBConnect;

public class VisaService {
	
	public void applyVisa(Visa visa) {
		
		Connection connection;
		PreparedStatement preparedStatement;
		
		try {
			connection = DBConnect.getDBConnection();

			preparedStatement = connection.prepareStatement("insert into applyvisa (fname,lname,sname,bday,gender,mail,pnumber,country,vtype,passportid,iday,days,user) values (?,?,?,?,?,?,?,?,?,?,?,?,?)");
			
			preparedStatement.setString(1, visa.getFname());
			preparedStatement.setString(2, visa.getLname());
			preparedStatement.setString(3, visa.getSname());
			preparedStatement.setString(4, visa.getBday());
			preparedStatement.setString(5, visa.getGender());
			preparedStatement.setString(6, visa.getMail());
			preparedStatement.setInt(7, visa.getPnumber());
			preparedStatement.setString(8, visa.getCountry());
			preparedStatement.setInt(9, visa.getVtype());
			preparedStatement.setInt(10, visa.getPid());
			preparedStatement.setString(11, visa.getIday());
			preparedStatement.setInt(12, visa.getDays());
			preparedStatement.setString(13, visa.getUser());
			preparedStatement.execute();
			//connection.commit();
			preparedStatement.close();
			connection.close();
			
			
		} catch (ClassNotFoundException | SQLException  e) {

			System.out.println(e.getMessage());
			
		}

	}

}
