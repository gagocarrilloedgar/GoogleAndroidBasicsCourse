package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        //Create an array of words
        ArrayList<Word> words = new ArrayList<Word>();

        //words.add("one"); --> for an String ArrayList type

        words.add(new Word("red","weṭeṭṭi"));
        words.add(new Word("green","chokokki"));
        words.add(new Word("brown","ṭakaakki"));
        words.add(new Word("gray","ṭopoppi"));
        words.add(new Word("black","kululli"));
        words.add(new Word("white","kelelli"));
        words.add(new Word("dusty yelow","ṭopiisә"));
        words.add(new Word("mustard yelow","chiwiiṭә"));


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
