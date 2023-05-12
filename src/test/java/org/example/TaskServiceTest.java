package org.example;


import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;


public class TaskServiceTest {

    Task task1 = new Task("Zadanie 1", false);
    Task task2 = new Task("Zadanie 2", true);
    Task task3 = new Task("Zadanie 3", false);

    @Test
    public void shouldAddTaskToTheList() {
        //Given:
        ArrayList<Task> taskList = new ArrayList<>(List.of(task1, task2, task3));
        TaskService taskService = new TaskService(taskList);
        String newTask = "Tidy up your room";

        //When:
        taskService.add(newTask);

        //Then:
        assertThat(taskService.getAll().stream().map(Task::value)).containsOnlyOnce(newTask);
    }

    @Test
    public void shouldRemoveElementFromList() {
        //Given:
        ArrayList<Task> taskList = new ArrayList<>(List.of(task1, task2, task3));
        TaskService taskService = new TaskService(taskList);
        int indexToRemove = 1;
        String elementNameToRemove = taskService.getAll().get(indexToRemove).value();

        //When:
        taskService.remove(indexToRemove);

        //Then:
        assertThat(taskService.getAll().stream().map(Task::value)).doesNotContain(elementNameToRemove);
    }

    @Test
    public void shouldNotRemoveElementsFromListWhenWrongIndexProvided() {
        //Given:
        ArrayList<Task> taskList = new ArrayList<>(List.of(task1, task2, task3));
        TaskService taskService = new TaskService(taskList);
        int indexToRemove = -2;
        List<Task> elementsBeforeAnAction = taskService.getAll();

        //When:
        taskService.remove(indexToRemove);

        //Then:
        assertThat(taskService.getAll()).hasSameElementsAs(elementsBeforeAnAction);
    }

    @Test
    public void shouldMarkTaskAsCompleted() {
        //Given:
        ArrayList<Task> taskList = new ArrayList<>(List.of(task1, task2, task3));
        TaskService taskService = new TaskService(taskList);
        int indexOfTheUncompletedTask = 0;

        //When:
        taskService.markAsCompleted(indexOfTheUncompletedTask);
        boolean taskStatusAfterTheChange = taskService.getAll().get(indexOfTheUncompletedTask).completed();

        //Then:
        assertThat(taskStatusAfterTheChange).isTrue();
    }

    @Test
    public void shouldNotChangeTheStatusDueToWrongIndex() {
        //Given:
        ArrayList<Task> taskList = new ArrayList<>(List.of(task1, task2, task3));
        TaskService taskService = new TaskService(taskList);
        int indexOfTheUncompletedTask = 3;
        List<Task> statusesBeforeAction = taskService.getAll();

        //When:
        taskService.markAsCompleted(indexOfTheUncompletedTask);

        //Then:
        assertThat(taskService.getAll()).usingRecursiveComparison()
                .isEqualTo(statusesBeforeAction);
    }
}
