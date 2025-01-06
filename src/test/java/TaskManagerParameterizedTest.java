import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class TaskManagerParameterizedTest {
    private TaskManager taskManager;

    static Stream<Arguments> taskProvider() {
        return Stream.of(
                Arguments.of("1", "Task 1"),
                Arguments.of("2", "Task 2"),
                Arguments.of("3", "Task 3"),
                Arguments.of("4", ""), // Edge case: empty description
                Arguments.of(null, "Null ID Task") // Edge case: null ID
        );
    }

    @ParameterizedTest
    @MethodSource("taskProvider")
    void testAddAndGetTaskWithDifferentInputs(String id, String description) {
        taskManager = new TaskManager(new MockDatabaseService());
        if (id == null) {
            assertThrows(IllegalArgumentException.class, () -> taskManager.addTask(new Task(id, description)));
        } else {
            Task task = new Task(id, description);
            taskManager.addTask(task);
            assertEquals(task, taskManager.getTask(id));
        }
    }
}
