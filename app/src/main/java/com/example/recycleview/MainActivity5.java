package com.example.recycleview;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import com.example.recycleview.DbHelper;

import com.example.recycleview.Student;

import java.util.ArrayList;
import java.util.List;

public class MainActivity5 extends AppCompatActivity {

    private ListView listViewStudents;
    private EditText editTextSearch;
    private DbHelper dbHelper;
    private ArrayAdapter<Student> arrayAdapter;
    private List<Student> studentList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        listViewStudents = findViewById(R.id.listViewStudents);
        editTextSearch = findViewById(R.id.editTextSearch);
        dbHelper = new DbHelper(this);
        studentList = new ArrayList<>();

        // Initialize the ArrayAdapter with empty student list
        arrayAdapter = new ArrayAdapter<>(this, R.layout.list_item_student, R.id.textViewName, studentList);
        listViewStudents.setAdapter(arrayAdapter);

        // Set up text change listener for search functionality
        editTextSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                // Call searchStudents method with the current search query
                String searchQuery = s.toString().trim();
                searchStudents(searchQuery);
            }
        });
    }

    private void searchStudents(String searchQuery) {
        // Clear the previous search results
        studentList.clear();

        // Perform the database query and update the student list
        studentList.addAll(dbHelper.searchStudents(searchQuery));

        // Notify the adapter that the data set has changed
        arrayAdapter.notifyDataSetChanged();
    }
}