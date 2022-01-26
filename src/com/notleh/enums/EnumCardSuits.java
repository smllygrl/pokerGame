package com.notleh.enums;

public enum EnumCardSuits {
    DIAMONDS("D"),
    HEARTS("H"),
    CLUBS("C"),
    SPADES("S");

    public final String suit;

    EnumCardSuits(final String suit) { this.suit = suit; }

//    public static EnumCardSuits suitOfCard(String substring) {
//        substring = suitOfCard()
//    }

    public String getSuit() { return this.suit; }

    @Override
    public String toString() {
        return suit.toString();
    }

    public static EnumCardSuits suitOfCard(String cardSuit)
    {
        for (EnumCardSuits enumCardSuits : values())
        {
            if (enumCardSuits.suit.equals(cardSuit))
            {
                return enumCardSuits;
            }
        }
        System.out.println("FAILED TO MAKE SUIT: " + cardSuit);
        return null;
    }
}

// Heavily references: https://gitlab.com/dakimar1/poker-hand-sorter/-/blob/master/src/main/java/project/types/EnumSuit.java
