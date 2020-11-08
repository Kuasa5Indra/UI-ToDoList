package com.example.todolist.fragment;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import com.example.todolist.R;
import com.example.todolist.activity.CreateTaskActivity;
import com.example.todolist.activity.EditTaskActivity;
import com.example.todolist.activity.MainActivity;
import com.example.todolist.adapter.TaskAdapter;
import com.example.todolist.base.BaseFragment;
import com.example.todolist.model.Task;
import com.example.todolist.presenter.MainPresenter;
import com.example.todolist.presenter.MainPresenterImpl;
import com.example.todolist.view.MainView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainFragment extends BaseFragment implements MainView {

    private FloatingActionButton addButton;
    private ListView todolistview;
    private MainPresenter presenter;

    public MainFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        todolistview = view.findViewById(R.id.todolistview);
        addButton = view.findViewById(R.id.floatingActionButton);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.onTapCreateTask();
            }
        });
        presenter = new MainPresenterImpl(this, getContext());
        presenter.onLoadTasks(getContext());
        return view;
    }

    @Override
    public void redirectToCreateTaskForm() {
        Intent intent = new Intent(getActivity(), CreateTaskActivity.class);
        startActivity(intent);
        getActivity().finish();
    }

    @Override
    public void redirectToEditTaskForm(Task task) {
        Intent intent = new Intent(getActivity(), EditTaskActivity.class);
        intent.putExtra("id", task.getId());
        intent.putExtra("title", task.getTitle());
        intent.putExtra("desc", task.getDescription());
        intent.putExtra("datetime", task.getDateTime());
        startActivity(intent);
        getActivity().finish();
    }

    @Override
    public void setupToDoList(TaskAdapter adapter) {
        todolistview.setAdapter(adapter);
        registerForContextMenu(todolistview);
    }

    @Override
    public void onCreateContextMenu(@NonNull ContextMenu menu, @NonNull View v, @Nullable ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getActivity().getMenuInflater();
        inflater.inflate(R.menu.ud_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        AdapterView.AdapterContextMenuInfo info= (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        Long id = todolistview.getItemIdAtPosition(info.position);
        switch (item.getItemId()){
            case R.id.edit_task:
                presenter.onEditTask(id.intValue());
                return true;
            case R.id.delete_task:
                presenter.onDeleteTask(id.intValue());
                presenter.onLoadTasks(getContext());
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }
}
