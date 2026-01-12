package Services;
import model.Student;
import repository.*;
public interface StudentService {
	
	Student searchStudent(int id);
	Student searchStudent(String name);
	int[] showMarks(int rollNo);
	double showPercentage(int rollNo);
	boolean isAddStudent(Student student);
}
