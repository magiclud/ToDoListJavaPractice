package org.example;

import java.util.ArrayList;

public class TaskService {
    ArrayList<Task> tasks;

    TaskService(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }

    public void remove(int taskId) {
        tasks.remove(taskId);
    }

    public void printAll() {
        tasks.forEach(e -> System.out.println(tasks.indexOf(e) + ": " + e.toString()));
    }

    public void markAsCompleted(int taskId) {
        Task updatedElement = new Task(tasks.get(taskId).value(), true);
        tasks.add(updatedElement);
        tasks.remove(taskId);
    }

    public void add(String readText) {
        tasks.add(new Task(readText, false));
    }
}
