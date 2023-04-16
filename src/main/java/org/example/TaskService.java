package org.example;

import java.util.ArrayList;

public class TaskService {
    ArrayList<Task> tasks;

    TaskService(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }

    public void remove(int taskId) {
        if(taskId>=0 && taskId<tasks.size()) {
            tasks.remove(taskId);
        }else {
            System.out.println("Provided wrong tasks id");
        }
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

    public ArrayList<Task> getAll() {
        return tasks;
    }
}
