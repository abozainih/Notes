package com.hfad.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class noteDetails extends AppCompatActivity {

    TextView title;
    TextView body;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_details);
        title = findViewById(R.id.textTitle);
        body = findViewById(R.id.textBody);

        Intent i = getIntent();
        Note n = (Note)i.getSerializableExtra("data");
        title.setText(n.noteTitle);
        body.setText(n.noteBody);


    }
}