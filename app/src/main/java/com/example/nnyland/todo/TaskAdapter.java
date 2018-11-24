package com.example.nnyland.todo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.List;

public class TaskAdapter extends ArrayAdapter {

    private static final String TAG = "TaskAdapter";
    private final int layoutResource;
    private final LayoutInflater layoutInflater;
    private List<Task> tasks;

    public TaskAdapter(Context context, int resource, List<Task> tasks) {
        super(context, resource);
        this.layoutResource = resource;
        this.layoutInflater = LayoutInflater.from(context);
        this.tasks = tasks;
    }

    @Override
    public int getCount() {
        return tasks.size();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // creates an instance of the task layout if there isn't one already
        if (convertView == null) {
            convertView = layoutInflater.inflate(layoutResource, parent, false);
        }

        // gets the text-views in the layout
        CheckBox checkBox = convertView.findViewById(R.id.task_checkbox);
        TextView title = convertView.findViewById(R.id.task_title);
        TextView notes = convertView.findViewById(R.id.task_notes);

        // gets the task location
        Task task = tasks.get(position);

        // sets the text for the task
        checkBox.setChecked(task.isComplete());
        title.setText(task.getTitle());
        notes.setText(task.getNotes());

        // return view
        return convertView;
    }
}
