package visa.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import visa.model.*;
import visa.util.DBConnect;

public class ConfirmExtend {
	
	public void checkPayment(Extend extend) {
		
		Connection connection;
		PreparedStatement preparedStatement;
		
		try {
			connection = DBConnect.getDBConnection();

			preparedStatement = connection.prepareStatement("select p.country,p.vtype,p.days,c.dcharge,p.extday,p.total from payment p left outer join charges c on c.cid=p.cid where p.id=? and p.extvisa=1");
			preparedStatement.setInt(1, extend.getId());
			ResultSet rs = preparedStatement.executeQuery();
			
			while(rs.next())
			{
				extend.setCountry(rs.getString(1));
				extend.setVtype(rs.getInt(2));
				extend.setDays(rs.getInt(3));
				extend.setDcharge(Double.parseDouble(rs.getString(4)));
				extend.setExtday(rs.getInt(5));
				extend.setCtotal(Double.parseDouble(rs.getString(6)));
					
				
				if(extend.getVtype()==1) {
					
					extend.setVvtype("Tourist");
					
				}else if(extend.getVtype()==2) {
					
					extend.setVvtype("Business");
					
				}else if(extend.getVtype()==3) {
					
					extend.setVvtype("Economic");
				
				}
				
			}
			
			preparedStatement.close();
			connection.close();
			
			
		} catch (ClassNotFoundException | SQLException  e) {

			System.out.println(e.getMessage());
		}

	}

}
