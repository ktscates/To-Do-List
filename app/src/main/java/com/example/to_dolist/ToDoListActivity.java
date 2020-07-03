package com.example.to_dolist;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Arrays;

public class ToDoListActivity extends AppCompatActivity {

    private ArrayAdapter taskAdapter;
    private ArrayList tasks;
    private EditText to_dos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_to_do_list);

        ListView listView = findViewById(R.id.list_view);

        String[] taskList = {};
        tasks = new ArrayList<>(Arrays.asList(taskList));

        taskAdapter = new ArrayAdapter(this, R.layout.simple_white_list_1, tasks);
        listView.setAdapter(taskAdapter);

        to_dos = findViewById(R.id.add_task);

        FloatingActionButton fab = findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder builder = new AlertDialog.Builder(ToDoListActivity.this);
                View addTaskView = getLayoutInflater().inflate(R.layout.dialog_add_task, null);

                builder.setView(addTaskView)
                        .setTitle("Add a new task")
                        .setPositiveButton(R.string.add, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                                String task = to_dos.getText().toString();
                                tasks.add(task);
                                taskAdapter.notifyDataSetChanged();


                            }
                        })
                        .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        });

                to_dos = addTaskView.findViewById(R.id.add_task);

                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
        });

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                tasks.remove(position);
                taskAdapter.notifyDataSetChanged();
               return true;
            }
        });

    }

}