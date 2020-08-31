package student.DAO;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Student_exam_tableConsoleUI 
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
				
				Student_exam_tablejdcDAO student_exam_tablejdbcDAO = new Student_exam_tablejdcDAO();
				
				System.out.println("Enter Student id : ");
				int sid = input.nextInt();
				
				System.out.println("Enter Exam id : ");
				int  eid= input.nextInt();
				
				System.out.println("Enter Sub1 : ");
				int sub1=input.nextInt();
				
				System.out.println("Enter Sub2 : ");
				int sub2 = input.nextInt();
				
				System.out.println("Enter Sub3 : ");
				int sub3 = input.nextInt();
				
				Student_exam_table student_exam_table = new Student_exam_table(sid , eid , sub1, sub2, sub3);
				
				try {
					if(student_exam_tablejdbcDAO.save(student_exam_table)) {
						System.out.println("Saved Successfully");
					}	
					else {
						System.out.println("Failed during save");
					}
				}
				catch(ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				
				
				break;
				
			case 2:
				System.out.println("Edit operation");
				Student_exam_tablejdcDAO student_exam_tablejdbcDAO2 = new Student_exam_tablejdcDAO();
				
				System.out.println("Enter Student id : ");
				int sid2 = input.nextInt();
				
				System.out.println("Enter Exam id : ");
				int  eid2= input.nextInt();
				
				System.out.println("Enter Sub1 : ");
				int sub12=input.nextInt();
				
				System.out.println("Enter Sub2 : ");
				int sub22 = input.nextInt();
				
				System.out.println("Enter Sub3 : ");
				int sub32 = input.nextInt();
				
				Student_exam_table student_exam_table2 = new Student_exam_table(sid2 , eid2 , sub12, sub22, sub32);
				
				try {
					if(student_exam_tablejdbcDAO2.edit(student_exam_table2)) {
						System.out.println("Updated Successfully");
					}	
					else {
						System.out.println("Failed during updation");
					}
				}
				catch(ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				
				
				break;
			
			case 3:
				System.out.println("Delete operation");
				Student_exam_tablejdcDAO student_exam_tablejdbcDAO4 = new Student_exam_tablejdcDAO();
				
				System.out.println("Enter id : ");
				int sid3 = input.nextInt();
	
				boolean s3=student_exam_tablejdbcDAO4.delete(sid3);
				
				if(s3) {
					System.out.println("Deleted Successfully");
				}	
				else {
					System.out.println("Failed during deletion");
				}
				
				
				break;
			
			case 4:
				
				
			case 5:
				System.exit(0);

			default:
				System.out.println("Invalid user option");
				break;
			}
			
		}
		
	}
}
