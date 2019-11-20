package Quizzes;

import java.util.ArrayList;

// Quiz 7, 8, 9
public class Course {
    private String name, code, instructor;
    private int semOffered, capacity = 500, i = 0;
    private ArrayList<Student> studentsInCourse;

    public Course() {
    }

    public Course(String name, String code, String instructor, int semOffered, int capacity) {
        this.name = name;
        this.code = code;
        this.instructor = instructor;
        this.semOffered = semOffered;
        this.capacity = capacity;
        this.studentsInCourse = new ArrayList<>(this.capacity);
    }

    public Course(String name, String code, String instructor, int semOffered, int capacity, ArrayList<Student> studentsInCourse) {
        this.name = name;
        this.code = code;
        this.instructor = instructor;
        this.semOffered = semOffered;
        this.capacity = capacity;
        this.studentsInCourse = studentsInCourse;
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

    public ArrayList<Student> getStudentsInCourse() {
        return studentsInCourse;
    }

    public void setStudentsInCourse(ArrayList<Student> studentsInCourse) {
        this.studentsInCourse = studentsInCourse;
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
        this.studentsInCourse.add(enrolledStudent);
    }

    public void dropAStudent(Student droppedStudent) {
        for (int j = 0; j < this.capacity; j++) {
            if (droppedStudent == this.studentsInCourse.get(i)) {
                this.studentsInCourse.set(i, null);
                droppedStudent.dropACourse(this);
                break;
            }
        }
    }
}
