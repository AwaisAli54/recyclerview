package com.example.recycleview;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity3 extends AppCompatActivity {

    ListView listView;
    ArrayList<String> arrayList = new ArrayList<>();

    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;

    DbHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);



        db = new DbHelper(this);

        List<Student> list = db.selectAllStudents();

        //ArrayAdapter<Student> arrayAdapter = new ArrayAdapter<Student>(this , android.R.layout.simple_list_item_1, list);
        //listView.setAdapter(arrayAdapter);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);




        recyclerView.setLayoutManager(layoutManager);

        adapter = new RecyclerViewAdapter(list) ;
        recyclerView.setAdapter(adapter);





    }
}