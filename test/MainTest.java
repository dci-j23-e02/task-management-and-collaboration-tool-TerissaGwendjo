import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.EnumSet;

class MainTest {

    @Test
    void testTaskCreation() {
        TaskCategory.Task task = TaskManager.createTask("Fix Bug", TaskStatus.OPEN, TaskCategory.DEVELOPMENT);
        assertNotNull(task);
        assertEquals("Fix Bug", task.title());
        assertEquals(TaskStatus.OPEN, task.status());
        assertTrue(task.categories().contains(TaskCategory.DEVELOPMENT));
    }

    @Test
    void testTaskAssignment() {
        TaskManager.TeamMember member = new TaskManager.TeamMember("John Doe", "john@example.com");
        Task task = new Task("Design Logo", TaskStatus.OPEN, EnumSet.of(TaskCategory.DESIGN));
        TaskManager.TaskAssignment assignment = new TaskManager.TaskAssignment(TaskCategory.Task, member);
        assertEquals("John Doe", assignment.assignee().name());
        assertEquals("Design Logo", assignment.task().title());
    }

    @Test
    void testStatusUpdate() {
        Task task = new Task("Prepare Report", TaskStatus.OPEN, EnumSet.noneOf(TaskCategory.class));
        Task updatedTask = new Task(task.title(), TaskStatus.COMPLETED, task.categories());
        assertEquals(TaskStatus.COMPLETED, updatedTask.status());
    }
}