package com.task.service;

import com.task.dao.TasksDAO;
import com.task.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by duminda on 6/19/18.
 */
@Service
public class TaskServiceImpl implements TaskService{

    @Autowired
    private TasksDAO tasksDAO;

    public void setTasksDAO(TasksDAO tasksDAO) {
        this.tasksDAO = tasksDAO;
    }

    @Override
    @Transactional
    public void addTask(Task task) {
        this.tasksDAO.insertRecord(task);
    }

    @Override
    public void updateTask(Task task) {

    }

    @Override
    @Transactional
    public Task getTaskById(int id) {
        return  this.tasksDAO.getRecordById(id);
    }

    @Override
    @Transactional
    public List<Task> getAllTasks() {
        return  this.tasksDAO.getAllRecords();
    }

    @Override
    @Transactional
    public int deleteTask(int id) {
        return  this.tasksDAO.deleteRecord(id);
    }
}
