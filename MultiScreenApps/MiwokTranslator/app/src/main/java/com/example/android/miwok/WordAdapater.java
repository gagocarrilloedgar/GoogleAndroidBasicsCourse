package com.example.android.miwok;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class WordAdapater extends ArrayAdapter<Word> {

    public WordAdapater(@NonNull Context context, ArrayList<Word> word) {
        //we are not going to use the second resourse so we can just set it to 0
        super(context,0, word);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view

        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the {@link Word} object located at this position in the list
        Word currentWord = getItem(position);

        // Find the defaultTextView in the list_item.xml layout with the ID version_name
        TextView defaultTextView = (TextView) listItemView.findViewById(R.id.default_text_view);
        // Get the default name from the current NUmber object and
        // set this text on the name defaultTranslation
        defaultTextView.setText(currentWord.getDefaultTranslation());

        // Find the miwokTranslation in the list_item.xml layout with the ID version_name
        TextView miwokTextView = (TextView) listItemView.findViewById(R.id.miwok_text_view);
        // Get the miwok name from the current NUmber object and
        // set this text on the name defaultTranslation
        miwokTextView.setText(currentWord.getMiwokTranslation());

        //Now we return the whole list item which contains 2 TextViewS(miwok & default)
        return listItemView;
    }
}
