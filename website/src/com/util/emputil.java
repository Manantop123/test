package com.util;

import java.sql.DriverManager;
import java.util.*;

import com.mysql.jdbc.Connection;

public class emputil {
	public static Connection createConnection()
	{
		Connection conn = null;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/newwebsite", "root","");
		}
		catch (Exception e2) {
			e2.printStackTrace();
		}
		return conn;
	}
}
