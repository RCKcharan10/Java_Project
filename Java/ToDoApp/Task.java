import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

public class Task implements Serializable {
    private UUID id;
    private String description;
    private boolean isCompleted;
    private Date creationTime;

    // Updated constructor to accept description
    public Task(String description) {
        this.id = UUID.randomUUID();
        this.description = description;
        this.isCompleted = false;
        this.creationTime = new Date();
    }

    public UUID getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void markAsCompleted() {
        this.isCompleted = true;
    }

    public Date getCreationTime() {
        return creationTime;
    }

    // Changed to protected to allow overriding
    protected void displayTask() {
        System.out.println("ID: " + id + ", Description: " + description + ", Completed: " + isCompleted + ", Created On: " + creationTime);
    }
}
