package com.formation.wiki;

import java.sql.Connection;
import java.sql.DriverManager;

import com.mysql.jdbc.exceptions.jdbc4.CommunicationsException;



public class ConnexionManager {

	public static String url = "jdbc:mysql://localhost:3306/wiki";
	public static String user = "root";
	public static String password = "";

	public static Connection getConnexion() {

		Connection con = null;

		try {
			// pr charger le driver
			Class.forName("com.mysql.jdbc.Driver");
			// pr recup une connectioni
			con = DriverManager.getConnection(url, user, password);
//			System.out.println("-----------------------------------------------------------");
//			System.out.println("connect database");
		} 
		
		catch (CommunicationsException e2) {
			System.out.println("pas de xammp");
			}
		
		catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);}
		
//		System.out.println("Opened database successfully");

		return con;
	}

}
