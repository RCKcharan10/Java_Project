// Move this class into a separate file named "PriorityTask.java"
public class PriorityTask extends Task {
    private int priorityLevel;

    // Constructor with description and priority level
    public PriorityTask(String description, int priorityLevel) {
        super(description);  // Call to super constructor
        this.priorityLevel = priorityLevel;
    }

    public int getPriorityLevel() {
        return priorityLevel;
    }

    // Override the displayTask method to include priority level
    @Override
    public void displayTask() {
        super.displayTask();  // Call to parent class's displayTask method
        System.out.println("Priority Level: " + priorityLevel);
    }
}
