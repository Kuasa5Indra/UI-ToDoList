package com.example.todolist.view;

import com.example.todolist.adapter.TaskAdapter;
import com.example.todolist.model.Task;

public interface MainView {
    void redirectToCreateTaskForm();
    void redirectToEditTaskForm(Task task);
    void setupToDoList(TaskAdapter adapter);
}
