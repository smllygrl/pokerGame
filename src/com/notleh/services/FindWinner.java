package com.notleh.services;

import com.notleh.entities.Hand;
import com.notleh.entities.Player;
import com.notleh.enums.EnumHandScores;

import static com.notleh.services.SolveDraw.solveDraw;

public class FindWinner {

    public static void findWinner(Player playerOne, Player playerTwo, Hand playerOneHand, Hand playerTwoHand)
    {
        int playerOneFinalScore = playerOne.getCurrentScore().getScore();
        int playerTwoFinalScore = playerTwo.getCurrentScore().getScore();

        if (playerTwoFinalScore != playerTwoFinalScore)
        {
            if (playerOneFinalScore > playerTwoFinalScore)
            {
                playerOne.setWinCount(+1);
                System.out.println("Player 1 wins");
            } else {
                playerTwo.setWinCount(+1);
                System.out.println("Player 2 wins");
            }

        } else {
            solveDraw(playerOne, playerTwo, playerOneHand, playerTwoHand);
        }

    }
}
