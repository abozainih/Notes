package com.hfad.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.io.Serializable;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements Serializable {
    ListView l ;
    SQLiteDatabase db;
    FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = dbConnect();
        l = findViewById(R.id.mylist);
        fab = findViewById(R.id.fab);
        MyAdapter my = new MyAdapter(MainActivity.this, getData());
        l.setAdapter(my);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, createNote.class);
                startActivity(i);
            }
        });
        l.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent in = new Intent(MainActivity.this,noteDetails.class);
                in.putExtra("data", getData()[position]);
                startActivity(in);
            }
        });

    }

     public SQLiteDatabase dbConnect(){
        SQLiteDatabase db=openOrCreateDatabase("notes", Context.MODE_PRIVATE, null);
        db.execSQL("create table if not exists notes(note_id INTEGER primary key autoincrement,noteTitle varchar,noteBody varchar)");
        return db;
    }

    Note[] getData(){
        Cursor c = db.rawQuery("select * from notes", null);
        Note[] n = new Note[c.getCount()];
        if(c.getCount() != 0) {
            int counter = 0;
            while (c.moveToNext()) {
                n[counter] = new Note(c.getString(1), c.getString(2));
                counter++;
            }
        }

        return n;

    }


}