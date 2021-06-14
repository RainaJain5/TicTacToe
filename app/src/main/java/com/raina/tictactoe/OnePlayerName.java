package com.raina.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class OnePlayerName extends AppCompatActivity {

    public static String playerName;
    public static boolean x, o, comp, you;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one_player_name);
    }

    public void submitintent(View view)
    {
        Intent intent = new Intent(OnePlayerName.this, OnePlayer.class);
        startActivity(intent);
    }

    public void submit(View view)
    {

        EditText player1NameBox = findViewById(R.id.name1);
        CheckBox check1 = (CheckBox) findViewById(R.id.checkBox);
        CheckBox check2 = (CheckBox) findViewById(R.id.checkBox2);
        CheckBox check3 = (CheckBox) findViewById(R.id.checkBox3);
        CheckBox check4 = (CheckBox) findViewById(R.id.checkBox4);

        x = check1.isChecked();
        o = check2.isChecked();
        comp = check3.isChecked();
        you = check4.isChecked();

        playerName = player1NameBox.getText().toString();

        if((x)&&(o))
            Toast.makeText(this,"You can choose only one",Toast.LENGTH_SHORT).show();
        if((!x)&&(!o))
            Toast.makeText(this,"You have to choose one",Toast.LENGTH_SHORT).show();

        else if((comp)&&(you))
            Toast.makeText(this,"You can choose only one",Toast.LENGTH_SHORT).show();
        else if((!comp)&&(!you))
            Toast.makeText(this,"You have to choose one",Toast.LENGTH_SHORT).show();

        else
            submitintent(view);

    }

}