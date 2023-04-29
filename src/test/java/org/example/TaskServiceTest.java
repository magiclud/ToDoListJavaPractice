package org.example;


import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;


public class TaskServiceTest {
    TaskService taskService;

    @BeforeTest
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
        assertThat(taskService.getAll().size()).isEqualTo(sizeBeforeRemoving + 1);
    }

    @Test
    public void shouldRemoveElementFromList() {
        int indexToRemove = 1;
        int sizeBeforeRemoving = taskService.getAll().size();
        taskService.remove(indexToRemove);
        assertThat(taskService.getAll().size()).isEqualTo(sizeBeforeRemoving - 1);
    }

    @Test
    public void shouldNotRemoveElementsFromListWhenWrongIndexProvided() {
        int indexToRemove = -2;
        int sizeBeforeRemoving = taskService.getAll().size();
        taskService.remove(indexToRemove);
        assertThat(taskService.getAll().size()).isEqualTo(sizeBeforeRemoving);
    }

    @Test
    public void shouldMarkTaskAsCompleted() {
        int indexOfTheUncompletedTask = 0;
        boolean taskStatusBeforeTheChange = taskService.getAll().get(indexOfTheUncompletedTask).completed();
        assertThat(taskStatusBeforeTheChange).isFalse();
        taskService.markAsCompleted(indexOfTheUncompletedTask);
        boolean taskStatusAfterTheChange = taskService.getAll().get(indexOfTheUncompletedTask).completed();
        assertThat(taskStatusAfterTheChange).isTrue();
    }

    @Test
    public void shouldNotChangeTheStatusDueToWrongIndex() {
        int indexOfTheUncompletedTask = 3;
        List<Boolean> statusesBeforeAction = taskService.getAll().stream().map(Task::completed).toList();
        taskService.markAsCompleted(indexOfTheUncompletedTask);
        List<Boolean> statusesAfterAction = taskService.getAll().stream().map(Task::completed).toList();
        assertThat(statusesAfterAction).isEqualTo(statusesBeforeAction);
    }
}
