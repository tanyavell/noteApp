package com.example.nos951.noteapplication.entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;


@Entity
public class Note {
    @PrimaryKey(autoGenerate = true)
    public int id;

    @NonNull
    public String title;

    public Note(String title){this.title = title;}
}
