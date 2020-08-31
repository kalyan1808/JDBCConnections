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
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Properties;

import students.com.Console.DAO;
import students.com.beans.Student;
import students.com.beans.Student_exam;
import students.com.beans.Student_exam_marks;

public class Student_exam_marksjdbcDAO implements DAO<Student_exam_marks>{

	Student s=new Student();
	Student_exam se=new Student_exam();
	@Override
	public boolean save(Student_exam_marks student_exam_marks) throws Exception 
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
				String sql="INSERT INTO person_exam_table VALUES(?,?,?,?,?)";
				stmt=con.prepareStatement(sql);
				stmt.setInt(1,student_exam_marks.getSid());
				stmt.setInt(2, student_exam_marks.getEid());
				stmt.setInt(3, student_exam_marks.getSub1());
				stmt.setInt(4, student_exam_marks.getSub2());
				stmt.setInt(5, student_exam_marks.getSub3());
				
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
	public boolean edit(Student_exam_marks student_exam_marks) throws Exception {
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
				String sql="UPDATE person_exam_table SET sub1='98' WHERE id="+student_exam_marks.getSid();
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
				String sql="DELETE FROM person_exam_table WHERE id="+id;
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
	public Student_exam_marks find3(int id) throws Exception {
		Student_exam_marks student_exam_marks=null;
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
				String sql="SELECT * FROM person_exam_table WHERE ID="+id;
				
				

				rs=stmt.executeQuery(sql);
				if(rs.next())
				{
					int sid=rs.getInt(1);
					int eid=rs.getInt(2);
					int sub1=rs.getInt(3);
					int sub2=rs.getInt(4);
					int sub3=rs.getInt(5);
					student_exam_marks=new Student_exam_marks(sid,eid,sub1,sub2,sub3);
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
		return student_exam_marks;
		
	}
	@Override
	public Student find(int id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Student_exam find1(int id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}



	

}
