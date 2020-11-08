package com.example.todolist.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.todolist.R;
import com.example.todolist.activity.MainActivity;
import com.example.todolist.base.BaseFragment;
import com.example.todolist.model.Task;
import com.example.todolist.presenter.EditTaskPresenter;
import com.example.todolist.presenter.EditTaskPresenterImpl;
import com.example.todolist.view.EditTaskView;
import com.google.android.material.textfield.TextInputEditText;

public class EditTaskFragment extends BaseFragment implements EditTaskView {
    private TextInputEditText et_title;
    private TextInputEditText et_desc;
    private TextInputEditText et_date;
    private TextInputEditText et_time;
    private Button button;
    private EditTaskPresenter presenter;
    private Bundle bundle;

    public EditTaskFragment(Bundle bundle) {
        this.bundle = bundle;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_edit_task, container, false);
        et_title = view.findViewById(R.id.e_titleEditText);
        et_desc = view.findViewById(R.id.e_descriptionEditText);
        et_date = view.findViewById(R.id.e_dateEditText);
        et_time = view.findViewById(R.id.e_timeEditText);
        button = view.findViewById(R.id.editTaskButton);
        initValue();
        presenter = new EditTaskPresenterImpl(this, getContext());
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String title = et_title.getText().toString();
                String description = et_desc.getText().toString();
                String datetime = et_date.getText().toString().concat(" " + et_time.getText().toString());
                presenter.editTask(bundle.getInt("id"), title, description, datetime);
            }
        });
        return view;
    }

    public void initValue(){
        String[] datetime = bundle.getString("datetime").split(" ");
        et_title.setText(bundle.getString("title"));
        et_desc.setText(bundle.getString("desc"));
        et_date.setText(datetime[0]);
        et_time.setText(datetime[1]);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public void redirectToMain() {
        Intent intent = new Intent(getActivity(), MainActivity.class);
        startActivity(intent);
        getActivity().finish();
    }
}
