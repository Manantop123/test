package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;

import com.bean.signup;
import com.util.emputil;

public class signupdao {
	public static void insertsignup(signup s1)
	{
		try
		{
			Connection conn = emputil.createconnConnection();
			String sql = "insert into mx_signup(fname,email,mobile,address,psw,cpsw,gender,usertype) values(?,?,?,?,?,?,?,?)";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, s1.getFname());
			pst.setString(2, s1.getEmail());
			pst.setLong(3, s1.getMobile());
			pst.setString(4, s1.getAddress());
			pst.setString(5, s1.getPsw());
			pst.setString(6, s1.getCpsw());
			pst.setString(7, s1.getGender());
			pst.setString(8, s1.getUsertype());
			pst.executeUpdate();
		}
		catch(Exception e2)
		{
			e2.printStackTrace();
		}
	}
		public static boolean checkemail(String email)
		{
			boolean flag = false;
			try
			{
				Connection conn = emputil.createconnConnection();
				String sql ="select * from mx_signup where email=?";
				PreparedStatement pst = conn.prepareStatement(sql);
				pst.setString(1, email);
				ResultSet rs = pst.executeQuery();
				
				if(rs.next())
				{
					flag =true;
				}
			}
			catch(Exception e2)
			{
				e2.printStackTrace();
			}
			return flag;
		}
	public static signup loginmail(String email, String psw)
	{
		signup s1 = null;
		try
		{
			Connection conn = emputil.createconnConnection();
			String sql ="select * from mx_signup where email=? and psw=?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, email);
			pst.setString(2, psw);
			ResultSet rs = pst.executeQuery();
			
			while(rs.next())
			{
				s1 = new signup();
				s1.setId(rs.getInt("id"));
				s1.setFname(rs.getString("fname"));
				s1.setEmail(rs.getString("email"));
				s1.setMobile(rs.getLong("mobile"));
				s1.setPsw(rs.getString("psw"));
				s1.setCpsw(rs.getString("cpsw"));
				s1.setAddress(rs.getString("address"));
				s1.setGender(rs.getString("gender"));
				s1.setUsertype(rs.getString("usertype"));
			}
		}
		catch(Exception e2)
		{
			e2.printStackTrace();
		}
		return s1;
	}
	public static void changepsw(String email, String psw)
	{
		try
		{
			Connection conn = emputil.createconnConnection();
			String sql ="update mx_signup set psw=? where email=?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, psw);
			pst.setString(2, email);
			pst.executeUpdate();
		}
		catch(Exception e2)
		{
			e2.printStackTrace();
		}
	}
	public static void updateform(signup s1)
	{
		try
		{
			Connection conn = emputil.createconnConnection();
			String sql = "update mx_signup set fname=? , mobile=? , address=? where email=?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, s1.getFname());
			pst.setLong(2, s1.getMobile());
			pst.setString(3, s1.getAddress());
			pst.setString(4, s1.getEmail());
			pst.executeUpdate();
			
		}
		catch(Exception e2)
		{
			e2.printStackTrace();
		}
	}
}
