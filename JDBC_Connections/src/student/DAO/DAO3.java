package student.DAO;

public interface DAO3 <E>
{
	boolean save(E e) throws Exception;
	boolean edit(E e) throws Exception;
	boolean delete(int id) throws Exception;
	Student_exam_table find() throws Exception;
}
