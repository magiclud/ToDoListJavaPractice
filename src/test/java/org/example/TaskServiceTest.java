package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

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
    public void shouldAddTaskToTheList() {
        String newTask = "Tidy up your room";
        int sizeBeforeRemoving = taskService.getAll().size();
        taskService.add(newTask);
        assertEquals(sizeBeforeRemoving + 1, taskService.getAll().size(), "The list of elements has not increased");
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

    @Test
    public void shouldMarkTaskAsCompleted() {
        int indexOfTheUncompletedTask = 0;
        boolean taskStatusBeforeTheChange = taskService.getAll().get(indexOfTheUncompletedTask).completed();
        assertFalse(taskStatusBeforeTheChange, "Task is not marked as uncompleted");
        taskService.markAsCompleted(indexOfTheUncompletedTask);
        boolean taskStatusAfterTheChange = taskService.getAll().get(indexOfTheUncompletedTask).completed();
        assertTrue(taskStatusAfterTheChange, "Task is not marked as completed");
    }

    @Test
    public void shouldNotChangeTheStatusDueToWrongIndex() {
        int indexOfTheUncompletedTask = 3;
        List<Boolean> statusesBeforeAction = taskService.getAll().stream().map(Task::completed).toList();
        taskService.markAsCompleted(indexOfTheUncompletedTask);
        List<Boolean> statusesAfterAction = taskService.getAll().stream().map(Task::completed).toList();
        assertEquals(statusesBeforeAction, statusesAfterAction);
    }
}
