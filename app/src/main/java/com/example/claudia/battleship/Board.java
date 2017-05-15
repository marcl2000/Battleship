package com.example.claudia.battleship;

/**

 -1 = empty
 0 = hit
 1 = ship
 2 = hit and miss

 */

        import java.util.Scanner;

public class Board {
    static Scanner sc = new Scanner(System.in);

    private static void main(String[] args) {
        System.out.println("**********************************");
        System.out.println("");
        System.out.println("Welcome to [BATTLESHIP]");
        System.out.println("By Coco and Claudia");
        System.out.println("");
        System.out.println("**********************************");

        int board[][] = new int[10][10];
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

    private static int getNum(int min, int max) {
        min = (int) Math.ceil(min);
        max = (int) Math.floor(max);
        return (int) (Math.floor(Math.random() * (max - min + 1)) + min);
    }
    private static void generateShip(int[][] board) {
        System.out.println("");
        destroyer(board);
        System.out.println("**********************************");
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
    }

    private static void generateAIShip(int[][] AIboard){
        int x = getNum(0, 9);
        int y = getNum(0, 9);
        int direction = getNum(1, 4);
        placeAIShip(AIboard, direction, x, y, 2);

        x = getNum(0, 9);
        y = getNum(0, 9);
        direction = getNum(1, 4);
        placeAIShip(AIboard, direction, x, y, 3);

        x = getNum(0, 9);
        y = getNum(0, 9);
        direction = getNum(1, 4);
        placeAIShip(AIboard, direction, x, y, 3);

        x = getNum(0, 9);
        y = getNum(0, 9);
        direction = getNum(1, 4);
        placeAIShip(AIboard, direction, x, y, 4);

    }

    private static void destroyer(int[][] board){
        System.out.println("Place your Destroyer (size 2):");
        System.out.println("Enter a valid x coordinate.");
        int x = sc.nextInt();
        while(x<0||x>10){
            System.out.println("Enter a valid x coordinate.");
            x = sc.nextInt();
        }
        System.out.println("Enter a valid y coordinate.");
        int y = sc.nextInt();
        while(y<0||y>10){
            System.out.println("Enter a valid y coordinate.");
            y = sc.nextInt();
        }
        int direction;
        System.out.println("In which direction?");
        printDirection();
        direction = sc.nextInt();
        while(direction>4||direction<1){
            System.out.println("Enter a valid direction.");
            printDirection();
            direction = sc.nextInt();
        }
        //if(placementCheck(board, direction, x, y, 2)==true){
        placeShip(board, direction, x, y, 2);
        //}
    }

    private static void submarine(int[][] board){
        System.out.println("Place your Submarine (size 3):");
        System.out.println("Enter a valid x coordinate.");
        int x = sc.nextInt();
        while(x<0||x>10){
            System.out.println("Enter a valid x coordinate.");
            x = sc.nextInt();
        }
        System.out.println("Enter a valid y coordinate.");
        int y = sc.nextInt();
        while(y<0||y>10){
            System.out.println("Enter a valid y coordinate.");
            y = sc.nextInt();
        }
        System.out.println("In which direction?");
        printDirection();
        int direction = sc.nextInt();
        while(direction>4||direction<1){
            System.out.println("Enter a valid direction.");
            printDirection();
            direction = sc.nextInt();
        }
        //if(placementCheck(board, direction, x, y, 3)==true){
        placeShip(board, direction, x, y, 3);
        //}
    }

    private static void cruiser(int[][] board){
        System.out.println("Place your Cruiser (size 3):");
        System.out.println("Enter a valid x coordinate.");
        int x = sc.nextInt();
        while(x<0||x>10){
            System.out.println("Enter a valid x coordinate.");
            x = sc.nextInt();
        }
        System.out.println("Enter a valid y coordinate.");
        int y = sc.nextInt();
        while(y<0||y>10){
            System.out.println("Enter a valid y coordinate.");
            y = sc.nextInt();
        }
        System.out.println("In which direction?");
        printDirection();
        int direction = sc.nextInt();
        while(direction>4||direction<1){
            System.out.println("Enter a valid direction.");
            printDirection();
            direction = sc.nextInt();
        }
        //if(placementCheck(board, direction, x, y, 3)==true){
        placeShip(board, direction, x, y, 3);
        //}
    }

    private static void battleship(int[][] board){
        System.out.println("Place your Battleship (size 4):");
        System.out.println("Enter a valid x coordinate.");
        int x = sc.nextInt();
        while(x<0||x>10){
            System.out.println("Enter a valid x coordinate.");
            x = sc.nextInt();
        }
        System.out.println("Enter a valid y coordinate.");
        int y = sc.nextInt();
        while(y<0||y>10){
            System.out.println("Enter a valid y coordinate.");
            y = sc.nextInt();
        }
        System.out.println("In which direction?");
        printDirection();
        int direction = sc.nextInt();
        while(direction>4||direction<1){
            System.out.println("Enter a valid direction:");
            printDirection();
            direction = sc.nextInt();
        }
        //if(placementCheck(board, direction, x, y, 4)==true){
        placeShip(board, direction, x, y, 4);
        //}
    }

    private static void printDirection(){
        System.out.println("Enter 1 for RIGHT.");
        System.out.println("Enter 2 for LEFT.");
        System.out.println("Enter 3 for UP.");
        System.out.println("Enter 4 for DOWN.");
    }

    private static void placeAIShip(int[][] board, int direction, int x, int y,  int size){
        if(direction==3){
            for(int i=0; i<size; i++){
                if(y-i>=0){
                    board[x][y-i] = 1;
                }
            }
        }
        if(direction==4){
            for(int i=0; i<size; i++){
                if(y+i<=9){
                    board[x][y+i] = 1;
                }
            }
        }
        if(direction==1){
            for(int i=0; i<size; i++){
                if(x-i>=0){
                    board[x-i][y] = 1;
                }
            }
        }
        if(direction==2){
            for(int i=0; i<size; i++){
                if(x+i<=9){
                    board[x+i][y] = 1;
                }
            }
        }
    }

    private static void placeShip(int[][] board, int direction, int x, int y,  int size){
        if(direction==1){
            for(int i=0; i<size; i++){
                if(x>0&&x<10&&y-i>0&&y-i<10){
                    board[x][y-i] = 1;
                }}
        }
        if(direction==2){
            for(int i=0; i<size; i++){
                if(x>0&&x<10&&y+i>0&&y+i<10){
                    board[x][y+i] = 1;
                }}
        }
        if(direction==3){
            for(int i=0; i<size; i++){
                if(x-i>0&&x-i<10&&y>0&&y<10){
                    board[x-i][y] = 1;
                }}
        }
        if(direction==4){
            for(int i=0; i<size; i++){
                if(x+i>0&&x+i<10&&y>0&&y<10){
                    board[x+i][y] = 1;
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

    private static void runGame(int[][] board, int[][] AIboard) {
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
        runGame(board, AIboard);
    }

    private static boolean scan(int[][] board) {
        int x = 0;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (board[i][j] == 1) {
                    x = 1;
                }
            }
        }
        if (x == 1) {
            return true;
        }
        return false;
    }

    public static void AIturn(int[][] board) {
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

    private static void turn(int[][] AIboard) {
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

    public static boolean hitCheck(int[][] board, int x, int y) {
        if (board[x][y] == -1) {
            return false; // empty square
        }
        if (board[x][y] == 0) {
            return false; // ship already destroyed
        }
        return true;
    }

    private static void initBoard(int[][] board, boolean AI) {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                board[i][j] = -1;
            }
        }
        if (AI == true) {
            generateAIShip(board);
        }
    }

    private static void displayBoard(int[][] board, boolean AI) {
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

    private static boolean overlapCheck(int x, int y, int[][] board) {
        if (board[x][y] == -1) {
            return true;
        }
        if (x < 0 || x > 9 || y < 0 || y > 9) {
            return true;
        }
        return false;
    }
}

