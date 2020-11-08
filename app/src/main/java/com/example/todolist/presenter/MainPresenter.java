package com.example.todolist.presenter;

import android.content.Context;

public interface MainPresenter {
    void onTapCreateTask();
    void onLoadTasks(Context context);
    void onDeleteTask(int id);
    void onEditTask(int id);
}
