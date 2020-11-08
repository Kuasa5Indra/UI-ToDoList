package com.example.todolist.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.todolist.R;
import com.example.todolist.activity.MainActivity;
import com.example.todolist.base.BaseFragment;
import com.example.todolist.presenter.CreateTaskPresenter;
import com.example.todolist.presenter.CreateTaskPresenterImpl;
import com.example.todolist.view.CreateTaskView;
import com.google.android.material.textfield.TextInputEditText;

public class CreateTaskFragment extends BaseFragment implements CreateTaskView {

    private TextInputEditText et_title;
    private TextInputEditText et_desc;
    private TextInputEditText et_date;
    private TextInputEditText et_time;
    private Button button;
    private CreateTaskPresenter presenter;

    public CreateTaskFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_create_task, container, false);
        presenter = new CreateTaskPresenterImpl(this, getContext());
        et_title = view.findViewById(R.id.c_titleEditText);
        et_desc = view.findViewById(R.id.c_descriptionEditText);
        et_date = view.findViewById(R.id.c_dateEditText);
        et_time = view.findViewById(R.id.c_timeEditText);
        button = view.findViewById(R.id.createTaskButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String title = et_title.getText().toString();
                String description = et_desc.getText().toString();
                String datetime = et_date.getText().toString().concat(" " + et_time.getText().toString());
                presenter.createTask(title, description, datetime);
            }
        });
        return view;
    }

    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void redirectToMain() {
        Intent intent = new Intent(getActivity(), MainActivity.class);
        startActivity(intent);
        getActivity().finish();
    }
}
