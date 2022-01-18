package com.notleh.services;

import com.notleh.entities.Hand;
import com.notleh.entities.Player;
import com.notleh.enums.EnumCardSuits;
import com.notleh.enums.EnumCardValues;

import static com.notleh.enums.EnumHandScores.*;

public class HandEvaluator {

    static int HAND_SIZE = 5;

    //    Sorting means I can confidently start with the lowest value in my loops

    public static void royalFlushTest(Player currentPlayer, Hand currentHand) {
        System.out.println("Royal flush test: " + currentPlayer);

        if (currentHand.cardsInHand.get(0).getValue().getIntValue() == 10) {
            boolean ascendingOrder = false;

//        starts at 1 as 0 is 10
            for (int i = 1; i < HAND_SIZE; i++) {
                if (currentHand.cardsInHand.get(i).getValue().getIntValue() == (10 + i)) {
                    ascendingOrder = true;
                    continue;
                } else return;
            }

            if (ascendingOrder) {
                EnumCardSuits suitToCompare = currentHand.cardsInHand.get(0).getSuit();
                for (int j = 1; j < HAND_SIZE - 1; j++) {
                    if (currentHand.cardsInHand.get(j).getSuit() == suitToCompare) {
                        continue;
                    } else currentPlayer.setCurrentScore(STRAIGHT);
                }
                if (currentPlayer.getCurrentScore() != STRAIGHT)
                    currentPlayer.setCurrentScore(ROYAL_FLUSH);
            } else return;
        } else return;
    }

    public static void straightFlushTest(Player currentPlayer, Hand currentHand)
    {
        System.out.println("Straight flush test: " + currentPlayer);
        int startValue = currentHand.cardsInHand.get(0).getValue().getIntValue();
        EnumCardSuits suitToCompare = currentHand.cardsInHand.get(0).getSuit();
//        Starting at 1 because 0 is the startValue which we compare all others
        for (int i = 1; i < HAND_SIZE; i++) {
            if(currentHand.cardsInHand.get(i).getValue().getIntValue() == startValue + i)
            {
                if (currentHand.cardsInHand.get(i).getSuit() == suitToCompare) {
                    continue;
                } else return;
            } else return;
        }
        currentPlayer.setCurrentScore(STRAIGHT_FLUSH);
    }


    public static void flushTest(Player currentPlayer, Hand currentHand)
    {
        System.out.println("Flush test: " + currentPlayer);
//        Because we start with a single suit to compare the others to...
        int suitCount = 1;
        for (int i = 0; i < HAND_SIZE; i++)
        {
            EnumCardSuits suitToCompare = currentHand.cardsInHand.get(i).getSuit();
            for (int j = i + 1; j < HAND_SIZE - 1; j++) {
                if (currentHand.cardsInHand.get(j).getSuit() == suitToCompare)
                {
                    suitCount++;
                }
            }
            if (suitCount == HAND_SIZE)
                currentPlayer.setCurrentScore(FLUSH);
        }
    }

    public static void straightTest(Player currentPlayer, Hand currentHand)
    {
        System.out.println("Straight test: " + currentPlayer);
        int startValue = currentHand.cardsInHand.get(0).getValue().getIntValue();
//        Starting at 1 because 0 is the startValue which we compare all others
        for (int i = 1; i < HAND_SIZE; i++) {
            if(currentHand.cardsInHand.get(i).getValue().getIntValue() == startValue + i)
            {
                continue;
            } else return;
        }
        currentPlayer.setCurrentScore(STRAIGHT);
    }

    public static void valueTest(Player currentPlayer, Hand currentHand) {
        System.out.println("Checking for pairs: " + currentPlayer);
        int valueArray[] = new int[HAND_SIZE];

        for (int i = 0; i < HAND_SIZE; i++) {
            EnumCardValues valueToCompare = currentHand.cardsInHand.get(i).getValue();
            int sameValue = valueArray[i];
            for (int j = i + 1; j < HAND_SIZE - 1; j++) {
                if (currentHand.cardsInHand.get(j).getValue() == valueToCompare) {
                    sameValue++;
                }
            }
        }

        int countOfTwo = 0;
        int countOfThree = 0;
        int countOfFour = 0;

//        Cases denote the number of cards the same as the one it was compared to, THUS case number + 1 = total occurence of card
        for (int i = 0; i < valueArray.length; i++) {
            switch (valueArray[i]) {
                case 0:
                    break;
                case 1:
                    countOfTwo++;
                    break;
                case 2:
                    countOfThree++;
                    break;
                case 3:
                    countOfFour++;
                    break;
            }
        }

        if (countOfFour == 1) {
            currentPlayer.setCurrentScore(FOUR_OF_KIND);
        } else if (countOfThree == 1) {
            if (countOfTwo == 1) {
                currentPlayer.setCurrentScore(FULL_HOUSE);
            } else currentPlayer.setCurrentScore(THREE_OF_KIND);
        } else if (countOfTwo == 2) {
            currentPlayer.setCurrentScore(TWO_PAIRS);
        } else if (countOfTwo == 1) {
            currentPlayer.setCurrentScore(PAIR);
        }
    }

}
