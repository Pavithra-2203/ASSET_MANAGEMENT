package com.hexaware.dam.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Utility class for managing database connections.
 * Provides a method to establish a connection to the MySQL database used by the Digital Asset Management system.
 
 * 
 * Note: Ensure that the database URL, username, and password are correct
 * and that the MySQL JDBC driver is included in the classpath.
 * 
 * @author Pavithra
 * @Date 2025-04-20
 */

public class DBConnUtil {

	
	private static final String DB_URL = "jdbc:mysql://localhost:3306/digitalassetmanagement";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "P@vi2203";

  //Establishes and returns a connection to the database.
    
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
    }
	}


