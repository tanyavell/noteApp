package com.example.nos951.noteapplication.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.nos951.noteapplication.entity.Note;

import java.util.List;

@Dao
public interface NoteDao {
    @Insert
    void insert(Note task);

    @Query("SELECT * FROM note")
    LiveData<List<Note>> getAllNote();
}
