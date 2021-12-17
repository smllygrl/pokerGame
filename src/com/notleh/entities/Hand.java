package com.notleh.entities;

import java.util.ArrayList;
import java.util.List;

import com.notleh.enums.EnumCardSuits;
import com.notleh.enums.EnumCardSuits.*;
import com.notleh.enums.EnumCardValues;
import com.notleh.enums.EnumCardValues.*;
import com.notleh.entities.Card;

public class Hand {

    static int HAND_SIZE = 5;

    public ArrayList<Card> cardsInHand = null;

    public buildHand(String cardArrValue)
    {
        for (int i = 0; i < HAND_SIZE; i++) {
            cardsInHand.add(Card(cardArrValue));
        }
    }

    public List<Card> getCards()
    {
        return cards;
    }
//    public ArrayList (String[] sortedPlayerCardsArr)
//    {
//
//    }
//
//    public ArrayList<String> cardInHand(suit) {
//        this.value = value;
//        this.suit = suit;
//    }
//
//    public EnumCardSuits getSuit() {
//        return suit;
//    }
//
//    public EnumCardValues getValue() {
//        return value;
//    }
//
//
//    public static ArrayList<String> getAllHandValues()
//    {
//        ArrayList<String> handValues = new ArrayList<>(5);
//
//        for (int i = 0; i < HAND_SIZE ; i++)
//        {
//            for (int j = 0; i <= 1; i++)
//            {
////                add card value to an array?
//                handValues.set(i, Hand[i][1]);
//
//            }
//        }
//
//        return handValues;
//    }
//
//    public static ArrayList<String> getAllHandSuits()
//    {
//        ArrayList<String> handSuits= new ArrayList<>(5);
//
//        for (int i = 0; i < HAND_SIZE ; i++)
//        {
//            for (int j = 0; i <= 1; i++)
//            {
////                add card suit to an array?
//                handSuits.set(i, Hand[i][0]);
//
//            }
//        }
//
//        return handSuits;
//    }


//    create eval checks in here

//    list of cards
//    hand created, sort cards ahead of time
//    sort by values

}


