package com.dxc.connections.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Demo_02 
{
	public static void main(String []args) throws SQLException
	{
		String dri="com.mysql.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306/queries";
		String un="root";
		String pw="root";
		Connection con=null;
		Statement stmt=null;
		ResultSet rs=null;
		try
		{
			Class.forName(dri);
			con=DriverManager.getConnection(url, un, pw);
			stmt=con.createStatement();
			String sql="SELECT * FROM students";
			rs=stmt.executeQuery(sql);
			while(rs.next())
			{
				int id=rs.getInt(1);
				String name=rs.getString(2);
				int sub1=rs.getInt(3);
				int sub2=rs.getInt(4);
				int sub3=rs.getInt(5);
				System.out.println("ID.No   Name   Sub1    Sub2    Sub3");
				System.out.println(+id+"   "+name+"   "+sub1+"   "+sub2+"   "+sub3);
				System.out.println("-----------------------------------------");
				System.out.println("ID.No   Name   Sub1    Sub2    Sub3    total");
				System.out.println(+id+"   "+name+"    "+sub1+"    "+sub2+"    "+sub3+"    "+(sub1+sub2+sub3));
				System.out.println("-----------------------------------------");
				if(sub1<35||sub2<35||sub3<35)
				{
					System.out.println("ID.No   Name    total");
					System.out.println(+id+ "   "+name+   "  Fail");
				}
				else
				{
					System.out.println("ID.No   Name    total");
					System.out.println(+id+ "   "+name+ "  Pass");
					System.out.println("--------------------------------------");
				}
			}
			
		}catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally {
			try {
			rs.close();}catch(SQLException e)
			{
				e.printStackTrace();
			}
			try {
				stmt.close();}catch(SQLException e)
				{
					e.printStackTrace();
				}
			try {
				con.close();}catch(SQLException e)
				{
					e.printStackTrace();
				}
		}
	}
}
