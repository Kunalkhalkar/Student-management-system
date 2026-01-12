package Services;
import java.util.ArrayList;
import model.Teacher;
import repository.TeacherRepoImpl;

public class TeacherServiceImpl implements TeacherService {
	TeacherRepoImpl tri = new TeacherRepoImpl();
	ArrayList<Object> teacher = tri.getTeacherList();
	@Override
	public void searchById(int id) {
		Teacher teacher = this.getTeacherById(id);
		if(teacher != null) {
			System.out.println("Teacher found\n"
					+ teacher.getId()
					+ teacher.getName()
					);
		}
		else {
			System.out.println("Teacher Not Found");
		}
	}

	@Override
	public ArrayList<Object> getTeacherList() {
		return tri.getTeacherList();
	}
	
	public boolean isAddTeacher(Teacher teacher) {
		boolean flag = isATeacher(teacher.getId());
		return flag ? false : tri.isAddTeacher(teacher);
	}
	
	public Teacher getTeacherById(int id) {
		Teacher tr = null;
		boolean flag = false;
		for(Object teachers : teacher) {
			tr = (Teacher)teachers;
			if(((Teacher) tr).getId() == id) {
				flag =true;
				break;
			}
		}
		return flag ? tr: null;
	}
	
	public boolean isATeacher(int id) {
		
		boolean flag = false;
		Teacher t = null;
		for(Object o : teacher) {
			int tid = ((Teacher)o).getId();
			if(tid == id) {
				flag = true;
				break;
			}
		}
		return flag ? flag: false;
	}
	
	
	public boolean setNameTeacher(int id, String name) {
		Teacher tr = getTeacherById(id);
		boolean flag = false;
		if( tr != null) {
			flag = true;
			tr.setName(name);
		}else {
			System.out.println("Teacher id not found");
		}
		return flag;
	} 
	

}
