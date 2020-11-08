package com.example.todolist.presenter;

import android.content.Context;

import com.example.todolist.helper.ToDoListDbHelper;
import com.example.todolist.model.Task;
import com.example.todolist.view.EditTaskView;

public class EditTaskPresenterImpl implements EditTaskPresenter{

    private ToDoListDbHelper dbHelper;
    private EditTaskView view;

    public EditTaskPresenterImpl(EditTaskView view, Context context) {
        this.view = view;
        dbHelper = new ToDoListDbHelper(context);
    }

    @Override
    public void editTask(int id, String title, String description, String datetime) {
        dbHelper.updateTask(new Task(id, title, description, datetime));
        view.redirectToMain();
    }
}
