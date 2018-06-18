package com.journaldev.prime.faces.beans;

import com.journaldev.hibernate.data.Task;
import com.journaldev.spring.service.TaskService;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import java.util.List;

@ManagedBean(name = "taskEditListView")
@SessionScoped
public class TaskEditListView {

    @ManagedProperty("#{taskService}")
    private TaskService taskService;

    private List<Task> taskList;

    private Task selectedTask;

    public Task getSelectedTask() {
        return selectedTask;
    }

    public void setSelectedTask(Task selectedTask) {
        this.selectedTask = selectedTask;
    }

    @PostConstruct
    public void init() {
        taskList = taskService.getTasks();
    }

    public void save()
    {
       taskService.save(selectedTask);
    }

    public void delete()
    {
        taskService.delete(selectedTask);
    }

    public TaskService getTaskService() {
        return taskService;
    }

    public void setTaskService(TaskService taskService) {
        this.taskService = taskService;
    }

    public List<Task> getTaskList() {
        return taskList;
    }

    public void setTaskList(List<Task> taskList) {
        this.taskList = taskList;
    }
}
