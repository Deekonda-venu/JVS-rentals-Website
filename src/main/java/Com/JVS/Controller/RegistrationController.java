package Com.JVS.Controller;

import jakarta.servlet.RequestDispatcher;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import Com.JVS.DAO_DTO.Registration_JDBC;
import Com.JVS.DAO_DTO.Registration_Model;

@WebServlet("/Registration")
public class RegistrationController extends HttpServlet {
//	private static final long serialVersionUID = 1L;
	public RegistrationController() {
        // TODO Auto-generated constructor stub
    }
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Welcome to servlets");
		String Firstname = request.getParameter("Firstname");
		String Lastname = request.getParameter("Lastname");
		String email= request.getParameter("email");
		String mobilenumber = request.getParameter("mobilenumber");
		String Password = request.getParameter("Password");
		String date_of_birth =request.getParameter("date_of_birth");
		
		Registration_Model Model = new Registration_Model();
		
	
		
		Model.setFirstname(Firstname);
		Model.setLastname(Lastname);
		Model.setEmail(email);
		Model.setMobilenumber(mobilenumber);
		Model.setPassword(Password);
		Model.setDate_of_birth(date_of_birth);
		
		System.out.println("successfuully completd model");
		
		System.out.println(Model);
		
		Registration_JDBC jdbc = new Registration_JDBC();
		
		String result = jdbc.Insert(Model);
		
		if(result.equals("success")) {
		    request.setAttribute("message", "Registration successful!");
		    RequestDispatcher rd = request.getRequestDispatcher("Login.html");
		    rd.forward(request, response);
		} else {
		    request.setAttribute("message", "Registration failed!");
		    RequestDispatcher rd = request.getRequestDispatcher("Registration.html");
		    rd.forward(request, response);
		}
		
		
		
	}

}
