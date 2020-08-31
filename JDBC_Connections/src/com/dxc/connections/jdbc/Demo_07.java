package com.dxc.connections.jdbc;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.Scanner;

public class Demo_07 
{
	public static void main(String []args)
	{
		Scanner sc=new Scanner(System.in);
		int id=sc.nextInt();
		String name=sc.next();
		int sub1=sc.nextInt();
		int sub2=sc.nextInt();
		int sub3=sc.nextInt();
		Properties properties=new Properties();
		try
		{
			properties.load(new FileInputStream("dp.prop"));
			String dri=properties.getProperty("dri");
			String url=properties.getProperty("url");
			String un=properties.getProperty("un");
			String pw=properties.getProperty("pw");
			Connection con=null;
			PreparedStatement stmt=null;
			try
			{	
				Class.forName(dri);
				con=DriverManager.getConnection(url, un, pw);
				String sql="INSERT INTO students "+"(id,name,sub1,sub2,sub3)"+"VALUES(?,?,?,?,?)";
				stmt=con.prepareStatement(sql);
				stmt.setInt(1,id);
				stmt.setString(2, name);
				stmt.setInt(3, sub1);
				stmt.setInt(4, sub2);
				stmt.setInt(5, sub3);
				int n=stmt.executeUpdate();
				if(n==1)
				{
					System.out.println("Inserted successlly");
				}
				else
				{
					System.out.println("Not Inserted");
				}
						
			}
			catch(ClassNotFoundException e)
			{
				e.printStackTrace();
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
			finally 
			{
				try 
				{
					stmt.close();
				}
				catch(SQLException e)
				{
					e.printStackTrace();
				}
				try 
				{
					con.close();
				}
				catch(SQLException e)
				{
					e.printStackTrace();
				}
			}
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
}
