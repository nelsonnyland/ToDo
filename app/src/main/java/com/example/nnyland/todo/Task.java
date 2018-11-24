package com.example.nnyland.todo;

public class Task {

    private int taskId;
    private String title;
    private String notes;
    private boolean complete;
    private boolean hidden;

    public Task() {
        title = "";
        notes = "";
        complete = false;
        hidden = false;
    }

    public Task(int taskId, String title, String notes,
                boolean complete, boolean hidden) {
        this.taskId = taskId;
        this.title = title;
        this.notes = notes;
        this.complete = complete;
        this.hidden = hidden;
    }

    public int getId() {
        return taskId;
    }

    public void setId(int taskId) {
        this.taskId = taskId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public boolean isComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }

    public boolean isHidden() {
        return hidden;
    }

    public void setHidden(boolean hidden) {
        this.hidden = hidden;
    }
}
