package Com.JVS.DAO_DTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Com.JVS.JDBC.JDBC_Driver;

public class Login_JDBC {
	
	public String Enquiry(Login_Model Model) {
		
		String status = "Failed";
		try {
			JDBC_Driver jdbc = new JDBC_Driver();
			Connection connection = JDBC_Driver.getConnection();
			String sql = "SELECT * FROM Rentals_data WHERE email = ? AND password = ?;";
	        
			PreparedStatement ps = connection.prepareStatement(sql);
			
			ps.setString(1, Model.getEmail());
			ps.setString(2, Model.getPassword());
			
			
			ResultSet Rows = ps.executeQuery();
			
			
			
			while(Rows.next()) {
				status = "success";
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
			
		}
		
		
		
		return status;
		
	}

}
