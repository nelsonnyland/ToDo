package com.example.nnyland.todo;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
        implements OnClickListener {

    private FloatingActionButton addTask;
    private SharedPreferences savedValues;
    private ArrayList<Task> tasklist;
    private ListView taskView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);

        savedValues = getSharedPreferences(
                "SavedValues", MODE_PRIVATE);
        addTask = findViewById(R.id.button_addTask);
        taskView = findViewById(R.id.listView_taskView);
        addTask.setOnClickListener(this);

        refreshTaskList();
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

    public void refreshTaskList() {
        // grab tasks from db
        tasklist = new ArrayList<Task>();
        Task test1 = new Task(01, "task 1", "Notes...",
                false, false);
        tasklist.add(test1);

        // set adapter for task layout
        TaskAdapter adapter = new TaskAdapter(
                MainActivity.this, R.layout.task_layout,
                tasklist
        );
        taskView.setAdapter(adapter);
    }
}
