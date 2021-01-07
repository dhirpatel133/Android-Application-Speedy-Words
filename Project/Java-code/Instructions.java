package com.example.pateldhirspeedywords;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Instructions extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instructions);
    }

    //Changes screen to the "instruction2" screen which displays all the different categories in the game
    public void viewCategories(View view) {
        Intent i = new Intent(this, Instruction2.class);
        startActivity(i);
    }

    //Changes screen to the game screen
    public void togame(View view) {
        //Instead of starting a new activity, the finish() method ends the current screen
        //so this way the progress on the game screen is still saved.
        finish();
    }
}