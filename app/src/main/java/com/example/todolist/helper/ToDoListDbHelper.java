package com.example.todolist.helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.todolist.model.Task;

import java.util.ArrayList;

public class ToDoListDbHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "todolist.db";

    private static final String SQL_CREATE_TABLE = "CREATE TABLE IF NOT EXISTS " + ToDoListContract.TABLE_NAME + " ("
            + ToDoListContract.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + ToDoListContract.COLUMN_TITLE
            + " VARCHAR(50), " + ToDoListContract.COLUMN_DESC + " TEXT, " + ToDoListContract.COLUMN_DATETIME
            + " VARCHAR(20))";
    private static final String SQL_DROP_TABLE = "DROP TABLE IF EXISTS " + ToDoListContract.TABLE_NAME;

    public ToDoListDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(SQL_CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(SQL_DROP_TABLE);
        onCreate(sqLiteDatabase);
    }

    public ArrayList<Task> getTasks(){
        ArrayList<Task> tasks = new ArrayList<>();
        Cursor cursor = getCursor();
        while (cursor.moveToNext()){
            tasks.add(new Task(cursor.getInt(cursor.getColumnIndex(ToDoListContract.COLUMN_ID)),
                    cursor.getString(cursor.getColumnIndex(ToDoListContract.COLUMN_TITLE)),
                    cursor.getString(cursor.getColumnIndex(ToDoListContract.COLUMN_DESC)),
                    cursor.getString(cursor.getColumnIndex(ToDoListContract.COLUMN_DATETIME))));
        }
        return tasks;
    }

    public void insertTask(Task task){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(ToDoListContract.COLUMN_TITLE, task.getTitle());
        values.put(ToDoListContract.COLUMN_DESC, task.getDescription());
        values.put(ToDoListContract.COLUMN_DATETIME, task.getDateTime());
        db.insert(ToDoListContract.TABLE_NAME, null, values);
        db.close();
    }

    public void updateTask(Task task){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(ToDoListContract.COLUMN_TITLE, task.getTitle());
        values.put(ToDoListContract.COLUMN_DESC, task.getDescription());
        values.put(ToDoListContract.COLUMN_DATETIME, task.getDateTime());
        String selection = ToDoListContract.COLUMN_ID + " = ?";
        String[] selectionArgs = { String.valueOf(task.getId()) };
        db.update(ToDoListContract.TABLE_NAME, values, selection, selectionArgs);
        db.close();
    }

    public void deleteTask(int id){
        SQLiteDatabase db = this.getReadableDatabase();
        String selection = ToDoListContract.COLUMN_ID + " = ?";
        String[] selectionArgs = { String.valueOf(id) };
        db.delete(ToDoListContract.TABLE_NAME, selection, selectionArgs);
        db.close();
    }

    private Cursor getCursor(){
        SQLiteDatabase db = this.getReadableDatabase();
        return db.query(
                ToDoListContract.TABLE_NAME,
                null,
                null,
                null,
                null,
                null,
                null
        );
    }
}
