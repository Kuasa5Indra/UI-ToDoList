package com.example.todolist.presenter;

import com.example.todolist.model.Task;
import com.example.todolist.view.CreateTaskView;

public class CreateTaskPresenterImpl implements CreateTaskPresenter{
    private CreateTaskView view;

    public CreateTaskPresenterImpl(CreateTaskView view) {
        this.view = view;
    }

    @Override
    public void createTask(String title) {
        view.showToast(title);
    }
}
