package com.notleh.services;

import com.notleh.entities.Hand;
import com.notleh.entities.Player;
import com.notleh.enums.EnumHandScores;

import java.util.Arrays;
import java.util.Objects;

import static com.notleh.enums.EnumHandScores.*;
import static com.notleh.services.HandEvaluator.*;

public class SolveDraw {
    //        As the hand is sorted, the FIRST card in the hand has the highest value
    public static void solveDraw(Player playerOne, Player playerTwo, Hand playerOneHand, Hand playerTwoHand) {

//      I only check p1 score here, bc solveDraw is only called when both scores are the same.
//      I simply need to store the value to determine the next move
        EnumHandScores mutualScore = playerOne.getCurrentScore();

        switch(mutualScore) {
            case PAIR -> solveOnePairDraw(playerOne, playerTwo, playerOneHand, playerTwoHand);
            case TWO_PAIRS -> solveTwoPairDraw(playerOne, playerTwo, playerOneHand, playerTwoHand);
            case THREE_OF_KIND -> solveThreeOfAKindDraw(playerOne, playerTwo, playerOneHand, playerTwoHand);
            default -> getHighCard(playerOne, playerTwo, playerOneHand, playerTwoHand);
        }

    }

    public static void getHighCard (Player playerOne, Player playerTwo, Hand playerOneHand, Hand playerTwoHand) {
//        System.out.println("DRAW: P1 Score - " + playerOne.getCurrentScore().toString() + ". P2 Score: " + playerTwo.getCurrentScore().toString());
        int playerOneHighCard = playerOneHand.cardsInHand.get(0).getValue().intValue;
        int playerTwoHighCard = playerTwoHand.cardsInHand.get(0).getValue().intValue;

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

        } else solveSuperDraw(playerOne, playerTwo, playerOneHand, playerTwoHand);
    }

    public static void solveOnePairDraw (Player playerOne, Player playerTwo, Hand playerOneHand, Hand playerTwoHand) {

        int[] playerOnePair = testForOnePair(playerOne, playerOneHand);
        int[] playerTwoPair = testForOnePair(playerTwo, playerTwoHand);

        if (playerOnePair[0] != playerTwoPair[0]) {
            if (playerOnePair[0] > playerTwoPair[0]) {
                playerOne.setCurrentScore(HIGH_CARD);
                playerTwo.setCurrentScore(LOST_DRAW);
            } else {
                playerTwo.setCurrentScore(HIGH_CARD);
                playerOne.setCurrentScore(LOST_DRAW);
            }
        } else solveSuperDraw(playerOne, playerTwo, playerOneHand, playerTwoHand);
    }

    public static void solveTwoPairDraw (Player playerOne, Player playerTwo, Hand playerOneHand, Hand playerTwoHand) {
//        An array of 2 ints, both representing the value of a pair eg [3, 12] = pair of 3s & pair of queens
        int [] playerOnePairs = testForTwoPairs(playerOne, playerOneHand);
        int playerOneHigh;
        int [] playerTwoPairs = testForTwoPairs(playerTwo, playerTwoHand);
        int playerTwoHigh;

        playerOneHigh = Math.max(playerOnePairs[0], playerOnePairs[1]);
        playerTwoHigh = Math.max(playerTwoPairs[0], playerTwoPairs[1]);

        if (playerOneHigh > playerTwoHigh) {
            playerOne.setCurrentScore(HIGH_CARD);
            playerTwo.setCurrentScore(LOST_DRAW);
        } else {
            playerTwo.setCurrentScore(HIGH_CARD);
            playerOne.setCurrentScore(LOST_DRAW);
        }
    }

    public static void solveThreeOfAKindDraw (Player playerOne, Player playerTwo, Hand playerOneHand, Hand playerTwoHand) {

        int[] p1Three = threeOfAKind(playerOne, playerOneHand);
        int[] p2Three = threeOfAKind(playerTwo, playerTwoHand);

        if (p1Three[0] != p2Three[0]){
            if (p1Three[0] > p2Three[0]) {
                playerOne.setCurrentScore(HIGH_CARD);
                playerTwo.setCurrentScore(LOST_DRAW);
            } else {
                playerTwo.setCurrentScore(HIGH_CARD);
                playerOne.setCurrentScore(LOST_DRAW);
            }
        } else solveSuperDraw(playerOne, playerTwo, playerOneHand, playerTwoHand);


    }

    public static void solveSuperDraw (Player playerOne, Player playerTwo, Hand playerOneHand, Hand playerTwoHand) {
        int playerOneSecondHighestCard = playerOneHand.cardsInHand.get(1).getValue().intValue;
        int playerTwoSecondHighestCard = playerTwoHand.cardsInHand.get(1).getValue().intValue;

        int playerOneThirdHighestCard = playerOneHand.cardsInHand.get(2).getValue().intValue;
        int playerTwoThirdHighestCard = playerTwoHand.cardsInHand.get(2).getValue().intValue;

        int playerOneFourthHighestCard = playerOneHand.cardsInHand.get(3).getValue().intValue;
        int playerTwoFourthHighestCard = playerTwoHand.cardsInHand.get(3).getValue().intValue;

        int playerOneFifthHighestCard = playerOneHand.cardsInHand.get(4).getValue().intValue;
        int playerTwoFifthHighestCard = playerTwoHand.cardsInHand.get(4).getValue().intValue;

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
        } else System.out.println("Both players have the same high card, the draw cannot be solved");
}
}
