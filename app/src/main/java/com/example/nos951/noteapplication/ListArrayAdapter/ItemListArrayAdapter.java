package com.example.nos951.noteapplication.ListArrayAdapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.example.nos951.noteapplication.entity.Item;

import java.util.List;

public class ItemListArrayAdapter extends ArrayAdapter {
    private List<Item> items;

    public ItemListArrayAdapter(Context context, int resource, List<Item> notes) {
        super(context, resource, notes);
        items = notes;
    }

    public int getCount(){
        return items.size();
    }

    public Item getItem(int position){
        return items.get(position);
    }

    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {

            Item item = getItem(position);

            //Create a layout
            Context context = parent.getContext();
            LinearLayout view = new LinearLayout(context);
            view.setOrientation(LinearLayout.HORIZONTAL);

            //Create a text view
            TextView nameTextView = new TextView(context);
            nameTextView.setText(item.description);

            //add text to the view
            view.addView(nameTextView);

            return view;
        }

        return convertView;
    }
}
