package Com.JVS.DAO_DTO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import Com.JVS.JDBC.JDBC_Driver;

public class Registration_JDBC {
	
	public String Insert(Registration_Model Model) {
		
		String result = "Failed";
		
		
//		Class.forName("com.mysql.cj.jdbc.Driver");
//		
//		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/JVS_Rentals","root","root");
//		
		
		
		try {
		JDBC_Driver jdbc = new JDBC_Driver();
		Connection connection = JDBC_Driver.getConnection();
		String sql = "INSERT INTO Rentals_data (Firstname, Lastname, email, mobilenumber, Password, date_of_birth) VALUES (?, ?, ?, ?, ?, ?)";
        
		PreparedStatement ps = connection.prepareStatement(sql);
		
		ps.setString(1, Model.getFirstname());
		ps.setString(2, Model.getLastname());
		ps.setString(3, Model.getEmail());
		ps.setString(4, Model.getMobilenumber());
		ps.setString(5, Model.getPassword());
		ps.setString(6, Model.getDate_of_birth());
		
		int Rows = ps.executeUpdate();
		
		if(Rows>0) {
			result = "success";
		}
		
		
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
		
	}
	
	
	
	

}
