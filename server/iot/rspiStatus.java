package iot;

import java.sql.*;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.jdbc.PreparedStatement;

public class rspiStatus {
	Connection con = null;
	 Statement st = null;
	 ResultSet rs = null;  
	 public void rpiStatus(String status){
		 String JDBC_DRIVER = "com.mysql.jdbc.Driver"; 
	     String url = "jdbc:mysql://localhost/student";
	     String user = "root";
	     String password = "";
	     String cons=status;

	     try {
	         Class.forName("com.mysql.jdbc.Driver");
	         //ystem.out.println("Connecting to database...");
	         con = DriverManager.getConnection(url, user, password);
	        // System.out.println("Creating statement...");
	         
	         String query="update login set status= ? where user_name='abc';";
	         PreparedStatement preparedstmt=(PreparedStatement) con.prepareStatement(query);
	         preparedstmt.setString(1, status);
	         preparedstmt.executeUpdate();
	         
	         	 }
	     catch(Exception e){
	     	e.printStackTrace();
	     	System.out.println("Error: unable to load driver class!");
	     }
	     
	     
	 }
}
