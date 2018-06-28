package com.task.dao;

import com.task.model.Task;

import java.util.List;

/**
 * Created by duminda on 6/14/18.
 */
public interface TasksDAO {

    public void insertRecord(Task task);
    public void updateRecord(Task task);
    public Task getRecordById(int id);
    public List<Task> getAllRecords();
    public int deleteRecord(int id);
}
