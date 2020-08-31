package student.DAO;
import java.util.List;
public interface DAO <E> 
{
	boolean save(E e) throws Exception;
	boolean edit(E e) throws Exception;
	boolean delete(int id) throws Exception;
	Student find(int id) throws Exception;
	List<Student> findall() throws Exception;
}
