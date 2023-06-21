
package com.example.recycleview;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DbHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "students.db";
    private static final String TABLE_NAME = "students";

    private static final String COLUMN_ID = "id";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_AGE = "age";
    private static final String COLUMN_CLAS = "class";

    private static final String TABLE_NAME_RECORDS = "records";

    private static final String COLUMN_IDD = "id";
    private static final String COLUMN_DATE = "date";
    private static final String COLUMN_SURAT = "surat";
    private static final String COLUMN_START = "start";
    private static final String COLUMN_END = "endd";
    private static final String COLUMN_SABKI = "sabki";
    private static final String COLUMN_MANZIL = "manzil";


    public DbHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String sql = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + "("
                + COLUMN_ID + " INTEGER,"
                + COLUMN_NAME + " TEXT,"
                + COLUMN_AGE + " TEXT,"
                + COLUMN_CLAS + " TEXT"
                + ")";
        db.execSQL(sql);

        String sql2 = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME_RECORDS + "("
                + COLUMN_ID + " INTEGER,"
                + COLUMN_DATE + " TEXT,"
                + COLUMN_SURAT + " INTEGER,"
                + COLUMN_START + " INTEGER,"
                + COLUMN_END + " INTEGER,"
                + COLUMN_SABKI + " INTEGER,"
                + COLUMN_MANZIL + " INTEGER,"
                + "FOREIGN KEY(" + COLUMN_IDD + ") REFERENCES " + TABLE_NAME + "(" + COLUMN_ID + ")"
                + ")";
        db.execSQL(sql2);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

        String sql = "DROP TABLE IF EXISTS " + TABLE_NAME;
        db.execSQL(sql);
        onCreate(db);

    }

    public void insertStudent(Student student) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, student.getName());
        values.put(COLUMN_AGE, student.getAge());
        values.put(COLUMN_CLAS, student.getClas());

        db.insert(TABLE_NAME, null, values);
        db.close();
    }


    public int getLastID()
    {
        SQLiteDatabase database=this.getReadableDatabase();
        Cursor cursor = database.rawQuery("SELECT MAX("+COLUMN_ID+") FROM "+TABLE_NAME, null);
        int maxid = (cursor.moveToFirst() ? cursor.getInt(0) : 0);
        return maxid;
    }


    public List<Student> selectAllStudents() {
        List<Student> students = new ArrayList<>();

        String sql = "SELECT * FROM " + TABLE_NAME;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(sql, null);

        /*
        * if (cursorCourses.moveToFirst()) {
            do {

                studentArrayList.add(new StudentModel(cursorCourses.getString(1),
                      cursorCourses.getInt(2),
                        cursorCourses.getInt(3) == 1 ? true : false));
            } while (cursorCourses.moveToNext());

        }
        * */

        if (cursor.moveToFirst()) {
            do {
                @SuppressLint("Range") int id = cursor.getInt(cursor.getColumnIndex(COLUMN_ID));
                @SuppressLint("Range") String name = cursor.getString(cursor.getColumnIndex(COLUMN_NAME));
                @SuppressLint("Range")  String age = cursor.getString(cursor.getColumnIndex(COLUMN_AGE));
                @SuppressLint("Range") String clas = cursor.getString(cursor.getColumnIndex(COLUMN_CLAS));
                students.add(new Student(id ,name, age, clas));
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();

        return students;
    }


    public void insertRecords(Records records) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_IDD, records.getId());
        values.put(COLUMN_DATE, records.getDate());
        values.put(COLUMN_SURAT, records.getSurat());
        values.put(COLUMN_START, records.getStart());
        values.put(COLUMN_END, records.getEnd());
        values.put(COLUMN_SABKI, records.getSabki());
        values.put(COLUMN_MANZIL, records.getManzil());

        db.insert(TABLE_NAME_RECORDS, null, values);
        db.close();
    }



    public List<Records> selectAllRecords() {
        List<Records> records = new ArrayList<>();

        String sql = "SELECT * FROM " + TABLE_NAME_RECORDS;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(sql, null);



        if (cursor.moveToFirst()) {
            do {
                @SuppressLint("Range") int id = cursor.getInt(cursor.getColumnIndex(COLUMN_IDD));
                @SuppressLint("Range") String date = cursor.getString(cursor.getColumnIndex(COLUMN_DATE));
                @SuppressLint("Range") int surat = cursor.getInt(cursor.getColumnIndex(COLUMN_SURAT));
                @SuppressLint("Range") int start = cursor.getInt(cursor.getColumnIndex(COLUMN_START));
                @SuppressLint("Range") int end = cursor.getInt(cursor.getColumnIndex(COLUMN_END));
                @SuppressLint("Range") int sabki = cursor.getInt(cursor.getColumnIndex(COLUMN_SABKI));
                @SuppressLint("Range") int manzil = cursor.getInt(cursor.getColumnIndex(COLUMN_MANZIL));
                records.add(new Records(id , date , surat , start , end , sabki , manzil));
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();

        return records;
    }





}