package Com.JVS.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;


public class JDBC_Driver {

    private static final String URL = "jdbc:mysql://localhost:3306/JVS_Rentals";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    public static Connection getConnection() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }

	
}

