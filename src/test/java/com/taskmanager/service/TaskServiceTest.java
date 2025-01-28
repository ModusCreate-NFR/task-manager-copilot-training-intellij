package com.taskmanager.service;

import com.taskmanager.model.Task;
import com.taskmanager.repository.TaskRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TaskServiceTest {
    private TaskService taskService;
    private TaskRepository taskRepository;

    @BeforeEach
    void setUp() {
        taskRepository = new TaskRepository();
        taskService = new TaskService(taskRepository);
    }

    @Test
    void testAddTask() {
        Task task = new Task(1, "Test Task", "This is a test task");
        taskService.addTask(task);
        assertEquals(1, taskRepository.findAll().size());
    }

    @Test
    void testGetAllTasks() {
        Task task1 = new Task(1, "Test Task 1", "This is the first test task");
        Task task2 = new Task(2, "Test Task 2", "This is the second test task");
        taskService.addTask(task1);
        taskService.addTask(task2);
        List<Task> tasks = taskService.getAllTasks();
        assertEquals(2, tasks.size());
    }
}