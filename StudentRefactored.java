import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentGradeCalculator {

    public static void RunStudentGradeCalculator(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Collect student data
        System.out.print("Enter the number of students: ");
        int numberOfStudents = scanner.nextInt();

        List<String> studentNames = new ArrayList<>();
        List<Double> studentGrades = new ArrayList<>();

        for (int i = 0; i < numberOfStudents; i++) {
            // Collect student name and grade
            System.out.print("Enter the name of student " + (i + 1) + ": ");
            String name = scanner.next();
            studentNames.add(name);

            System.out.print("Enter the grade of student " + (i + 1) + ": ");
            double grade = scanner.nextDouble();
            studentGrades.add(grade);
        }

        // Calculate average grade
        double totalGrades = 0.0;
        for (Double grade : studentGrades) {
            totalGrades += grade;
        }
        double average = totalGrades / studentGrades.size();

        // Display student grades and average
        System.out.println("\nStudent Grade Report:");
        for (int i = 0; i < numberOfStudents; i++) {
            System.out.println(studentNames.get(i) + ": " + studentGrades.get(i));
        }

        System.out.println("\nAverage Grade: " + average);
    }
}
