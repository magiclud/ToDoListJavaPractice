package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class ToDoList {

    public static void main(String[] args) {

        ArrayList<Task> tasksList = new ArrayList<>();
        Scanner in = new Scanner(System.in);

        int action;

        System.out.println("Possible actions:\n");
        System.out.println("1. Adding a task ");
        System.out.println("2. Removing a task");
        System.out.println("3. Listing all tasks ");
        System.out.println("4. Mark task as completed");
        System.out.println("5. Exit");


        do {
            action = readCorrectNumberFromConsole(in);
            switch (action) {
                case 1:
                    System.out.println("Enter the task:");
                    in.nextLine();
                    String readText = in.nextLine();
                    tasksList.add(new Task(readText, false));
                    break;
                case 2:
                    System.out.println("Write number of the task to remove:");
                    in.nextLine();
                    int idToRemove = in.nextInt();
                    tasksList.remove(idToRemove);
                    break;
                case 3:
                    System.out.println("Your todo list: ");
                    break;
                case 4:
                    System.out.println("Which task is completed:");
                    in.nextLine();
                    int idCompleted = in.nextInt();
                    Task updatedElement = new Task(tasksList.get(idCompleted).value(), true);
                    tasksList.add(updatedElement);
                    tasksList.remove(idCompleted);
                    System.out.println(updatedElement);
                    break;
                default:
            }
            tasksList.forEach(e -> System.out.println(tasksList.indexOf(e) + ": " + e.toString()));
        } while (action != 5);
    }


    private static int readCorrectNumberFromConsole(Scanner in) {
        int number;
        System.out.println("Enter a number of an action");
        while (!in.hasNextInt()) {
            System.out.println("That's not a number!");
            in.next();
        }
        number = in.nextInt();
        return number;
    }
}
