package com.example.todolist.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.todolist.R;
import com.example.todolist.model.Task;
import com.example.todolist.presenter.CreateTaskPresenter;
import com.example.todolist.presenter.CreateTaskPresenterImpl;
import com.example.todolist.view.CreateTaskView;
import com.google.android.material.textfield.TextInputEditText;

public class CreateTaskActivity extends AppCompatActivity implements CreateTaskView {

    private TextInputEditText et_title;
    private TextInputEditText et_desc;
    private TextInputEditText et_date;
    private TextInputEditText et_time;
    private Button button;
    private CreateTaskPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_task);

        presenter = new CreateTaskPresenterImpl(this);
        this.setTitle("Create Task");
        et_title = findViewById(R.id.titleEditText);
        et_desc = findViewById(R.id.descriptionEditText);
        et_date = findViewById(R.id.dateEditText);
        et_time = findViewById(R.id.timeEditText);
        button = findViewById(R.id.createTaskButton);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String title = et_title.getText().toString();
                String desc = et_desc.getText().toString();
                String datetime = et_date.getText().toString().concat(et_time.getText().toString());
                presenter.createTask(title);
            }
        });
    }

    @Override
    public void showToast(String title) {
        Toast.makeText(getApplicationContext(), title, Toast.LENGTH_LONG).show();
    }
}