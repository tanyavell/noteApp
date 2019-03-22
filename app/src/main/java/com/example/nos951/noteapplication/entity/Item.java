package com.example.nos951.noteapplication.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(foreignKeys = {
        @ForeignKey(entity = Note.class,
                parentColumns = "id",
                childColumns = "note_id",
                onDelete = ForeignKey.CASCADE)
        })
public class Item {

    @PrimaryKey(autoGenerate = true)
    public int id;

    @NonNull
    public String description;

    @NonNull
    @ColumnInfo(name = "note_id")
    public int noteId;

    public Item(String description, int noteId){
        this.description = description;
        this.noteId = noteId;
    }
}
