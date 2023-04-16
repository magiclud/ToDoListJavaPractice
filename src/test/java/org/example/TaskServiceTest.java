package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class TaskServiceTest {
    TaskService taskService;

    @BeforeEach
    void setUp() {
        Task task1 = new Task("Zadanie 1", false);
        Task task2 = new Task("Zadanie 2", true);
        Task task3 = new Task("Zadanie 3", false);
        ArrayList<Task> taskList = new ArrayList<>();
        taskList.add(task1);
        taskList.add(task2);
        taskList.add(task3);
        this.taskService = new TaskService(taskList);
    }

    @Test
    public void shouldRemoveElementFromList() {
        int indexToRemove = 1;
        int sizeBeforeRemoving = taskService.getAll().size();
        taskService.remove(indexToRemove);
        assertEquals(sizeBeforeRemoving - 1, taskService.getAll().size(), "The list of elements has not been reduced by 1");
    }

    @Test
    public void shouldNotRemoveElementsFromListWhenWrongIndexProvided() {
        int indexToRemove = -2;
        int sizeBeforeRemoving = taskService.getAll().size();
        taskService.remove(indexToRemove);
        assertEquals(sizeBeforeRemoving, taskService.getAll().size(), "The list of elements has changed");
    }
}
