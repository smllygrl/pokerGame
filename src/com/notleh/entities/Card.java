package com.notleh.entities;


import java.util.Arrays;
import java.util.stream.Stream;

public class Card {

    public static int PLAYER_ONE_BEGIN = 0;
    public static int PLAYER_ONE_END = 14;
    public static int PLAYER_TWO_BEGIN = 15;
    public static int PLAYER_TWO_END = 29;

    public String playerCards (String validUserInput, Integer begin, Integer end)
    {
        return validUserInput.substring(begin, end);
    }

    public Stream<String> playerCardsSortedArr (String playerCards)
    {
        String[] playerCardsArr = playerCards.split(" ");
        Stream<String> sortedPlayerCardsArr = Arrays.stream(playerCardsArr).sorted();
        return sortedPlayerCardsArr;
    }

}


