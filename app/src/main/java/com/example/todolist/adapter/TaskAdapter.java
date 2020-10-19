package com.example.todolist.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.todolist.R;
import com.example.todolist.model.Task;

import java.util.List;

public class TaskAdapter extends BaseAdapter {
    private Context context;
    private List<Task> tasks;

    public TaskAdapter(Context context, List<Task> tasks) {
        this.context = context;
        this.tasks = tasks;
    }

    @Override
    public int getCount() {
        return tasks.size();
    }

    @Override
    public Object getItem(int i) {
        return tasks.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        Task task = (Task) getItem(i);
        if(view == null){
            LayoutInflater inflater = LayoutInflater.from(context);
            view = inflater.inflate(R.layout.task_listview, null);
        }
        TextView tvTitle = view.findViewById(R.id.tv_title);
        TextView tvDescription = view.findViewById(R.id.tv_description);
        TextView tvDateTime = view.findViewById(R.id.tv_datetime);
        tvTitle.setText(task.getTitle());
        tvDescription.setText(task.getDescription());
        tvDateTime.setText(task.getDateTime());
        return view;
    }
}
