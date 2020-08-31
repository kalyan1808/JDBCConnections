package com.dxc.connections.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Demo_01 
{
	public static void main(String[] args)
	{
		String dri="com.mysql.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306/dxc";
		String un="root";
		String pw="root";
		try
		{
			Class.forName(dri);
			Connection con=DriverManager.getConnection(url, un, pw);
			Statement stmt=con.createStatement();
			System.out.println("Connection:"+con);
			System.out.println("Statement:"+stmt);
		}catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
}
