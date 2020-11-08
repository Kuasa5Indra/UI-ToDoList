package com.example.todolist.presenter;

import android.content.Context;

import com.example.todolist.adapter.TaskAdapter;
import com.example.todolist.helper.ToDoListDbHelper;
import com.example.todolist.model.Task;
import com.example.todolist.view.MainView;

import java.util.List;

public class MainPresenterImpl implements MainPresenter {

    private MainView view;
    private List<Task> taskList;
    private ToDoListDbHelper dbHelper;

    public MainPresenterImpl(MainView view, Context context) {
        this.view = view;
        dbHelper = new ToDoListDbHelper(context);
    }

    @Override
    public void onTapCreateTask() {
        view.redirectToCreateTaskForm();
    }

    @Override
    public void onLoadTasks(Context context) {
        taskList = dbHelper.getTasks();
        TaskAdapter adapter = new TaskAdapter(context, taskList);
        view.setupToDoList(adapter);
    }

    @Override
    public void onDeleteTask(int id) {
        int idTask = taskList.get(id).getId();
        dbHelper.deleteTask(idTask);
    }

    @Override
    public void onEditTask(int id) {
        Task task = taskList.get(id);
        view.redirectToEditTaskForm(task);
    }
}
