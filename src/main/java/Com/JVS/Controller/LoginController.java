package Com.JVS.Controller;

import jakarta.servlet.RequestDispatcher;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import Com.JVS.DAO_DTO.Login_JDBC;
import Com.JVS.DAO_DTO.Login_Model;


@WebServlet("/Login")
public class LoginController extends HttpServlet {
//	private static final long serialVersionUID = 1L;
	public LoginController() {
        // TODO Auto-generated constructor stub
    }
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email = request.getParameter("email");
		String Password = request.getParameter("Password");
		
		System.out.println(email);
		
		Login_Model Model = new Login_Model();
		
		Model.setEmail(email);
		Model.setPassword(Password);
		System.out.println(Model);
		System.out.println("Model is successfully loadded");
		Login_JDBC jdbc = new Login_JDBC();
		
		String status =jdbc.Enquiry(Model);
		
		if(status.equals("success")) {
			System.out.println("success");
			request.setAttribute("message", "Registration successful!");
		    RequestDispatcher rd = request.getRequestDispatcher("Home.html");
		    rd.forward(request, response);
			
		}else {
			System.out.println("failed");
			 request.setAttribute("message", "Registration failed!");
			    RequestDispatcher rd = request.getRequestDispatcher("Login.html");
			    rd.forward(request, response);
			
		}
		
		
		
	}

}
