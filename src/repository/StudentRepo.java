package repository;
import model.Student;
import java.util.*;

public interface StudentRepo {
	boolean isAddStudent(Student student); // checks the student is present in db if not returns true and add it.
	ArrayList<Object> getStudentList(); // returns the list of students 
	//double getPercentage(int id); // returns the percentage of specified student 
	
}
