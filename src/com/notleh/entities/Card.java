package com.notleh.entities;


import com.notleh.enums.EnumCardSuits;
import com.notleh.enums.EnumCardValues;

import java.util.Arrays;
import java.util.stream.Stream;

public class Card {

//    Card class should only have suit and value enum

    private EnumCardSuits suit;
    private EnumCardValues value;



    public Card(String inputCardArr)
    {
        value = EnumCardValues.getValue(inputCardArr.substring(0, 1));
        suit = EnumCardSuits.getSuit(inputCardArr.substring(1, 2));
    }


//
//    public String playerCards (String validUserInput, Integer begin, Integer end)
//    {
//        return validUserInput.substring(begin, end);
//    }
//
//



}


