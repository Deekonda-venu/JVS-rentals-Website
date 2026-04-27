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
    <link rel="stylesheet" href="Header.css">
</head>
<body>
    <div class="container mt-5">
        <div class="d-flex align-items-center justify-content-between mb-4">
			<h2 class="mb-0">User Profile</h2>
			<a href="Logout" class="btn btn-outline-dark">Logout</a>
		</div>
	<div class="header" id="nav">
		<button class="navbar-toggler" onclick="toggleMenu()">
			<span class="bar"></span> <span class="bar"></span> <span class="bar"></span>
		</button>
		<div class="menu" id="menu">
			<button type="button" class="x" id="close">X</button>
			<a href="Profile.jsp" class="item">Profile</a>
			<a href="HelpCenter.html" class="item">Help Center</a>
			<a href="FAQ.html" class="item">FAQ</a>
			<a href="Privacy policy.html" class="item">Privacy Policy</a>
			<a href="Feedback.html" class="item">Feedback</a>
		</div>
		<img src="JVS2O.jpg" height="50px" width="50px;" class="logoimage">
		<p class="Rentals"><b>RENTALS</b></p>
		<h5><a href="Home.html" class="Home">Home</a></h5>
		<h5><a href="BookNow.html" class="Book">BookNow</a></h5>
		<h5><a href="Contact_us.html" class="Contact">Contact Us</a></h5>
		<h5><a href="About_Us.html" class="About">About Us</a></h5>
		<h5><a href="Terms.html" class="Terms">Terms & Services</a></h5>
	</div>

    <div class="container" style="margin-top: 120px;">
        <div class="row">
            <div class="col-md-8">
                <h2 class="mb-4">User Profile</h2>
            </div>
        </div>

        <%
            Registration_Model user = (Registration_Model) session.getAttribute("user");
            if (user == null) {
        %>
            <div class="alert alert-danger">No user logged in. <a href="Login.html">Login here</a></div>
        <%
            } else {
        %>
			<div class="card shadow-sm border-0">
				<div class="card-body">
					<div class="row">
						<div class="col-md-3 text-center">
							<img src="JVS2O.jpg" alt="Avatar" style="width: 110px; height: 110px; border-radius: 60px; box-shadow: 2px 2px 5px rgba(0,0,0,0.25);">
							<p style="margin-top: 10px;"><b><%= user.getFirstname() %> <%= user.getLastname() %></b></p>
							<p style="margin: 0; color: gray;">Member</p>
						</div>
						<div class="col-md-9">
							<form action="ProfileServlet" method="post">
								<div class="form-row">
									<div class="form-group col-md-6">
										<label>First Name:</label>
										<input type="text" class="form-control" value="<%= user.getFirstname() %>" readonly>
									</div>
									<div class="form-group col-md-6">
										<label>Last Name:</label>
										<input type="text" class="form-control" value="<%= user.getLastname() %>" readonly>
									</div>
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
								<div>
									<button type="submit" name="action" value="update" class="btn btn-primary" style="background-color: orange; border-color: orange;">Update</button>
									<button type="submit" name="action" value="delete" class="btn btn-danger" onclick="return confirm('Are you sure you want to delete your account?');">Delete</button>
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
        <%
            }
        %>
    </div>

	<script>
		var a = 0;
		function toggleMenu() {
			if (a == 0) {
				document.getElementById('menu').style.display = "flex";
				document.getElementById('menu').style.left = "0px";
				document.getElementById('menu').style.transition = "all 1s";
				document.getElementById("menu").style.zIndex = 999;
				a++;
			} else {
				document.getElementById('menu').style.left = "-250px";
				document.getElementById('menu').style.transition = "all 1s";
				document.getElementById('menu').style.display = "none";
				a = 0;
			}
		}
		document.addEventListener('DOMContentLoaded', function() {
			var closeBtn = document.getElementById('close');
			if (closeBtn) {
				closeBtn.onclick = toggleMenu;
			}
		});
	</script>
</body>
</html>
