import java.util.Scanner;

public class Main {
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