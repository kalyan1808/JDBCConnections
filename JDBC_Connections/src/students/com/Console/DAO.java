package students.com.Console;





import students.com.beans.Student;
import students.com.beans.Student_exam;
import students.com.beans.Student_exam_marks;

public interface DAO <E>
{
	boolean save(E e) throws Exception;
	boolean edit(E e) throws Exception;
	boolean delete(int id) throws Exception;
	Student find(int id) throws Exception;
	Student_exam find1(int id) throws Exception;
	Student_exam_marks find3(int id) throws Exception;
}
