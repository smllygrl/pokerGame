package com.notleh.services;

import com.notleh.entities.Hand;
import com.notleh.entities.Player;

import java.io.FileNotFoundException;

import static com.notleh.enums.EnumHandScores.HIGH_CARD;
import static com.notleh.enums.EnumHandScores.LOST_DRAW;
import static com.notleh.services.FindWinner.findWinner;

public class SolveDraw {

    public static void solveDraw(Player playerOne, Player playerTwo, Hand playerOneHand, Hand playerTwoHand) throws FileNotFoundException {
        System.out.println("It is a draw");
//        As the hand is sorted, the final card in the hand has the highest value
        int playerOneHighCard = playerOneHand.cardsInHand.get(4).getValue().intValue;
        int playerTwoHighCard = playerTwoHand.cardsInHand.get(4).getValue().intValue;

        if (playerOneHighCard != playerTwoHighCard)
        {
            if (playerOneHighCard > playerTwoHighCard)
            {
                playerOne.setCurrentScore(HIGH_CARD);
                playerTwo.setCurrentScore(LOST_DRAW);
            } else {
                playerTwo.setCurrentScore(HIGH_CARD);
                playerOne.setCurrentScore(LOST_DRAW);
            }
            findWinner(playerOne, playerTwo, playerOneHand, playerTwoHand);
        } else solveSuperDraw(playerOne, playerTwo, playerOneHand, playerTwoHand);
    }

    public static void solveSuperDraw (Player playerOne, Player playerTwo, Hand playerOneHand, Hand playerTwoHand) throws FileNotFoundException {
        int playerOneSecondHighestCard = playerOneHand.cardsInHand.get(3).getValue().intValue;
        int playerTwoSecondHighestCard = playerTwoHand.cardsInHand.get(3).getValue().intValue;

        int playerOneThirdHighestCard = playerOneHand.cardsInHand.get(2).getValue().intValue;
        int playerTwoThirdHighestCard = playerTwoHand.cardsInHand.get(2).getValue().intValue;

        int playerOneFourthHighestCard = playerOneHand.cardsInHand.get(1).getValue().intValue;
        int playerTwoFourthHighestCard = playerTwoHand.cardsInHand.get(1).getValue().intValue;

        int playerOneFifthHighestCard = playerOneHand.cardsInHand.get(0).getValue().intValue;
        int playerTwoFifthHighestCard = playerTwoHand.cardsInHand.get(0).getValue().intValue;

        if (playerOneSecondHighestCard != playerTwoSecondHighestCard)
        {
            if (playerOneSecondHighestCard > playerTwoSecondHighestCard)
            {
                playerOne.setCurrentScore(HIGH_CARD);
                playerTwo.setCurrentScore(LOST_DRAW);
            } else {
                playerTwo.setCurrentScore(HIGH_CARD);
                playerOne.setCurrentScore(LOST_DRAW);
            }
            findWinner(playerOne, playerTwo, playerOneHand, playerTwoHand);

        } else if (playerOneThirdHighestCard != playerTwoThirdHighestCard)
        {
            if (playerOneThirdHighestCard > playerTwoThirdHighestCard)
            {
                playerOne.setCurrentScore(HIGH_CARD);
                playerTwo.setCurrentScore(LOST_DRAW);
            } else {
                playerTwo.setCurrentScore(HIGH_CARD);
                playerOne.setCurrentScore(LOST_DRAW);
            }
            findWinner(playerOne, playerTwo, playerOneHand, playerTwoHand);

        } else if (playerOneFourthHighestCard != playerTwoFourthHighestCard)
        {
            if (playerOneFourthHighestCard > playerTwoFourthHighestCard)
                {
                    playerOne.setCurrentScore(HIGH_CARD);
                    playerTwo.setCurrentScore(LOST_DRAW);
                } else {
                playerTwo.setCurrentScore(HIGH_CARD);
                playerOne.setCurrentScore(LOST_DRAW);
            }
            findWinner(playerOne, playerTwo, playerOneHand, playerTwoHand);

        } else if (playerOneFifthHighestCard != playerTwoFifthHighestCard)
        {
            if (playerOneFifthHighestCard > playerTwoFifthHighestCard)
        {
            playerOne.setCurrentScore(HIGH_CARD);
            playerTwo.setCurrentScore(LOST_DRAW);
        } else {
            playerTwo.setCurrentScore(HIGH_CARD);
            playerOne.setCurrentScore(LOST_DRAW);
            }
            findWinner(playerOne, playerTwo, playerOneHand, playerTwoHand);
        } else System.out.println("Both players have the same high card, the draw cannot be solved");
}
}
