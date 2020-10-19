package com.example.todolist.view;

import com.example.todolist.adapter.TaskAdapter;

public interface MainView {
    void redirectToCreateTaskForm();
    void setupToDoList(TaskAdapter adapter);
}
