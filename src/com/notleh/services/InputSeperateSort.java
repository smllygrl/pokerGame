package com.notleh.services;

import com.notleh.enums.EnumCardValues;

import java.util.ArrayList;
import java.util.Arrays;

public class InputSeperateSort {

    static int HAND_SIZE = 5;

    public static ArrayList<String> createCardArray(String validUserInput, Integer stringStart, Integer stringEnd)
    {
        String playerHandString = validUserInput.substring(stringStart, stringEnd);
        String[] playerCardsArrTemp = playerHandString.split(" ");
        Arrays.sort(playerCardsArrTemp);

        ArrayList<String> playerCardsArr = new ArrayList<String>(HAND_SIZE);
        for (int i = 0; i < HAND_SIZE; i++) {
            playerCardsArr.add(playerCardsArrTemp[i]);
        }

        sortHand(playerCardsArr);

        return playerCardsArr;
    }

    public static void sortHand(ArrayList<String> arrPlayerCards) {

        for (int i = 0; i < HAND_SIZE; i++) {

            for (int j = 0; j < HAND_SIZE; j++) {

                String smallString = arrPlayerCards.get(i);
                String smallSubStr = smallString.substring(0, 1);
                EnumCardValues smallEnum = EnumCardValues.valueOfCard(smallSubStr);

                String bigString = arrPlayerCards.get(j);
                String bigSubStr = bigString.substring(0, 1);
                EnumCardValues bigEnum = EnumCardValues.valueOfCard(bigSubStr);

                assert smallEnum != null;
                assert bigEnum != null;
                if (smallEnum.getIntValue() > bigEnum.getIntValue()) {
                    arrPlayerCards.set(i, bigString);
                    arrPlayerCards.set(j, smallString);
                }
            }
        }

    }






}
