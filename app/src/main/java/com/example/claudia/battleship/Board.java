package com.example.claudia.battleship;

/*

 -1 = empty
 0 = hit
 1 = ship
 2 = hit and miss

 */

import android.content.Context;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;



public class Board {
    private static Context context;
    private static int posit;


    public Board(Context context){
        this.context = context.getApplicationContext();
    }

    private static int getNum(int min, int max) {
        min = (int) Math.ceil(min);
        max = (int) Math.floor(max);
        return (int) (Math.floor(Math.random() * (max - min + 1)) + min);
    }


    public static void placeStart(List<String> UserArray){
        posit = BattleshipUserActivity.getPosition();
        UserArray.set(posit, "o");


    }
    public static void placeFinish(List<String> UserArray){
        String gameStatus = BattleshipUserActivity.getGameStatus();

        if((posit - BattleshipUserActivity.getPosition()) == 1){
            //the boat is going left
            gameStatus = BattleshipUserActivity.getGameStatus();
            if (gameStatus == "placingDestroyerFinish"){
                //length 2
                UserArray.set(posit-1, "o");
            }
            else if ((gameStatus == "placingSubmarineFinish")||(gameStatus == "placingCruiserFinish")){
                //length 3
                UserArray.set(posit-1, "o");
                UserArray.set(posit-2, "o");
            }
            else if (gameStatus == "placingBattleshipFinish"){
                //length 4
                UserArray.set(posit-1, "o");
                UserArray.set(posit-2, "o");
                UserArray.set(posit-3, "o");
            }

        }
        if((posit - BattleshipUserActivity.getPosition()) == -1){
            //the ship is going right

            gameStatus = BattleshipUserActivity.getGameStatus();
            if (gameStatus == "placingDestroyerFinish"){
                //length 2
                UserArray.set(posit+1, "o");
            }
            else if ((gameStatus == "placingSubmarineFinish")||(gameStatus == "placingCruiserFinish")){
                //length 3
                UserArray.set(posit+1, "o");
                UserArray.set(posit+2, "o");
            }
            else if (gameStatus == "placingBattleshipFinish"){
                //length 4
                UserArray.set(posit+1, "o");
                UserArray.set(posit+2, "o");
                UserArray.set(posit+3, "o");
            }
        }
        if((posit - BattleshipUserActivity.getPosition()) > 1){
            //the ship is going up

            gameStatus = BattleshipUserActivity.getGameStatus();
            if (gameStatus == "placingDestroyerFinish"){
                //length 2
                UserArray.set(posit-10, "o");
            }
            else if ((gameStatus == "placingSubmarineFinish")||(gameStatus == "placingCruiserFinish")){
                //length 3
                UserArray.set(posit-10, "o");
                UserArray.set(posit-20, "o");
            }
            else if (gameStatus == "placingBattleshipFinish"){
                //length 4
                UserArray.set(posit-10, "o");
                UserArray.set(posit-20, "o");
                UserArray.set(posit-30, "o");
            }
        }
        if((posit - BattleshipUserActivity.getPosition()) < -1){
            //the ship is going down

            gameStatus = BattleshipUserActivity.getGameStatus();
            if (gameStatus == "placingDestroyerFinish"){
                //length 2
                UserArray.set(posit+10, "o");
            }
            else if ((gameStatus == "placingSubmarineFinish")||(gameStatus == "placingCruiserFinish")){
                //length 3
                UserArray.set(posit+10, "o");
                UserArray.set(posit+20, "o");
            }
            else if (gameStatus == "placingBattleshipFinish"){
                //length 4
                UserArray.set(posit+10, "o");
                UserArray.set(posit+20, "o");
                UserArray.set(posit+30, "o");
            }
        }






    }
    public static int getDirection(int initpos){
        int dir;
        if (initpos==0){if(Math.random()>=0.5){dir=4;}else{dir=2;}}
/*3,1*/ else if ((initpos==97)||(initpos==98)||(initpos==99)||(initpos==87)||(initpos==88)||(initpos==89)||(initpos==77)||(initpos==78)||(initpos==79)){if(Math.random()>=0.5){dir=3;}else{dir=1;}}
/*4,1*/ else if ((initpos==8)||(initpos==7)||(initpos==9)||(initpos==17)||(initpos==18)||(initpos==19)||(initpos==27)||(initpos==28)||(initpos==29)){if(Math.random()>=0.5){dir=4;}else{dir=1;}}
/*3,2*/ else if ((initpos==91)||(initpos==92)||(initpos==90)||(initpos==80)||(initpos==70)||(initpos==81)||(initpos==82)||(initpos==71)||(initpos==72)){if(Math.random()>=0.5){dir=3;}else{dir=2;}}
/*2,4*/ else if ((initpos==1)||(initpos==2)||(initpos==10)||(initpos==20)||(initpos==11)||(initpos==12)||(initpos==21)||(initpos==22)){if(Math.random()>=0.5){dir=4;}else{dir = 2;}}

/*1,2,3*/ else if ((initpos==73)||(initpos==74)||(initpos==75)||(initpos==76)||(initpos==83)||(initpos==84)||(initpos==85)||(initpos==86)||(initpos==93)||(initpos==94)||(initpos==95)||(initpos==96)){if (Math.random() >= 0.6) {
                dir = 3;} else if ((Math.random() >= 0.3)&&(Math.random() < 0.6)){dir = 2;} else { dir = 1;}}
/*4,2,3*/ else if ((initpos==60)||(initpos==50)||(initpos==40)||(initpos==30)||(initpos==31)||(initpos==32)||(initpos==41)||(initpos==42)||(initpos==51)||(initpos==52)||(initpos==61)||(initpos==62)){
            if (Math.random() >= 0.6) {dir = 2;} else if ((Math.random() >= 0.3)&&(Math.random() < 0.6)){dir = 3;} else { dir = 4;}}
/*1,4,3*/ else if ((initpos==37)||(initpos==38)||(initpos==39)||(initpos==47)||(initpos==48)||(initpos==49)||(initpos==57)||(initpos==58)||(initpos==59)||(initpos==67)||(initpos==68)||(initpos==69)){
            if (Math.random() >= 0.6) {dir = 1;} else if ((Math.random() >= 0.3)&&(Math.random() < 0.6)){dir = 3;} else { dir = 4;}}
/*1,2,4*/ else if ((initpos==3)||(initpos==4)||(initpos==5)||(initpos==6)||(initpos==13)||(initpos==14)||(initpos==15)||(initpos==16)||(initpos==23)||(initpos==24)||(initpos==25)||(initpos==26)){
            if (Math.random() >= 0.6) {dir = 1;} else if ((Math.random() >= 0.3)&&(Math.random() < 0.6)){dir = 2;} else { dir = 4;}}

        else {dir = getNum(1,4);}


        return dir;
    }
    public static void placeAIShips(List<String> AIArrayCopy){

        //destroyer
        int initpos = getNum(0, 99);
        int dir = getDirection(initpos);

        AIArrayCopy.set(initpos, "o");
        if(dir == 1){
            //boat is going left
            AIArrayCopy.set(initpos -1, "o");
        }
        else if(dir == 2){
            //boat is going right
            AIArrayCopy.set(initpos +1, "o");
        }
        else if(dir == 3){
            //boat is going up
            AIArrayCopy.set(initpos -10, "o");
        }
        else if(dir == 4){
            //boat is going down
            AIArrayCopy.set(initpos +10, "o");
        }

        //submarine & cruiser
        for (int i =0;i<2;i++) {
            initpos = getNum(0, 99);
            dir = getDirection(initpos);

            AIArrayCopy.set(initpos, "o");
            if (dir == 1) {
                //boat is going left
                AIArrayCopy.set(initpos - 1, "o");
                AIArrayCopy.set(initpos - 2, "o");
            } else if (dir == 2) {
                //boat is going right
                AIArrayCopy.set(initpos + 1, "o");
                AIArrayCopy.set(initpos +2, "o");
            } else if (dir == 3) {
                //boat is going up
                AIArrayCopy.set(initpos - 10, "o");
                AIArrayCopy.set(initpos -20, "o");
            } else if (dir == 4) {
                //boat is going down
                AIArrayCopy.set(initpos + 10, "o");
                AIArrayCopy.set(initpos + 20, "o");
            }

        }

        //battleship
        initpos = getNum(0, 99);
        dir = getDirection(initpos);

        AIArrayCopy.set(initpos, "o");
        if(dir == 1){
            //boat is going left
            AIArrayCopy.set(initpos -1, "o");
            AIArrayCopy.set(initpos -2, "o");
            AIArrayCopy.set(initpos -3, "o");
        }
        else if(dir == 2){
            //boat is going right
            AIArrayCopy.set(initpos +1, "o");
            AIArrayCopy.set(initpos +2, "o");
            AIArrayCopy.set(initpos +3, "o");
        }
        else if(dir == 3){
            //boat is going up
            AIArrayCopy.set(initpos -10, "o");
            AIArrayCopy.set(initpos -20, "o");
            AIArrayCopy.set(initpos -30, "o");
        }
        else if(dir == 4){
            //boat is going down
            AIArrayCopy.set(initpos +10, "o");
            AIArrayCopy.set(initpos +20, "o");
            AIArrayCopy.set(initpos +30, "o");
        }
    }

