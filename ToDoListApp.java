package JavaInternPrograms;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * ToDoListApp - A simple console-based to-do list manager.
 * Demonstrates Object-Oriented Programming with classes and objects,
 * and data structure manipulation using ArrayList.
 */
class Task {
    private String title;
    private boolean isCompleted;

    public Task(String title) {
        this.title = title;
        this.isCompleted = false;
    }

    public void markCompleted() {
        this.isCompleted = true;
    }

    @Override
    public String toString() {
        return (isCompleted ? "[✔] " : "[ ] ") + title;
    }
}

public class ToDoListApp {
    private static ArrayList<Task> tasks = new ArrayList<>();

    public static void addTask(String title) {
        tasks.add(new Task(title));
        System.out.println("Task added successfully!");
    }

    public static void markTaskComplete(int index) {
        if (index >= 0 && index < tasks.size()) {
            tasks.get(index).markCompleted();
            System.out.println("Task marked as completed!");
        } else {
            System.out.println("Invalid task number.");
        }
    }

    public static void displayTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks in the list.");
        } else {
            System.out.println("\n===== To-Do List =====");
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + ". " + tasks.get(i));
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n===== To-Do List Menu =====");
            System.out.println("1. Add Task");
            System.out.println("2. Mark Task as Complete");
            System.out.println("3. View All Tasks");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); 
            switch (choice) {
                case 1:
                    System.out.print("Enter task title: ");
                    String title = scanner.nextLine();
                    addTask(title);
                    break;
                case 2:
                    displayTasks();
                    System.out.print("Enter task number to mark complete: ");
                    int taskNumber = scanner.nextInt();
                    markTaskComplete(taskNumber - 1);
                    break;
                case 3:
                    displayTasks();
                    break;
                case 4:
                    System.out.println("Exiting To-Do List... Goodbye!");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }

        scanner.close();
    }
}
