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
    /**
     * board class
     * @param context
     */
    public Board(Context context){
        this.context = context.getApplicationContext();
    }

    /**
     * method
     * @param min
     * @param max
     * @return random integer
     */
    private static int getNum(int min, int max) {
        min = (int) Math.ceil(min);
        max = (int) Math.floor(max);
        return (int) (Math.floor(Math.random() * (max - min + 1)) + min);
    }

    /**
     * method
     * @param UserArray
     */
    public static void placeStart(List<String> UserArray){
        posit = BattleshipUserActivity.getPosition();
        UserArray.set(posit, "o");


    }

    /**
     * method
     * @param UserArray
     */
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

    /**
     * method
     * @param initpos
     * @return direction
     */
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

    /**
     * method
     * @param AIArrayCopy
     */
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

    /**
     * method
     * @param board
     * @return
     */
    public static boolean scan(List<String> board) {
        for(int i=0; i<99; i++){
            if(board.get(i)=="o"){
                return true;
            }
        }
       return false; //game end
    }

    /**
     * method
     * @param AI
     * @param AICopy
     */
    public static void turn(List<String> AI, List<String> AICopy) { //USER TURN, takes AIArray copy
        int pos = BattleshipUserActivity.getPosition();
        if(AICopy.get(pos)=="o"){
            AI.set(pos, "x");
            AICopy.set(pos, "x");
        }else {
            AI.set(pos, "'");
        }
    }

    /**
     * method
     * @param Board
     */
    public static void AIturn(List<String> Board){
        int pos = getNum(0, 99);
        if(Board.get(pos)=="o"){
            Board.set(pos, "x");
        }else{
            Board.set(pos, "`");
        }
    }
}

