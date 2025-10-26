package jsonUtils;

public class Students {

	public String id;
	public String studentName;
	public Grade grade;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public Grade getGrade() {
		return grade;
	}

	public void setGrade(Grade grade) {
		this.grade = grade;
	}

	public String toString() {
		return getId() + " " + getStudentName()+" "+getGrade();
	}

}
