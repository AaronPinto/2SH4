package Quizzes;

// Quiz 7, 8
public class Course {
	private String name, code, instructor;
	private int semOffered, capacity = 500, i = 0;
	private Student[] studentsInCourse;

	public Course() {
		this.studentsInCourse = new Student[capacity];
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getInstructor() {
		return instructor;
	}

	public void setInstructor(String instructor) {
		this.instructor = instructor;
	}

	public int getSemOffered() {
		return semOffered;
	}

	public void setSemOffered(int semOffered) {
		this.semOffered = semOffered;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public void enrollAStudent(Student enrolledStudent) {
		this.studentsInCourse[i++] = enrolledStudent;
	}

	public void dropAStudent(Student enrolledStudent) {
		for (int j = 0; j < this.capacity; j++) {
			if (enrolledStudent == this.studentsInCourse[i]) {
				this.studentsInCourse[i] = null;
				enrolledStudent.dropACourse(this);
				break;
			}
		}
	}
}
