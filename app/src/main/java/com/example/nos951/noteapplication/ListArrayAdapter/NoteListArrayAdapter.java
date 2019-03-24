package com.example.nos951.noteapplication.ListArrayAdapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.nos951.noteapplication.ItemActivity;
import com.example.nos951.noteapplication.entity.Note;

import java.util.List;

public class NoteListArrayAdapter extends ArrayAdapter {
    private List<Note> mNoteList;

    public NoteListArrayAdapter(Context context, int resource, List<Note> notes) {
        super(context, resource, notes);
        mNoteList = notes;
    }

    public int getCount(){
       return mNoteList.size();
    }

    public Note getNote(int position){
        return mNoteList.get(position);
    }

    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {

            Note note = getNote(position);

            //Create a layout
            Context context = parent.getContext();
            LinearLayout view = new LinearLayout(context);
            view.setOrientation(LinearLayout.HORIZONTAL);

            //Create a text view
            TextView nameTextView = new TextView(context);
            nameTextView.setText(note.title);

            //add text to the view
            view.addView(nameTextView);

            nameTextView.setOnClickListener(v -> {
                Intent intent = new Intent(context, ItemActivity.class);

                System.out.println("HELO");

                intent.putExtra(ItemActivity.ITEM_ID_MESSAGE, Integer.toString(note.id));
                context.startActivity(intent);
            });

            //TextView parTextView = new TextView(c
            //
            // ontext);
            //parTextView.setText(Integer.toString(courses.get(position).getPar()));
            //view.addView(parTextView);
            return view;
        }

        return convertView;
    }
}
