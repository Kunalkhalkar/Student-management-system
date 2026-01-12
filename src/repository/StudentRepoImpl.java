package repository;
import java.util.*;
import model.*;
//import repository.*;

public class StudentRepoImpl implements StudentRepo {
	
	ArrayList<Object> students = new ArrayList<>();
	
	public boolean isAddStudent(Student student) {
		return students.add(student) ? true : false;
	}
	
	public ArrayList<Object> getStudentList(){
		return this.students;
	}
	
	public Student searchStudent(String name) {// overloaded method, returns the first Occurance of name
		// ArrayList<Object> students = str.getStudentList();
		 boolean flag = false;
		 Student st= null;
		 for(Object stud : students) {
			 st = (Student)stud;
			
			 if(st.getName().equalsIgnoreCase(name)) {
				 flag = true;
			 }
		}
		 return flag ? st : null;
	}	
}

