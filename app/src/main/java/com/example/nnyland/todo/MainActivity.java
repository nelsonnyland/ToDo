package com.example.nnyland.todo;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity
        implements OnClickListener {

    private SharedPreferences savedValues;
    private Button btnAddTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnAddTask = (Button) findViewById(R.id.btnAddTask);
        btnAddTask.setOnClickListener(this);
        savedValues = getSharedPreferences("SavedValues", MODE_PRIVATE);
    }

    /*
    @Override
    public void onPause() {
        Editor editor = savedValues.edit();
        editor.putString("task1", task1);
        //editor.commit();
        editor.apply();
        super.onPause();
    }

    @Override
    public void onResume() {
        super.onResume();
        task1 = savedValues.getString("task1", "");
        txtTask1.setText(task1);
    }
    */

    @Override
    public void onClick(View v) {
        Toast.makeText(this, "ADD TASK",
                Toast.LENGTH_LONG).show();
        //Log.d(TAG, "RUN TERMINAL OUTPUT: NEW TASK BUTTON CLICKED!");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_settings, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.menu_settings) {
            startActivity(new Intent(getApplicationContext(),
                    SettingsActivity.class));
            //Toast.makeText(this, "SETTINGS",
            //        Toast.LENGTH_LONG).show();
            //Log.d(TAG, "RUN TERMINAL OUTPUT: SETTINGS SELECTION CLICKED!");
            return true;
        } else if (item.getItemId() == R.id.menu_about) {
            //startActivity(new Intent(getApplicationContext(),
            //        AboutActivity.class));
            Toast.makeText(this, "ABOUT",
                    Toast.LENGTH_LONG).show();
            //Log.d(TAG, "RUN TERMINAL OUTPUT: ABOUT SELECTION CLICKED!");
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }
}
