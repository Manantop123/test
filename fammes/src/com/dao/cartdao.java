package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.bean.cartbean;
import com.bean.wishlist;
import com.util.emputil;

public class cartdao {
	public static void getalldetails(cartbean c1)
	{
		try
		{
		Connection conn = emputil.createconnConnection();
		String sql = "insert into cart(pid,id,pqty,price,total_price) values(?,?,?,?,?)";
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setInt(1,c1.getPid() );
		pst.setInt(2, c1.getId());
		pst.setInt(3, c1.getPqty());
		pst.setInt(4, c1.getPrice());
		pst.setInt(5, c1.getPrice());
		pst.executeUpdate();
		}
		catch(Exception e2)
		{
			e2.printStackTrace();
		}
	}
	public static List<cartbean>  getalluser(int id)
	{
		List<cartbean> list =new  ArrayList<cartbean>();
		try
		{
			Connection conn = emputil.createconnConnection();
			String sql = "select * from cart where id =?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			
			while(rs.next())
			{
				cartbean c = new cartbean();
				c.setCid(rs.getInt("cid"));
				c.setPid(rs.getInt("pid"));
				c.setId(rs.getInt("id"));
				c.setPqty(rs.getInt("pqty"));
				c.setPrice(rs.getInt("price"));
				c.setTotal_price(rs.getInt("total_price"));
				list.add(c);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	public static boolean checkcartlist(int pid, int id)
	{
		boolean flag = false;
		try
		{
			Connection conn = emputil.createconnConnection();
			String sql = "select * from wishlist where pid=? ,id=?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, pid);
			pst.setInt(2, id);
			ResultSet rs = pst.executeQuery();
			
			if(rs.next())
			{
				flag = true;
			}
		}
		catch(Exception e2)
		{
			e2.printStackTrace();
		}
		return flag;
	}
	public static void removecart(cartbean c)
	{
		try
		{
			Connection conn = emputil.createconnConnection();
			String sql ="delete from cart where pid=? and id=?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, c.getPid());
			pst.setInt(2, c.getId());
			pst.executeUpdate();
		}
		catch(Exception e2)
		{
			e2.printStackTrace();
		}
	}
}
