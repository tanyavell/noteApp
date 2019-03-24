package com.example.nos951.noteapplication.View;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import com.example.nos951.noteapplication.NoteRepository;
import com.example.nos951.noteapplication.entity.Note;

import java.util.List;

public class NoteView extends AndroidViewModel {

    private NoteRepository mRepository;
    private LiveData<List<Note>> mAllNotes;

    public NoteView(Application application){
        super(application);
        mRepository = new NoteRepository(application);
        mAllNotes = mRepository.getAllNotes();
    }

    public LiveData<List<Note>> getAllNote() {
        return mAllNotes;
    }

    public void insert(Note task) {
        mRepository.insertNote(task);
    }

}
