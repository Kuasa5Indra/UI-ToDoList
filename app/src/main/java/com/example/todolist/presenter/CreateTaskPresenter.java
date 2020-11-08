package com.example.todolist.presenter;

import com.example.todolist.model.Task;

public interface CreateTaskPresenter {
    void createTask(String title, String description, String datetime);
}
