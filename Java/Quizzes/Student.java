package Quizzes;

// Quiz 6, 7 & 8
public class Student {
	private String name, dateOfBirth; // Can use Date class
	private int yearInSchool, i = 0;
	private Course[] coursesTaken;

	public Student() {
		this.coursesTaken = new Course[10];
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

	public Course[] getCoursesTaken() {
		return coursesTaken;
	}

	public void setCoursesTaken(Course[] coursesTaken) {
		this.coursesTaken = coursesTaken;
	}

	public void enrollToACourse(Course myCourse) {
		this.coursesTaken[i++] = myCourse;
	}

	public void dropACourse(Course myCourse) {
		for (int j = 0; j < this.coursesTaken.length; j++) {
			if (myCourse == this.coursesTaken[i]) {
				this.coursesTaken[i] = null;
				myCourse.dropAStudent(this);
				break;
			}
		}
	}
}
