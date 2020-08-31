package student.DAO;

public interface DAO2 <E>
{
	boolean save(E e) throws Exception;
	boolean edit(E e) throws Exception;
	boolean delete(int id) throws Exception;
	Student_exam find(int id) throws Exception;
}
