package com.example.claudia.battleship;

import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


import static com.example.claudia.battleship.R.id.aiBoard;
import static com.example.claudia.battleship.R.id.userBoard;

/**
 * Created by Claudia on 2017-05-01.
 */

public class ScreenActivity extends AppCompatActivity {
    //The only screen the user sees


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.userscreen_board);

        GridView aiGridView = (GridView) findViewById(aiBoard);
        GridView userGridView = (GridView) findViewById(userBoard);
        aiGridView.setAdapter(new ButtonAdapter(this));
        userGridView.setAdapter(new ButtonAdapter(this));
        Toast.makeText(this, "Tap the location you wish to strike.", Toast.LENGTH_SHORT);




        }




    public class ButtonAdapter extends BaseAdapter {
        private Context mContext;
        private String[][] buttons = { {"b00", "b01", "b02", "b03", "b04", "b05", "b06", "b07", "b08", "b09"},
                                        {"b10", "b11", "b12", "b13", "b14", "b15", "b16", "b17", "b18", "b19"},
                                        {"b20", "b21", "b22", "b23", "b24", "b25", "b26", "b27", "b28", "b29"},
                                        {"b30", "b31", "b32", "b33", "b34", "b35", "b36", "b37", "b38", "b39"},
                                        {"b40", "b41", "b42", "b43", "b44", "b45", "b46", "b47", "b48", "b49"},
                                        {"b50", "b51", "b52", "b53", "b54", "b55", "b56", "b57", "b58", "b59"},
                                        {"b60", "b61", "b62", "b63", "b64", "b65", "b66", "b67", "b68", "b69"},
                                        {"b70", "b71", "b72", "b73", "b74", "b75", "b76", "b77", "b78", "b79"},
                                        {"b80", "b81", "b82", "b83", "b84", "b85", "b86", "b87", "b88", "b89"},
                                        {"b90", "b91", "b92", "b93", "b94", "b95", "b96", "b97", "b98", "b99"} };


        // Gets the context so it can be used later
        public ButtonAdapter(Context c) {
            mContext = c;
        }

        // Total number of things contained within the adapter
        public int getCount() {
            return buttons.length;
        }

        // Require for structure, not really used in my code.
        public Object getItem(int position) {
            return null;
        }

        // Require for structure, not really used in my code. Can
        // be used to get the id of an item in the adapter for
        // manual control.
        public long getItemId(int position) {
            return position;
        }


        public View getView(int position,
                            View convertView, ViewGroup parent) {

            Button btn;
            if (convertView == null) {
                // if it's not recycled, initialize some attributes
                btn = new Button(mContext);
                btn.setLayoutParams(new GridView.LayoutParams(100, 55));
                btn.setPadding(8, 8, 8, 8);
            }
            else {
                btn = (Button) convertView;
            }
            btn.setOnClickListener(new MyOnClickListener(position)); //why is this here and why is it not an ID given
            //exus
            //btn.setText(buttons[position]);

            btn.setTextColor(Color.WHITE);

            btn.setId(position); //***********Does this change the id of the button? What happened to the string of IDs?

            return btn;
        }
    }

    class MyOnClickListener implements View.OnClickListener {
        private final int position;
        public MyOnClickListener(int position){
            this.position = position;
        }
        public void onClick(View v){
            //functttitontontoantaon(this.position);
        }
    }
}
