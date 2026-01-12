package repository;
import model.Teacher;
public interface TeacherRepo {
	boolean isATeacher(Teacher teacher);
	boolean isAddTeacher(Teacher teacher);
}
