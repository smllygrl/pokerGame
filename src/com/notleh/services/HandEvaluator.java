package com.notleh.services;

import com.notleh.entities.Hand;
import com.notleh.entities.Player;
import com.notleh.enums.EnumCardValues;

import java.util.Objects;

import static com.notleh.enums.EnumHandScores.*;

public class HandEvaluator implements combinationTester{

    static int HAND_SIZE = 5;

//    ALL HANDS ARE IN DESCENDING (THE HIGHEST INT VALUE FIRST) ORDER

//    Helper methods
    public static Boolean sameSuit (String suitToCompare, Hand currentHand) {
        boolean sameSuit = false;
        for (int j = 1; j < HAND_SIZE - 1; j++) {
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
                    System.out.println("ROYAL FLUSH: " + currentHand.cardsInHand.toString());
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
                System.out.println("STRAIGHT FLUSH: " + currentHand.cardsInHand.toString());
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
            System.out.println("Four of a kind: " + currentHand.cardsInHand.toString());
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
            System.out.println("Four of a kind: " + currentHand.cardsInHand.toString());
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
                System.out.println("FULL HOUSE: " + currentHand.cardsInHand.toString());
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
                System.out.println("FULL HOUSE: " + currentHand.cardsInHand.toString());
                currentPlayer.setCurrentScore(FULL_HOUSE);
            }
        }
    }


    public static void flushTest(Player currentPlayer, Hand currentHand)
    {
//        FLUSH TEST WORKS
        String suitToCompare = currentHand.cardsInHand.get(0).getSuit().toString();
        if(sameSuit(suitToCompare, currentHand)){
            System.out.println("FLUSH: " + currentHand.cardsInHand.toString());
        }

    }

    public static void straightTest(Player currentPlayer, Hand currentHand)
    {
//        STRAIGHT TEST WORKS
        if (descendingOrder(currentHand)) {
            System.out.println("STRAIGHT: " + currentHand.cardsInHand.toString());
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
            System.out.println("THREE OF A KIND: " + currentHand.cardsInHand.toString());
            sameThree = firstThree;
            currentPlayer.setCurrentScore(THREE_OF_KIND);
        }

        int[] middleThree =
                {
                        currentHand.cardsInHand.get(1).getValue().getIntValue(),
                        currentHand.cardsInHand.get(2).getValue().getIntValue(),
                        currentHand.cardsInHand.get(3).getValue().getIntValue()};

        if (sameValue(middleThree)) {
            System.out.println("THREE OF A KIND: " + currentHand.cardsInHand.toString());
            sameThree = firstThree;
            currentPlayer.setCurrentScore(THREE_OF_KIND);
        }

        int[] lastThree =
                {
                        currentHand.cardsInHand.get(2).getValue().getIntValue(),
                        currentHand.cardsInHand.get(3).getValue().getIntValue(),
                        currentHand.cardsInHand.get(4).getValue().getIntValue()};

        if (sameValue(lastThree)) {
            System.out.println("THREE OF A KIND: " + currentHand.cardsInHand.toString());
            sameThree = lastThree;
            currentPlayer.setCurrentScore(THREE_OF_KIND);
        }

        return sameThree;

    }


    public static int[][] pairTest(Player currentPlayer, Hand currentHand) {

//        As the hand is sorted, pairs can appear in any of the 4 index possibilities:
//        0, 1 // 1, 2 // 2, 3 // 3, 4
//        This function will see if there are any pairs & count the number of pairs if they do exist
//        There will be one card in the hand not in a pair of there are two pairs

        int[][] potentialPairs = new int [4][2];

        int[] cardOneCardTwo =
                {
                        currentHand.cardsInHand.get(0).getValue().getIntValue(),
                        currentHand.cardsInHand.get(1).getValue().getIntValue()
                };

        potentialPairs[0] = cardOneCardTwo;

        int[] cardTwoCardThree =
                {
                        currentHand.cardsInHand.get(1).getValue().getIntValue(),
                        currentHand.cardsInHand.get(2).getValue().getIntValue()
                };

        potentialPairs[1] = cardTwoCardThree;


        int[] cardThreeCardFour =
                {
                        currentHand.cardsInHand.get(2).getValue().getIntValue(),
                        currentHand.cardsInHand.get(3).getValue().getIntValue()
                };

        potentialPairs[2] = cardThreeCardFour;

        int[] cardFourCardFive =
                {
                        currentHand.cardsInHand.get(3).getValue().getIntValue(),
                        currentHand.cardsInHand.get(4).getValue().getIntValue()
                };

        potentialPairs[3] = cardFourCardFive;

        int[][] pairs = new int[2][2];
        int pairCount = 0;
        for (int i = 0; i < potentialPairs.length; i++) {
            int[] pairToTest = potentialPairs[i];
            for (int j = 0; j < 2; j++) {
                if (pairToTest[0] == pairToTest[1]) {
                    pairs[j] = pairToTest;
                    pairCount++;
                }
            }
        }

        if (pairCount == 2) {
            currentPlayer.setCurrentScore(TWO_PAIRS);
        } else if (pairCount == 2) {
            currentPlayer.setCurrentScore(PAIR);
        }

        return pairs;
    }

//    @Override
//    public void getCombination() {
//
//    }
}
