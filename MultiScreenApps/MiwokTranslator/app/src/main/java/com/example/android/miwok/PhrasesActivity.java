package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        //Create an array of words
        ArrayList<Word> words = new ArrayList<Word>();

        //words.add("one"); --> for an String ArrayList type

        words.add(new Word("Where are you going?", "minto wuksus"));
        words.add(new Word("What is your name?", "tinnә oyaase'nә"));
        words.add(new Word("My name is...", "oyaaset..."));
        words.add(new Word("How are you feeling?", "michәksәs?"));
        words.add(new Word("I’m feeling good.", "kuchi achit"));
        words.add(new Word("Are you coming?", "әәnәs'aa?"));
        words.add(new Word("Yes, I’m coming.", "hәә’ әәnәm"));
        words.add(new Word("I’m coming.", "әәnәm"));
        words.add(new Word("Let’s go.", "yoowutis"));
        words.add(new Word("Come here.", "әnni'nem"));


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
