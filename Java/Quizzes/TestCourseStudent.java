package Quizzes;

import java.util.Scanner;

// Quiz 10
public class TestCourseStudent {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Course[] courses = new Course[10];

        System.out.println("Input 10 courses, 1 per line, formatted as (space separated): Name Code Instructor SemesterOffered Capacity");
        for (int i = 0; i < courses.length; i++) {
            String[] input = s.nextLine().split(" ");
            courses[i] = new Course(input[0], input[1], input[2], Integer.parseInt(input[3]), Integer.parseInt(input[4]));
        }

        Student[] students = new Student[100];

        System.out.println("Input 100 students, 1 per line, formatted as (space separated): Name DateOfBirth Year");
        for (int i = 0; i < students.length; i++) {
            String[] input = s.nextLine().split(" ");
            students[i] = new Student(input[0], input[1], Integer.parseInt(input[2]));
        }

        for (Student student : students) {
            int maxCoursesPerStudent = 5;

            for (int j = 0; j < courses.length && student.getCoursesTaken().size() < maxCoursesPerStudent; j++)
                if (courses[j].getCapacity() > courses[j].getStudentsInCourse().size()) {
                    courses[j].enrollAStudent(student);
                    student.enrollToACourse(courses[j]);
                }
        }

        for (Course course : courses) {
            System.out.println(course.getName() + ":");

            for (Student student : course.getStudentsInCourse())
                System.out.println(student.getName());

            System.out.println("-----------------------------");
        }
    }
}
