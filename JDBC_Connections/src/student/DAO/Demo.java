package student.DAO;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class Demo 
{
	public static void main(String []args)
	{
		Properties properties=new Properties();
		properties.setProperty("dri","com.mysql.jdbc.Driver");
		properties.setProperty("url","jdbc:mysql://localhost:3306/queries");
		properties.setProperty("un","root");
		properties.setProperty("pw","root");
		try
		{
			properties.store(new FileOutputStream("dp1.prop"), "Regular properties to run JDBC Application");
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
