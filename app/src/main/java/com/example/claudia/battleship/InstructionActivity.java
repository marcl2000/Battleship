package com.example.claudia.battleship;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class InstructionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instruction);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        Button mBackButton = (Button) findViewById(R.id.btnBack);

        setSupportActionBar(toolbar);
        mBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //mStartButton.setText("Clicked");
                Intent i = new Intent(InstructionActivity.this, BoardActivity.class);
                startActivity(i);
                ////CODE FOR SWTITCHING TO ANOTHER CLASS/SCREEN
            }
        });
    }
    }


