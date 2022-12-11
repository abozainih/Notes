package com.hfad.myapplication;

import java.io.Serializable;

public class Note implements Serializable {

    String noteTitle;
    String noteBody;

    public Note(String noteTitle,String noteBody){
        this.noteTitle = noteTitle;
        this.noteBody = noteBody;
    }



}
