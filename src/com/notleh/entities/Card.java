package com.notleh.entities;


import com.notleh.enums.EnumCardSuits;
import com.notleh.enums.EnumCardValues;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

public class Card {

//    Card class should only have suit and value enum

    public EnumCardSuits suit;
    public EnumCardValues value;

// should only take in 2 item string eg index of sorted array

    public Card(ArrayList<String> cardString )
    {
        value = EnumCardValues.valueOfCard(cardString.get(0));
        suit = EnumCardSuits.suitOfCard(cardString.get(1));
    }

    public Card(EnumCardSuits suit, EnumCardValues value)
    {
        this.suit = suit;
        this.value = value;
    }

    public EnumCardSuits getSuit() {
        return suit;
    }

    public EnumCardValues getValue() {
        return value;
    }

    @Override
    public String toString()
    {
        return Card.this.value + "" + Card.this.suit;
    }

}

// Heavily references: https://gitlab.com/dakimar1/poker-hand-sorter/-/blob/master/src/main/java/project/model/Card.java


