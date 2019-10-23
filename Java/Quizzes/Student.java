package Quizzes;

// Quiz 6
public class Student {
	private String name;
	private String dateOfBirth; // Can use Date class
	private int yearInSchool;
	private String[] coursesTaken;

	public Student() {

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public int getYearInSchool() {
		return yearInSchool;
	}

	public void setYearInSchool(int yearInSchool) {
		this.yearInSchool = yearInSchool;
	}

	public String[] getCoursesTaken() {
		return coursesTaken;
	}

	public void setCoursesTaken(String[] coursesTaken) {
		this.coursesTaken = coursesTaken;
	}
}
