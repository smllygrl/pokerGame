package com.notleh.enums;

public enum EnumCardSuits {
    DIAMONDS("D"),
    HEARTS("H"),
    CLUBS("C"),
    SPADES("S");

    public final String suit;

    EnumCardSuits(final String suit) { this.suit = suit; }

    public String getSuit() { return suit; }

    public static EnumCardSuits suitOfCard (String cardSuit)
    {
        for (EnumCardSuits enumCardSuit : values())
        {
            if (enumCardSuit.suit.equals(cardSuit))
            {
                return enumCardSuit;
            }
        }
        return null;
    }
}

// Heavily references: https://gitlab.com/dakimar1/poker-hand-sorter/-/blob/master/src/main/java/project/types/EnumSuit.java