    /*
    private static void runGame(List board, int[][] AIboard) {
        AIturn(board);
        turn(AIboard);
        if (scan(AIboard) == false) {
            System.out.println("");
            System.out.println("All enemy ships destroyed. YOU WIN!");
            return;
        } else if (scan(board) == false) {
            System.out.println("");
            System.out.println("All your ships were destroyed. YOU LOSE!");
            return;
        }
        //runGame(board, AIboard);
    }
**/
    public static boolean scan(List<String> board) {
        for(int i=0; i<99; i++){
            if(board.get(i)=="o"){
                return true;
            }
        }
       return false; //game end
    }
/*
    public static void AIturn(List board) {
        // boolean path = false;
        // int xprev = 0;
        // int yprev = 0;
        // if(path==false){
        System.out.println("");
        System.out.println("**********************************");
        System.out.println("ENEMY TURN.");

        int x = (int) (Math.random() * 10);
        int y = (int) (Math.random() * 10);

        if (hitCheck(board, x, y) == false) {
            System.out.println("The enemy struck at " + x + " " + y);
            if(board[x][y] == 0){
                System.out.println("The enemy already struck that! What a silly robot.");
                System.out.println("**********************************");
            }
            else{
                board[x][y] = 2;
                System.out.println("The enemy attack was ineffective!");
                System.out.println("**********************************");
            }
        } else {
            System.out.println("Your ship at " + x + " " + y + " was struck by the enemy!");
            System.out.println("**********************************");
            board[x][y] = 0;
            // path = true;
        }

        displayBoard(board, false);
        // }

        // else{

        // }
    }
*/
    public static void turn(List<String> AI, List<String> AICopy) { //USER TURN, takes AIArray copy
        int pos = BattleshipUserActivity.getPosition();
        if(AICopy.get(pos)=="o"){
            AI.set(pos, "x");
            Toast.makeText(context, "SUCCESS", Toast.LENGTH_SHORT).show();
        }else {
            AI.set(pos, "'");
            Toast.makeText(context, "FAILURE", Toast.LENGTH_SHORT).show();
        }
    }

