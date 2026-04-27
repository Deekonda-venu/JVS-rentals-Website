package Com.JVS.Controller;

import java.io.IOException;

import Com.JVS.DAO_DTO.Booking_JDBC;
import Com.JVS.DAO_DTO.Booking_Model;
import Com.JVS.DAO_DTO.Registration_Model;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/Book")
public class BookingController extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		Registration_Model user = null;
		if (session != null) {
			user = (Registration_Model) session.getAttribute("user");
		}

		if (user == null) {
			response.sendRedirect("Login.html");
			return;
		}

		String bikeName = request.getParameter("bikeName");
		String pickupLocation = request.getParameter("pickupLocation");
		String pickupDate = request.getParameter("pickupDate");
		String daysStr = request.getParameter("days");
		String phone = request.getParameter("phone");

		int days = 1;
		try {
			days = Integer.parseInt(daysStr);
		} catch (Exception e) {
			days = 1;
		}

		Booking_Model model = new Booking_Model();
		model.setUserEmail(user.getEmail());
		model.setBikeName(bikeName);
		model.setPickupLocation(pickupLocation);
		model.setPickupDate(pickupDate);
		model.setDays(days);
		model.setPhone(phone);

		Booking_JDBC jdbc = new Booking_JDBC();
		String result = jdbc.insert(model);

		if ("success".equals(result)) {
			response.sendRedirect("Profile.jsp");
		} else {
			response.sendRedirect("BookNow.html");
		}
	}
}
