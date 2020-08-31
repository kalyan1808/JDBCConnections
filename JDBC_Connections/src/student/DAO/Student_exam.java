package student.DAO;

public class Student_exam 
{
	int id;
	String exam;
	public Student_exam()
	{
		super();
	}
	public Student_exam(int id, String exam)
	{
		super();
		this.id=id;
		this.exam=exam;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getExam() {
		return exam;
	}
	public void setExam(String exam) {
		this.exam = exam;
	}
	@Override
	public String toString()
	{
		return "Student_exam [id=" +id+ "exam= " +exam+ "]";
	}
	public String toCSV()
	{
		return id+","+exam;
	}
}
