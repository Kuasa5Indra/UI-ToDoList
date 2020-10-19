package com.example.todolist.model;

import java.io.Serializable;

public class Task {
    private String title;
    private String description;
    private String dateTime;

    public Task(String title, String description, String dateTime) {
        this.title = title;
        this.description = description;
        this.dateTime = dateTime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }
}
