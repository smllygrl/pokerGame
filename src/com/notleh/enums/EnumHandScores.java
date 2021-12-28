package com.notleh.enums;

public enum EnumHandScores {
    HIGH_CARD(1),
    PAIR(2),
    TWO_PAIRS(3),
    THREE_OF_KIND(4),
    STRAIGHT(5),
    FLUSH(6),
    FULL_HOUSE(7),
    FOUR_OF_KIND(8),
    STRAIGHT_FLUSH(9),
    ROYAL_FLUSH(10);

    public final Integer score;

    EnumHandScores(final Integer score)
    {
        this.score = score;
    }

    public Integer getScore()
    {
        return score;
    }
}

 Heavily references: https://gitlab.com/dakimar1/poker-hand-sorter/-/blob/master/src/main/java/project/types/EnumNameCombination.java
