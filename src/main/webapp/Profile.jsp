<%@ page import="Com.JVS.DAO_DTO.Registration_Model" %>
<%@ page import="Com.JVS.DAO_DTO.Booking_JDBC" %>
<%@ page import="Com.JVS.DAO_DTO.Booking_Model" %>
<%@ page import="java.util.List" %>
<%@ page session="true" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Profile</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css">
</head>
<body>
    <div class="container mt-5">
        <div class="d-flex align-items-center justify-content-between mb-4">
			<h2 class="mb-0">User Profile</h2>
			<a href="Logout" class="btn btn-outline-dark">Logout</a>
		</div>

        <%
            Registration_Model user = (Registration_Model) session.getAttribute("user");
            if (user == null) {
        %>
            <div class="alert alert-danger">No user logged in. <a href="Login.html">Login here</a></div>
        <%
            } else {
        %>
            <form action="ProfileServlet" method="post">
                <div class="form-group">
                    <label>First Name:</label>
                    <input type="text" class="form-control" value="<%= user.getFirstname() %>" readonly>
                </div>

                <div class="form-group">
                    <label>Last Name:</label>
                    <input type="text" class="form-control" value="<%= user.getLastname() %>" readonly>
                </div>

                <div class="form-group">
                    <label>Email:</label>
                    <input type="email" class="form-control" name="email" value="<%= user.getEmail() %>">
                </div>

                <div class="form-group">
                    <label>Mobile Number:</label>
                    <input type="text" class="form-control" value="<%= user.getMobilenumber() %>" readonly>
                </div>

                

                <button type="submit" name="action" value="update" class="btn btn-primary">Update</button>
                <button type="submit" name="action" value="delete" class="btn btn-danger" onclick="return confirm('Are you sure you want to delete your account?');">Delete</button>
            </form>

			<hr>
			<h3 class="mt-4">My Bookings</h3>
			<%
				Booking_JDBC bookingJdbc = new Booking_JDBC();
				List<Booking_Model> bookings = bookingJdbc.getBookingsByEmail(user.getEmail());
				if (bookings == null || bookings.isEmpty()) {
			%>
				<div class="alert alert-info">No bookings yet. <a href="BookNow.html">Book a bike here</a>.</div>
			<%
				} else {
			%>
				<div class="table-responsive">
					<table class="table table-bordered table-striped mt-3">
						<thead class="thead-dark">
							<tr>
								<th>Bike</th>
								<th>Location</th>
								<th>Date</th>
								<th>Days</th>
								<th>Phone</th>
							</tr>
						</thead>
						<tbody>
							<%
								for (Booking_Model b : bookings) {
							%>
								<tr>
									<td><%= b.getBikeName() %></td>
									<td><%= b.getPickupLocation() %></td>
									<td><%= b.getPickupDate() %></td>
									<td><%= b.getDays() %></td>
									<td><%= b.getPhone() %></td>
								</tr>
							<%
								}
							%>
						</tbody>
					</table>
				</div>
			<%
				}
			%>
        <%
            }
        %>
    </div>
</body>
</html>
