package com.example.todolist.presenter;

import android.content.Context;

import com.example.todolist.adapter.TaskAdapter;
import com.example.todolist.model.Task;
import com.example.todolist.view.MainView;

import java.util.ArrayList;
import java.util.List;

public class MainPresenterImpl implements MainPresenter {

    private MainView view;
    protected List<Task> taskList;

    public MainPresenterImpl(MainView view) {
        this.view = view;
        taskList = new ArrayList<>();
        taskList.add(new Task("Judul", "deskripsi", "jam 1"));
        taskList.add(new Task("Judul 2", "deskripsi 2", "jam 2"));
    }

    @Override
    public void onTapCreateTask() {
        view.redirectToCreateTaskForm();
    }

    @Override
    public void onLoadTasks(Context context) {
        TaskAdapter adapter = new TaskAdapter(context, taskList);
        view.setupToDoList(adapter);
    }
}
