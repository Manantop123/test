package com.swing;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/*
 * swing : is a part of java foundation classes.
 * 			
 * 			it is used to develop desktop application.
 * 
 * AWT : extract window tool kit.
 * 
 * need action listener implement for event handling.
 * 
 * 
 */

public class swingdemo implements ActionListener{
	
	JFrame f;
	JTextField t1,t2,t3,t4,t5;
	JLabel l1,l2,l3,l4,l5;
	JButton b1,b2,b3,b4;
	
	swingdemo()
	{
		f = new JFrame("Employee Regitsration");
		f.setVisible(true);
		f.setSize(350, 500);
		f.setLayout(null);
		f.setResizable(false);
		
		l5 = new JLabel("ID");
		l1 = new JLabel("First Name");
		l2= new JLabel("Last Name");
		l3= new JLabel("Email");
		l4= new JLabel("mobile");
		
		f.add(l5);
		f.add(l1);
		f.add(l2);
		f.add(l3);
		f.add(l4);
		
		t5= new JTextField(20);
		t1= new JTextField(20);
		t2 = new JTextField(20);
		t3= new JTextField(20);
		t4 = new JTextField(20);
		
		f.add(t5);
		f.add(t1);
		f.add(t2);
		f.add(t3);
		f.add(t4);
		
		b1= new JButton("insert");
		b2= new JButton("search");
		b3= new JButton("update");
		b4 = new JButton("delete");
		
		f.add(b1);
		f.add(b2);
		f.add(b3);
		f.add(b4);
		
		l5.setBounds(50, 50, 100,80);
		l1.setBounds(50, 100, 100, 80);
		l2.setBounds(50, 150 , 100, 80);
		l3.setBounds(50, 200, 100, 80);
		l4.setBounds(50,250, 100, 80);
		
		t5.setBounds(150, 80, 150, 25);
		t1.setBounds(150, 130, 150, 25);
		t2.setBounds(150, 180, 150, 25);
		t3.setBounds(150, 230, 150, 25);
		t4.setBounds(150,280, 150, 25);
		
		b1.setBounds(50, 330, 100, 30);
		b2.setBounds(200, 330, 100, 30);
		b3.setBounds(50, 380, 100, 30);
		b4.setBounds(200, 380, 100, 30);
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
	}

	public void actionPerformed(ActionEvent ae) {
	
		if(ae.getSource()==b1)
		{
			//System.out.println("insert clicked");
			try
			{
				Class.forName("com.mysql.jdbc.Driver");
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/swingdemo", "root", "");
				String sql = "insert into employee(fname,lname,email,mobile) values(?,?,?,?)";
				PreparedStatement pst = conn.prepareStatement(sql);
				pst.setString(1, t1.getText());
				pst.setString(2, t2.getText());
				pst.setString(3, t3.getText());
				pst.setString(4, t4.getText());
				pst.executeUpdate();
				
				JOptionPane.showMessageDialog(f, "data inserted succwssfully");
				
				t1.setText("");
				t2.setText("");
				t3.setText("");
				t4.setText("");
			}
			catch(Exception e2)
			{
				e2.printStackTrace();
			}
		}
		else if(ae.getSource()==b2)
		{
			//System.out.println("searched clicked");
			try
			{
				Class.forName("com.mysql.jdbc.Driver");
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/swingdemo", "root","" );
				String sql = "select * from employee where id=?";
				PreparedStatement pst = conn.prepareStatement(sql);
				pst.setInt(1, Integer.parseInt(t5.getText()));
				ResultSet rs = pst.executeQuery();
				
				if(rs.next())
				{
					t1.setText(rs.getString("fname"));
					t2.setText(rs.getString("lname"));
					t3.setText(rs.getString("email"));
					t4.setText(rs.getString("mobile"));
					
				}
				
				JOptionPane.showMessageDialog(f, "data searched succssfully");
				
//				t1.setText("");
//				t2.setText("");
//				t3.setText("");
//				t4.setText("");
			}
			catch(Exception e2)
			{
				e2.printStackTrace();
			}
		}
		else if(ae.getSource()==b3)
		{
			//System.out.println("update clicked");
			try
			{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/swingdemo", "root", "");
			String sql ="update employee set fname=?,lname=?,email=?,mobile=? where id=?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, t1.getText());
			pst.setString(2, t2.getText());
			pst.setString(3, t3.getText());
			pst.setString(4, t4.getText());
			pst.setInt(5, Integer.parseInt(t5.getText()));
			pst.executeUpdate();
			
			JOptionPane.showMessageDialog(f, "data updated successfully");
			
			t5.setText("");
			t1.setText("");
			t2.setText("");
			t3.setText("");
			t4.setText("");
			t5.setText("");
			}
			catch(Exception e2)
			{
				e2.printStackTrace();
			}
		}
		else if(ae.getSource()==b4)
		{
			try
			{
				Class.forName("com.mysql.jdbc.Driver");
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/swingdemo", "root", "");
				String sql ="delete from employee where id =?";
				PreparedStatement pst = conn.prepareStatement(sql);
				pst.setInt(1, Integer.parseInt(t5.getText()));
				pst.executeUpdate();
				
				JOptionPane.showMessageDialog(f, "data deleted successfully");
				
				t5.setText("");
				t1.setText("");
				t2.setText("");
				t3.setText("");
				t4.setText("");
			}
			catch(Exception e2)
			{
				e2.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		new swingdemo();
	}


	
}
