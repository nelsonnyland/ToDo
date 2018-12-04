package com.example.nnyland.todo;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RelativeLayout;

import java.util.List;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.TaskHolder> {

    private List<Task> taskList;

    // view holder for task views
    public static class TaskHolder extends RecyclerView.ViewHolder {
        public CheckBox checkBox;
        public EditText taskTitle;
        public TaskHolder(View v) {
            super(v);
            checkBox = v.findViewById(R.id.task_checkbox);
            taskTitle = v.findViewById(R.id.task_title);
        }
    }

    // constructor
    public TaskAdapter(List<Task> tasks) {
        this.taskList = tasks;
    }

    // create new view
    @Override
    public TaskAdapter.TaskHolder onCreateViewHolder(ViewGroup parent,
                                                     int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.task_layout, parent, false);
        return new TaskHolder(view);
    }

    // refresh content
    @Override
    public void onBindViewHolder(TaskHolder taskHolder, int position) {
        // get task
        Task task = taskList.get(position);
        // set data
        taskHolder.checkBox.setChecked(task.isComplete());
        taskHolder.taskTitle.setText(task.getTitle());
    }

    @Override
    public int getItemCount() {
        return taskList.size();
    }
}
