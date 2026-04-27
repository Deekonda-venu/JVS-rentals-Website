package Com.JVS.DAO_DTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Com.JVS.JDBC.JDBC_Driver;

import Com.JVS.DAO_DTO.Registration_Model;

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

	public Registration_Model getUserByEmail(String email) {
		Registration_Model user = null;
		try {
			Connection connection = JDBC_Driver.getConnection();
			String sql = "SELECT Firstname, Lastname, email, mobilenumber, Password, date_of_birth FROM Rentals_data WHERE email = ?;";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				user = new Registration_Model();
				user.setFirstname(rs.getString("Firstname"));
				user.setLastname(rs.getString("Lastname"));
				user.setEmail(rs.getString("email"));
				user.setMobilenumber(rs.getString("mobilenumber"));
				user.setPassword(rs.getString("Password"));
				user.setDate_of_birth(rs.getString("date_of_birth"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}

}
