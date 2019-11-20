package Quizzes;

import java.util.ArrayList;

// Quiz 6, 7, 8, 9
public class Student {
    private String name, dateOfBirth; // Can use Date class
    private int yearInSchool, i = 0;
    private ArrayList<Course> coursesTaken = new ArrayList<>();

    public Student() {
    }

    public Student(String name, String dateOfBirth, int yearInSchool) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.yearInSchool = yearInSchool;
    }

    public Student(String name, String dateOfBirth, int yearInSchool, ArrayList<Course> coursesTaken) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.yearInSchool = yearInSchool;
        this.coursesTaken = coursesTaken;
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

    public ArrayList<Course> getCoursesTaken() {
        return coursesTaken;
    }

    public void setCoursesTaken(ArrayList<Course> coursesTaken) {
        this.coursesTaken = coursesTaken;
    }

    public void enrollToACourse(Course myCourse) {
        this.coursesTaken.add(myCourse);
    }

    public void dropACourse(Course myCourse) {
        for (int j = 0; j < this.coursesTaken.size(); j++) {
            if (myCourse == this.coursesTaken.get(i)) {
                this.coursesTaken.set(i, null);
                myCourse.dropAStudent(this);
                break;
            }
        }
    }
}
