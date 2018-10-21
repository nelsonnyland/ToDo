package com.example.nnyland.todo;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

import static android.content.ContentValues.TAG;

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

    @Override
    public void onClick(View v) {
        Toast.makeText(this, "Button Clicked",
                        Toast.LENGTH_LONG).show();
        Log.d(TAG, "RUN TERMINAL OUTPUT: NEW TASK BUTTON CLICKED!");
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
}
