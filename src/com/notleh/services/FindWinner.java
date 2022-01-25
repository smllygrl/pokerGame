package com.notleh.services;

import com.notleh.entities.Hand;
import com.notleh.entities.Player;

import com.notleh.enums.EnumHandScores;

import java.io.FileNotFoundException;
import java.util.Objects;
import java.util.Scanner;
//
//import static com.notleh.services.Game.playAgain;
import static com.notleh.services.SolveDraw.solveDraw;

public class FindWinner {

    public static void findWinner(Player playerOne, Player playerTwo, Hand playerOneHand, Hand playerTwoHand) {
        int playerOneFinalScore = playerOne.getCurrentScore().getScore();
        int playerTwoFinalScore = playerTwo.getCurrentScore().getScore();



        if (playerOneFinalScore != playerTwoFinalScore)
        {
            if (playerOneFinalScore > playerTwoFinalScore)
            {
                playerOne.setWinCount(playerOne.getWinCount(playerTwo) + 1);
                System.out.println("Player 1 wins with a " + playerOne.getCurrentScore() + ". Win count: " + playerOne.getWinCount(playerOne) + " hands.");
                System.out.println("Player 2 lost with a " + playerTwo.getCurrentScore() + ". Win count: " + playerTwo.getWinCount(playerTwo) + " hands.");
                playerOne.setCurrentScore(EnumHandScores.ZER0);
                playerTwo.setCurrentScore(EnumHandScores.ZER0);
//                Scanner input = new Scanner(System.in);
//                System.out.println("Play again? Y / N");
//                String yesOrNo = input.nextLine();
//                if (Objects.equals(yesOrNo, "Y")){
//                    try {
//                        playAgain(playerOne, playerTwo);
//                    } catch (FileNotFoundException e) {
//                        e.printStackTrace();
//                    }
//                }
                return;

            } else {
                playerTwo.setWinCount(playerTwo.getWinCount(playerTwo) + 1);
                System.out.println("Player 2 wins with a " + playerTwo.getCurrentScore() + ". Win count: " + playerTwo.getWinCount(playerTwo) + " hands.");
                System.out.println("Player 1 lost with a " + playerOne.getCurrentScore() + ". Win count: " + playerOne.getWinCount(playerOne) + " hands.");
                playerOne.setCurrentScore(EnumHandScores.ZER0);
                playerTwo.setCurrentScore(EnumHandScores.ZER0);
//                Scanner input = new Scanner(System.in);
//                System.out.println("Play again? Y / N");
//                String yesOrNo = input.nextLine();
//                if ("Y".equals(yesOrNo)){
//                    try {
//                        playAgain(playerOne, playerTwo);
//                    } catch (FileNotFoundException e) {
//                        e.printStackTrace();
//                    }
//                }
            }

        } else {
            solveDraw(playerOne, playerTwo, playerOneHand, playerTwoHand);
        }

    }
}
