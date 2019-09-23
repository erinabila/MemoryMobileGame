package com.erinabila.memorymobilegame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void buttonClicked(View view) {
        EditText pairView = (EditText) findViewById(R.id.pair);
        String pair = pairView.getText().toString();

        EditText pair2View = (EditText) findViewById(R.id.pair2);
        String pair2 = pair2View.getText().toString();

        EditText rowView = (EditText) findViewById(R.id.gridRow);
        String row = rowView.getText().toString();

        EditText columnView = (EditText) findViewById(R.id.gridColumn);
        String column = columnView.getText().toString();

        GameModel myModel = new GameModel(pair, pair2, row, column);

        String myGame = myModel.scoreBoard();
        ((TextView) findViewById(R.id.score)).setText(myGame);

        //Displays board
        String myGame2 = myModel.playGame();
        ((TextView) findViewById(R.id.board)).setText(myGame2);
    }

    public void buttonNext(View view){
        EditText pairView = (EditText) findViewById(R.id.pair);
        String pair = pairView.getText().toString();

        EditText pair2View = (EditText) findViewById(R.id.pair2);
        String pair2 = pair2View.getText().toString();

        EditText rowView = (EditText) findViewById(R.id.gridRow);
        String row = rowView.getText().toString();

        EditText columnView = (EditText) findViewById(R.id.gridColumn);
        String column = columnView.getText().toString();

        GameModel myModel = new GameModel(pair, pair2, row, column);

        String myGame2 = myModel.playNext();
        ((TextView) findViewById(R.id.board)).setText(myGame2);

        //Displays board
        String myGame = myModel.scoreBoard();
        ((TextView) findViewById(R.id.score)).setText(myGame);

        ((EditText) findViewById(R.id.pair)).setText("");
        ((EditText) findViewById(R.id.pair2)).setText("");

        ((TextView) findViewById(R.id.score)).setText(myGame);

    }
}