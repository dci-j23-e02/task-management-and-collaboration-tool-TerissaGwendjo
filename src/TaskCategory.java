import java.util.EnumSet;

public enum TaskCategory {
    DEVELOPMENT, DESIGN, TESTING, DOCUMENTATION;

public record Task(String title, TaskStatus status, EnumSet<TaskCategory> categories) {}

}