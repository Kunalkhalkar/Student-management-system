package model;
/*Student management System
 * developing a program that help to teachers take attendance of Students, add new Students, assign the subjects to students, 
 * update the marks of Students, Program able to calculate the percentage of students and store it in List, update student details
 * modify by name, teacher modify by name to salary, 
 * */
public class Student {
	private int rollNo;
	private String name;
	private int[] marks;
	
	public Student (int rollNo, String name, int ...marks){
		this.rollNo = rollNo;
		this.name = name;
		this.marks = marks;
	}

	public int getRollNo() {
		return rollNo;
	}

	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int[] getMarks() {
		return marks;
	}

//	public void setMarks(int[] marks) {
//		this.marks = marks;
//	}
//	
}
