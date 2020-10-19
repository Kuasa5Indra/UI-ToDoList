package com.example.todolist.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.example.todolist.R;
import com.example.todolist.adapter.TaskAdapter;
import com.example.todolist.model.Task;
import com.example.todolist.presenter.MainPresenter;
import com.example.todolist.presenter.MainPresenterImpl;
import com.example.todolist.view.MainView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class MainActivity extends AppCompatActivity implements MainView {

    private FloatingActionButton addButton;
    private ListView todolistview;
    private MainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        todolistview = findViewById(R.id.todolistview);
        addButton = findViewById(R.id.floatingActionButton);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.onTapCreateTask();
            }
        });
        presenter = new MainPresenterImpl(this);
        presenter.onLoadTasks(this);
    }

    @Override
    public void redirectToCreateTaskForm() {
        Intent intent = new Intent(getApplicationContext(), CreateTaskActivity.class);
        startActivity(intent);
    }

    @Override
    public void setupToDoList(TaskAdapter adapter) {
        todolistview.setAdapter(adapter);
    }
}