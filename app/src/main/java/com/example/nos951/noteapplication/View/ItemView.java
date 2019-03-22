package com.example.nos951.noteapplication.View;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import com.example.nos951.noteapplication.NoteRepository;
import com.example.nos951.noteapplication.entity.Item;
import com.example.nos951.noteapplication.entity.Note;

import java.util.List;

public class ItemView extends AndroidViewModel {

    private NoteRepository mRepository;
    public ItemView(Application application) {
        super(application);
        mRepository = new NoteRepository(application);
    }
    public LiveData<List<Item>> getAllItemByNote(int note) {
        return mRepository.getAllItemForNote(note);
    }

    public void insert(Item task) {
        mRepository.insertItem(task);
    }
}
