package students.com.DAO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import students.com.Console.DAO;
import students.com.beans.Student;
import students.com.beans.Student_exam;
import students.com.beans.Student_exam_marks;

public class StudentjdbcDAO implements DAO<Student>
{
	public boolean save(Student student) throws Exception
	{
		boolean res=false;
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
				String sql="INSERT INTO PERSON VALUES(?,?,?,?,?)";
				stmt=con.prepareStatement(sql);
				stmt.setInt(1,student.getId());
				stmt.setString(2, student.getName());
				stmt.setString(3, student.getEmail());
				stmt.setString(4, student.getPhone());
				stmt.setDate(5,  new Date(student.getdob().getTime()));
				
				int n=stmt.executeUpdate();
				if(n==1)
				{
					res=true;
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
		return res;
	}

	@Override
	public boolean edit(Student student) throws Exception {
		boolean res=false;
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
			try
			{	
				Class.forName(dri);
				con=DriverManager.getConnection(url, un, pw);
				stmt=con.createStatement();
				String sql="UPDATE PERSON SET email=kk@gmail.com WHERE id="+student.getId();
				int n=stmt.executeUpdate(sql);
				if(n==1)
				{
					res=true;
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
		return res;
	}

	@Override
	public boolean delete(int id) throws Exception {
		boolean res=false;
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
			try
			{	
				Class.forName(dri);
				con=DriverManager.getConnection(url, un, pw);
				stmt=con.createStatement();
				String sql="DELETE FROM PERSON WHERE id="+id;
				int n=stmt.executeUpdate(sql);
				if(n==1)
				{
					res=true;
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
		return res;
	}

	@Override
	public Student find(int id) throws Exception {
		// TODO Auto-generated method stub
		Student student=null;
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
				String sql="SELECT * FROM person WHERE ID="+id;
				
				rs=stmt.executeQuery(sql);
				if(rs.next())
				{
					String name=rs.getString(2);
					String email=rs.getString(3);
					String phoneno=rs.getString(4);
					java.util.Date dd=rs.getDate(5);
					String strdob=new SimpleDateFormat("dd-MM-yyyy").format(dd);
					student=new Student(id,name,email,phoneno,strdob);
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
		return student;
	}
	
	@Override
	public Student_exam find1(int id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Student_exam_marks find3(int id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	
		
}
