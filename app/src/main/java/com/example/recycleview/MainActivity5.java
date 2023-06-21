package com.example.recycleview;



import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity5 extends AppCompatActivity {

    ListView list2;

    DbHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        list2 = findViewById(R.id.list2);
        db = new DbHelper(this);

        ArrayAdapter<Records> arrayAdapter = new ArrayAdapter<Records>(this , android.R.layout.simple_list_item_1 , db.selectAllRecords());
        list2.setAdapter(arrayAdapter);


    }
}