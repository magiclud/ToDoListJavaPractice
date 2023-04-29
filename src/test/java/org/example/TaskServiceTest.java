package org.example;


import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;


public class TaskServiceTest {
    TaskService taskService;
    ArrayList<Task> taskList = new ArrayList<>();

    @Test
    public void shouldAddTaskToTheList() {
        Task task1 = new Task("Zadanie 1", false);
        Task task2 = new Task("Zadanie 2", true);
        Task task3 = new Task("Zadanie 3", false);
        String newTask = "Tidy up your room";

        Given:
        taskList.add(task1);
        taskList.add(task2);
        taskList.add(task3);
        this.taskService = new TaskService(taskList);
        int sizeBeforeRemoving = taskService.getAll().size();
        When:
        taskService.add(newTask);

        Then:
        assertThat(taskService.getAll().size()).isEqualTo(sizeBeforeRemoving + 1);
    }

    @Test
    public void shouldRemoveElementFromList() {
        Task task1 = new Task("Zadanie 1", false);
        Task task2 = new Task("Zadanie 2", true);
        Task task3 = new Task("Zadanie 3", false);
        int indexToRemove = 1;

        Given:
        taskList.add(task1);
        taskList.add(task2);
        taskList.add(task3);
        this.taskService = new TaskService(taskList);
        int sizeBeforeRemoving = taskService.getAll().size();
        When:
        taskService.remove(indexToRemove);
        Then:
        assertThat(taskService.getAll().size()).isEqualTo(sizeBeforeRemoving - 1);
    }

    @Test
    public void shouldNotRemoveElementsFromListWhenWrongIndexProvided() {
        Task task1 = new Task("Zadanie 1", false);
        Task task2 = new Task("Zadanie 2", true);
        Task task3 = new Task("Zadanie 3", false);
        int indexToRemove = -2;

        Given:
        taskList.add(task1);
        taskList.add(task2);
        taskList.add(task3);
        this.taskService = new TaskService(taskList);
        int sizeBeforeRemoving = taskService.getAll().size();
        When:
        taskService.remove(indexToRemove);
        Then:
        assertThat(taskService.getAll().size()).isEqualTo(sizeBeforeRemoving);
    }

    @Test
    public void shouldMarkTaskAsCompleted() {
        Task task1 = new Task("Zadanie 1", false);
        Task task2 = new Task("Zadanie 2", true);
        Task task3 = new Task("Zadanie 3", false);
        int indexOfTheUncompletedTask = 0;

        Given:
        taskList.add(task1);
        taskList.add(task2);
        taskList.add(task3);
        this.taskService = new TaskService(taskList);
        When:
        taskService.markAsCompleted(indexOfTheUncompletedTask);
        boolean taskStatusAfterTheChange = taskService.getAll().get(indexOfTheUncompletedTask).completed();
        Then:
        assertThat(taskStatusAfterTheChange).isTrue();
    }

    @Test
    public void shouldNotChangeTheStatusDueToWrongIndex() {
        Task task1 = new Task("Zadanie 1", false);
        Task task2 = new Task("Zadanie 2", true);
        Task task3 = new Task("Zadanie 3", false);
        int indexOfTheUncompletedTask = 3;

        Given:
        taskList.add(task1);
        taskList.add(task2);
        taskList.add(task3);
        this.taskService = new TaskService(taskList);
        List<Boolean> statusesBeforeAction = taskService.getAll().stream().map(Task::completed).toList();
        When:
        taskService.markAsCompleted(indexOfTheUncompletedTask);
        List<Boolean> statusesAfterAction = taskService.getAll().stream().map(Task::completed).toList();
        Then:
        assertThat(statusesAfterAction).isEqualTo(statusesBeforeAction);
    }
}
