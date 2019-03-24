package com.example.nos951.noteapplication;


import android.arch.lifecycle.ViewModelProviders;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.nos951.noteapplication.ListArrayAdapter.NoteListArrayAdapter;
import com.example.nos951.noteapplication.View.ItemView;
import com.example.nos951.noteapplication.View.NoteView;
import com.example.nos951.noteapplication.entity.Note;

public class NoteActivity extends AppCompatActivity {

    private ItemView itemView;
    private NoteView noteViews;

    private ListView noteListView;
    private Button addNoteButton;
    private TextView inputText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.note_layout);

        //Layout setup
        inputText = findViewById(R.id.InputText);
        noteListView = findViewById(R.id.ListView);
        addNoteButton = findViewById(R.id.ConfirmButton);

        //Get "database"
        noteViews = ViewModelProviders.of(this).get(NoteView.class);
        //Register to observer & add adapter
        noteViews.getAllNote().observe(this, notes -> {
            if(notes==null)
                return;

            NoteListArrayAdapter adapter = new NoteListArrayAdapter(NoteActivity.this, R.layout.note_layout, notes);
            noteListView.setAdapter(adapter);
        });

        addNoteButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(inputText !=null && inputText.getText()!=null)
                    noteViews.insert(new Note(inputText.getText().toString()));

                System.out.println("button Pressedo "  + inputText.getText().toString());

            }
        });

    }
}
