package com.example.pateldhirspeedywords;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class Instruction2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instruction2);
    }

    //Changes screen to "instruction" screen
    public void toinstructions(View view) {
        //Instead of starting a new activity, the finish() method just nullifies the current screen
        finish();
    }
}