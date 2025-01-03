// Student.java
public class Student {
    private String name;
    private int rollNumber;
    private String course;
    private double marks;

    public Student(String name, int rollNumber, String course, double marks) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.course = course;
        this.marks = marks;
    }

    // Getters and Setters
    public String getName() { return name; }
    public int getRollNumber() { return rollNumber; }
    public String getCourse() { return course; }
    public double getMarks() { return marks; }

    public void setName(String name) { this.name = name; }
    public void setCourse(String course) { this.course = course; }
    public void setMarks(double marks) { this.marks = marks; }
    public void setRollNumber(int rollNumber) { this.rollNumber = rollNumber; }

    // Grade Calculation Feature
    public String calculateGrade() {
        if (marks >= 90) return "A+";
        else if (marks >= 75) return "A";
        else if (marks >= 60) return "B";
        else if (marks >= 50) return "C";
        else return "F";
    }

    @Override
    public String toString() {
        return name + " | Roll No: " + rollNumber + " | Course: " + course + " | Marks: " + marks + " | Grade: " + calculateGrade();
    }
}
