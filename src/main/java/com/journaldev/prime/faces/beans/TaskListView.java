package com.journaldev.prime.faces.beans;

import com.journaldev.hibernate.data.Task;
import com.journaldev.spring.service.TaskService;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name = "taskListView")
@SessionScoped
public class TaskListView {

    @ManagedProperty("#{taskService}")
    private TaskService taskService;

    private boolean completed;

    private Task task = new Task();

    public TaskService getTaskService() {
        return taskService;
    }

    public String register() {
        // Calling Business Service
        taskService.register(task);
        // Add message
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage("The Task " + this.task.getTitle() + " Is Registered Successfully"));
        return "";
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public void setTaskService(TaskService taskService) {
        this.taskService = taskService;
    }


    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
