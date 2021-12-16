//package com.notleh.services;
//
//import java.util.Arrays;
//import java.util.stream.Stream;
//
//public class HandSeperateSort {

//    public static int PLAYER_ONE_BEGIN = 0;
//    public static int PLAYER_ONE_END = 14;
//    public static int PLAYER_TWO_BEGIN = 15;
//    public static int PLAYER_TWO_END = 29;

// takes in validUserInput
//
//    String playerOneHandString = inputHandString.substring(0, 14);
//    String playerTwoHandString = inputHandString.substring(15, 28);
//
//    String[] playerOneHandStringSplit = playerOneHandString.split("");
//    String[] playerTwoHandStringSplit = playerTwoHandString.split("");
//
//    public static Stream<String> sortHand (String[] playerHandStringSplit)
//    {
//        return Arrays.stream(playerHandStringSplit).sorted();
//    }
//public Stream<String> playerCardsSortedArr (String playerCards)
//    {
//        String[] playerCardsArr = playerCards.split(" ");
//        Stream<String> sortedPlayerCardsArr = Arrays.stream(playerCardsArr).sorted();
//        return sortedPlayerCardsArr;
//    }
//
//}
