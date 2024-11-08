package com.taskmanager.repository;

import com.taskmanager.model.Task;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class TaskRepository {
    private final List<Task> tasks = new ArrayList<>();
    private int currentId = 1;

    public Task save(Task task) {
        if (task.getId() == 0) {
            task.setId(currentId++);
            tasks.add(task);
        } else {
            tasks.removeIf(t -> t.getId() == task.getId());
            tasks.add(task);
        }
        return task;
    }

    public Optional<Task> findById(int id) {
        return tasks.stream().filter(task -> task.getId() == id).findFirst();
    }

    public List<Task> findAll() {
        return new ArrayList<>(tasks);
    }

    public boolean deleteById(int id) {
        return tasks.removeIf(task -> task.getId() == id);
    }

    public void deleteAll() {
        tasks.clear();
    }

    public int count() {
        return tasks.size();
    }




}