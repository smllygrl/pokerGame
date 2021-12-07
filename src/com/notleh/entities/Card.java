package com.notleh.entities;

import com.notleh.enums.EnumCardSuits;
import com.notleh.enums.EnumCardValues;

import java.util.ArrayList;

public class Card {

    EnumCardValues value;
    EnumCardSuits suit;

   public ArrayList<String> Card (EnumCardSuits suit, EnumCardValues value)
   {
       this.value = value;
       this.suit = suit;
   }

   public EnumCardSuits getSuit()
   {
       return suit;
   }

   public EnumCardValues getValue()
   {
       return value;
   }

