public interface DatabaseService {
    void saveTask(Task task);
    Task findTaskById(String id);
    void deleteTaskById(String id);
}
