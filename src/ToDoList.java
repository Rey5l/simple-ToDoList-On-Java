import java.util.ArrayList;
import java.util.Scanner;

public class ToDoList {
    private static ArrayList<String> tasks = new ArrayList<>();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Сhoose action: ");
            System.out.println("1. Add task");
            System.out.println("2. Delete task");
            System.out.println("3. Print tasks list");
            System.out.println("4. Exit");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addTask(scanner);
                    break;
                case 2:
                    deleteTask(scanner);
                    break;
                case 3:
                    displayTasks();
                    break;
                case 4:
                    System.out.println("The program is finished");
                    scanner.close();
                    return;
                default:
                    System.out.println("Uncorrect action. Please, choose 1 ... 4");
            }
        }
    }

    private static void displayTasks() {
        if (tasks.isEmpty()) {
            System.out.println("The tasks list is empty");
        } else {
            System.out.println("Current tasks list: ");
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + ". " + tasks.get(i));
            }
        }
    }

    private static void deleteTask(Scanner scanner) {
        if (tasks.isEmpty()) {
            System.out.println("Tasks list is empty!");
            return;
        }
        System.out.println("Choose number of task to delete");
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + ". " + tasks.get(i));
        }
        int taskNumber = scanner.nextInt();
        if (taskNumber >= 1 && taskNumber <= tasks.size()) {
            tasks.remove(taskNumber - 1);
            System.out.println("The task has been delete");
        } else {
            System.out.println("Uncorrect number of task");
        }
    }

    private static void addTask(Scanner scanner) {
        System.out.println("Add new task: ");
        String task = scanner.next();
        tasks.add(task);
        System.out.println("The task has been added");
    }
}