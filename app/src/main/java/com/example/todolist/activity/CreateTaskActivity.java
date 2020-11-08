package com.example.todolist.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.todolist.R;
import com.example.todolist.base.BaseActivity;
import com.example.todolist.fragment.CreateTaskFragment;
import com.example.todolist.presenter.CreateTaskPresenter;
import com.example.todolist.presenter.CreateTaskPresenterImpl;
import com.example.todolist.view.CreateTaskView;
import com.google.android.material.textfield.TextInputEditText;

public class CreateTaskActivity extends BaseActivity {

    private CreateTaskFragment fragment;

    @Override
    protected void initViews() {
        toolbar.setTitle("Create Task");
        fragment = new CreateTaskFragment();
        setFragmentTransaction(fragment);
    }
}