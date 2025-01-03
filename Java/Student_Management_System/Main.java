// Main.java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StudentManagementSystem sms = new StudentManagementSystem();
        sms.loadFromFile();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Student Management System ---");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search Student by Roll Number");
            System.out.println("4. Search Student by Name");
            System.out.println("5. Sort Students by Marks");
            System.out.println("6. Generate Report");
            System.out.println("7. Save and Exit");

            // Now using the new method to avoid double prompts
            int choice = InputValidator.getValidMenuChoice();
            switch (choice) {
                case 1 -> {
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    int rollNumber = InputValidator.getValidRollNumber();  // Now correctly prompting for roll number
                    System.out.print("Enter Course: ");
                    String course = scanner.nextLine();
                    double marks = InputValidator.getValidMarks();
                    sms.addStudent(new Student(name, rollNumber, course, marks));
                }
                case 2 -> sms.viewAllStudents();
                case 3 -> sms.searchStudentByRollNumber(InputValidator.getValidRollNumber());
                case 4 -> {
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    sms.searchStudentByName(name);
                }
                case 5 -> sms.sortStudentsByMarks();
                case 6 -> sms.generateReport();
                case 7 -> {
                    sms.saveToFile();
                    System.out.println("Data saved. Exiting.");
                    return;
                }
                default -> System.out.println("Invalid choice! Please enter a number between 1-7.");
            }
        }
    }
}
