import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

class TaskManagerMockTest {
    private TaskManager taskManager;
    private DatabaseService mockDatabaseService;

    @BeforeEach
    void setUp() {
        mockDatabaseService = Mockito.mock(DatabaseService.class);
        taskManager = new TaskManager(mockDatabaseService);
    }

    @Test
    void testAddTaskCallsDatabaseService() {
        Task task = new Task("1", "Test Task");
        taskManager.addTask(task);

        // Verify that saveTask was called on the mock
        verify(mockDatabaseService).saveTask(task);
    }

    @Test
    void testDeleteTaskCallsDatabaseService() {
        Task task = new Task("1", "Test Task");
        taskManager.addTask(task);
        taskManager.deleteTask("1");

        // Verify that deleteTaskById was called on the mock
        verify(mockDatabaseService).deleteTaskById("1");
    }

    @Test
    void testGetTaskCallsDatabaseService() {
        Task task = new Task("1", "Test Task");
        when(mockDatabaseService.findTaskById("1")).thenReturn(task);

        taskManager.addTask(task);
        Task retrievedTask = taskManager.getTask("1");

        // Verify that findTaskById was called on the mock
        verify(mockDatabaseService).findTaskById("1");
        assertEquals(task, retrievedTask);
    }

    @Test
    void testGetTaskWithMockedDatabaseServiceReturnsNull() {
        when(mockDatabaseService.findTaskById("nonexistent")).thenReturn(null);

        assertThrows(TaskNotFoundException.class, () -> taskManager.getTask("nonexistent"));
    }
}

