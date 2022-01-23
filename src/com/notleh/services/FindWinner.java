package com.notleh.services;

import com.notleh.entities.Hand;
import com.notleh.entities.Player;
import com.notleh.enums.EnumHandScores;

import java.util.Scanner;

import static com.notleh.services.PlayAgain.playAgain;
import static com.notleh.services.SolveDraw.solveDraw;

public class FindWinner {

    public static void findWinner(Player playerOne, Player playerTwo, Hand playerOneHand, Hand playerTwoHand)
    {
        int playerOneFinalScore = playerOne.getCurrentScore().getScore();
        int playerTwoFinalScore = playerTwo.getCurrentScore().getScore();

        if (playerOneFinalScore != playerTwoFinalScore)
        {
            if (playerOneFinalScore > playerTwoFinalScore)
            {
                playerOne.setWinCount(+1);
                System.out.println("Player 1 wins" + playerOne.getCurrentScore());
                Scanner input = new Scanner(System.in);
                System.out.println("Play again? Y / N");
                String yesOrNo = input.nextLine();
                if (yesOrNo == "Y"){
                    playAgain(playerOne, playerTwo);
                }
            } else {
                playerTwo.setWinCount(+1);
                System.out.println("Player 2 wins" + playerTwo.getCurrentScore());
                Scanner input = new Scanner(System.in);
                System.out.println("Play again? Y / N");
                String yesOrNo = input.nextLine();
                if (yesOrNo == "Y"){
                    playAgain(playerOne, playerTwo);
                }
            }

        } else {
            solveDraw(playerOne, playerTwo, playerOneHand, playerTwoHand);
        }

    }
}
