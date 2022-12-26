package com.dao;

import java.util.*;

import javax.swing.text.StyledEditorKit.BoldAction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.bean.wishlist;
import com.util.emputil;

public class wishlistdao {
	public static void getalldetails(wishlist w1)
	{
		try
		{
		Connection conn = emputil.createconnConnection();
		String sql = "insert into wishlist(pid,id) values(?,?)";
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setInt(1,w1.getPid() );
		pst.setInt(2, w1.getId());
		pst.executeUpdate();
		}
		catch(Exception e2)
		{
			e2.printStackTrace();
		}
	}
	public static List<wishlist> getemployeebyusre(int id)
	{
		List<wishlist> list = new ArrayList<wishlist>();
		try
		{
			Connection conn = emputil.createconnConnection();
			String sql ="select * from wishlist where id =?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			
			while(rs.next())
			{
				wishlist w = new wishlist();
				w.setWid(rs.getInt("wid"));
				w.setPid(rs.getInt("pid"));
				w.setId(rs.getInt("id"));
				list.add(w);
			}
		}
		catch(Exception e2)
		{
			e2.printStackTrace();
		}
		return list;
	}
	public static boolean checkwishlist(int pid, int id)
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
	public static void removelist(wishlist w)
	{
		try
		{
		Connection conn = emputil.createconnConnection();
		String sql = "delete from wishlist where pid=? and id=?";
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setInt(1, w.getPid());
		pst.setInt(2, w.getId());
		pst.executeUpdate();
		}
		catch(Exception e2)
		{
			e2.printStackTrace();
		}
	}
	public static boolean checklist(int pid, int id)
	{
		boolean flag = false;
		try
		{
			Connection conn = emputil.createconnConnection();
			String sql ="select * from cart where pid=? and id=?";
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
}

