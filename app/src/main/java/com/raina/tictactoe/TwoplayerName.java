package com.raina.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class TwoplayerName extends AppCompatActivity {

    public static String player1Name;
    public static String player2Name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_twoplayer_name);
    }

    public void submit(View view)
    {

        EditText player1NameBox = findViewById(R.id.name1);
        EditText player2NameBox = findViewById(R.id.name2);

        player1Name = player1NameBox.getText().toString();
        player2Name = player2NameBox.getText().toString();

        Intent intent = new Intent(TwoplayerName.this, TwoPlayer.class);
        startActivity(intent);
    }

}