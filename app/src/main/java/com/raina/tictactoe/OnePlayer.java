package com.raina.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;

public class OnePlayer extends AppCompatActivity {

    String name1, name2;
    boolean x = OnePlayerName.x;
    boolean you = OnePlayerName.you;
    static char opponent, player;
//    player - computer
//    opponent = you

    int activePlayer;
    // Player representation
    // 0 - X
    // 1 - O
    public  static char[][] board = {{'_', '_', '_'},
                                    {'_', '_', '_'},
                                    {'_', '_', '_'}};
    boolean gameActive = true;
    int[] gameState = {2, 2 , 2, 2, 2, 2, 2, 2, 2};
    int[][] winPositions = {{0,1,2}, {3,4,5}, {6,7,8},
            {0,3,6}, {1,4,7}, {2,5,8},
            {0,4,8}, {2,4,6}};
    int player1 = 0, player2 = 0;

    public static class Move
    {
        int row, col;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one_player);


        if(x)
        {
            player = 'o';
            opponent = 'x';
            name1 = OnePlayerName.playerName;
            name2 = "Computer";

            if(you)
            {
                activePlayer = 0;
                String player1Active = "*"+ name1 + " : " + player1;
                String player2Score = name2 + " : " + player2;

                TextView status = findViewById(R.id.status);
                status.setText(player1Active);
                TextView status2 = findViewById(R.id.status2);
                status2.setText(player2Score);
            }

            else
            {
                activePlayer = 1;
                String player2Active = "*"+ name2 + " : " + player2;
                String player1Score = name1 + " : " + player1;

                TextView status = findViewById(R.id.status);
                status.setText(player1Score);
                TextView status2 = findViewById(R.id.status2);
                status2.setText(player2Active);
                CompTurn();
            }
        }
        else
        {
            player = 'x';
            opponent = 'o';
            name2 = OnePlayerName.playerName;
            name1 = "Computer";

            if(!you)
            {
                activePlayer = 0;
                String player1Active = "*"+ name1 + " : " + player1;
                String player2Score = name2 + " : " + player2;

                TextView status = findViewById(R.id.status);
                status.setText(player1Active);
                TextView status2 = findViewById(R.id.status2);
                status2.setText(player2Score);
                CompTurn();
            }

            else
            {
                activePlayer = 1;
                String player2Active = "*"+ name2 + " : " + player2;
                String player1Score = name1 + " : " + player1;

                TextView status = findViewById(R.id.status);
                status.setText(player1Score);
                TextView status2 = findViewById(R.id.status2);
                status2.setText(player2Active);
            }

        }

        }


    public void play(View view)
    {
        ImageView img = (ImageView) view;
        int tappedImage = Integer.parseInt(img.getTag().toString());


        if (!gameActive) {
            gameReset(view);
            return;
        }
        if (gameState[tappedImage] == 2) {

            gameState[tappedImage] = activePlayer;
            img.setTranslationY(-1000f);
            if (activePlayer == 0) {
                String player2Active = "*" + name2 + " : " + player2;
                String player1Score = name1 + " : " + player1;

                img.setImageResource(R.drawable.x);
                activePlayer = 1;
                TextView status = findViewById(R.id.status);
                status.setText(player1Score);
                TextView status2 = findViewById(R.id.status2);
                status2.setText(player2Active);

                img.animate().translationYBy(1000f).setDuration(300);
                AddX(tappedImage);

                if (gameState[0] != 2 && gameState[1] != 2 && gameState[2] != 2 && gameState[3] != 2
                        && gameState[4] != 2 && gameState[5] != 2 && gameState[6] != 2 && gameState[7] != 2
                        && gameState[8] != 2)
                {
                    gameActive = false;
                    String player2Score = name2 + " : " + player1;
                    String win = "Game Draw - Tap to Replay";

                    TextView status3 = findViewById(R.id.status);
                    status3.setText(player1Score);
                    TextView status4 = findViewById(R.id.status2);
                    status4.setText(player2Score);
                    TextView winner = findViewById(R.id.textView2);
                    winner.setText(win);
                }
                else
                    CompTurn();

            } else {
                String player1Active = "*" + name1 + " : " + player1;
                String player2Score = name2 + " : " + player2;

                img.setImageResource(R.drawable.o);
                activePlayer = 0;
                TextView status = findViewById(R.id.status);
                status.setText(player1Active);
                TextView status2 = findViewById(R.id.status2);
                status2.setText(player2Score);
                img.animate().translationYBy(1000f).setDuration(300);
                Add0(tappedImage);

                if (gameState[0] != 2 && gameState[1] != 2 && gameState[2] != 2 && gameState[3] != 2
                        && gameState[4] != 2 && gameState[5] != 2 && gameState[6] != 2 && gameState[7] != 2
                        && gameState[8] != 2)
                {
                    gameActive = false;
                    String player1Score = name1 + " : " + player1;
                    String win = "Game Draw - Tap to Replay";

                    TextView status3 = findViewById(R.id.status);
                    status3.setText(player1Score);
                    TextView status4 = findViewById(R.id.status2);
                    status4.setText(player2Score);
                    TextView winner = findViewById(R.id.textView2);
                    winner.setText(win);
                }
                else
                CompTurn();
            }
        }
        else
            Toast.makeText(this,"Already Filled",Toast.LENGTH_SHORT).show();

        for (int[] winPosition : winPositions)
        {
            if (gameState[winPosition[0]] == gameState[winPosition[1]] &&
                    gameState[winPosition[1]] == gameState[winPosition[2]] &&
                    gameState[winPosition[0]] != 2)
            {
                gameActive = false;
                if(x)
                {
                    name1 = OnePlayerName.playerName;
                    name2 = "Computer";
                }
                else
                {
                    name2 = OnePlayerName.playerName;
                    name1 = "Computer";
                }
                if (gameState[winPosition[0]] == 0) {
                    player1++;
                    String player2Active = "*" + name2 + " : " + player2;
                    String player1Score = name1 + " : " + player1;
                    String win = name1 + " Won - Tap to Replay";

                    TextView status = findViewById(R.id.status);
                    status.setText(player1Score);
                    TextView status2 = findViewById(R.id.status2);
                    status2.setText(player2Active);
                    TextView winner = findViewById(R.id.textView2);
                    winner.setText(win);
                } else {
                    player2++;
                    String player1Active = "*" + name1 + " : " + player1;
                    String player2Score = name2 + " : " + player2;
                    String win = name2 + " Won - Tap to Replay";

                    TextView status = findViewById(R.id.status);
                    status.setText(player1Active);
                    TextView status2 = findViewById(R.id.status2);
                    status2.setText(player2Score);
                    TextView winner = findViewById(R.id.textView2);
                    winner.setText(win);
                }
            }
        }

        boolean emptySquare = false;
        for (int squareState : gameState)
        {
            if (squareState == 2)
            {
                emptySquare = true;
                break;
            }
        }
        if (!emptySquare && gameActive)
        {
            gameActive = false;
            String player1Score = name1 + " : " + player1;
            String player2Score = name2 + " : " + player2;
            String win = "Game Draw - Tap to Replay";


            TextView status = findViewById(R.id.status);
            status.setText(player1Score);
            TextView status2 = findViewById(R.id.status2);
            status2.setText(player2Score);
            TextView winner = findViewById(R.id.textView2);
            winner.setText(win);
        }
    }


    public void CompTurn()
    {
        Move bestMove = findBestMove(board);
        int gameStateIndex=getGameState(bestMove.row, bestMove.col);

        if(x)
        {
            gameState[gameStateIndex]=1;
            board[bestMove.row][bestMove.col]='o';
        }
        else
        {
            gameState[gameStateIndex]=0;
            board[bestMove.row][bestMove.col]='x';
        }
        showX(bestMove.row, bestMove.col);

        if(activePlayer==1)
            activePlayer = 0;
        else
            activePlayer = 1;

        name2 = OnePlayerName.playerName;
        name1 = "Computer";

        String player2Active = "*"+ name2 + " : " + player2;
        String player1Score = name1 + " : " + player1;

        TextView status = findViewById(R.id.status);
        status.setText(player1Score);
        TextView status2 = findViewById(R.id.status2);
        status2.setText(player2Active);

    }

    public void Add0(int imageTag)
    {
        if (imageTag==0){
            board[0][0]='o';
        }else if(imageTag==1){
            board[0][1]='o';
        }else if(imageTag==2){
            board[0][2]='o';
        }else if(imageTag==3){
            board[1][0]='o';
        }else if(imageTag==4){
            board[1][1]='o';
        }else if(imageTag==5){
            board[1][2]='o';
        }else if(imageTag==6){
            board[2][0]='o';
        }else if(imageTag==7){
            board[2][1]='o';
        }else if(imageTag==8){
            board[2][2]='o';
        }
    }

    public void AddX(int imageTag)
    {
        if (imageTag==0){
            board[0][0]='x';
        }else if(imageTag==1){
            board[0][1]='x';
        }else if(imageTag==2){
            board[0][2]='x';
        }else if(imageTag==3){
            board[1][0]='x';
        }else if(imageTag==4){
            board[1][1]='x';
        }else if(imageTag==5){
            board[1][2]='x';
        }else if(imageTag==6){
            board[2][0]='x';
        }else if(imageTag==7){
            board[2][1]='x';
        }else if(imageTag==8){
            board[2][2]='x';
        }
    }


    public void showX(int row, int col){

        if(x)
        {
            if(row==0 && col==0){
                ((ImageView) findViewById(R.id.imageView0)).setImageResource(R.drawable.o);
            }else if(row==0 && col==1){
                ((ImageView) findViewById(R.id.imageView1)).setImageResource(R.drawable.o);
            }else if(row==0 && col==2){
                ((ImageView) findViewById(R.id.imageView2)).setImageResource(R.drawable.o);
            }else if(row==1 && col==0){
                ((ImageView) findViewById(R.id.imageView3)).setImageResource(R.drawable.o);
            }else if(row==1 && col==1){
                ((ImageView) findViewById(R.id.imageView4)).setImageResource(R.drawable.o);
            }else if(row==1 && col==2){
                ((ImageView) findViewById(R.id.imageView5)).setImageResource(R.drawable.o);
            }else if(row==2 && col==0){
                ((ImageView) findViewById(R.id.imageView6)).setImageResource(R.drawable.o);
            }else if(row==2 && col==1){
                ((ImageView) findViewById(R.id.imageView7)).setImageResource(R.drawable.o);
            }else if(row==2 && col==2){
                ((ImageView) findViewById(R.id.imageView8)).setImageResource(R.drawable.o);
            }
        }
        else
        {
            if(row==0 && col==0){
                ((ImageView) findViewById(R.id.imageView0)).setImageResource(R.drawable.x);
            }else if(row==0 && col==1){
                ((ImageView) findViewById(R.id.imageView1)).setImageResource(R.drawable.x);
            }else if(row==0 && col==2){
                ((ImageView) findViewById(R.id.imageView2)).setImageResource(R.drawable.x);
            }else if(row==1 && col==0){
                ((ImageView) findViewById(R.id.imageView3)).setImageResource(R.drawable.x);
            }else if(row==1 && col==1){
                ((ImageView) findViewById(R.id.imageView4)).setImageResource(R.drawable.x);
            }else if(row==1 && col==2){
                ((ImageView) findViewById(R.id.imageView5)).setImageResource(R.drawable.x);
            }else if(row==2 && col==0){
                ((ImageView) findViewById(R.id.imageView6)).setImageResource(R.drawable.x);
            }else if(row==2 && col==1){
                ((ImageView) findViewById(R.id.imageView7)).setImageResource(R.drawable.x);
            }else if(row==2 && col==2){
                ((ImageView) findViewById(R.id.imageView8)).setImageResource(R.drawable.x);
            }
        }


    }


    static int getGameState(int row, int col ){
        int gameStateIndex = -1;
        if(row==0 && col==0){
            gameStateIndex=0;
        }else if(row==0 && col==1){
            gameStateIndex=1;
        }else if(row==0 && col==2){
            gameStateIndex=2;
        }else if(row==1 && col==0){
            gameStateIndex=3;
        }else if(row==1 && col==1){
            gameStateIndex=4;
        }else if(row==1 && col==2){
            gameStateIndex=5;
        }else if(row==2 && col==0){
            gameStateIndex=6;
        }else if(row==2 && col==1){
            gameStateIndex=7;
        }else if(row==2 && col==2){
            gameStateIndex=8;
        }
        return gameStateIndex;
    }


    static Boolean isMovesLeft(char[][] board)
    {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                if (board[i][j] == '_')
                    return true;
        return false;
    }

    static int evaluate(char[][] b)
    {

        for (int row = 0; row < 3; row++)
        {
            if (b[row][0] == b[row][1] &&
                    b[row][1] == b[row][2])
            {
                if (b[row][0] == player)
                    return +10;
                else if (b[row][0] == opponent)
                    return -10;
            }
        }

        for (int col = 0; col < 3; col++)
        {
            if (b[0][col] == b[1][col] &&
                    b[1][col] == b[2][col])
            {
                if (b[0][col] == player)
                    return +10;

                else if (b[0][col] == opponent)
                    return -10;
            }
        }

        if (b[0][0] == b[1][1] && b[1][1] == b[2][2])
        {
            if (b[0][0] == player)
                return +10;
            else if (b[0][0] == opponent)
                return -10;
        }

        if (b[0][2] == b[1][1] && b[1][1] == b[2][0])
        {
            if (b[0][2] == player)
                return +10;
            else if (b[0][2] == opponent)
                return -10;
        }

        return 0;
    }


    static int minimax(char[][] board,
                       int depth, Boolean isMax)
    {
        int score = evaluate(board);

        if (score == 10)
            return score;
        if (score == -10)
            return score;
        if (!isMovesLeft(board))
            return 0;

        int best;
        if (isMax)
        {
            best = -1000;

            for (int i = 0; i < 3; i++)
            {
                for (int j = 0; j < 3; j++)
                {
                    if (board[i][j]=='_')
                    {
                        board[i][j] = player;
                        best = Math.max(best, minimax(board,
                                depth + 1, !isMax));

                        board[i][j] = '_';
                    }
                }
            }
        }

        else
        {
            best = 1000;
            for (int i = 0; i < 3; i++)
            {
                for (int j = 0; j < 3; j++)
                {
                    if (board[i][j] == '_')
                    {
                        board[i][j] = opponent;

                        best = Math.min(best, minimax(board,
                                depth + 1, !isMax));

                        board[i][j] = '_';
                    }
                }
            }
        }
        return best;
    }


    static Move findBestMove(char[][] board)
    {
        int bestVal = -1000;
        Move bestMove = new Move();
        bestMove.row = -1;
        bestMove.col = -1;

        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                if (board[i][j] == '_')
                {
                    board[i][j] = player;
                    int moveVal = minimax(board, 0, false);

                    board[i][j] = '_';

                    if (moveVal > bestVal)
                    {
                        bestMove.row = i;
                        bestMove.col = j;
                        bestVal = moveVal;
                    }
                }
            }
        }

        return bestMove;
    }

    public void gameReset(View view) {

        gameActive = true;

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

        for(int i = 0;i<3;i++){
            for(int j = 0; j<3;j++){
                board[i][j]='_';
            }
        }

        if(x)
        {
            name1 = OnePlayerName.playerName;
            name2 = "Computer";

            if(you)
            {
                activePlayer = 0;
                String player1Active = "*"+ name1 + " : " + player1;
                String player2Score = name2 + " : " + player2;

                TextView status = findViewById(R.id.status);
                status.setText(player1Active);
                TextView status2 = findViewById(R.id.status2);
                status2.setText(player2Score);
            }

            else
            {

                activePlayer = 1;
                String player2Active = "*"+ name2 + " : " + player2;
                String player1Score = name1 + " : " + player1;

                TextView status = findViewById(R.id.status);
                status.setText(player1Score);
                TextView status2 = findViewById(R.id.status2);
                status2.setText(player2Active);
                CompTurn();
            }
        }
        else
        {
            name2 = OnePlayerName.playerName;
            name1 = "Computer";

            if(!you)
            {

                activePlayer = 0;
                String player1Active = "*"+ name1 + " : " + player1;
                String player2Score = name2 + " : " + player2;

                TextView status = findViewById(R.id.status);
                status.setText(player1Active);
                TextView status2 = findViewById(R.id.status2);
                status2.setText(player2Score);
                CompTurn();
            }

            else
            {

                activePlayer = 1;
                String player2Active = "*"+ name2 + " : " + player2;
                String player1Score = name1 + " : " + player1;

                TextView status = findViewById(R.id.status);
                status.setText(player1Score);
                TextView status2 = findViewById(R.id.status2);
                status2.setText(player2Active);
            }
        }

        TextView winner = findViewById(R.id.textView2);
        winner.setText("");

    }

    public void gameResetButton(View view) {
        player1 = 0;
        player2 = 0;

        gameReset(view);
    }
}