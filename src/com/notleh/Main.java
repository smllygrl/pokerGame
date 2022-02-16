package com.notleh;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static com.notleh.services.InitiateGame.initiateGame;

public class Main {

    public static int PLAYER_ONE_BEGIN = 0;
    public static int PLAYER_ONE_END = 14;
    public static int PLAYER_TWO_BEGIN = 15;
    public static int PLAYER_TWO_END = 29;

    public static void main(String[] args) throws FileNotFoundException {

        int playerOneWinCount = 0;
        int playerTwoWinCount = 0;
        int gameCount = 0;
        int failCount = 0;

        File file = new File("/Users/NLH/Desktop/poker-hands.txt");
        Scanner sc = new Scanner(file);

       while (sc.hasNext()) {
           String line = sc.nextLine();
           int winner = initiateGame(line);

           gameCount ++;

           if (winner == 1) {
               playerOneWinCount++;
           }
           if (winner == 2) {
               playerTwoWinCount++;
           }

//           if (winner == 0){
//               failCount++;
//           }
       }

       int totalWins = playerOneWinCount + playerTwoWinCount;

//        System.out.println("We played " + gameCount + " games, & found a winner for " + totalWins + " games.");
//        System.out.println("We failed " + failCount + " games.");
        System.out.println("Player 1: " + playerOneWinCount + " hands");
        System.out.println("Player 2: " + playerTwoWinCount + " hands");



    }

}

