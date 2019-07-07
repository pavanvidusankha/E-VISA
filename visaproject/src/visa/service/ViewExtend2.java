package visa.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import visa.model.Extend;
import visa.util.DBConnect;

public class ViewExtend2 {
	
	public ArrayList<Extend> getExtend(String user) {
		
		ArrayList<Extend> extendList = new ArrayList<Extend>();
		Connection connection;
		PreparedStatement preparedStatement;
		try {
			
			connection = DBConnect.getDBConnection();
			preparedStatement = connection.prepareStatement("select id,user,country,vtype,days,total,ivisa,exvisa,extvisa,extday from payment where user=? and extvisa is not null and extvisa=1");
			preparedStatement.setString(1, user);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				
				Extend extend = new Extend();
				
				extend.setId(Integer.parseInt(resultSet.getString(1)));
				extend.setUser(resultSet.getString(2));
				extend.setCountry(resultSet.getString(3));
				extend.setDays(Integer.parseInt(resultSet.getString(5)));
				extend.setCtotal(Double.parseDouble(resultSet.getString(6)));
				extend.setIvisa(resultSet.getString(7));
				extend.setExvisa(resultSet.getString(8));
				extend.setExtday(Integer.parseInt(resultSet.getString(10)));
				
				
				if(Integer.parseInt(resultSet.getString(4))==1) {
					
					extend.setVvtype("Tourist");
				
				}else if(Integer.parseInt(resultSet.getString(4))==2) {
					
					extend.setVvtype("Business");
					
				}else if(Integer.parseInt(resultSet.getString(4))==3){
					
					extend.setVvtype("Economic");
					
				}
				
				if(Integer.parseInt(resultSet.getString(9))==1) {
					
					extend.setEextvisa("Verified");
				
				}else if(Integer.parseInt(resultSet.getString(9))==2) {
					
					extend.setEextvisa("pending");
					
				}else if(Integer.parseInt(resultSet.getString(9))==0){
					
					extend.setEextvisa("rejected");
					
				}
				
				
				extendList.add(extend);
				
			}
			
			preparedStatement.close();
			connection.close();
		} catch (ClassNotFoundException | SQLException  e) {

			System.out.println(e.getMessage());
		}

		return extendList;
	}

}
