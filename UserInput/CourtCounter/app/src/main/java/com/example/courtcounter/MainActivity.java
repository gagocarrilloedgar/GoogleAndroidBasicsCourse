package com.example.courtcounter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Public method used on the display
     */

    public void plusThree(View view)
    {
        int number = 3;
        char type = 'a';
        Add(number,type);
    }

    public void plusTwo(View view)
    {
        int number = 2;
        char type = 'a';
        Add(number,type);
    }

    public void freeThrow(View view)
    {
        int number = 1;
        char type = 'a';
        Add(number,type);
    }

    public void plusThree_B(View view)
    {
        int number = 3;
        char type = 'b';
        Add(number,type);
    }

    public void plusTwo_B(View view)
    {
        int number = 2;
        char type = 'b';
        Add(number,type);
    }

    public void freeThrow_B(View view)
    {
        int number = 1;
        char type = 'b';
        Add(number,type);
    }

    public void resetButton(View view)
    {
        TextView score;

        score = (TextView) findViewById(R.id.team_a_score);
        score.setText("" + 0);

        score = (TextView) findViewById(R.id.team_b_score);
        score.setText("" + 0);

    }

    /**
     * private methods-------------------------------------------
     */
    private int TextViewToIntScoresTeamA()
    {   TextView viewnumber;
        viewnumber = (TextView) findViewById(R.id.team_a_score);
        int number = Integer.parseInt(viewnumber.getText().toString());

        return number;
    }

    private int TextViewToIntScoresTeamB()
    {   TextView viewnumber;
        viewnumber = (TextView) findViewById(R.id.team_b_score);
        int number = Integer.parseInt(viewnumber.getText().toString());

        return number;
    }

    private void Add(int selection, char teamSelection){

        int number;
        int result;
        TextView score;

        if(teamSelection == 'a')
        {
            number = TextViewToIntScoresTeamA();
            result = number + selection;
            score = (TextView) findViewById(R.id.team_a_score);
            score.setText("" + result);
        }
        else if(teamSelection =='b')
        {
            number = TextViewToIntScoresTeamB();
            result = number + selection;
            score =  (TextView) findViewById(R.id.team_b_score);
            score.setText("" + result);
        }


    }
}
