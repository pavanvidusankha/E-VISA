package visa.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import visa.model.Visa;
import visa.util.DBConnect;

public class UserPayments {
	
	public ArrayList<Visa> getVisa(String user) {
		
		ArrayList<Visa> visaList = new ArrayList<Visa>();
		Connection connection;
		PreparedStatement preparedStatement;
		try {
			
			connection = DBConnect.getDBConnection();
			preparedStatement = connection.prepareStatement("select id,fname,lname,sname,bday,gender,mail,pnumber,country,vtype,iday,days,verify,passportid from applyvisa where user=? and verify=1 and payment is NULL");
			preparedStatement.setString(1, user);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				
				Visa visa = new Visa();
				
				visa.setId(Integer.parseInt(resultSet.getString(1)));
				visa.setFname(resultSet.getString(2));
				visa.setLname(resultSet.getString(3));
				visa.setSname(resultSet.getString(4));
				visa.setBday(resultSet.getString(5));
				visa.setGender(resultSet.getString(6));
				visa.setMail(resultSet.getString(7));
				visa.setPnumber(Integer.parseInt(resultSet.getString(8)));
				visa.setCountry(resultSet.getString(9));
				visa.setIday(resultSet.getString(11));
				visa.setDays(Integer.parseInt(resultSet.getString(12)));
				visa.setPid(Integer.parseInt(resultSet.getString(14)));
				
				if(Integer.parseInt(resultSet.getString(10))==1) {
					
					visa.setVvtype("Tourist");
				
				}else if(Integer.parseInt(resultSet.getString(10))==2) {
					
					visa.setVvtype("Business");
					
				}else if(Integer.parseInt(resultSet.getString(10))==3){
					
					visa.setVvtype("Economic");
					
				}
				
				if(resultSet.getString(13)==null) {
					
					visa.setVverify("pending");
				
				}else if(Integer.parseInt(resultSet.getString(13))==1) {
					
					visa.setVverify("Verified");
					
				}else {
					
					visa.setVverify("rejected");
					
				}
				
				visaList.add(visa);
				
			}
			
			preparedStatement.close();
			connection.close();
		} catch (ClassNotFoundException | SQLException  e) {

			System.out.println(e.getMessage());
		}

		return visaList;
	}

}
