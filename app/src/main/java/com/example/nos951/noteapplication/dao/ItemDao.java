package com.example.nos951.noteapplication.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.nos951.noteapplication.entity.Item;

import java.util.List;

@Dao
public interface ItemDao {
    @Insert
    void insert(Item task);

    @Query("SELECT * FROM item WHERE note_id = :noteId")
    LiveData<List<Item>> getItemsByNotedId(int noteId);
}
