package com.notleh;

import java.util.ArrayList;

public class DumpingGround {

    public static void createCards(String playerHandString, ArrayList playerHand)
    {

//        Makes 5 individual arrays with 0 = value & 1 = suit
        ArrayList<String> cardOne = new ArrayList<>();
        String cardOneContent = playerHandString.substring(0, 2);
        fillCards(cardOneContent, cardOne);
//        Adds the card to the player hand array, creating a 2D array
        playerHand.add(1);
        playerHand.set(0, cardOne);

        ArrayList<String> cardTwo = new ArrayList<>();
        String cardTwoContent  = playerHandString.substring(3, 5);
        fillCards(cardTwoContent, cardTwo);
        playerHand.add(2);
        playerHand.set(1, cardTwo);

        ArrayList<String> cardThree = new ArrayList<>();
        String cardThreeContent  = playerHandString.substring(6, 8);
        fillCards(cardThreeContent, cardThree);
        playerHand.add(3);
        playerHand.set(2, cardThree);

        ArrayList<String> cardFour = new ArrayList<>();
        String cardFourContent  = playerHandString.substring(9, 11);
        fillCards(cardFourContent, cardFour);
        playerHand.add(4);
        playerHand.set(3, cardFour);

        ArrayList<String> cardFive = new ArrayList<>();
        String cardFiveContent  = playerHandString.substring(12);
        fillCards(cardFiveContent, cardFive);
        playerHand.add(5);
        playerHand.set(4, cardFive);
    }

    public static void fillCards(String cardContent, ArrayList card){

        String value = cardContent.substring(0, 1);
        String suit = cardContent.substring(1);

        card.add(1);
        card.add(2);

        card.set(0, value);
        card.set(1, suit);
    }

    public static void buildHand(String validUserInput) {

        String playerOneHandString = validUserInput.substring(0, 14);
        System.out.println(playerOneHandString);
        sortHand(playerOneHandString);
        ArrayList<String> playerOneHand = new ArrayList<String>();
//        Calls create card function, which creates and fills
        createCards(playerOneHandString, playerOneHand);
//        playerOneHand.stream().sorted();

        String playerTwoHandString = validUserInput.substring(15, 29);
        System.out.println(playerTwoHandString);
        sortHand(playerTwoHandString);
        ArrayList<String> playerTwoHand = new ArrayList<String>();
        createCards(playerTwoHandString, playerTwoHand);
//        playerTwoHand.stream().sorted();

        System.out.println(playerOneHand);
        System.out.println(playerTwoHand);

//        allocateHand(playerOneHand, playerTwoHand);
    }

    public static void testSuite(String testString)
    {
        sortHand(testString);
        System.out.println(testString);
    }

//    public static void allocateHand(ArrayList<ArrayList<String>> playerOneHand, ArrayList<ArrayList<String>> playerTwoHand)
//    {
//        Player playerOne = new Player("playerOne", ArrayList<playerOneHand>, 0, 0);
//        Player playerTwo = new Player("playerTwo", ArrayList<playerTwoHand>, 0, 0);
//    }

//public static ArrayList sortHand(ArrayList<String> str)
//{
//    return ArrayList.stream().sorted();
//}
//
//







}

}
