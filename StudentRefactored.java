import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentGradeCalculator {

    public static void RunStudentGradeCalculator(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of students: ");
        int numberOfStudents = scanner.nextInt();

        List<Student> students = getStudentData(scanner, numberOfStudents);

        double average = calculateAverage(students);

        displayStudentGrades(students, average);
    }

    // Collect student data (name and grade)
    private static List<Student> getStudentData(Scanner scanner, int numberOfStudents) {
        List<Student> students = new ArrayList<>();
        for (int i = 0; i < numberOfStudents; i++) {
            students.add(createStudent(scanner, i + 1));
        }
        return students;
    }

    // Create a student object from user input
    private static Student createStudent(Scanner scanner, int studentIndex) {
        System.out.print("Enter the name of student " + studentIndex + ": ");
        String name = scanner.next();
        System.out.print("Enter the grade of student " + studentIndex + ": ");
        double grade = scanner.nextDouble();
        return new Student(name, grade);
    }

    // Calculate the average grade from a list of students
    private static double calculateAverage(List<Student> students) {
        double total = 0.0;
        for (Student student : students) {
            total += student.getGrade();
        }
        return total / students.size();
    }

    // Display the student grades and average
    private static void displayStudentGrades(List<Student> students, double average) {
        System.out.println("\nStudent Grade Report:");
        for (Student student : students) {
            System.out.println(student.getName() + ": " + student.getGrade());
        }
        System.out.println("\nAverage Grade: " + average);
    }

    // Helper class to store student data
    static class Student {
        private String name;
        private double grade;

        public Student(String name, double grade) {
            this.name = name;
            this.grade = grade;
        }

        public String getName() {
            return name;
        }

        public double getGrade() {
            return grade;
        }
    }
}
