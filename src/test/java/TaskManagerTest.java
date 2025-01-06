import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskManagerTest {
    private TaskManager taskManager;

    @BeforeEach
    void setUp() {
        taskManager = new TaskManager(new MockDatabaseService());
    }

    @Test
    void testAddAndGetTask() {
        Task task = new Task("1", "Test Task");
        taskManager.addTask(task);
        assertEquals(task, taskManager.getTask("1"));
    }

    @Test
    void testGetTaskNotFound() {
        assertThrows(TaskNotFoundException.class, () -> taskManager.getTask("nonexistent"));
    }

    @Test
    void testDeleteTask() {
        Task task = new Task("1", "Test Task");
        taskManager.addTask(task);
        taskManager.deleteTask("1");
        assertThrows(TaskNotFoundException.class, () -> taskManager.getTask("1"));
    }

    @Test
    void testGetTaskWithNullId() {
        assertThrows(IllegalArgumentException.class, () -> taskManager.getTask(null));
    }

    @Test
    void testDeleteNonExistentTask() {
        assertThrows(TaskNotFoundException.class, () -> taskManager.deleteTask("nonexistent"));
    }

    @Test
    void testAddDuplicateTask() {
        Task task1 = new Task("1", "Test Task");
        Task task2 = new Task("1", "Another Task");
        taskManager.addTask(task1);
        taskManager.addTask(task2); // This should overwrite the first task
        assertEquals(task2, taskManager.getTask("1"));
    }
}
