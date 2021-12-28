package com.notleh.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class InputSeperateSort {

    static int HAND_SIZE = 5;

    public void sortedArr (ArrayList<String> cardArray) {
    }

    public static ArrayList<String> createCardArray(String validUserInput, Integer stringStart, Integer stringEnd)
    {
        String playerHandString = validUserInput.substring(stringStart, stringEnd);
        String[] playerCardsArrTemp = playerHandString.split(" ");
        System.out.println(Arrays.toString(playerCardsArrTemp));

        ArrayList<String> playerCardsArr = new ArrayList<String>(HAND_SIZE);
        for (int i = 0; i < HAND_SIZE; i++) {
            playerCardsArr.add(playerCardsArrTemp[i]);
        }
        playerCardsArr.stream().sorted();

        return playerCardsArr;
    }






}
