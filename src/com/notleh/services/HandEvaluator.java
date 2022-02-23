package com.notleh.services;

import com.notleh.entities.Hand;
import com.notleh.entities.Player;
import com.notleh.enums.EnumCardValues;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

import static com.notleh.enums.EnumHandScores.*;

public class HandEvaluator {

    static int HAND_SIZE = 5;
    static int FIRST_CARD = 0;

//    ALL HANDS ARE IN DESCENDING (THE HIGHEST INT VALUE FIRST) ORDER

//    Helper methods
    public static Boolean sameSuit (String firstCardSuit, Hand currentHand) {
        boolean sameSuit = false;

//        Starts at 1 as the firstSuitCard is a param for this method
        for (int j = 1; j < HAND_SIZE; j++) {
            if (currentHand.cardsInHand.get(j).getSuit().toString() == firstCardSuit) {
                sameSuit = true;
            } else {
                sameSuit = false;
                return sameSuit;
            }
        }
        return sameSuit;
    }

    public static Boolean descendingOrder (Hand currentHand) {
        boolean descendingOrder = false;
        int startValue = currentHand.cardsInHand.get(FIRST_CARD).getValue().getIntValue();
        for (int i = 1; i < HAND_SIZE; i++) {
            if (currentHand.cardsInHand.get(i).getValue().getIntValue() == startValue - i) {
                descendingOrder = true;
            } else {
                descendingOrder = false;
                return descendingOrder;
            }
        }
        return descendingOrder;
    }

    public static Boolean sameValue (int[] cardValues) {
        boolean sameValue = false;
        int valueToCompare = cardValues[FIRST_CARD];

//        Starts at 1 as 0 is the card to which we compare all others
        for (int i = 1; i < cardValues.length; i++) {
            if (cardValues[i] == valueToCompare){
                sameValue = true;
            } else {
                sameValue = false;
                return sameValue;
            }

        }

        return sameValue;
    }

//    Tests begin

    public static void royalFlushTest(Player currentPlayer, Hand currentHand) {


      if (Objects.equals(currentHand.cardsInHand.get(FIRST_CARD).getValue().getIntValue(), EnumCardValues.ACE.getIntValue())) {
            if (descendingOrder(currentHand)){
                String suitToCompare = currentHand.cardsInHand.get(FIRST_CARD).getSuit().toString();
                if (sameSuit(suitToCompare, currentHand)){
                    currentPlayer.setCurrentScore(ROYAL_FLUSH);
                }
            }
        }
    }

    public static void straightFlushTest(Player currentPlayer, Hand currentHand)
    {

        if (descendingOrder(currentHand)){
            String suitToCompare = currentHand.cardsInHand.get(FIRST_CARD).getSuit().toString();
            if (sameSuit(suitToCompare, currentHand)){
                currentPlayer.setCurrentScore(STRAIGHT_FLUSH);
            }
        }
    }

    public static void fourOfAKind (Player currentPlayer, Hand currentHand) {

//       This will check whether there are 4 of the value in currentHand
//       There are only two possibilities as the hand is sorted

        int TwoPossibilities = 2;

        for (int i = 0; i < TwoPossibilities; i++) {
            int [] fourCards = {
                    currentHand.cardsInHand.get(i).getValue().getIntValue(),
                    currentHand.cardsInHand.get(i + 1).getValue().getIntValue(),
                    currentHand.cardsInHand.get(i + 2).getValue().getIntValue(),
                    currentHand.cardsInHand.get(i + 3).getValue().getIntValue()
            };
            for (int j = 0; j < TwoPossibilities; j++) {
                if (sameValue(fourCards)){
                    currentPlayer.setCurrentScore(FOUR_OF_KIND);
                    return;
                }
            }

        }

    }

