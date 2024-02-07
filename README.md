### Project: Task Management and Collaboration Tool

#### Project Overview
In this project, you will develop a simplified model for a task management and collaboration tool using Java. This tool will allow users to create tasks, assign them to team members, and track their progress. You will utilize Enum Types, EnumSet, Varargs, and Java 14 Records to model the data and functionalities of the tool. Additionally, you will explore the differences between using records and final classes in Java.

#### Objectives:
- Understand and apply Enum Types and EnumSet in Java.
- Learn how to attach values to Java Enums.
- Utilize Varargs for methods that require a variable number of arguments.
- Implement Java 14 Records to model immutable data.
- Compare the use of records with final classes in Java.

### Step 1: Define Task Status Enum

#### Objective:
Create an Enum to represent the status of tasks in the tool.

#### Task:
1. Define an Enum named `TaskStatus` with the values `OPEN`, `IN_PROGRESS`, `REVIEW`, and `COMPLETED`.
2. Attach a string description to each Enum value.

#### Code Snippet:
```java
public enum TaskStatus {
    OPEN("Open"),
    IN_PROGRESS("In Progress"),
    REVIEW("Review"),
    COMPLETED("Completed");

    private final String description;

    TaskStatus(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
```

### Step 2: Use EnumSet for Task Categories

#### Objective:
Model task categories using EnumSet for efficient storage and retrieval.

#### Task:
1. Define an Enum named `TaskCategory` with values like `DEVELOPMENT`, `DESIGN`, `TESTING`, etc.
2. In your task model, use an EnumSet to store multiple categories for a task.

#### Code Snippet:
```java
public enum TaskCategory {
    DEVELOPMENT, DESIGN, TESTING, DOCUMENTATION
}

public record Task(String title, TaskStatus status, EnumSet<TaskCategory> categories) {}
```

### Step 3: Implement Varargs in Task Creation

#### Objective:
Allow creating a task with a variable number of categories using Varargs.

#### Task:
1. Create a method in your task manager class that accepts Varargs for `TaskCategory`.
2. Use this method to instantiate a task with multiple categories.

#### Code Snippet:
```java
public class TaskManager {
    public static Task createTask(String title, TaskStatus status, TaskCategory... categories) {
        return new Task(title, status, EnumSet.copyOf(Arrays.asList(categories)));
    }
}
```

### Step 4: Model Team Members and Assign Tasks

#### Objective:
Use Java 14 Records to model team members and assign tasks to them.

#### Task:
1. Define a `TeamMember` record with fields like `name` and `email`.
2. Create a `TaskAssignment` record that links tasks to team members.

#### Code Snippet:
```java
public record TeamMember(String name, String email) {}

public record TaskAssignment(Task task, TeamMember assignee) {}
```

### Step 5: Compare Record vs. Final Class

#### Objective:
Understand the differences between using records and final classes by modeling a task with both approaches.

#### Task:
1. Create a final class version of the `Task` model with `equals`, `hashCode`, and `toString` methods implemented.
2. Discuss the differences in verbosity, immutability, and usage between the two approaches.

#### Discussion Points:
- Records provide a concise way to model immutable data without boilerplate code.
- Final classes offer more flexibility but require manual implementation of methods like `equals` and `hashCode`.
- Records are ideal for simple data carriers, while final classes might be preferred for more complex behaviors.




### Additional Requirements: Command Line Tool and JUnit 5 Testing

To enhance the Task Management and Collaboration Tool project, you will now add a command-line interface (CLI) to interact with the application and use JUnit 5 for testing its functionalities.

#### Step 6: Develop a Command-Line Interface (CLI)

#### Objective:
Create a simple CLI to add tasks, assign them to team members, and update task statuses.

#### Task:
1. Implement a `CommandLineTool` class with a main method to serve as the entry point.
2. Use a loop and the `Scanner` class to accept input from the user.
3. Provide options to create tasks, list tasks, assign tasks to team members, and update task statuses.

#### Code Snippet:
```java
import java.util.Scanner;

public class CommandLineTool {
    private static final TaskManager taskManager = new TaskManager();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input;
        System.out.println("Task Management Tool");
        do {
            System.out.println("\nOptions: create, list, assign, update, exit");
            System.out.print("Enter option: ");
            input = scanner.nextLine();
            switch (input) {
                case "create":
                    // Implement task creation logic
                    break;
                case "list":
                    // Implement task listing logic
                    break;
                case "assign":
                    // Implement task assignment logic
                    break;
                case "update":
                    // Implement task status update logic
                    break;
                case "exit":
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        } while (!input.equals("exit"));
    }
}
```

#### Step 7: Implement JUnit 5 Tests

#### Objective:
Write unit tests to ensure the correctness of the application's functionalities.

#### Task:
1. Add JUnit 5 to your project dependencies.
2. Create test cases for task creation, task assignment, and status updates.
3. Use assertions to validate the expected outcomes.

#### Code Snippet:
```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TaskManagerTest {

    @Test
    void testTaskCreation() {
        Task task = TaskManager.createTask("Fix Bug", TaskStatus.OPEN, TaskCategory.DEVELOPMENT);
        assertNotNull(task);
        assertEquals("Fix Bug", task.title());
        assertEquals(TaskStatus.OPEN, task.status());
        assertTrue(task.categories().contains(TaskCategory.DEVELOPMENT));
    }

    @Test
    void testTaskAssignment() {
        TeamMember member = new TeamMember("John Doe", "john@example.com");
        Task task = new Task("Design Logo", TaskStatus.OPEN, EnumSet.of(TaskCategory.DESIGN));
        TaskAssignment assignment = new TaskAssignment(task, member);
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
```


### Deliverables:
- Enum Types and EnumSet to model task statuses and categories.
- Use of Varargs to allow flexible task category assignment.
- Java 14 Records to model immutable data structures like tasks, team members, and task assignments.
- A comparison between using records and final classes for modeling data in Java.
- A `CommandLineTool` class that provides a simple CLI for interacting with the task management tool.
- A set of JUnit 5 tests in a `TaskManagerTest` class that validate the core functionalities of task creation, assignment, and status updates.


This project will give you hands-on experience with modern Java features and best practices for modeling data and functionality in a task management context.
This Additional Requirements of the project will not only allow you to interact with the application through a command-line interface but also ensure its reliability through unit testing with JUnit 5.

### Resources:

 - [A Guide to Java Enums](https://www.baeldung.com/a-guide-to-java-enums)
 - [Enum Types](https://docs.oracle.com/javase/tutorial/java/javaOO/enum.html)
 - [Attaching Values to Java Enum](https://www.baeldung.com/java-enum-values)
 - [Java Enum with Custom Values: A Detailed Guide](https://ioflood.com/blog/java-enum-with-values/)
 - [Guide to EnumSet](https://www.baeldung.com/java-enumset)
 - [Varargs in Java](https://www.baeldung.com/java-varargs)
 - [Java 14 Record](https://www.baeldung.com/java-record-keyword)
 - [Record vs. Final Class in Java](https://www.baeldung.com/java-record-vs-final-class)
