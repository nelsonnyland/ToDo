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

public class MainActivity extends AppCompatActivity
        implements OnClickListener {

    private FloatingActionButton addTask;
    private SharedPreferences savedValues;
    private ArrayList<Task> tasklist;
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
            Snackbar.make(v, "Added task", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();
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
     * Obtains a tasklist from database and fills adapter with data
     *
     */
    public void createTaskList() {
        // grab tasks from db
        tasklist = new ArrayList<Task>();
        Task test1 = new Task(01, "task 1", "Notes...",
                false, false);
        tasklist.add(test1);

        // set layout manager
        manager = new LinearLayoutManager(this);
        taskView.setLayoutManager(manager);

        // set adapter for layout
        adapter = new TaskAdapter(tasklist);
        taskView.setAdapter(adapter);
    }
}
