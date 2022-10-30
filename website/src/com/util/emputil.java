package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.*;


public class emputil {
	public static Connection createConnection()
	{
		Connection conn = null;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/newwebsite", "root" , "" );
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
}
