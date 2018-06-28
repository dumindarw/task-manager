package com.task.service;

import com.task.model.Task;

import java.util.List;

/**
 * Created by duminda on 6/17/18.
 */
public interface TaskService {

    public void addTask(Task task);
    public void updateTask(Task task);
    public Task getTaskById(int id);
    public List<Task> getAllTasks();
    public int deleteTask(int id);
}
