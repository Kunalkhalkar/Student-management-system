package main;
import java.util.*;

import Services.TeacherServiceImpl;
import model.*;
import Services.StudentServiceImpl;
public class StudentApp {

	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StudentServiceImpl ss = new StudentServiceImpl();// student service 
		TeacherServiceImpl ts = new TeacherServiceImpl();// teacher service
		Student student1 = new Student(1, "kunal", 10, 20, 30, 40, 50, 60);
		ss.isAddStudent(student1);
		Student student2 = new Student(2, "yash", 10, 20, 30, 40, 50, 60);
		ss.isAddStudent(student2);
		Student student3 = new Student(3, "pravin", 10, 20, 30, 40, 50, 60);
		ss.isAddStudent(student3);
		Student student4 = new Student(4, "swapnil", 100, 20, 30, 40, 50, 60);
		ss.isAddStudent(student4);
		
		Teacher teacher5 = new Teacher(101, "harshit");
		ts.isAddTeacher(teacher5);
		Teacher teacher2 = new Teacher(102, "gaurav");
		ts.isAddTeacher(teacher2);
		Teacher teacher3 = new Teacher(103, "ganesh");
		ts.isAddTeacher(teacher3);
		Teacher teacher4 = new Teacher(104, "gorakh");
		ts.isAddTeacher(teacher4);
		/*added initial teacher and students to avoid testing related problems
		 * */
		do {
		System.out.println("1.add student\n"
				+ "2. add teacher\n"
				+ "3. view marks of student\n"
				+ "4. view percentage of student\n"
				+ "5. searh student by name\n"
				+ "6. search student by roll number\n"
				+ "7. show all Students\n"
				+ "8. show all teachers\n"
				+ "9. Search teacher By id\n"
				+ "10. edit Student name By roll Number\n"
				+ "11. edit Teacher name By ID\n"
				+ "12. EXIT\n");
		System.out.println("Enter the choice");
		int ch = sc.nextInt();
		if(ch == 12) {//if user wants to exit 
			System.out.println("exiting");
			break;
			}else {
		switch(ch) {
		case 1:
			System.out.println("Enter your teacher id");
			int tid = sc.nextInt();
			// add if else here
			if(ts.isATeacher(tid)) {
			System.out.println("Enter the roll number, name, marks of 6 subject of student");
			int rollNo= sc.nextInt();
			String name = sc.next();
			int[] marks  = new int[6];
			for(int i= 0; i<marks.length; i++) {
				marks[i] = sc.nextInt();
				//System.out.println(mark);
			}
			Student student = new Student(rollNo, name, marks);
			boolean flag = ss.isAddStudent(student);
			String msg = flag ? "Student Added" : "Student not added";
			System.out.println(msg);
			}
			else {
				System.out.println("You Are Not A Teacher");
			}
		break;
			
		case 2:
			System.out.println("Enter the Id, name of teacher");
			int id= sc.nextInt();
			String tname =sc.next();
			Teacher teacher = new Teacher(id, tname);
			boolean flag = ts.isAddTeacher(teacher); // returns true if teacher is not already present in list
			if(flag) {
				System.out.println("Teacher is Added");
				}
			else {
				System.out.println("!! Teacher is Not added !!");
			}
			
		break;
		
		case 3:
			System.out.println("Enter the id of student");
			int rollNo = sc.nextInt();
			 flag = ss.isAStudent(rollNo);
			if(flag) {
				System.out.println("marks of roll no: "+ rollNo );
				int mark[] = ss.showMarks(rollNo);
				for(int mrk : mark) {
					System.out.printf("%d \t",mrk);
				}
				System.out.println();
			}
			else {
				System.out.println("student not found");
			}
		break;
		
		case 4:
			System.out.println("Enter the roll number of student");
			rollNo = sc.nextInt();
			if(ss.isAStudent(rollNo)) {
			double percentage = ss.showPercentage(rollNo);
			System.out.println("percentage of student "+ rollNo+ " is : \n"+percentage+"%");
			}
			else {
				System.out.println("Student not found");
			}
		break;
		
		case 5:
			System.out.println("Enter the name of Student");
			String name= sc.next();
			Student std = ss.searchStudent(name);
			if(std != null) {
				System.out.println("Roll no.\t"
						+ "name\t"
						+ "percentage");
				System.out.println(std.getRollNo()+"\t "+std.getName()+"\t "+ss.showPercentage(std.getRollNo())+"%");
			}else {
				System.out.println("Student name not found");
			}
		break;
		
		case 6:
			System.out.println("Enter the roll number of student");
			rollNo = sc.nextInt();
			flag= ss.isAStudent(rollNo);
			if(flag) {
				std =ss.searchStudent(rollNo);
				System.out.println("Roll no.\t"
						+ "name\t"
						+ "percentage");
				System.out.println(std.getRollNo()+"\t "+std.getName()+"\t "+ss.showPercentage(std.getRollNo())+"%");
			}
			else {
				System.out.println("roll number not found");
			}
		break;
			
		case 7:
			ArrayList<Object> students = ss.getStudentList();
			System.out.println("Roll no.\t "
					+ "name \t\t"
					+ "percentage");
			for(Object stud : students) {
				std = (Student)stud;
				System.out.println(std.getRollNo()+"\t\t "+std.getName()+"\t\t"+ss.showPercentage(std.getRollNo())+"%");
			}
		break;	
		
		case 8:
			ArrayList<Object> teachers = ts.getTeacherList();
			if(teachers.size() == 0) {
				System.out.println("No Teacher Found");
			}
			else {
				System.out.println("id\tName");
			for(Object tr : teachers) {
				Teacher ter = (Teacher)tr;
				
				System.out.println(ter.getId() +"\t " +ter.getName());
			}
			}
		break;
		case 9:
			System.out.println("Enter the id of teacher");
			tid= sc.nextInt();
			Object teacher1 = ts.getTeacherById(tid);
			if(teacher1 == null) {
				System.out.println("Teacher Not Found");
				break;
			}
			System.out.println("id\tName");
			System.out.println(((Teacher) (teacher1)).getId() + "\t "+ ((Teacher) (teacher1)).getName());
			break;
			
		case 10:
			System.out.println("Enter your teacher id");
			tid = sc.nextInt();
			if(ts.isATeacher(tid)) {
			System.out.println("Enter the roll number of Student");
			rollNo = sc.nextInt();
			if(ss.isAStudent(rollNo)) {//outer if condition
				System.out.println("Enter the new name of Student");
				name = sc.next();
				flag = ss.studentSetName(rollNo, name);
				if(flag) {//inner if condition
					System.out.println("Student name updated with "+name);
				}
				else {
					System.out.println("Student not updated");
				}
			}
			else {
				System.out.println("Student id is Not found");
			}
			}
			else {
				System.out.println("you are not a teacher");
				break;
			}
			
			break;
			
		case 11:
			System.out.println("Enter the ID of Teacher");
			id = sc.nextInt();
			if(ts.isATeacher(id)) {
				System.out.println("Enter the name of teacher");
				name = sc.next();
				flag = ts.setNameTeacher(id, name);
				if(flag) {
					System.out.println("Teacher name changed with "+name);
				}
				else {
					System.out.println("Teacher name Not changed");
				}
		}
			else {
				System.out.println("Teacher id Not Found");
			}
			
		break;
			
		default:
			System.out.println("Wrong choice");
				}
			}
		}
		while(true);
	}

}
