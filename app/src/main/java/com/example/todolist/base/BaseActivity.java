package com.example.todolist.base;

import android.os.Bundle;
import android.widget.Toolbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.todolist.R;

public abstract class BaseActivity extends AppCompatActivity {

    protected Toolbar toolbar;
    protected BaseFragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);

        toolbar = findViewById(R.id.toolbar);
        setActionBar(toolbar);
        initViews();
    }

    protected abstract void initViews();

    protected void setFragmentTransaction(BaseFragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, fragment);
        fragmentTransaction.commit();
        this.fragment = fragment;
    }
}
