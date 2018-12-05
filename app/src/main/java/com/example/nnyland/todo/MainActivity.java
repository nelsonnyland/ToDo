package com.example.nnyland.todo;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements OnClickListener {

    private FloatingActionButton addTask;
    private SharedPreferences savedValues;
    private List<Task> tasklist;
    private RecyclerView taskView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);

        savedValues = getSharedPreferences(
                "SavedValues", MODE_PRIVATE);
        addTask = findViewById(R.id.button_addTask);
        taskView = findViewById(R.id.taskView);
        addTask.setOnClickListener(this);

        createTaskList();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.button_addTask) {
            addTask();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.settings_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.menu_settings) {
            startActivity(new Intent(getApplicationContext(),
                    SettingsActivity.class));
            return true;
        } else if (item.getItemId() == R.id.menu_about) {
            startActivity(new Intent(getApplicationContext(),
                    AboutActivity.class));
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }

    /**
     * Obtains a tasklist from database and fills adapter with data.
     *
     */
    public void createTaskList() {
        tasklist = new ArrayList<Task>();
        // GRAB TASKS FROM DB //

        // set layout manager
        manager = new LinearLayoutManager(this);
        taskView.setLayoutManager(manager);

        // set adapter for layout
        adapter = new TaskAdapter(tasklist);
        taskView.setAdapter(adapter);
    }

    /**
     * Creates a blank task in response to the add task button
     * click event.
     */
    public void addTask() {
        int size = adapter.getItemCount();
        Task task = new Task();
        tasklist.add(task);
        adapter.notifyItemInserted(size);
    }
}
