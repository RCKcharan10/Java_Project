public class AutoSave {
    private ToDoApp toDoApp;

    public AutoSave(ToDoApp toDoApp) {
        this.toDoApp = toDoApp;
    }

    public void startAutoSave() {
        new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(30000);  // Save every 30 seconds
                    toDoApp.saveTasks();  // Changed to public access for saveTasks()
                    System.out.println("Tasks auto-saved.");
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }).start();
    }
}
