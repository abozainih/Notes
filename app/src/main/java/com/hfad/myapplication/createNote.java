package com.hfad.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.Serializable;

public class createNote extends AppCompatActivity {

    EditText noteTitle,noteBody;
    Button create;
    SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_note);

        noteTitle = findViewById(R.id.addtextTitle);
        noteBody = findViewById(R.id.addtextBody);
        create = findViewById(R.id.addButton);
        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db=openOrCreateDatabase("notes", Context.MODE_PRIVATE, null);
                db.execSQL("insert into notes(noteTitle,noteBody) values ('"+ noteTitle.getText() + "','"+ noteBody.getText()+"')");
                Intent i = new Intent(createNote.this,MainActivity.class);
                startActivity(i);
            }
        });

    }
}