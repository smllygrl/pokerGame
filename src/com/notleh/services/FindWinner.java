package com.notleh.services;

import com.notleh.entities.Hand;
import com.notleh.entities.Player;
import com.notleh.enums.EnumHandScores;

import java.io.FileNotFoundException;
import java.util.Objects;
import java.util.Scanner;

import static com.notleh.services.PlayAgain.playAgain;
import static com.notleh.services.SolveDraw.solveDraw;

public class FindWinner {

    public static void findWinner(Player playerOne, Player playerTwo, Hand playerOneHand, Hand playerTwoHand) throws FileNotFoundException {
        int playerOneFinalScore = playerOne.getCurrentScore().getScore();
        int playerTwoFinalScore = playerTwo.getCurrentScore().getScore();

        if (playerOneFinalScore != playerTwoFinalScore)
        {
            if (playerOneFinalScore > playerTwoFinalScore)
            {
                playerOne.setWinCount(playerOne.getWinCount(playerOne) + 1);
                System.out.println("Player 1 wins with a " + playerOne.getCurrentScore() + ". Win count: " + playerOne.getWinCount(playerOne) + " hands.");
                System.out.println("Player 2 lost with a " + playerTwo.getCurrentScore() + ". Win count: " + playerTwo.getWinCount(playerTwo) + " hands.");
                Scanner input = new Scanner(System.in);
                System.out.println("Play again? Y / N");
                String yesOrNo = input.nextLine();
                if (Objects.equals(yesOrNo, "Y")){
                    playAgain(playerOne, playerTwo);
                }
            } else {
                playerTwo.setWinCount(playerTwo.getWinCount(playerTwo) + 1);
                System.out.println("Player 2 wins with a " + playerTwo.getCurrentScore() + ". Win count: " + playerTwo.getWinCount(playerTwo) + " hands.");
                System.out.println("Player 1 lost with a " + playerOne.getCurrentScore() + ". Win count: " + playerOne.getWinCount(playerOne) + " hands.");
                Scanner input = new Scanner(System.in);
                System.out.println("Play again? Y / N");
                String yesOrNo = input.nextLine();
                if ("Y".equals(yesOrNo)){
                    playAgain(playerOne, playerTwo);
                }
            }

        } else {
            solveDraw(playerOne, playerTwo, playerOneHand, playerTwoHand);
        }

    }
}
