import java.util.HashMap;
import java.util.Map;

public class TaskManager {
    private Map<String, Task> tasks = new HashMap<>();
    private DatabaseService databaseService;

    public TaskManager(DatabaseService databaseService) {
        this.databaseService = databaseService;
    }

    public void addTask(Task task) {
        if (task.getId() == null) {
            throw new IllegalArgumentException("Task ID cannot be null");
        }
        tasks.put(task.getId(), task);
        databaseService.saveTask(task); // Save to database
    }

    public Task getTask(String id) {
        if (id == null) {
            throw new IllegalArgumentException("Task ID cannot be null");
        }
        if (!tasks.containsKey(id)) {
            throw new TaskNotFoundException("Task not found: " + id);
        }
        return tasks.get(id);
    }

    public void deleteTask(String id) {
        if (id == null) {
            throw new IllegalArgumentException("Task ID cannot be null");
        }
        if (!tasks.containsKey(id)) {
            throw new TaskNotFoundException("Task not found: " + id);
        }
        tasks.remove(id);
        databaseService.deleteTaskById(id); // Delete from database
    }
}

