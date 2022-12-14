package com.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.bean.employee;
import com.util.emputil;

public class empdao {
	public static void insertemployee(employee e1)
	{
		try
		{
			Connection conn = emputil.createConnection();
			String sql ="insert into employee(fname,gender,mobile,email,password) values(?,?,?,?,?)";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, e1.getFname());
			pst.setString(2, e1.getGender());
			pst.setLong(3, e1.getMobile());
			pst.setString(4, e1.getEmail());
			pst.setString(5, e1.getPassword());
			pst.executeUpdate();
		}
		catch(Exception e2)
		{
			e2.printStackTrace();
		}
	}
	public static List<employee> getemp()
	{
		List<employee> list = new ArrayList<employee>();
		try
		{
			Connection conn = emputil.createConnection();
			String sql ="select * from employee";
			PreparedStatement pst = conn.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			
			while(rs.next())
			{
				employee e1 = new employee();
				e1.setId(rs.getInt("id"));
				e1.setFname(rs.getString("fname"));
				e1.setGender(rs.getString("gender"));
				e1.setMobile(rs.getLong("mobile"));
				e1.setEmail(rs.getString("email"));
				e1.setPassword(rs.getString("password"));
				list.add(e1);
			}
			
			
		}
		catch(Exception e2)
		{
			e2.printStackTrace();
		}
		return list;
	}
	public static employee getbyid(int id)
	{
		employee e = null;
		try
		{
			Connection conn = emputil.createConnection();
			String sql = "select * from employee where id=?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			
			if(rs.next())
			{
				e=new employee();
				e.setId(rs.getInt("id"));
				e.setFname(rs.getString("fname"));
				e.setGender(rs.getString("gender"));
				e.setMobile(rs.getLong("mobile"));
				e.setEmail(rs.getString("email"));
			}
		}
		catch(Exception e2)
		{
			e2.printStackTrace();
		}
		return e;
	}
	public static void updateemployee(employee e2)
	{
		try
		{
			Connection conn = emputil.createConnection();
			String sql ="update employee set fname=?,gender=?,mobile=?,email=?,password=? where id=?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, e2.getFname());
			pst.setString(2, e2.getGender());
			pst.setLong(3, e2.getMobile());
			pst.setString(4, e2.getEmail());
			pst.setString(5, e2.getPassword());
			pst.setInt(6, e2.getId());
			pst.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public static void deleteemployee(int id)
	{
		try
		{
			Connection conn = emputil.createConnection();
			String sql ="delete from employee where id=?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, id);
			pst.executeUpdate();
		}
		catch(Exception e2)
		{
			e2.printStackTrace();
		}
	}
}


