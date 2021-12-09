//package com.notleh.services;
//
//public class HandEvaluator {
//
//
//    private static Integer playerOneScore = 0;
//    private static Integer playerTwoScore = 0;
//    public static Integer playerOneCount = 0;
//    public static Integer playerTwoCount = 0;
////
//    //    Takes in playerOneHand
//    //    Takes in playerTwoHand
//    public Integer findScore()
//    {
//
//        //    Values:
//        //    A 2 3 4 5 6 7 8 9 T (T is 10) J Q K
//        //    Suits:
//        //    H D S C
//
////        PlayerOneHand AH 9S 4D TD 8S
////        PlayerTwoHand 4H JS 3C TC 8D
//
////    figure out category of hand and return enum value as score

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



// if 2 cards have the same value
// test:
//    3: Two Pairs - Two different pairs
//        TWO_PAIRS
//
//    2: Pair - Two cards of the same value
//        PAIR

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

////    Returns playerOneScore
////    Returns playerTwoScore
//
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
////    Returns player SCORE
//
////    Split each indiv index into value eg. A and suit eg. H
////    If p1 score = p2 score: additional check
////    Check value of card, highest value card = +1 SCORE
//
////    If p1 score > p2 score: p1 COUNT = + 1
//
////    p1 + p2 score = 0
//
//}
