package student.DAO;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;


public class StudentConsoleUI {

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
				DAO<Student> studentjdbcDAO = new StudentjdbcDAO();
				
				System.out.println("Enter id : ");
				int id = input.nextInt();
				
				System.out.println("Enter name : ");
				String name = input.next();
				
				System.out.println("Enter email : ");
				String email = input.next();
				
				System.out.println("Enter phoneno : ");
				String phone = input.next();
				
				System.out.println("Enter date of birth : ");
				String dob = input.next();
				
				Student student = new Student(id, name, email, phone, dob);
				
				try {
					if(studentjdbcDAO.save(student)) {
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
				StudentjdbcDAO studentjdbcDAO3 = new StudentjdbcDAO();
				
				System.out.println("Enter id : ");
				int id2 = input.nextInt();
				
				System.out.println("Enter name : ");
				String name2 = input.next();
				
				System.out.println("Enter email : ");
				String email2 = input.next();
				
				System.out.println("Enter phoneno : ");
				String phone2 = input.next();
				
				System.out.println("Enter date of birth : ");
				String dob2 = input.next();
				
				Student student2 = new Student(id2, name2, email2, phone2, dob2);
				
				try {
					if(studentjdbcDAO3.edit(student2)) {
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
				StudentjdbcDAO studentjdbcDAO4 = new StudentjdbcDAO();
				
				System.out.println("Enter id : ");
				int id3 = input.nextInt();
	
				boolean s3=studentjdbcDAO4.delete(id3);
				
				if(s3) {
					System.out.println("Deleted Successfully");
				}	
				else {
					System.out.println("Failed during deletion");
				}
				
				
				break;
			
			case 4:
				System.out.println("Delete operation");
				StudentjdbcDAO studentjdbcDAO2 = new StudentjdbcDAO();
				System.out.println("Enter id : ");
				int id4 = input.nextInt();
				
				System.out.println("Enter name : ");
				String name4 = input.next();
				
				System.out.println("Enter email : ");
				String email4 = input.next();
				
				System.out.println("Enter phoneno : ");
				String phone4 = input.next();
				
				System.out.println("Enter date of birth : ");
				String dob4 = input.next();
				
				Student student4 = new Student(id4, name4, email4, phone4, dob4);
				boolean s4=studentjdbcDAO2.delete(id4);
				
				if(s4) {
					System.out.println(id4+","+name4+","+email4+","+phone4+","+dob4);
					
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
