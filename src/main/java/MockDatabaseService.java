import java.util.HashMap;
import java.util.Map;

public class MockDatabaseService implements DatabaseService {
    private Map<String, Task> database = new HashMap<>();

    @Override
    public void saveTask(Task task) {
        database.put(task.getId(), task);
    }

    @Override
    public Task findTaskById(String id) {
        return database.get(id);
    }

    @Override
    public void deleteTaskById(String id) {
        database.remove(id);
    }
}

