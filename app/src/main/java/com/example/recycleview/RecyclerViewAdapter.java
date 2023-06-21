package com.example.recycleview;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyVH> {

    List<Student> students;

    public RecyclerViewAdapter(List<Student> students){
        this.students = students;
    }
    @NonNull
    @Override
    public RecyclerViewAdapter.MyVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView =
                LayoutInflater.from(parent.getContext()).inflate(R.layout.showstudent, parent, false);
        return new MyVH(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.MyVH holder, int position) {
        holder.data = students.get(position);
        holder.studentName.setText("Name: "+ holder.data.getName());
        holder.studentAge.setText("Age: " + holder.data.getAge());
        holder.studentClass.setText("Class: "+ holder.data.getClas());
    }

    @Override
    public int getItemCount() {
        return students.size();
    }

    public class MyVH extends RecyclerView.ViewHolder {

        TextView studentName;
        TextView studentAge;

        TextView studentClass;

        Student data;
        public MyVH(@NonNull View itemView) {
            super(itemView);
            studentName = itemView.findViewById(R.id.textView8);
            studentAge = itemView.findViewById(R.id.textView9);
            studentClass = itemView.findViewById(R.id.textView10);

        }
    }
}