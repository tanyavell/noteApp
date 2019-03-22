package com.example.nos951.noteapplication;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import com.example.nos951.noteapplication.dao.ItemDao;
import com.example.nos951.noteapplication.dao.NoteDao;
import com.example.nos951.noteapplication.database.NoteDatabase;
import com.example.nos951.noteapplication.entity.Item;
import com.example.nos951.noteapplication.entity.Note;

import java.util.List;

public class NoteRepository {
    private ItemDao itemDao;
    private NoteDao noteDao;

    private LiveData<List<Note>> mAllNotes;

    public NoteRepository(Application application) {
        NoteDatabase db = NoteDatabase.getInstance(application);
        noteDao = db.getNoteDao();
        itemDao = db.getItemDao();

        mAllNotes = noteDao.getAllNote();
    }
    public LiveData<List<Note>> getAllNotes() {
        return mAllNotes;
    }

    public LiveData<List<Item>> getAllItemForNote(int noteID){
        return itemDao.getItemsByNotedId(noteID);
    }

    public void insertNote(Note note) {
        new insertNoteAsyncTask(noteDao).execute(note);
    }

    public void insertItem(Item item) {
        new insertItemAsyncTask(itemDao).execute(item);
    }

    private static class insertNoteAsyncTask extends AsyncTask<Note, Void, Void> {
        private NoteDao mAsyncNoteDao;
        insertNoteAsyncTask(NoteDao dao) {
            mAsyncNoteDao = dao;
        }
        @Override
        protected Void doInBackground(final Note... params) {
            mAsyncNoteDao.insert(params[0]);
            return null;
        }
    }

    private static class insertItemAsyncTask extends AsyncTask<Item, Void, Void> {
        private ItemDao mAsyncItemDao;
        insertItemAsyncTask(ItemDao dao) {
            mAsyncItemDao = dao;
        }
        @Override
        protected Void doInBackground(final Item... params) {
            mAsyncItemDao.insert(params[0]);
            return null;
        }
    }
}
