package students.com.DAO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Properties;

import students.com.Console.DAO;
import students.com.beans.Student;
import students.com.beans.Student_exam;
import students.com.beans.Student_exam_marks;

public class Student_examjdbcDAO implements DAO<Student_exam>
{

	@Override
	public boolean save(Student_exam student_exam) throws Exception 
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
				String sql="INSERT INTO person_exam VALUES(?,?)";
				stmt=con.prepareStatement(sql);
				stmt.setInt(1,student_exam.getId());
				stmt.setString(2, student_exam.getExam());
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
	public boolean edit(Student_exam student_exam) throws Exception 
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
			Statement stmt=null;
			try
			{	
				Class.forName(dri);
				con=DriverManager.getConnection(url, un, pw);
				stmt=con.createStatement();
				String sql="UPDATE person_exam SET exam='sem2' WHERE id="+student_exam.getId();
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
	public boolean delete(int id) throws Exception 
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
			Statement stmt=null;
			try
			{	
				Class.forName(dri);
				con=DriverManager.getConnection(url, un, pw);
				stmt=con.createStatement();
				String sql="DELETE FROM person_exam WHERE id="+id;
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
	public Student_exam find1(int id) throws Exception 
	{
		Student_exam student_exam=null;
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
				String sql="SELECT * FROM person_exam WHERE ID="+id;
				

				rs=stmt.executeQuery(sql);
				if(rs.next())
				{
					String exam=rs.getString(2);
					student_exam=new Student_exam(id,exam);
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
		return student_exam;
	}

	@Override
	public Student find(int id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Student_exam_marks find3(int id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}



}
