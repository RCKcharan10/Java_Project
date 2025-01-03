// InputValidator.java
import java.util.Scanner;

public class InputValidator {
    private static Scanner scanner = new Scanner(System.in);

    // Method specifically for menu selection
    public static int getValidMenuChoice() {
        int choice = -1;
        boolean valid = false;
        while (!valid) {
            try {
                System.out.print("Enter choice: "); // Only asks for menu choice here
                choice = Integer.parseInt(scanner.nextLine());
                valid = true;
            } catch (NumberFormatException e) {
                System.out.println("Invalid choice. Please enter a numeric value.");
            }
        }
        return choice;
    }

    // Method specifically for roll number input
    public static int getValidRollNumber() {
        int rollNumber = -1;
        boolean valid = false;
        while (!valid) {
            try {
                System.out.print("Enter Roll Number: "); // Only asks for roll number here
                rollNumber = Integer.parseInt(scanner.nextLine());
                valid = true;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a numeric roll number.");
            }
        }
        return rollNumber;
    }

    public static double getValidMarks() {
        double marks = -1;
        boolean valid = false;
        while (!valid) {
            try {
                System.out.print("Enter Marks (0-100): ");
                marks = Double.parseDouble(scanner.nextLine());
                if (marks < 0 || marks > 100) {
                    System.out.println("Invalid input. Marks should be between 0 and 100.");
                } else {
                    valid = true;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a numeric value.");
            }
        }
        return marks;
    }
}
