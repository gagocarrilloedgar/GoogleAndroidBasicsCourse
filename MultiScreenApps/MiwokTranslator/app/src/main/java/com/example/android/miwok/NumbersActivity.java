package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        //Create an array of words
        ArrayList<Word> words = new ArrayList<Word>();

        //words.add("one"); --> for an String ArrayList type

        words.add(new Word("one","lutti"));
        words.add(new Word("two","otiiko"));
        words.add(new Word("three","tolookosu"));
        words.add(new Word("four","oyyisa"));
        words.add(new Word("five","massokka"));
        words.add(new Word("six","temmokka"));
        words.add(new Word("seven","kenekaku"));
        words.add(new Word("eight","kawinta"));
        words.add(new Word("nine","wo'e"));
        words.add(new Word("ten","na'aacha"));


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
