import java.util.Arrays;
import java.util.EnumSet;

public class TaskManager {
    public static TaskCategory.Task createTask(String title, TaskStatus status, TaskCategory... categories) {
        return new TaskCategory.Task(title, status, EnumSet.copyOf(Arrays.asList(categories)));
    }

    public record TeamMember(String name, String email) {}

    public record TaskAssignment(TaskCategory.Task task, TeamMember assignee) {}

}