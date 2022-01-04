package com.notleh.services;

import com.notleh.entities.Hand;
import com.notleh.entities.Player;
import com.notleh.enums.EnumCardSuits;
import com.notleh.enums.EnumCardValues;

import static com.notleh.enums.EnumHandScores.*;

public class HandEvaluator {

    static int HAND_SIZE = 5;

    //    Sorting means I can confidently start with the lowest value in my loops

    public static void royalFlushTest(Player currentPlayer, Hand currentHand)
    {
        if(currentHand.cardsInHand.get(0).getValue().getIntValue() == 10)
        {
            if(currentHand.cardsInHand.get(1).getValue().getIntValue() == 11)
            {
                if(currentHand.cardsInHand.get(2).getValue().getIntValue() == 12)
                {
                    if(currentHand.cardsInHand.get(3).getValue().getIntValue() == 13)
                    {
                        if(currentHand.cardsInHand.get(4).getValue().getIntValue() == 14)
                        {
                            for (int i = 0; i < HAND_SIZE; i++)
                            {
                                EnumCardSuits suitToCompare = currentHand.cardsInHand.get(i).getSuit();
                                for (int j = i + 1; j < HAND_SIZE - 1; j++) {
                                    if (currentHand.cardsInHand.get(j).getSuit() == suitToCompare)
                                    {
                                        continue;
                                    } else currentPlayer.setCurrentScore(STRAIGHT);
                                }
                                currentPlayer.setCurrentScore(ROYAL_FLUSH);
                            }
                        }
                    }
                }
            }
        }
    }

    public static void pairTest(Player currentPlayer, Hand currentHand)
    {
        int pairCount = 0;
        int kindCount = 0;

        for (int i = 0; i < HAND_SIZE; i++) {
            EnumCardValues valueToCompare = currentHand.cardsInHand.get(i).getValue();
            for (int j = i + 1; j < HAND_SIZE - 1; j++) {
                if (currentHand.cardsInHand.get(j).getValue() == valueToCompare)
                {
                    pairCount ++;
                    kindCount ++;
                    continue;
                }
            }

        }

        if (pairCount == 1)
        {
            currentPlayer.setCurrentScore(PAIR);
        }

        if (pairCount == 2)
        {
            currentPlayer.setCurrentScore(TWO_PAIRS);
        }

        if (kindCount == 3)
        {
            currentPlayer.setCurrentScore(THREE_OF_KIND);
        }

        if (kindCount == 4)
        {
            currentPlayer.setCurrentScore(FOUR_OF_KIND);
        }

        return;
    }

    //    8: Four of a kind - Four cards with the same value
//        FOUR_OF_KIND
//    4: Three of a kind - Three cards of the same value
//        THREE_OF_KIND
//
//    3: Two Pairs - Two different pairs
//        TWO_PAIRS
//
//    2: Pair - Two cards of the same value
//        PAIR


//    10: Royal Flush - T, J, Q, K, & A in the same suit
//        ROYAL_FLUSH
//
//    9: Straight Flush - All five cards in consecutive value order, in the same suit
//        STRAIGHT_FLUSH
//
//    6: Flush - All five cards having the same suit
//        FLUSH
//

//
//    7: Full House - Three of a kind and a pair
//        FULL_HOUSE
//

//
//    5: Straight - All 5 cards in consecutive order
//        STRAIGHT
//
//    1: High Card - Highest value card
//        HIGH_CARD
//
//    5: Straight - All 5 cards in consecutive order
//        STRAIGHT
//
//    1: High Card - Highest value card
//        HIGH_CARD
//

}
