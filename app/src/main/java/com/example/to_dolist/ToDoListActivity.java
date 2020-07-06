package com.example.to_dolist;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ToDoListActivity extends AppCompatActivity {

    private EditText to_dos;
    private TaskAdapter adapter;
    private ArrayList<String> taskList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_to_do_list);

        RecyclerView taskRecycler = findViewById(R.id.recycler_task);
        LinearLayoutManager taskLayoutManager = new LinearLayoutManager(this);
        taskRecycler.setLayoutManager(taskLayoutManager);

        taskList = new ArrayList<String>();
        adapter = new TaskAdapter(this, taskList);
        taskRecycler.setAdapter(adapter);

//        ListView listView = findViewById(R.id.list_view);
//
//        String[] taskList = {"Shoping", "Cooking"};
//        tasks = new ArrayList<>(Arrays.asList(taskList));
//
//        taskAdapter = new ArrayAdapter(this, R.layout.simple_white_list_1, tasks);
//        listView.setAdapter(taskAdapter);
//
//        to_dos = findViewById(R.id.add_task);

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
                                taskList.add(task);
                                adapter.notifyDataSetChanged();


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

//        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
//            @Override
//            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
//                tasks.remove(position);
//                taskAdapter.notifyDataSetChanged();
//               return true;
//            }
//        });

    }

}