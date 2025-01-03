import java.io.*;
import java.util.*;
import java.util.logging.Logger;

public class ToDoApp {
    private HashMap<UUID, Task> taskMap = new HashMap<>();
    private final Scanner scanner = new Scanner(System.in);
    private final String fileName = "tasks.dat";
    private static final Logger logger = AppLogger.getLogger();

    public void start() {
        loadTasks(); // Load tasks at startup

        AutoSave autoSave = new AutoSave(this);  // Start auto-save
        autoSave.startAutoSave();

        while (true) {
            System.out.println("\n--- To-Do List Application ---");
            System.out.println("1. Add Task");
            System.out.println("2. View Tasks");
            System.out.println("3. Mark Task as Completed");
            System.out.println("4. Delete Task");
            System.out.println("5. Save Tasks");
            System.out.println("6. Load Tasks");
            System.out.println("7. Sort Tasks");
            System.out.println("8. Search Tasks");
            System.out.println("9. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1 -> addTask();
                case 2 -> viewTasks();
                case 3 -> markTaskAsCompleted();
                case 4 -> deleteTask();
                case 5 -> saveTasks();
                case 6 -> loadTasks();
                case 7 -> sortTasks();
                case 8 -> searchTasks();
                case 9 -> {
                    saveTasks(); // Save tasks before exiting
                    System.out.println("Exiting the application. Goodbye!");
                    return;
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void addTask() {
        System.out.println("Enter task description: ");
        String description = scanner.nextLine();
        System.out.println("Is it a priority task? (yes/no): ");
        String isPriority = scanner.nextLine().toLowerCase();
        Task task;

        if ("yes".equals(isPriority)) {
            System.out.println("Enter priority level (1-5): ");
            int priority = scanner.nextInt();
            task = new PriorityTask(description, priority);
        } else {
            task = new Task(description);
        }

        taskMap.put(task.getId(), task);
        logger.info("Added task: " + task.getId());
    }

    private void viewTasks() {
        if (taskMap.isEmpty()) {
            System.out.println("No tasks available.");
            return;
        }
        taskMap.values().forEach(Task::displayTask);
    }

    private void markTaskAsCompleted() {
        System.out.println("Enter the Task ID to mark as completed: ");
        String taskIdStr = scanner.nextLine();
        UUID taskId = UUID.fromString(taskIdStr);

        Task task = taskMap.get(taskId);
        if (task != null) {
            task.markAsCompleted();
            logger.info("Task marked as completed: " + taskId);
        } else {
            System.out.println("Task not found.");
        }
    }

    private void deleteTask() {
        System.out.println("Enter the Task ID to delete: ");
        String taskIdStr = scanner.nextLine();
        UUID taskId = UUID.fromString(taskIdStr);

        try {
            Task task = taskMap.remove(taskId);
            if (task != null) {
                System.out.println("Task deleted successfully.");
                logger.info("Task deleted: " + taskId);
            } else {
                throw new TaskNotFoundException("Task not found.");
            }
        } catch (TaskNotFoundException e) {
            System.err.println(e.getMessage());
            logger.warning(e.getMessage());
        }
    }

    // Changed to public
    public void saveTasks() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName))) {
            out.writeObject(taskMap);
            System.out.println("Tasks saved.");
        } catch (IOException e) {
            System.err.println("Error saving tasks: " + e.getMessage());
            logger.severe("Error saving tasks: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
private void loadTasks() {
    try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName))) {
        Object object = in.readObject();
        
        // Check if the object is of type HashMap<UUID, Task>
        if (object instanceof HashMap<?, ?>) {
            taskMap = (HashMap<UUID, Task>) object;  // Safe cast after the check
            System.out.println("Tasks loaded.");
        } else {
            System.err.println("Invalid object type in saved file.");
        }
    } catch (IOException | ClassNotFoundException e) {
        System.err.println("Error loading tasks: " + e.getMessage());
    }
}

    private void sortTasks() {
        System.out.println("Sort tasks by: 1. Creation Date, 2. Priority, 3. Status");
        int sortOption = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        switch (sortOption) {
            case 1 -> taskMap.values().stream()
                    .sorted(Comparator.comparing(Task::getCreationTime))
                    .forEach(Task::displayTask);
            case 2 -> taskMap.values().stream()
                    .filter(task -> task instanceof PriorityTask)
                    .sorted(Comparator.comparing(task -> ((PriorityTask) task).getPriorityLevel()))
                    .forEach(Task::displayTask);
            case 3 -> {
                System.out.println("Pending Tasks:");
                taskMap.values().stream()
                        .filter(task -> !task.isCompleted())
                        .forEach(Task::displayTask);
                System.out.println("Completed Tasks:");
                taskMap.values().stream()
                        .filter(Task::isCompleted)
                        .forEach(Task::displayTask);
            }
            default -> System.out.println("Invalid option.");
        }
    }

    private void searchTasks() {
        System.out.println("Search tasks by: 1. Task ID, 2. Description");
        int searchOption = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        switch (searchOption) {
            case 1 -> {
                System.out.println("Enter Task ID: ");
                String taskIdStr = scanner.nextLine();
                UUID taskId = UUID.fromString(taskIdStr);
                Task task = taskMap.get(taskId);
                if (task != null) {
                    task.displayTask();
                } else {
                    System.out.println("Task not found.");
                }
            }
            case 2 -> {
                System.out.println("Enter keyword: ");
                String keyword = scanner.nextLine();
                taskMap.values().stream()
                        .filter(task -> task.getDescription().contains(keyword))
                        .forEach(Task::displayTask);
            }
            default -> System.out.println("Invalid option.");
        }
    }

    public static void main(String[] args) {
        new ToDoApp().start();
    }
}
