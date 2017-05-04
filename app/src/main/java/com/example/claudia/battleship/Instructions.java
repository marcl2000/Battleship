package com.example.claudia.battleship;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

/**
 * Created by Claudia on 2017-05-03.
 */

public class Instructions  extends AppCompatActivity {
    private Button mBackButton;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_board);
        mBackButton = (Button) findViewById(R.id.btnBack);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //mStartButton.setText("Clicked");
                Intent i = new Intent(Instructions.this, BoardActivity.class);
                startActivity(i);
                ////CODE FOR SWTITCHING TO ANOTHER CLASS/SCREEN
            }
        });
    }
}
