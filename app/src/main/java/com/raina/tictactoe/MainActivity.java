package com.raina.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void twoplayer(View view)
     {
        Intent intent = new Intent(MainActivity.this, TwoplayerName.class);
        startActivity(intent);
    }

    public void oneplayer(View view)
    {
        Intent intent = new Intent(MainActivity.this, OnePlayerName.class);
        startActivity(intent);
    }
}