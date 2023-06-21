package com.example.recycleview;



import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity6 extends AppCompatActivity {

    ListView listView;
    List<Student> list = new ArrayList<>();
    Student student;
    ArrayList<String> arrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);
        listView = findViewById(R.id.lists);

        DbHelper db = new DbHelper(this);

        list = db.selectAllStudents();

        for (int i = 0; i < list.size(); i++) {

            arrayList.add(list.get(i).getName());

        }

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this , android.R.layout.simple_list_item_1, arrayList);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //String f = arrayList.get(i);
                int f = 1;

                for (int j = 0; j < arrayList.size(); j++) {
                    if (arrayList.get(i).equals(list.get(i).getId()) ){
                        f = list.get(i).getId();
                    }

                }


                Intent intent = new Intent(MainActivity6.this , MainActivity4.class);
                //Toast.makeText(MainActivity.this, f, Toast.LENGTH_SHORT).show();
                intent.putExtra("id" , f);
                //intent.putExtra("ayatStart" , SSP[position]);
                //intent.putExtra("ayatEnd" , (SSP[position + 1]  ) );
                startActivity(intent);
            }
        });

    }
}