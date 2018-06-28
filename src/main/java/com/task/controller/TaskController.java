package com.task.controller;

import com.task.model.Task;
import com.task.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by duminda on 6/19/18.
 */
@Controller
public class TaskController {

    private TaskService taskService;

    @Autowired(required = true)
    @Qualifier(value = "taskService")
    public void setTaskService(TaskService taskService) {
        this.taskService = taskService;
    }

    @RequestMapping(value = "/tasks", method = RequestMethod.GET)
    public String listTasks(Model model){

        model.addAttribute("task", new Task());
        model.addAttribute("taskList", taskService.getAllTasks());
        return "task";
    }

    @RequestMapping(value = "/tasks/add", method = RequestMethod.POST)
    public String addTask(@ModelAttribute("task") Task task){
        if(task.getId() == 0)  this.taskService.addTask(task);
        else this.taskService.updateTask(task);

        return "redirect:/tasks";
    }

    @RequestMapping(value = "/tasks/remove/{id}")
    public String removeTask(@PathVariable("id") int id){
        this.taskService.deleteTask(id);
        return "redirect:/tasks";
    }

    @RequestMapping(value = "/tasks/edit/{id}")
    public String updateTask(@PathVariable("id") int id, Model model){

        model.addAttribute("task", this.taskService.getTaskById(id));
        model.addAttribute("taskList", this.taskService.getAllTasks());
        return "task";
    }
}
