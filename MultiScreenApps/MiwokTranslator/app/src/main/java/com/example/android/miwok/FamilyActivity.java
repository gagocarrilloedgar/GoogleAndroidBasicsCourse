package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class FamilyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        //Create an array of words
        ArrayList<Word> words = new ArrayList<Word>();

        //words.add("one"); --> for an String ArrayList type

        words.add(new Word("father", "әpә"));
        words.add(new Word("mother", "әṭa"));
        words.add(new Word("son", "angsi"));
        words.add(new Word("daughter", "tune"));
        words.add(new Word("older brother", "taachi"));
        words.add(new Word("younger brother", "chalitti"));
        words.add(new Word("older sister", "teṭe"));
        words.add(new Word("younger sister", "kolliti"));
        words.add(new Word("grandmother ", "ama"));
        words.add(new Word("grandfather", "paapa"));


        /**
         * The next lines will create dynamically the views based on the ArrayList, words
         */
        //Array of TextViews
        /**LinearLayout rootView = (LinearLayout)findViewById(R.id.rootView);
         for(int i=0;i<words.size();i++){
         TextView numberView = new TextView(this);
         numberView.setText(words.get(i));
         rootView.addView(numberView);
         }*/

        //ListView + arrayAdapater
        //List itemlayout --> lookfor at google for R.layout
        WordAdapater itemsAdapter = new WordAdapater(this, words);

        ListView listView = (ListView) findViewById(R.id.list);

        if (listView != null) {
            listView.setAdapter(itemsAdapter);
        }

    }
}
