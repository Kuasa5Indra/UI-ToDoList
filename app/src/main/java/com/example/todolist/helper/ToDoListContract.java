package com.example.todolist.helper;

import android.provider.BaseColumns;

public class ToDoListContract implements BaseColumns {
    private ToDoListContract(){}

    public static final String TABLE_NAME = "todolist";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_TITLE = "title";
    public static final String COLUMN_DESC = "description";
    public static final String COLUMN_DATETIME = "datetime";
}
