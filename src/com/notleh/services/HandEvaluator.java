package com.notleh.services;

import com.notleh.enums.EnumHandScores;

import java.util.ArrayList;

import static com.notleh.enums.EnumHandScores.*;
import static com.notleh.enums.EnumCardValues.*;
import static com.notleh.enums.EnumCardSuits.*;

public class HandEvaluator {

    //    Sorting means I can confidently start with the lowest value in my loops

    public static boolean royalFlushTest(ArrayList<String> hand)
    {
        if (cardOne.getSuit == cardFive.getSuit)
        {
            if (cardOne.value == "T" && cardFive.value == "A")
                player.currentScore = ROYAL_FLUSH;
            return true;
        }
        return false;
    }

    public static int pairTest(ArrayList<String> hand)
    {
        int count = 0;

        for (int i = 0; i < HAND_SIZE; i++) {
            for (int j = 0; j < 2; j++) {
                if (ArrayList[i][j] == ArrayList[i+1][j+1])
                {
                    count = count + 1;
                }
            }
        }

        if (count == 1)
        {
            player.currentScore = PAIR;
        }

        if (count == 2)
        {
            player.currentScore = TWO_PAIRS;
        }
    }
    

// if suits all match
// test:
//    10: Royal Flush - T, J, Q, K, & A in the same suit
//        ROYAL_FLUSH
//
//    9: Straight Flush - All five cards in consecutive value order, in the same suit
//        STRAIGHT_FLUSH
//
//    6: Flush - All five cards having the same suit
//        FLUSH
//
// if 3 or more cards have same value
// test:
//    8: Four of a kind - Four cards with the same value
//        FOUR_OF_KIND
//
//    7: Full House - Three of a kind and a pair
//        FULL_HOUSE
//
//    4: Three of a kind - Three cards of the same value
//        THREE_OF_KIND
//
// if 2 cards have the same value
// test:
//    3: Two Pairs - Two different pairs
//        TWO_PAIRS
//
//    2: Pair - Two cards of the same value
//        PAIR
//
// else test:
//    5: Straight - All 5 cards in consecutive order
//        STRAIGHT
//
//    1: High Card - Highest value card
//        HIGH_CARD
// else test:
//    5: Straight - All 5 cards in consecutive order
//        STRAIGHT
//
//    1: High Card - Highest value card
//        HIGH_CARD
//    }
    

//    public Integer solveDraw()
//    {
//
////        figure out who has cards with the highest value
//
//    }
//
//    if (playerOneScore = playerTwoScore)
//    {
////         I don't think below is a thing in Java
//        solveDraw(playerOneScore, playerTwoScore);
//
//    }
//
//    if (playerOneScore > playerTwoScore)
//    {
//        playerOneCount = playerOneCount + 1;
//    } else
//    {
//        playerTwoCount = playerTwoCount + 1;
//    }
//    

}
