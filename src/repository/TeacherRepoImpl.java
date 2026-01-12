package repository;
import java.util.*;
import model.Teacher;
public class TeacherRepoImpl implements TeacherRepo {
	ArrayList<Object> teachers = new ArrayList();
	
	public 
	ArrayList<Object> getTeacherList(){
		return teachers;
	}
	public boolean isAddTeacher(Teacher teacher) {
		return teachers.add(teacher);
	}
	
	
	public boolean isATeacher(Teacher teacher) {
		boolean flag = false;
		Teacher t = null;
		for(Object o : teachers) {
			int tid = ((Teacher)o).getId();
			if(tid == teacher.getId()) {
				flag = true;
				break;
			}
		}
		return flag ? false: flag;
	}
	
}
