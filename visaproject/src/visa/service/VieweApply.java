package visa.service;

import java.util.*;

import javax.servlet.http.HttpSession;

import visa.model.*;
import java.sql.*;
import visa.util.*;

public class VieweApply {
	
	public ArrayList<Visa> getVisa(String user) {
		
		ArrayList<Visa> visaList = new ArrayList<Visa>();
		Connection connection;
		PreparedStatement preparedStatement;
		try {
			
			connection = DBConnect.getDBConnection();
			preparedStatement = connection.prepareStatement("select id,fname,lname,sname,bday,gender,mail,pnumber,country,vtype,passportid,iday,days,verify from applyvisa where payment is null and user=?");
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
				visa.setPid(Integer.parseInt(resultSet.getString(11)));
				visa.setIday(resultSet.getString(12));
				visa.setDays(Integer.parseInt(resultSet.getString(13)));
				
				if(Integer.parseInt(resultSet.getString(10))==1) {
					
					visa.setVvtype("Tourist");
				
				}else if(Integer.parseInt(resultSet.getString(10))==2) {
					
					visa.setVvtype("Business");
					
				}else if(Integer.parseInt(resultSet.getString(10))==3){
					
					visa.setVvtype("Economic");
					
				}
				
				if(resultSet.getString(14)==null) {
					
					visa.setVverify("Pending");
				
				}else if(Integer.parseInt(resultSet.getString(14))==1) {
					
					visa.setVverify("Verified");
					
				}else {
					
					visa.setVverify("Rejected");
					
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
