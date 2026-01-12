package Services;
import java.util.*;
import model.Student;
//import repository.StudentRepo;
import repository.StudentRepoImpl;

public class StudentServiceImpl implements StudentService {
	StudentRepoImpl str = new StudentRepoImpl();
	
	 
	public int[] showMarks(int rollNo) {
		return ((getStudentByRollNo(rollNo)).getMarks());
	
	}
	
	public double showPercentage(int rollNo) {
		int[] s = getStudentByRollNo(rollNo).getMarks();
		double sum=0;
		for(int stud : s) {
			sum += stud;
		}
		return (double)(sum / 600 * 100);
		
	}
	
	@Override
	public Student searchStudent(int rollNo) {// method returns the roll number 
		ArrayList<Object> students = str.getStudentList();
		 boolean flag = false;
		 Student st= null;
		 for(Object stud : students) {
			 st = (Student)stud;
			 if(st.getRollNo() == rollNo) {
				 flag = true;
			 }
		}
		 return flag ? st : null;
	}
	@Override
	public Student searchStudent(String name) {// overloaded method, returns the first Occurance of name
		// ArrayList<Object> students = str.getStudentList();
		 ArrayList<Object> students = str.getStudentList();
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
	
	 public boolean isAddStudent(Student student) {// to add student in list
		 ArrayList<Object> students = str.getStudentList();
		 boolean flag = false;
		 for(Object stud : students) {
			 Student st = (Student)stud;
			 if(st.getRollNo() == student.getRollNo()) {
				 flag = true;
				 break;
			 }
		}
		 return flag ? false : str.isAddStudent(student);
	 }
	 
	 public boolean isAStudent(int rollNo) { //to check that is that roll number is alloted to any student
		 ArrayList<Object> students = str.getStudentList();
		 boolean flag = false;
		 for(Object stud : students) {
			 Student st = (Student)stud;
			 if(st.getRollNo() == rollNo) {
				 flag = true;
			 }
		}
		 return flag ? flag : false; 
	 }
	 
	 // get student object from arraylist.
	 
	 private Student getStudentByRollNo(int rollNo) {
		 ArrayList<Object> students = str.getStudentList();
		 boolean flag = false;
		 Student st= null;
		 for(Object stud : students) {
			 st = (Student)stud;
			 if(st.getRollNo() == rollNo) {
				 flag = true;
			 }
		}
		 return flag ? st : null;
	 }
	 
	 public void printStudents(){
		 ArrayList<Object> students = str.getStudentList();
		 for(Object stud : students) {
			 Student student = (Student)stud;
			 System.out.println(student.getRollNo()+"\t"+student.getName());
			// System.out.println("hello");
		 }
	 }
	 
	 public ArrayList<Object> getStudentList(){
			return str.getStudentList();
		}
	 public boolean studentSetName(int rollNo, String name) {
		 Student st = getStudentByRollNo(rollNo);
		 st.setName(name);
		return true;
	 }
		
}