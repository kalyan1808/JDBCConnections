package com.dxc.connections.jdbc;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.Scanner;



public class Demo_06 
{
	public static void main(String []args)
	{
		Scanner sc=new Scanner(System.in);
		int id=sc.nextInt();
		Properties properties=new Properties();
		try
		{
			properties.load(new FileInputStream("dp.prop"));
			String dri=properties.getProperty("dri");
			String url=properties.getProperty("url");
			String un=properties.getProperty("un");
			String pw=properties.getProperty("pw");
			Connection con=null;
			Statement stmt=null;
			ResultSet rs=null;
			try
			{	
				Class.forName(dri);
				con=DriverManager.getConnection(url, un, pw);
				stmt=con.createStatement();
				String sql="SELECT * FROM students WHERE id ="+id;
				rs=stmt.executeQuery(sql);
				if(rs.next())
				{
					String name=rs.getString(2);
					int sub1=rs.getInt(3);
					int sub2=rs.getInt(4);
					int sub3=rs.getInt(5);
					System.out.println(id+" , "+name+" , "+sub1+" , "+sub2+" , "+sub3);			
				}
				else
				{
					System.out.println("Display not Found");
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
					rs.close();
				}
				catch(SQLException e)
				{
					e.printStackTrace();
				}
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
