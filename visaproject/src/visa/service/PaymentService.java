package visa.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import visa.model.Payment;
import visa.util.DBConnect;

public class PaymentService {
	
public void savePayment(Payment payment) {
		
		Connection connection;
		PreparedStatement preparedStatement,preparedStatement1,preparedStatement2,preparedStatement3;
		
		try {
			connection = DBConnect.getDBConnection();
			
			preparedStatement1=connection.prepareStatement("UPDATE applyvisa set payment=1 where id=?");
			preparedStatement1.setInt(1, payment.getId());
			preparedStatement1.execute();
			preparedStatement1.close();
			
			preparedStatement2 = connection.prepareStatement("SELECT DATE_ADD(CURDATE(), INTERVAL 3 DAY)");
			ResultSet rs = preparedStatement2.executeQuery();
			
			while(rs.next())
			{
				payment.setIvisa(rs.getString(1));
				
				preparedStatement3 = connection.prepareStatement("SELECT DATE_ADD(CURDATE(), INTERVAL 3+? DAY)");
				preparedStatement3.setInt(1, payment.getDays());
				ResultSet rs1 = preparedStatement3.executeQuery();
				
				while(rs1.next())
				{
					payment.setExvisa(rs1.getString(1));
					
					preparedStatement = connection.prepareStatement("insert into payment (id,cid,user,country,vtype,days,total,ivisa,exvisa) values (?,?,?,?,?,?,?,?,?)");
					preparedStatement.setInt(1, payment.getId());
					preparedStatement.setInt(2, payment.getCid());
					preparedStatement.setString(3, payment.getUser());
					preparedStatement.setString(4, payment.getCountry());
					preparedStatement.setInt(5, payment.getVtype());
					preparedStatement.setInt(6, payment.getDays());
					preparedStatement.setDouble(7, payment.getCtotal());
					preparedStatement.setString(8, payment.getIvisa());
					preparedStatement.setString(9, payment.getExvisa());
					preparedStatement.execute();
					
					preparedStatement.close();
					
				}
				
				preparedStatement3.close();
			}
			
			
			preparedStatement2.close();
			connection.close();
			
			
			
		} catch (ClassNotFoundException | SQLException  e) {

			System.out.println(e.getMessage());
		}

	}

}
