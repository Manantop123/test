package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.bean.product;
import com.util.emputil;

public class productdao {
	
	public static void addproduct(product p)
	{
		try
		{
			Connection conn = emputil.createconnConnection();
			String sql = "insert into mx_product(id,product_category,product_name,product_model,product_price,product_image,product_details) values(?,?,?,?,?,?,?)";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, p.getId());
			pst.setString(2, p.getProduct_category());
			pst.setString(3, p.getProduct_name());
			pst.setString(4, p.getProduct_model());
			pst.setInt(5, p.getProduct_price());
			pst.setString(6, p.getProduct_image());
			pst.setString(7, p.getProduct_Details());
			pst.executeUpdate();
		}
		catch(Exception e2)
		{
			e2.printStackTrace();
		}

	}
	public static List<product> getallproduct()
	{
		List<product> l1 = new  ArrayList<product>();
		try
		{
			Connection conn = emputil.createconnConnection();
			String sql ="select * from mx_product";
			PreparedStatement pst = conn.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			
			while(rs.next())
			{
				product p = new product();
				p.setPid(rs.getInt("pid"));
				p.setId(rs.getInt("id"));
				p.setProduct_category(rs.getString("product_category"));
				p.setProduct_name(rs.getString("product_name"));
				p.setProduct_model(rs.getString("product_model"));
				p.setProduct_price(rs.getInt("product_price"));
				p.setProduct_image(rs.getString("product_image"));
				p.setProduct_Details(rs.getString("product_details"));
				l1.add(p);
			}
		}
		catch(Exception e2)
		{
			e2.printStackTrace();
		}
		
		return l1;
	}
	public static product getproductbyid(int pid)
	{
		product p1 = null;
		try
		{
			Connection conn = emputil.createconnConnection();
			String sql ="select * from mx_product where pid=?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, pid);
			ResultSet rs = pst.executeQuery();
			
			if(rs.next())
			{
				p1 = new product();
				p1.setPid(rs.getInt("pid"));
				p1.setId(rs.getInt("id"));
				p1.setProduct_category(rs.getString("product_category"));
				p1.setProduct_name(rs.getString("product_name"));
				p1.setProduct_model(rs.getString("product_model"));
				p1.setProduct_price(rs.getInt("product_price"));
				p1.setProduct_image(rs.getString("product_image"));
				p1.setProduct_Details(rs.getString("product_details"));
			}
		}
		catch(Exception e2)
		{
			e2.printStackTrace();
		}
		return p1;
	}
	public static void editproduct(product p)
	{
		try
		{
			Connection conn = emputil.createconnConnection();
			String sql = "update mx_product set product_category=?,product_name=?,product_model=?,product_price=?,product_Details=? where pid=?";
			PreparedStatement pst = conn.prepareStatement(sql);
			
			pst.setString(1, p.getProduct_category());
			pst.setString(2, p.getProduct_name());
			pst.setString(3, p.getProduct_model());
			pst.setInt(4, p.getProduct_price());
			pst.setString(5, p.getProduct_Details());
			pst.setInt(6, p.getPid());
			pst.executeUpdate();
		}
		catch(Exception e2)
		{
			e2.printStackTrace();
		}

	}
	public static void deleteproduct(int pid)
	{
		try
		{
			Connection conn = emputil.createconnConnection();
			String sql ="delete from mx_product where pid=?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, pid);
			pst.executeUpdate();
		}
		catch(Exception e2)
		{
			e2.printStackTrace();
		}
	}
	public static List<product> getproductbycategory(String product_category)
	{
		List<product> l1 = new  ArrayList<product>();
		try
		{
			Connection conn = emputil.createconnConnection();
			String sql ="select * from mx_product where product_category=?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, product_category);
			ResultSet rs = pst.executeQuery();
			
			while(rs.next())
			{
				product p = new product();
				p.setPid(rs.getInt("pid"));
				p.setId(rs.getInt("id"));
				p.setProduct_category(rs.getString("product_category"));
				p.setProduct_name(rs.getString("product_name"));
				p.setProduct_model(rs.getString("product_model"));
				p.setProduct_price(rs.getInt("product_price"));
				p.setProduct_image(rs.getString("product_image"));
				p.setProduct_Details(rs.getString("product_details"));
				l1.add(p);
			}
		}
		catch(Exception e2)
		{
			e2.printStackTrace();
		}
		
		return l1;
	}
}