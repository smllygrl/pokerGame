package com.notleh.services;

import com.notleh.entities.Hand;
import com.notleh.entities.Player;
import com.notleh.enums.EnumCardValues;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

import static com.notleh.enums.EnumHandScores.*;

public class HandEvaluator {

    static int HAND_SIZE = 5;

//    ALL HANDS ARE IN DESCENDING (THE HIGHEST INT VALUE FIRST) ORDER

//    Helper methods
    public static Boolean sameSuit (String suitToCompare, Hand currentHand) {
        boolean sameSuit = false;
        for (int j = 1; j < HAND_SIZE; j++) {
            if (currentHand.cardsInHand.get(j).getSuit().toString() == suitToCompare) {
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
        int startValue = currentHand.cardsInHand.get(0).getValue().getIntValue();
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
        int valueToCompare = cardValues[0];

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
//        ROYAL FLUSH TEST WORKS

//        Checks if ACE (the highest int value) is the first in the hand
        if (Objects.equals(currentHand.cardsInHand.get(0).getValue().getIntValue(), EnumCardValues.ACE.getIntValue())) {
            if (descendingOrder(currentHand)){
                String suitToCompare = currentHand.cardsInHand.get(0).getSuit().toString();
                if (sameSuit(suitToCompare, currentHand)){
//                    System.out.println("ROYAL FLUSH: " + currentHand.cardsInHand.toString());
                    currentPlayer.setCurrentScore(ROYAL_FLUSH);
                }
            }
        }
    }

    public static void straightFlushTest(Player currentPlayer, Hand currentHand)
    {
//        STRAIGHT FLUSH WORKS
        if (descendingOrder(currentHand)){
            String suitToCompare = currentHand.cardsInHand.get(0).getSuit().toString();
            if (sameSuit(suitToCompare, currentHand)){
//                System.out.println("STRAIGHT FLUSH: " + currentHand.cardsInHand.toString());
                currentPlayer.setCurrentScore(STRAIGHT_FLUSH);
            }
        }
    }

    public static void fourOfAKind (Player currentPlayer, Hand currentHand) {

//        FOUR OF A KIND WORKS

//        This will check whether there are 4 of the value in currentHand

//        notSame, same, same, same, same
        int [] lastFour = {
                currentHand.cardsInHand.get(1).getValue().getIntValue(),
                currentHand.cardsInHand.get(2).getValue().getIntValue(),
                currentHand.cardsInHand.get(3).getValue().getIntValue(),
                currentHand.cardsInHand.get(4).getValue().getIntValue()
        };

        if (sameValue(lastFour)){
//            System.out.println("Four of a kind: " + currentHand.cardsInHand.toString());
            currentPlayer.setCurrentScore(FOUR_OF_KIND);
        }
//        OR
//        same, same, same, same, notSame
        int [] firstFour = {
                currentHand.cardsInHand.get(0).getValue().getIntValue(),
                currentHand.cardsInHand.get(1).getValue().getIntValue(),
                currentHand.cardsInHand.get(2).getValue().getIntValue(),
                currentHand.cardsInHand.get(3).getValue().getIntValue()
        };

        if (sameValue(firstFour)){
//            System.out.println("Four of a kind: " + currentHand.cardsInHand.toString());
            currentPlayer.setCurrentScore(FOUR_OF_KIND);
        }

//        As the hand is sorted, all the cards of the same value are located together
//        for (int i = 0; i < 2; i++) {
//            int check = currentHand.cardsInHand.get(i).getValue().getIntValue();
//            int count = 0;
//            for (int j = 0; j < HAND_SIZE; j++) {
//                if (currentHand.cardsInHand.get(j).getValue().getIntValue() == check) {
//                    count ++;
//                }
//            }
//            if (count == 4) {
//                currentPlayer.setCurrentScore(FOUR_OF_KIND);
//            }
//        }
    }

    public static void fullHouseTest (Player currentPlayer, Hand currentHand) {

//        This will check if a pair is amongst the hand, as well as if there is a threeOfAKind
//        As the hand is sorted, if it is a full house, it is either PAIR, PAIR, THREE, THREE, THREE or THREE, THREE, THREE, PAIR, PAIR

        int[] firstTwo =
                {
                        currentHand.cardsInHand.get(0).getValue().getIntValue(),
                        currentHand.cardsInHand.get(1).getValue().getIntValue()
                };
        int[] lastThree =
                {
                        currentHand.cardsInHand.get(2).getValue().getIntValue(),
                        currentHand.cardsInHand.get(3).getValue().getIntValue(),
                        currentHand.cardsInHand.get(4).getValue().getIntValue()
                };

        if (sameValue(firstTwo)) {
            if (sameValue(lastThree)) {
//                System.out.println("FULL HOUSE: " + currentHand.cardsInHand.toString());
                currentPlayer.setCurrentScore(FULL_HOUSE);
            }
        }

        int[] firstThree =
                {
                        currentHand.cardsInHand.get(0).getValue().getIntValue(),
                        currentHand.cardsInHand.get(1).getValue().getIntValue(),
                        currentHand.cardsInHand.get(2).getValue().getIntValue()
                };
        int[] lastTwo =
                {
                        currentHand.cardsInHand.get(3).getValue().getIntValue(),
                        currentHand.cardsInHand.get(4).getValue().getIntValue()
                };

        if (sameValue(firstThree)) {
            if (sameValue(lastTwo)) {
//                System.out.println("FULL HOUSE: " + currentHand.cardsInHand.toString());
                currentPlayer.setCurrentScore(FULL_HOUSE);
            }
        }
    }

    public static void flushTest(Player currentPlayer, Hand currentHand)
    {
//        FLUSH TEST WORKS
        String suitToCompare = currentHand.cardsInHand.get(0).getSuit().toString();
        if(sameSuit(suitToCompare, currentHand)){
            currentPlayer.setCurrentScore(FLUSH);
//            System.out.println("FLUSH: " + currentHand.cardsInHand.toString());
        }

    }

    public static void straightTest(Player currentPlayer, Hand currentHand)
    {
//        STRAIGHT TEST WORKS
        if (descendingOrder(currentHand)) {
//            System.out.println("STRAIGHT: " + currentHand.cardsInHand.toString());
            currentPlayer.setCurrentScore(STRAIGHT);
        }
    }

    public static int[] threeOfAKind (Player currentPlayer, Hand currentHand) {

//        As the hand is sorted, the three will either be the first three cards, the last three, or the middle three

        int[] sameThree = new int[3];

        int[] firstThree =
                {
                        currentHand.cardsInHand.get(0).getValue().getIntValue(),
                        currentHand.cardsInHand.get(1).getValue().getIntValue(),
                        currentHand.cardsInHand.get(2).getValue().getIntValue()};

        if (sameValue(firstThree)) {
//            System.out.println("THREE OF A KIND: " + currentHand.cardsInHand.toString());
            sameThree = firstThree;
            currentPlayer.setCurrentScore(THREE_OF_KIND);
        }

        int[] middleThree =
                {
                        currentHand.cardsInHand.get(1).getValue().getIntValue(),
                        currentHand.cardsInHand.get(2).getValue().getIntValue(),
                        currentHand.cardsInHand.get(3).getValue().getIntValue()};

        if (sameValue(middleThree)) {
//            System.out.println("THREE OF A KIND: " + currentHand.cardsInHand.toString());
            sameThree = firstThree;
            currentPlayer.setCurrentScore(THREE_OF_KIND);
        }

        int[] lastThree =
                {
                        currentHand.cardsInHand.get(2).getValue().getIntValue(),
                        currentHand.cardsInHand.get(3).getValue().getIntValue(),
                        currentHand.cardsInHand.get(4).getValue().getIntValue()};

        if (sameValue(lastThree)) {
//            System.out.println("THREE OF A KIND: " + currentHand.cardsInHand.toString());
            sameThree = lastThree;
            currentPlayer.setCurrentScore(THREE_OF_KIND);
        }

        return sameThree;

    }

    public static int @NotNull [] testForTwoPairs (Player currentPlayer, Hand currentHand) {
        int pairSize = 2;
        int[] firstPair = new int [pairSize];
        int[] secondPair = new int[pairSize];
        int[] returnArray = new int[pairSize];

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

        if (secondPair[0] != 0) {
//            Creates an array with the two values of the pairs for any draw solving
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
