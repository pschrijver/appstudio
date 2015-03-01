package com.paulschrijver.guessthenumber;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;


public class MainActivity extends ActionBarActivity {
    private int randomInt;

    private void gennumber(int min, int max) {
        Random rand = new Random();
        randomInt = rand.nextInt((max - min) + 1) + min;
        System.out.println(Integer.toString(randomInt));
    }

    public void compareNumbers(int goal, int guess) {
        if (guess < goal){
            Toast.makeText(this, "Correct answer should be higher.", Toast.LENGTH_SHORT).show();
        }
        else if (guess > goal){
            Toast.makeText(this, "Correct answer should be lower.", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(this, "Correct answer!", Toast.LENGTH_SHORT).show();
            gennumber(1, 1000);
            Toast.makeText(this, "New number is generated.", Toast.LENGTH_SHORT).show();
        }

    }

    public void checkInput(View view) {
        EditText editText = (EditText) findViewById(R.id.numberinput);
        // Check if a number is entered.
        if (editText.getText().toString().trim().length() == 0) {
            Toast.makeText(this, "You did not enter a guess.", Toast.LENGTH_SHORT).show();
        }
        else{
            int userGuess = Integer.parseInt(editText.getText().toString());
            compareNumbers(randomInt, userGuess);
        }
        // Clear textfield
        editText.setText("");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gennumber(1, 1000);
    }


    public void newNumber(View view) {
        gennumber(1, 1000);
    }
}
