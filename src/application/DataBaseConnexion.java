package application;

import java.sql.*;
import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
import java.sql.SQLException;

public class DataBaseConnexion {
   private static final String USERNAME="root"; 
   private static final String PASSWORD="";
   private static final String HOST="127.0.0.1";
   private static final int PORT=3306;
   private static final String DB_NAME="login_db";
   public  Connection con=null;
   
   public static Connection connexionDB() {
	   try {
		   Class.forName("com.mysql.cj.jdbc.Driver");
		   Connection con=DriverManager.getConnection("jdbc:mysql://"+HOST+":"+PORT+"/"+DB_NAME, USERNAME, PASSWORD);
	       System.out.println("connexion succeed");
		   return con ;
	} catch (ClassNotFoundException | SQLException e) {
		System.out.println("connexion echouee");
		e.printStackTrace();
		return null;
	}
   }

  
}
