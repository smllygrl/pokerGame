package com.notleh.enums;

public enum EnumCardSuits {
    DIAMONDS("D"),
    HEARTS("H"),
    CLUBS("C"),
    SPADES("S");

    public final String suit;

    EnumCardSuits(final String suit) { this.suit = suit; }

    public String getSuit() { return suit; }
}
