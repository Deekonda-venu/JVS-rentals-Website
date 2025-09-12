<%@ page import="Com.JVS.DAO_DTO.Registration_Model" %>
<%@ page session="true" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Profile</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css">
</head>
<body>
    <div class="container mt-5">
        <h2 class="mb-4">User Profile</h2>

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
        <%
            }
        %>
    </div>
</body>
</html>
