package com.example.nos951.noteapplication.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.example.nos951.noteapplication.dao.ItemDao;
import com.example.nos951.noteapplication.dao.NoteDao;
import com.example.nos951.noteapplication.entity.Item;
import com.example.nos951.noteapplication.entity.Note;

@Database(entities = {Note.class, Item.class}, version = 1)
public abstract class NoteDatabase extends RoomDatabase {
    private static volatile NoteDatabase INSTANCE;

    public abstract NoteDao getNoteDao();
    public abstract ItemDao getItemDao();

    public static NoteDatabase getInstance(Context context) {
        if (INSTANCE == null) {
            synchronized (NoteDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            NoteDatabase.class,
                            "note_database")
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
