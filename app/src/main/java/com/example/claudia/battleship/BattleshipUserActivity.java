package com.example.claudia.battleship;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.example.claudia.battleship.R.id.aiBoard;
import static com.example.claudia.battleship.R.id.userBoard;

/*REASON WHY: why the text was clicked
         1: Placing a ship
         2: Attacking a ship
*/



public class BattleshipUserActivity extends AppCompatActivity {
    private static int reasonWhy;

    public static int getReasonWhy() {
        return reasonWhy;
    }

    public static void setReasonWhy(int newReason) {
        reasonWhy = newReason;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_battleship_user);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        GridView aiGridView = (GridView) findViewById(R.id.aiBoard);
        GridView userGridView = (GridView) findViewById(R.id.userBoard);
        String[] tempAIArray = new String[100];
        for (int i = 0; i < 100; i++) {
            tempAIArray[i] = "~";
        }
        List<String> AIArray = new ArrayList<String>(Arrays.asList(tempAIArray));

        String[] tempUserArray = new String[100];
        for (int i = 0; i < 100; i++) {
            tempUserArray[i] = "~";
        }

        List<String> UserArray = new ArrayList<String>(Arrays.asList(tempUserArray));

        ArrayAdapter<String> AIAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, AIArray);
        aiGridView.setAdapter(AIAdapter);
        ArrayAdapter<String> UserAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, UserArray);
        userGridView.setAdapter(UserAdapter);

        aiGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = parent.getItemAtPosition(position).toString();


            }
        });

        userGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = parent.getItemAtPosition(position).toString();


            }
        });


        Toast.makeText(getApplication().getBaseContext(), "Welcome to Battleship!", Toast.LENGTH_SHORT).show();
        Toast.makeText(getApplication().getBaseContext(), "You will now choose your ships", Toast.LENGTH_LONG).show();

        Board.generateShip(userGridView);











        /*int board[][] = new int[10][10];
        initBoard(board, false);
        int AIboard[][] = new int[10][10];
        initBoard(AIboard, true);

        System.out.println("You will now place your ships.");
        generateShip(board);
        System.out.println("");
        System.out.println("**********************************");
        displayBoard(board, false);

        runGame(board, AIboard);
    }
    */


    }

    public void onClick(View v) {

        final int reasonWhy = BattleshipUserActivity.getReasonWhy();

        switch (reasonWhy) {

            case 1:
                //change that point to a different symbol


                break;

            case 2:


                break;


        }


    }
}

