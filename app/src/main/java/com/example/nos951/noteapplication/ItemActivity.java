package com.example.nos951.noteapplication;

import android.app.IntentService;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.nos951.noteapplication.ListArrayAdapter.ItemListArrayAdapter;
import com.example.nos951.noteapplication.View.ItemView;
import com.example.nos951.noteapplication.View.NoteView;
import com.example.nos951.noteapplication.entity.Item;
import com.example.nos951.noteapplication.entity.Note;

public class ItemActivity  extends AppCompatActivity {
    public static final String ITEM_ID_MESSAGE = "ITEM_ID_MESSAGE";

    private ItemView itemViews;

    private ListView noteListView;
    private Button addNoteButton;
    private TextView inputText;

    int parentNote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_layout);

        //Revocer layout stuff
        inputText = findViewById(R.id.InputText);
        noteListView = findViewById(R.id.ListView);
        addNoteButton = findViewById(R.id.ConfirmButton);

        //Find parent Note
        Intent intent = getIntent();
        String message = intent.getStringExtra(ITEM_ID_MESSAGE);
        parentNote = Integer.parseInt(message);


        //Adapter
        itemViews = ViewModelProviders.of(this).get(ItemView.class);
        itemViews.getAllItemByNote(parentNote).observe(this, items -> {
            if (items == null)
                return;

            ItemListArrayAdapter adapter = new ItemListArrayAdapter(ItemActivity.this, R.layout.item_layout, items);
            noteListView.setAdapter(adapter);
        });


        addNoteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (inputText != null && inputText.getText() != null)
                    itemViews.insert(new Item(inputText.getText().toString(), parentNote));

                System.out.println("Bottone premuto " + inputText.getText().toString());
            }
        });
    }
}
