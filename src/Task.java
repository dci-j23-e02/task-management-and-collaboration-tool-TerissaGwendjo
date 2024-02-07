import java.util.EnumSet;
import java.util.Objects;

public final class Task {
    private final String title;
    private final TaskStatus status;
    private final EnumSet<TaskCategory> categories;

    public Task(String title, TaskStatus status, EnumSet<TaskCategory> categories) {
        this.title = title;
        this.status = status;
        this.categories = categories;
    }

    public String getTitle() {
        return title;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public EnumSet<TaskCategory> getCategories() {
        return categories;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return Objects.equals(title, task.title) &&
                status == task.status &&
                Objects.equals(categories, task.categories);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, status, categories);
    }

    @Override
    public String toString() {
        return "Task{" +
                "title='" + title + '\'' +
                ", status=" + status +
                ", categories=" + categories +
                '}';
    }
}
