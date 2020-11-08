package com.example.todolist.presenter;

import android.content.Context;

import com.example.todolist.helper.ToDoListDbHelper;
import com.example.todolist.model.Task;
import com.example.todolist.view.CreateTaskView;

public class CreateTaskPresenterImpl implements CreateTaskPresenter{
    private CreateTaskView view;
    private ToDoListDbHelper dbHelper;

    public CreateTaskPresenterImpl(CreateTaskView view, Context context) {
        this.view = view;
        dbHelper = new ToDoListDbHelper(context);
    }

    @Override
    public void createTask(String title, String description, String datetime) {
        dbHelper.insertTask(new Task(title, description, datetime));
        view.redirectToMain();
    }
}
