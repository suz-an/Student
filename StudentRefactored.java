import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Student {
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

public class StudentGradeCalculator {

    public static void main(String[] args) {
        run();
    }

    private static void run() {
        Scanner scanner = new Scanner(System.in);
        List<Student> students = new ArrayList<>();

        int studentCount = getStudentCount(scanner);
        collectStudentData(scanner, students, studentCount);

        double average = calculateAverage(students);
        printReport(students, average);
    }

    private static int getStudentCount(Scanner scanner) {
        System.out.print("Enter the number of students: ");
        return scanner.nextInt();
    }

    private static void collectStudentData(Scanner scanner, List<Student> students, int studentCount) {
        for (int i = 0; i < studentCount; i++) {
            System.out.print("Enter the name of student " + (i + 1) + ": ");
            String name = scanner.next();
            System.out.print("Enter the grade of student " + (i + 1) + ": ");
            double grade = scanner.nextDouble();
            students.add(new Student(name, grade));
        }
    }

    private static double calculateAverage(List<Student> students) {
        double sum = 0.0;
        for (Student student : students) {
            sum += student.getGrade();
        }
        return sum / students.size();
    }

    private static void printReport(List<Student> students, double average) {
        System.out.println("\nStudent Grade Report:");
        for (Student student : students) {
            System.out.println(student.getName() + ": " + student.getGrade());
        }
        System.out.println("\nAverage Grade: " + average);
    }
}