package com.notleh.services;

import com.notleh.entities.Hand;
import com.notleh.entities.Player;
import com.notleh.enums.EnumCardSuits;
import com.notleh.enums.EnumCardValues;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Objects;

import static com.notleh.enums.EnumHandScores.*;

public class HandEvaluator {

    static int HAND_SIZE = 5;

//    ALL HANDS ARE IN DESCENDING (THE HIGHEST INT VALUE FIRST) ORDER

    public static void royalFlushTest(Player currentPlayer, Hand currentHand) {

//        ROYAL FLUSH TEST WORKS

        if (currentHand.cardsInHand.get(0).getValue().getIntValue() == EnumCardValues.ACE.getIntValue()) {
            boolean descendingOrder = false;
            int startValue = currentHand.cardsInHand.get(0).getValue().getIntValue();

            for (int i = 0; i < HAND_SIZE; i++) {
                if (currentHand.cardsInHand.get(i).getValue().getIntValue() == startValue - i) {
                    descendingOrder = true;
                } else return;
            }

            if (descendingOrder) {
                EnumCardSuits suitToCompare = currentHand.cardsInHand.get(0).getSuit();

                for (int j = 1; j < HAND_SIZE - 1; j++) {
                    if (currentHand.cardsInHand.get(j).getSuit() != suitToCompare) {
                        currentPlayer.setCurrentScore(STRAIGHT);
                        return;
                    }
                }

                if (currentPlayer.getCurrentScore() != STRAIGHT)
                    currentPlayer.setCurrentScore(ROYAL_FLUSH);
            }
        }
    }

    public static void straightFlushTest(Player currentPlayer, Hand currentHand)
    {

//        STRAIGHT FLUSH WORKS

        int startValue = currentHand.cardsInHand.get(0).getValue().getIntValue();
        EnumCardSuits suitToCompare = currentHand.cardsInHand.get(0).getSuit();
//        Starting at 1 because 0 is the startValue which we compare all others
        for (int i = 1; i < HAND_SIZE; i++) {
//            Minus i as card sizes get smaller as index increases
            if(currentHand.cardsInHand.get(i).getValue().getIntValue() == startValue - i)
            {
                if (currentHand.cardsInHand.get(i).getSuit() == suitToCompare) {
                    continue;
                } else return;
            } else return;
        }
        currentPlayer.setCurrentScore(STRAIGHT_FLUSH);
    }

    public static void fourOfAKind (Player currentPlayer, Hand currentHand) {

//        FOUR OF A KIND WORKS

//        This will check whether there are 4 of the value in currentHand[0] and/ or currentHand[1]
//        As the hand is sorted, all the cards of the same value are located together

        for (int i = 0; i < 2; i++) {
            int check = currentHand.cardsInHand.get(i).getValue().getIntValue();
            int count = 0;
            for (int j = 0; j < HAND_SIZE; j++) {
                if (currentHand.cardsInHand.get(j).getValue().getIntValue() == check) {
                    count ++;
                }
            }
            if (count == 4) {
                currentPlayer.setCurrentScore(FOUR_OF_KIND);
            }
        }
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

        if (firstTwo[0] == firstTwo [1]) {
            if (lastThree[0] == lastThree[1]) {
                if (lastThree[1] == lastThree[2]) {
                    currentPlayer.setCurrentScore(FULL_HOUSE);
                }
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

        if (firstThree[0] == firstThree[1]) {
            if (firstThree[1] == firstThree[2]) {
                if (lastTwo[0] == lastTwo[1]) {
                    currentPlayer.setCurrentScore(FULL_HOUSE);
                }
            }
        }

    }


    public static void flushTest(Player currentPlayer, Hand currentHand)
    {

//        FLUSH TEST WORKS

//        Because we start with a single suit to compare the others to...
        boolean sameSuit = false;

            EnumCardSuits suitToCompare = currentHand.cardsInHand.get(0).getSuit();
            for (int j = 1; j < HAND_SIZE - 1; j++) {
                if (currentHand.cardsInHand.get(j).getSuit() == suitToCompare)
                {
                    sameSuit = true;
                } else return;
            }

        if (sameSuit) {
            currentPlayer.setCurrentScore(FLUSH);
        }

    }

    public static void straightTest(Player currentPlayer, Hand currentHand)
    {

//        STRAIGHT TEST WORKS

        int startValue = currentHand.cardsInHand.get(0).getValue().getIntValue();

        boolean descendingOrder = false;
        //        Starting at 1 because 0 is the startValue which we compare all others
        for (int i = 1; i < HAND_SIZE; i++) {
            if(currentHand.cardsInHand.get(i).getValue().getIntValue() == startValue - i)
            {
                descendingOrder = true;
            } else return;
        }

        if (descendingOrder) {
            currentPlayer.setCurrentScore(STRAIGHT);
        }
    }

    public static void threeOfAKind (Player currentPlayer, Hand currentHand) {

//        As the hand is sorted, the three will either be the first three cards, or the last three

        int[] firstThree =
                {
                        currentHand.cardsInHand.get(0).getValue().getIntValue(),
                        currentHand.cardsInHand.get(1).getValue().getIntValue(),
                        currentHand.cardsInHand.get(2).getValue().getIntValue()};

        if (firstThree[0] == firstThree [1]) {
            if (firstThree[1] == firstThree[2]) {
                currentPlayer.setCurrentScore(THREE_OF_KIND);
            }
        }

        int[] lastThree =
                {
                        currentHand.cardsInHand.get(2).getValue().getIntValue(),
                        currentHand.cardsInHand.get(3).getValue().getIntValue(),
                        currentHand.cardsInHand.get(4).getValue().getIntValue()};

        if (lastThree[0] == lastThree [1]) {
            if (lastThree[1] == lastThree[2]) {
                currentPlayer.setCurrentScore(THREE_OF_KIND);
            }
        }


    }

    public static void pairTest(Player currentPlayer, Hand currentHand) {

//        As the hand is sorted, pairs can appear in any of the 4 index possibilities:
//        0, 1 // 1, 2 // 2, 3 // 3, 4
//        This function will see if there are any pairs & count the number of pairs if they do exist
//        There will be one card in the hand not in a pair

        int pairCount = 0;


        int[] cardOneCardTwo =
                {
                        currentHand.cardsInHand.get(0).getValue().getIntValue(),
                        currentHand.cardsInHand.get(1).getValue().getIntValue()
                };


        if (cardOneCardTwo[0] == cardOneCardTwo[1])
        {
            pairCount ++;
        }


        int[] cardThreeCardFour =
                {
                        currentHand.cardsInHand.get(2).getValue().getIntValue(),
                        currentHand.cardsInHand.get(3).getValue().getIntValue()
                };

        if (cardThreeCardFour[0] == cardThreeCardFour[1])
        {
            pairCount ++;
        }


        int[] cardTwoCardThree =
                {
                        currentHand.cardsInHand.get(1).getValue().getIntValue(),
                        currentHand.cardsInHand.get(2).getValue().getIntValue()
                };

        if (cardTwoCardThree[0] == cardTwoCardThree[1])
        {
            pairCount ++;
        }


        int[] cardFourCardFive =
                {
                        currentHand.cardsInHand.get(3).getValue().getIntValue(),
                        currentHand.cardsInHand.get(4).getValue().getIntValue()
                };

        if (cardFourCardFive[0] == cardFourCardFive[1])
        {
            pairCount ++;
        }

        if (pairCount == 2) {
            currentPlayer.setCurrentScore(TWO_PAIRS);
        } else if (pairCount == 1) {
            currentPlayer.setCurrentScore(PAIR);
        }




    }

}
