package com.hfad.myapplication;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class MyAdapter extends ArrayAdapter {

    Activity myActivity;
    String [] Title;
    Note[] note;

    public MyAdapter(@NonNull Activity myActivity, Note[] note) {
        super(myActivity, R.layout.row,note);
//        this.Title = Title;
//        this.Note = Note;
        this.note = note;
        this.myActivity = myActivity;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater l = myActivity.getLayoutInflater(); // create the custom ListView
        View row = l.inflate(R.layout.row, null, true); // create a row
        TextView titleString = row.findViewById(R.id.title);
        TextView noteString = row.findViewById(R.id.note);
        titleString.setText(note[position].noteTitle);
        noteString.setText(note[position].noteBody);
        return row;

    }
}
