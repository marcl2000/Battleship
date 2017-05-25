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
        import java.util.Scanner;

public class Board {
    private static Context context;


    public Board(Context context){
        this.context = context.getApplicationContext();
    }

    private static int getNum(int min, int max) {
        min = (int) Math.ceil(min);
        max = (int) Math.floor(max);
        return (int) (Math.floor(Math.random() * (max - min + 1)) + min);
    }

    /**
    public static void generateShip(GridView userGridView) {
        destroyer(userGridView);
        displayBoard(board, false);
        System.out.println("");
        System.out.println("**********************************");
        submarine(board);
        System.out.println("**********************************");
        displayBoard(board, false);
        System.out.println("");
        System.out.println("**********************************");
        cruiser(board);
        System.out.println("**********************************");
        displayBoard(board, false);
        System.out.println("");
        System.out.println("**********************************");
        battleship(board);
        System.out.println("**********************************");
        displayBoard(board, false);
        System.out.println("");
        System.out.println("**********************************");
    }**/

    public static void placeStart(List board){

    }
    public static void placeFinish(List board){

    }

    private static void placeAIShip(List board, int direction, int x, int y,  int size){
        if(direction==3){
            for(int i=0; i<size; i++){
                if(y-i>=0){
                    board[x][y-i] = "o";
                }
            }
        }
        if(direction==4){
            for(int i=0; i<size; i++){
                if(y+i<=9){
                    board[x][y+i] = "o";
                }
            }
        }
        if(direction==1){
            for(int i=0; i<size; i++){
                if(x-i>=0){
                    board[x-i][y] = "o";
                }
            }
        }
        if(direction==2){
            for(int i=0; i<size; i++){
                if(x+i<=9){
                    board[x+i][y] = "o";
                }
            }
        }
    }

    private static void placeShip(List board, int direction, int x, int y,  int size){
        if(direction==1){
            for(int i=0; i<size; i++){
                if(x>0&&x<10&&y-i>0&&y-i<10){
                    board[x][y-i] = "o";
                }}
        }
        if(direction==2){
            for(int i=0; i<size; i++){
                if(x>0&&x<10&&y+i>0&&y+i<10){
                    board[x][y+i] = "o";
                }}
        }
        if(direction==3){
            for(int i=0; i<size; i++){
                if(x-i>0&&x-i<10&&y>0&&y<10){
                    board[x-i][y] = "o";
                }}
        }
        if(direction==4){
            for(int i=0; i<size; i++){
                if(x+i>0&&x+i<10&&y>0&&y<10){
                    board[x+i][y] = "o";
                }}
        }
    }

    /**public static boolean placementCheck(int[][] board, int direction, int x, int y, int size){
     if(overlapCheck(x, y, board)==true){
     return false;
     }
     for(int i=0; i<size; i++){
     if(direction==1){
     if(overlapCheck(x, y, board)==false){
     y = y - 1;
     } else { return false; }
     }
     if(direction==2){
     if(overlapCheck(x, y, board)==false){
     y = y + 1;
     } else { return false; }
     }
     if(direction==3){
     if(overlapCheck(x, y, board)==false){
     x = x - 1;
     } else { return false; }
     }
     if(direction==4){
     if(overlapCheck(x, y, board)==false){
     x = x + 1;
     } else { return false; }
     }
     }
     return true;
     }**/

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

    private static boolean scan(List board) {
        int x = 0;
        if(int i=0; i<100; i++){
            if(board.get(i)=="-1"){
                x == -1;
            }
        }
        if (x == 1) {
            return true;
        }
        return false;
    }

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

    private static void turn(List AIboard) {
        System.out.println("");
        System.out.println("**********************************");
        System.out.println("YOUR TURN.");
        System.out.println("Enter the x coordinate:");
        int x = sc.nextInt();
        while (x < 0 || x > 10) {
            System.out.println("Please enter a valid x coordinate between 0 and 10.");
            x = sc.nextInt();
        }
        System.out.println("Enter the y coordinate:");
        int y = sc.nextInt();
        while (y < 0 || y > 10) {
            System.out.println("Please enter a valid y coordinate between 0 and 10.");
            y = sc.nextInt();
        }

        System.out.println("Targetting: " + x + " " + y);
        if (hitCheck(AIboard, x, y) == false) {
            if(AIboard[x][y] == 0){
                System.out.println("You already struck there, silly!");
            }
            else{
                AIboard[x][y] = 2;
                System.out.println("Your attack was ineffective!");
            }
        } else {
            System.out.println("You hit the enemy ship!");
            AIboard[x][y] = 0;
        }
        System.out.println("**********************************");
        displayBoard(AIboard, true);
    }

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
                        ) {
                    System.out.print("o");
                    System.out.print(" ");
                }
                /**
                 * if(board[i][j] == 1 && AI==true){ System.out.print("o");
                 * System.out.print(" "); }
                 **/
                if (board[i][j] == 0) {
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
    }
}

