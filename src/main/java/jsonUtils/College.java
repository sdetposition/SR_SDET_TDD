package jsonUtils;

import java.util.List;

public class College {
	
	public String school_name;
	public String class_name;
	public List<Students> students;

	public String getSchoolName() {
		return school_name;
	}

	public void setSchoolName(String schoolName) {
		this.school_name = schoolName;
	}

	public String getClassName() {
		return class_name;
	}

	public void setClassName(String className) {
		this.class_name = className;
	}

	public List<Students> getStudents() {
		return students;
	}

	public void setStudents(List<Students> students) {
		this.students = students;
	}

	public String toString() {
		return getSchoolName() + " " + getClassName() + " " + getStudents();
	}

}
