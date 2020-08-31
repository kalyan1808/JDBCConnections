package student.DAO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;


public class DisplayAllStudents {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		FileInputStream fis;
		System.out.println("Welcome\nList of Students!!!");
		try {
			fis = new FileInputStream("dp.prop");
			ObjectInputStream ois = new ObjectInputStream(fis);
			
			while(fis.available() > 0) {
				Student student = (Student)ois.readObject();
				System.out.println(student);
			}
			
			ois.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("End of the program!!!");
		

	}

}
