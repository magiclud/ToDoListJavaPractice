package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TaskService {
    ArrayList<Task> tasks;

    TaskService(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }

    public void remove(int taskId) {
        if (taskId >= 0 && taskId < tasks.size()) {
            tasks.remove(taskId);
        } else {
            System.out.println("Provided wrong tasks id");
        }
    }

    public void markAsCompleted(int taskId) {
        if (taskId >= 0 && taskId < tasks.size()) {
            Task updatedElement = tasks.get(taskId).asCompleted();
            tasks.add(updatedElement);
            tasks.remove(taskId);
        } else {
            System.out.println("Provided wrong tasks id");
        }
    }

    public void add(String readText) {
        tasks.add(new Task(readText, false));
    }

    public List<Task> getAll() {
        return Collections.unmodifiableList(tasks);
    }
}
