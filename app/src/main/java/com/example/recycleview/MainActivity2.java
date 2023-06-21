package com.example.recycleview;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    TextView textname, textage , textclass;
    Button btn;
    DbHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        textname = findViewById(R.id.editTextText);
        textage = findViewById(R.id.editTextText2);
        textclass = findViewById(R.id.editTextText3);
        btn = findViewById(R.id.button5);
        db = new DbHelper(this);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = textname.getText().toString();
                String age = textage.getText().toString();
                String clas = textclass.getText().toString();

                if (name.isEmpty() || age.isEmpty() || clas.isEmpty()) {
                    Toast.makeText(MainActivity2.this, "Please enter missing data", Toast.LENGTH_SHORT).show();

                    return;
                }

                int id = db.getLastID() + 1;

                Student student = new Student(id , name, age, clas);
                db.insertStudent(student);

                textname.setText("");
                textage.setText("");
                textclass.setText("");

                Toast.makeText(MainActivity2.this, "Student Added Successfully.", Toast.LENGTH_SHORT).show();



            }
        });


    }
}