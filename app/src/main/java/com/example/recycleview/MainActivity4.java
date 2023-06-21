package com.example.recycleview;

import androidx.appcompat.app.AppCompatActivity;

import android.icu.util.Calendar;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;

public class MainActivity4 extends AppCompatActivity {

    EditText surat , start , end , sabki, manzil;
    Button button;

    DbHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        surat = findViewById(R.id.editTextText4);
        start = findViewById(R.id.editTextText5);
        end = findViewById(R.id.editTextText6);
        sabki = findViewById(R.id.editTextText7);
        manzil = findViewById(R.id.editTextText8);

        button = findViewById(R.id.button6);

        db = new DbHelper(this);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int suratno = Integer.parseInt(surat.getText().toString());
                int startayat = Integer.parseInt(start.getText().toString());
                int endayat = Integer.parseInt(end.getText().toString());
                int sabkino = Integer.parseInt(sabki.getText().toString());
                int manzilno = Integer.parseInt(manzil.getText().toString());


               /* if (suratno.isEmpty() || .isEmpty() || clas.isEmpty()) {
                    Toast.makeText(MainActivity2.this, "Please enter missing data", Toast.LENGTH_SHORT).show();

                    return;
                }*/

                Calendar calendar;
                SimpleDateFormat dateFormat;
                String dates;


                calendar = Calendar.getInstance();

                dateFormat = new SimpleDateFormat("MM/dd/yyyy");
                dates = dateFormat.format(calendar.getTime());

                Records records = new Records(1 , dates ,suratno , startayat, endayat , sabkino , manzilno);
                db.insertRecords(records);

                surat.setText("");
                start.setText("");
                end.setText("");
                sabki.setText("");
                manzil.setText("");


                Toast.makeText(MainActivity4.this, "Records Added Successfully.", Toast.LENGTH_SHORT).show();

            }
        });


    }
}