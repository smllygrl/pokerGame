package com.notleh.entities;

import java.util.ArrayList;

import com.notleh.enums.EnumCardSuits;
import com.notleh.enums.EnumCardSuits.*;
import com.notleh.enums.EnumCardValues;
import com.notleh.enums.EnumCardValues.*;
import com.notleh.entities.Card;

public class Hand {

//    Takes in sortedPlayerCardsArr

    ArrayList<String> cardOne;
    ArrayList<String> cardTwo;
    ArrayList<String> cardThree;
    ArrayList<String> cardFour;
    ArrayList<String> cardFive;

    static int HAND_SIZE = 5;
    static int VALUE_POSITION = 0;
    static int SUIT_POSITION = 1;

    public Hand(ArrayList<String> cardOne, ArrayList<String> cardTwo, ArrayList<String> cardThree, ArrayList<String> cardFour, ArrayList<String> cardFive;
    {
        this.cardOne = cardOne;
        this.cardTwo = cardTwo;
        this.cardThree = cardThree;
        this.cardFour = cardFour;
        this.cardFive = cardFive;
    }

    public ArrayList (String[] sortedPlayerCardsArr)
    {

    }

    public ArrayList<String> cardInHand(suit) {
        this.value = value;
        this.suit = suit;
    }

    public EnumCardSuits getSuit() {
        return suit;
    }

    public EnumCardValues getValue() {
        return value;
    }


    public static ArrayList<String> getAllHandValues()
    {
        ArrayList<String> handValues = new ArrayList<>(5);

        for (int i = 0; i < HAND_SIZE ; i++)
        {
            for (int j = 0; i <= 1; i++)
            {
//                add card value to an array?
                handValues.set(i, Hand[i][1]);

            }
        }

        return handValues;
    }

    public static ArrayList<String> getAllHandSuits()
    {
        ArrayList<String> handSuits= new ArrayList<>(5);

        for (int i = 0; i < HAND_SIZE ; i++)
        {
            for (int j = 0; i <= 1; i++)
            {
//                add card suit to an array?
                handSuits.set(i, Hand[i][0]);

            }
        }

        return handSuits;
    }


//    create eval checks in here

//    list of cards
//    hand created, sort cards ahead of time
//    sort by values

}


