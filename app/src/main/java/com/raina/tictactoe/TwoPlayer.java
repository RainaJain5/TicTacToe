package com.raina.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Arrays;

public class TwoPlayer extends AppCompatActivity {


      String name1 = TwoplayerName.player1Name;
      String name2 = TwoplayerName.player2Name;


    boolean gameActive = true;
    // Player representation
    // 0 - X - Player 1
    // 1 - O - Player 2
    int activePlayer = 0;
    int[] gameState = {2, 2 , 2, 2, 2, 2, 2, 2, 2};
    int[][] winPositions = {{0,1,2}, {3,4,5}, {6,7,8},
            {0,3,6}, {1,4,7}, {2,5,8},
            {0,4,8}, {2,4,6}};
    int player1 = 0, player2 = 0;


    public void play(View view){
        ImageView img = (ImageView) view;
        int tappedImage = Integer.parseInt(img.getTag().toString());
        if(!gameActive)
        gameReset(view);
        if(gameState[tappedImage] == 2)
        {
            gameState[tappedImage] = activePlayer;
            img.setTranslationY(-1000f);
            if (activePlayer == 0)
            {
                String player2Active = "*"+ name2 + " : " + player2;
                String player1Score = name1 + " : " + player1;

                img.setImageResource(R.drawable.x);
                activePlayer = 1;
                TextView status = findViewById(R.id.status);
                status.setText(player1Score);
                TextView status2 = findViewById(R.id.status2);
                status2.setText(player2Active);
            }
            else {
                String player1Active = "*"+ name1 + " : " + player1;
                String player2Score = name2 + " : " + player2;

                img.setImageResource(R.drawable.o);
                activePlayer = 0;
                TextView status = findViewById(R.id.status);
                status.setText(player1Active);
                TextView status2 = findViewById(R.id.status2);
                status2.setText(player2Score);
            }
            img.animate().translationYBy(1000f).setDuration(300);
        }

        for(int[] winPosition: winPositions)
        {
            if(gameState[winPosition[0]] == gameState[winPosition[1]] &&
                    gameState[winPosition[1]] == gameState[winPosition[2]] &&
                    gameState[winPosition[0]]!=2)
            {
                gameActive = false;
                if(gameState[winPosition[0]] == 0)
                {
                    player1++;
                    String player2Active = "*"+ name2 + " : " + player2;
                    String player1Score = name1 + " : " + player1;

                    TextView status = findViewById(R.id.status);
                    status.setText(player1Score);
                    TextView status2 = findViewById(R.id.status2);
                    status2.setText(player2Active);
                    TextView winner = findViewById(R.id.textView2);
                    winner.setText(name1 + " Won");
                }
                else
                {
                    player2++;
                    String player1Active = "*"+ name1 + " : " + player1;
                    String player2Score = name2 + " : " + player2;

                    TextView status = findViewById(R.id.status);
                    status.setText(player1Active);
                    TextView status2 = findViewById(R.id.status2);
                    status2.setText(player2Score);
                    TextView winner = findViewById(R.id.textView2);
                    winner.setText(name2 + " Won");

                }
            }
        }

        boolean emptySquare = false;
        for (int squareState : gameState)
        {
            if (squareState == 2) {
                emptySquare = true;
                break;
            }
        }
        if (!emptySquare && gameActive)
        {
            gameActive = false;
            String player1Score = name1 + " : " + player1;
            String player2Score = name2 + " : " + player2;

            TextView status = findViewById(R.id.status);
            status.setText(player1Score);
            TextView status2 = findViewById(R.id.status2);
            status2.setText(player2Score);
            TextView winner = findViewById(R.id.textView2);
            winner.setText("Game Draw");
        }
    }

    public void gameReset(View view) {

        gameActive = true;
        activePlayer = 0;
        String player1Active = "*"+ name1 + " : " + player1;
        String player2Score = name2 + " : " + player2;

        Arrays.fill(gameState, 2);
        ((ImageView)findViewById(R.id.imageView0)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView1)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView2)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView3)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView4)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView5)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView6)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView7)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView8)).setImageResource(0);

        TextView status = findViewById(R.id.status);
        status.setText(player1Active);
        TextView status2 = findViewById(R.id.status2);
        status2.setText(player2Score);
        TextView winner = findViewById(R.id.textView2);
        winner.setText("");

    }

    public void gameResetButton(View view) {
        gameActive = true;
        activePlayer = 0;
        player1 = 0;
        player2 = 0;
        String player1Active = "*"+ name1 + " : " + player1;
        String player2Score = name2 + " : " + player2;

        Arrays.fill(gameState, 2);
        ((ImageView)findViewById(R.id.imageView0)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView1)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView2)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView3)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView4)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView5)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView6)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView7)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView8)).setImageResource(0);

        TextView status = findViewById(R.id.status);
        status.setText(player1Active);
        TextView status2 = findViewById(R.id.status2);
        status2.setText(player2Score);
        TextView winner = findViewById(R.id.textView2);
        winner.setText("");

    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two_player);

        String player1Active = "*"+ name1 + " : " + player1;
        String player2Score = name2 + " : " + player2;


        TextView status = findViewById(R.id.status);
        status.setText(player1Active);
        TextView status2 = findViewById(R.id.status2);
        status2.setText(player2Score);

    }
}

