package students.com.ConsoleUI;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

import students.com.Console.DAO;
import students.com.DAO.Student_examjdbcDAO;
import students.com.DAO.StudentjdbcDAO;
import students.com.beans.Student;
import students.com.beans.Student_exam;

public class Student_examConsoleUI 
{
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		Scanner input = new Scanner(System.in);
		int choice = 0;
		
		while(choice != 5) {
			System.out.println("1. Save Student");
			System.out.println("2. Edit Existing student");
			System.out.println("3. Delete Student");
			System.out.println("4. Display Student");
			System.out.println("\n5. Exit");
			System.out.println();
			System.out.print("Enter your option : ");
			choice = input.nextInt();
			
			switch (choice) {
			case 1:
				System.out.println("Save operation");
				DAO<Student_exam> student_examjdbcDAO = new Student_examjdbcDAO();
				
				System.out.println("Enter id : ");
				int id = input.nextInt();
				
				System.out.println("Enter exam : ");
				String exam = input.next();
				
				Student_exam student_exam = new Student_exam(id, exam);
				
				try {
					if(student_examjdbcDAO.save(student_exam)) {
						System.out.println("Saved Successfully");
					}	
					else {
						System.out.println("Failed during save");
					}
				}
				catch(ClassNotFoundException e) {
					e.printStackTrace();
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				
				
				break;
				
			case 2:
				System.out.println("Edit operation");
				Student_examjdbcDAO student_examjdbcDAO3 = new Student_examjdbcDAO();
				
				System.out.println("Enter id : ");
				int id2 = input.nextInt();
				
				System.out.println("Enter exam : ");
				String exam2 = input.next();
				
				Student_exam student_exam2 = new Student_exam(id2, exam2);
				
				try {
					if(student_examjdbcDAO3.edit(student_exam2)) {
						System.out.println("Updated Successfully");
					}	
					else {
						System.out.println("Failed during Updation");
					}
				}
				catch(ClassNotFoundException e) {
					e.printStackTrace();
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				
				
				break;
			
			case 3:
				System.out.println("Delete operation");
				Student_examjdbcDAO student_examjdbcDAO4 = new Student_examjdbcDAO();
				
				System.out.println("Enter id : ");
				int id3 = input.nextInt();
	
				boolean s3=student_examjdbcDAO4.delete(id3);
				
				if(s3) {
					System.out.println("Deleted Successfully");
				}	
				else {
					System.out.println("Failed during deletion");
				}
				
				
				break;
			
			case 4:
				System.out.println("Display operation");
				System.out.println("Enter exam id to find : ");
				int findId = input.nextInt();
				try {
					
					Student_examjdbcDAO student_examDAO2 = new Student_examjdbcDAO();
					Student_exam s = student_examDAO2.find1(findId);
					
					if(s != null) {
						System.out.println("Exam id Found : ");
						System.out.println(s);
					}
					else {
						System.out.println("Exam ID not found with id : "+findId);
					}
				}
				catch(ClassNotFoundException e) {
					e.printStackTrace();
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
				
			case 5:
				System.exit(0);

			default:
				System.out.println("Invalid user option");
				break;
			}
			
		}
		
	}
}