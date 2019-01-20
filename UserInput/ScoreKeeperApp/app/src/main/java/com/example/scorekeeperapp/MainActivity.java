package com.example.scorekeeperapp;

import android.os.TestLooperManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    String selection ;
    int addOne = 1;

    /**
     * First we will create the methods for each Button, these will be public and void
     */

    public void goalOneTeamA(View view) {
        selection = "a";
        GetValue(selection);
    }

    public void goalOneTeamB(View view) {
        selection = "b";
        GetValue(selection);
    }
    public void noGoalOneTeamA(View view) {
        selection = "na";
        GetValue(selection);

    }
    public void noGoalOneTeamB(View view) {
        selection = "nb";
        GetValue(selection);

    }

    /**
     * Now the only action left is the reset button
     */
    public void resetButton(View view) {
        PurgeAll();
    }

    /**
     * Private methods in order to complete the logic under the program
     */

    private void GetValue(String scoreSelection) {
        int score =0;
        int updatedScore =0;
        TextView scoreView = (TextView) findViewById(R.id.scoresTeamA);

        if(scoreSelection == "a")
        {
            scoreView = (TextView) findViewById(R.id.scoresTeamA);
            score = Integer.parseInt(scoreView.getText().toString());
            updatedScore = add(score);

        }
        else if(scoreSelection == "b")
        {
            scoreView = (TextView) findViewById(R.id.scoresTeamB);
            score = Integer.parseInt(scoreView.getText().toString());
        }
        else if(scoreSelection == "na")
        {
            scoreView = (TextView) findViewById(R.id.faultsTeamA);
            score = Integer.parseInt(scoreView.getText().toString());

        }
        else if(scoreSelection == "nb")
        {
            scoreView = (TextView) findViewById(R.id.faultsTeamB);
            score = Integer.parseInt(scoreView.getText().toString());

        }

        updatedScore = add(score);
        scoreView.setText("" + updatedScore);

    }

    /**
     * Becasuse its a soocar match we dont need to worry about different score values,
     * so we can just add one each time.
     * @param currentScore
     */
    private int add(int currentScore) {

        int updatedScore = currentScore + addOne;
        return updatedScore;

    }

    /**
     * Sets all the scores to 0
     */
    private void PurgeAll(){
        TextView deleteScores = (TextView) findViewById(R.id.scoresTeamA);
        deleteScores.setText("" + 0);
        deleteScores = (TextView) findViewById(R.id.scoresTeamB);
        deleteScores.setText("" + 0);
        deleteScores = (TextView) findViewById(R.id.faultsTeamA);
        deleteScores.setText("" + 0);
        deleteScores = (TextView) findViewById(R.id.faultsTeamB);
        deleteScores.setText("" + 0);

    }

}
