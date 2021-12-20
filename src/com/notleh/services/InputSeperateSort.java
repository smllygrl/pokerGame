package com.notleh.services;

import com.notleh.entities.Card;

import java.util.Arrays;
import java.util.stream.Stream;

public class InputSeperateSort {

    public InputSeperateSort(Stream<String> cardArray) {
    }

    public static Stream<String> createCardArray(String validUserInput, Integer stringStart, Integer stringEnd)
    {
        String playerHandString = validUserInput.substring(stringStart, stringEnd);
        String[] playerCardsArr = playerHandString.split(" ");
        Stream<String> sortedPlayerCardsArr = Arrays.stream(playerCardsArr).sorted();
        System.out.println(sortedPlayerCardsArr);
        return sortedPlayerCardsArr;
    }






}