    public static void AIturn(List<String> Board){
        int pos = getNum(0, 99);
        if(Board.get(pos)=="o"){
            Board.set(pos, "x");
            Toast.makeText(context, "YOU WERE HIT", Toast.LENGTH_SHORT).show();
        }else{
            Board.set(pos, "`");
            Toast.makeText(context, "MISS", Toast.LENGTH_SHORT).show();
        }
    }/*

    public static boolean hitCheck(List board, int x, int y) {
        if (board[x][y] == -1) {
            return false; // empty square
        }
        if (board[x][y] == 0) {
            return false; // ship already destroyed
        }
        return true;
    }

    private static void initBoard(List board, boolean AI) {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                board[i][j] = "~";
            }
        }
        if (AI == true) {
            generateAIShip(board);
        }
    }

    private static void displayBoard(List board, boolean AI) {
        System.out.println("");
        if (AI == true) {
            System.out.println("    [ENEMY BOARD]");
        } else {
            System.out.println("    [YOUR BOARD]");
        }

        System.out.println("");
        System.out.print("  0 1 2 3 4 5 6 7 8 9");
        for (int i = 0; i < 10; i++) {
            System.out.println("");
            System.out.print(i + " ");
            for (int j = 0; j < 10; j++) {

                if(board[i][j] == 2){
                    System.out.print("x");
                    System.out.print(" ");
                }

                if (board[i][j] == -1) {
                    System.out.print("~");
                    System.out.print(" ");
                }
                if (board[i][j] == 1 /** && AI==false **/

                /**
                 * if(board[i][j] == 1 && AI==true){ System.out.print("o");
                 * System.out.print(" "); }
                 **/
          /*      if (board[i][j] == 0) {
                    System.out.print("'");
                    System.out.print(" ");
                }
            }
        }
        System.out.println("");
    }

    private static boolean overlapCheck(int x, int y, List board) {
        if (board[x][y] == -1) {
            return true;
        }
        if (x < 0 || x > 9 || y < 0 || y > 9) {
            return true;
        }
        return false;
    }*/
}

