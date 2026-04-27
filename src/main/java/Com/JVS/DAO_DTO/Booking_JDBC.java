package Com.JVS.DAO_DTO;

import java.util.ArrayList;
import java.util.List;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Com.JVS.JDBC.JDBC_Driver;

public class Booking_JDBC {

	public String insert(Booking_Model model) {
		String result = "Failed";
		try {
			Connection connection = JDBC_Driver.getConnection();
			String sql = "INSERT INTO bookings (user_email, bike_name, pickup_location, pickup_date, days, phone) VALUES (?, ?, ?, ?, ?, ?)";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, model.getUserEmail());
			ps.setString(2, model.getBikeName());
			ps.setString(3, model.getPickupLocation());
			ps.setString(4, model.getPickupDate());
			ps.setInt(5, model.getDays());
			ps.setString(6, model.getPhone());
			int rows = ps.executeUpdate();
			if (rows > 0) {
				result = "success";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public List<Booking_Model> getBookingsByEmail(String email) {
		List<Booking_Model> bookings = new ArrayList<>();
		try {
			Connection connection = JDBC_Driver.getConnection();
			String sql = "SELECT user_email, bike_name, pickup_location, pickup_date, days, phone FROM bookings WHERE user_email = ? ORDER BY id DESC";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Booking_Model m = new Booking_Model();
				m.setUserEmail(rs.getString("user_email"));
				m.setBikeName(rs.getString("bike_name"));
				m.setPickupLocation(rs.getString("pickup_location"));
				m.setPickupDate(rs.getString("pickup_date"));
				m.setDays(rs.getInt("days"));
				m.setPhone(rs.getString("phone"));
				bookings.add(m);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bookings;
	}
}