    public static void fullHouseTest (Player currentPlayer, Hand currentHand) {

// For this test, I execute the three of a kind and pair check. If both are true, there is a full house

        boolean pair = false;

        for (int i = 0; i < HAND_SIZE - 1; i++) {
                int [] pairToTest = new int[2];
                pairToTest[0] = currentHand.cardsInHand.get(i).getValue().getIntValue();
                pairToTest[1] = currentHand.cardsInHand.get(i + 1).getValue().getIntValue();
            if (pairToTest[0] == pairToTest[1]) {
                pair = true;
                break;
            }

        }

//        Only executes the three of a kind check if there is a pair in the hand
        if (pair) {

            for (int i = 0; i < 3; i++) {

                int[] threeToCheck = {
                        currentHand.cardsInHand.get(i).getValue().getIntValue(),
                        currentHand.cardsInHand.get(1 + i).getValue().getIntValue(),
                        currentHand.cardsInHand.get(2 + i).getValue().getIntValue()
                };

                if (sameValue(threeToCheck)) {
                    currentPlayer.setCurrentScore(FULL_HOUSE);
                    return;
                }

                break;

            }

        }

    }


    public static void flushTest(Player currentPlayer, Hand currentHand)
    {
//        FLUSH TEST WORKS
        String suitToCompare = currentHand.cardsInHand.get(FIRST_CARD).getSuit().toString();
        if(sameSuit(suitToCompare, currentHand)){
            currentPlayer.setCurrentScore(FLUSH);
        }

    }

    public static void straightTest(Player currentPlayer, Hand currentHand)
    {
//        STRAIGHT TEST WORKS
        if (descendingOrder(currentHand)) {
            currentPlayer.setCurrentScore(STRAIGHT);
        }
    }

    public static int[] threeOfAKind (Player currentPlayer, Hand currentHand) {

//        As the hand is sorted, the three will either be the first three cards, the last three, or the middle three
        int ThreePossibilities = 3;

//        The array below is used for solving draws
        int[] sameThree = new int[3];

        for (int i = 0; i < ThreePossibilities; i++) {

            int[] threeToCheck = {
                    currentHand.cardsInHand.get(i).getValue().getIntValue(),
                    currentHand.cardsInHand.get(1 + i).getValue().getIntValue(),
                    currentHand.cardsInHand.get(2 + i).getValue().getIntValue()
            };


            for (int j = 0; j < ThreePossibilities; j++) {


                if (sameValue(threeToCheck)) {
                    sameThree = threeToCheck;
                    currentPlayer.setCurrentScore(THREE_OF_KIND);
                    return sameThree;
                } break;


            }
        }

        return sameThree;

    }

    public static int @NotNull [] testForTwoPairs (Player currentPlayer, Hand currentHand) {
        int pairSize = 2;
        int[] firstPair = new int [pairSize];
        int[] secondPair = new int[pairSize];


        for (int i = 0; i < HAND_SIZE - 1; i++) {
                int [] pairToTest = new int[pairSize];
                int secondCard = i + 1;
                pairToTest[0] = currentHand.cardsInHand.get(i).getValue().getIntValue();
                pairToTest[1] = currentHand.cardsInHand.get(secondCard).getValue().getIntValue();
                if (pairToTest[0] == pairToTest[1]) {
//                Checking if any value has been assigned
                    if (firstPair[0] == 0) {
                        firstPair = pairToTest;
                    } else {
                        secondPair = pairToTest;
                    }
                }
        }

        int[] returnArray = new int[pairSize];

//      Creates an array with the two values of the pairs for any draw solving
        if (secondPair[0] != 0) {
            returnArray[0] = firstPair[0];
            returnArray[1] = secondPair[0];
            currentPlayer.setCurrentScore(TWO_PAIRS);
        }

        return returnArray;
    }

    public static int[] testForOnePair (Player currentPlayer, Hand currentHand) {
        int[] pair = new int [2];

        for (int i = 0; i < HAND_SIZE - 1; i++) {
            int [] pairToTest = new int[2];
            pairToTest[0] = currentHand.cardsInHand.get(i).getValue().getIntValue();
            pairToTest[1] = currentHand.cardsInHand.get(i + 1).getValue().getIntValue();
            if (pairToTest[0] == pairToTest[1]) {
                pair = pairToTest;
                currentPlayer.setCurrentScore(PAIR);
            }
        }

        return pair;

    }
}
