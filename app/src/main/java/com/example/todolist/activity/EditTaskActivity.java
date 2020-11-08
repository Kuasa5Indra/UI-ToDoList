package com.example.todolist.activity;

import android.os.Bundle;

import com.example.todolist.base.BaseActivity;
import com.example.todolist.fragment.EditTaskFragment;
import com.example.todolist.model.Task;

public class EditTaskActivity extends BaseActivity {
    private EditTaskFragment fragment;

    @Override
    protected void initViews() {
        toolbar.setTitle("Edit Task");
        Bundle bundle = getIntent().getExtras();
        fragment = new EditTaskFragment(bundle);
        setFragmentTransaction(fragment);
    }
}
