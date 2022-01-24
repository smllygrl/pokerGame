package com.notleh.enums;

public enum EnumCardValues {
    TWO("2", 2),
    THREE("3", 3),
    FOUR("4", 4),
    FIVE("5", 5),
    SIX("6", 6),
    SEVEN("7", 7),
    EIGHT("8", 8),
    NINE("9", 9),
    TEN("T", 10),
    JACK("J", 11),
    QUEEN("Q", 12),
    KING("K", 13),
    ACE("A", 14);

    public final String strValue;

    public final Integer intValue;

    EnumCardValues(final String strValue, Integer intValue)
    {
        this.strValue = strValue;
        this.intValue = intValue;
    }

    public String getStrValue()
    {
        return strValue;
    }

    public Integer getIntValue()
    {
        return intValue;
    }

    public static EnumCardValues valueOfCard(String cardValue)
    {
        for (EnumCardValues enumCardValue : values())
        {
            if (enumCardValue.strValue.equals(cardValue))
            {
                return enumCardValue;
            }
        }
        return null;
    }
}

//    Heavily references: https://gitlab.com/dakimar1/poker-hand-sorter/-/blob/master/src/main/java/project/types/EnumValue.java