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

//        Starts on 1 as if cards are the same on index 0, this method is called
        for (int i = 1; i < HAND_SIZE; i++) {

            int p1card = playerOneHand.cardsInHand.get(i).getValue().intValue;
            int p2card = playerTwoHand.cardsInHand.get(i).getValue().intValue;

            for (int j = 0; j < HAND_SIZE; j++) {

                if (p1card != p2card) {
                    if (p1card > p2card)
                    {
                        playerOne.setCurrentScore(HIGH_CARD);
                        playerTwo.setCurrentScore(LOST_DRAW);
                    } else {
                        playerTwo.setCurrentScore(HIGH_CARD);
                        playerOne.setCurrentScore(LOST_DRAW);
                    }
                    return;
                } else break;

            }
        }

}
}
