// StudentManagementSystem.java
import java.io.*;
import java.util.*;

public class StudentManagementSystem {
    private List<Student> students = new ArrayList<>();
    private final String fileName = "students.csv";

    public void addStudent(Student student) {
        students.add(student);
        System.out.println("Student added successfully.");
    }

    public void viewAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found.");
        } else {
            students.forEach(System.out::println);
        }
    }

    // Search Student by Roll Number
    public void searchStudentByRollNumber(int rollNumber) {
        for (Student student : students) {
            if (student.getRollNumber() == rollNumber) {
                System.out.println(student);
                return;
            }
        }
        System.out.println("Student not found.");
    }

    // Search Student by Name
    public void searchStudentByName(String name) {
        for (Student student : students) {
            if (student.getName().equalsIgnoreCase(name)) {
                System.out.println(student);
                return;
            }
        }
        System.out.println("Student not found.");
    }

    // Sort Students by Marks
    public void sortStudentsByMarks() {
        students.sort(Comparator.comparingDouble(Student::getMarks).reversed());
        System.out.println("Students sorted by marks.");
    }

    public void generateReport() {
        double totalMarks = students.stream().mapToDouble(Student::getMarks).sum();
        double averageMarks = totalMarks / students.size();
        System.out.println("Total Students: " + students.size());
        System.out.println("Average Marks: " + averageMarks);
    }

    // File Handling
    public void saveToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (Student student : students) {
                writer.write(student.getName() + "," + student.getRollNumber() + "," + student.getCourse() + "," + student.getMarks() + "\n");
            }
            System.out.println("Data saved successfully.");
        } catch (IOException e) {
            System.out.println("Error saving data: " + e.getMessage());
        }
    }

    public void loadFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                students.add(new Student(data[0], Integer.parseInt(data[1]), data[2], Double.parseDouble(data[3])));
            }
            System.out.println("Data loaded successfully.");
        } catch (IOException e) {
            System.out.println("Error loading data: " + e.getMessage());
        }
    }
}
