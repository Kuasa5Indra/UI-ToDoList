package com.example.todolist.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.example.todolist.R;
import com.example.todolist.adapter.TaskAdapter;
import com.example.todolist.base.BaseActivity;
import com.example.todolist.fragment.MainFragment;
import com.example.todolist.presenter.MainPresenter;
import com.example.todolist.presenter.MainPresenterImpl;
import com.example.todolist.view.MainView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends BaseActivity {

    private MainFragment fragment;
    @Override
    protected void initViews() {
        fragment = new MainFragment();
        setFragmentTransaction(fragment);
    }
}