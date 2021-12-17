package com.notleh.entities;


import com.notleh.enums.EnumCardSuits;
import com.notleh.enums.EnumCardValues;

import java.util.Arrays;
import java.util.stream.Stream;

public class Card {

//    Card class should only have suit and value enum

    private EnumCardSuits suit;
    private EnumCardValues value;

// should only take in 2 item string eg index of sorted array

    public Card(String cardString)
    {
        value = EnumCardValues.valueOfCard(cardString.substring(0, 1));
        suit = EnumCardSuits.suitOfCard(cardString.substring(1, 2));
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

    public boolean valueInt (EnumCardValues enumCardValues)
    {
        return value.getIntValue().equals(enumCardValues.getIntValue());
    }
}

// Heavily references: https://gitlab.com/dakimar1/poker-hand-sorter/-/blob/master/src/main/java/project/model/Card.java


