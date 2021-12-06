package com.notleh;

import com.notleh.entities.Player;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.println("Input 10 card values + ENTER (eg. AH 9S 4D TD 8S 4H JS 3C TC 8D)");
        String inputHandString = input.nextLine();
        validateHand(inputHandString);
        buildHand(inputHandString);
    }

    public static boolean validateHand(String string) {

//        REGEX must ensure 1 space between each value or card assignment won't work

        Pattern pattern = Pattern.compile("([1-9TKQJA][DHSC]\\s?){10}");
        Matcher matcher = pattern.matcher(string);
        boolean validInput = matcher.find();
        if (validInput) {
            System.out.println("Valid input, cards being assigned");
            return true;
        } else {
            System.out.println("Invalid input. Please re-read input instructions and try again.");
            return false;
        }
    }

    public static void createCards(String playerHandString, ArrayList playerHand)
    {
        ArrayList<String> cardOne = new ArrayList<>();
        String cardOneContent = playerHandString.substring(0, 2);
        fillCards(cardOneContent, cardOne);
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
        ArrayList<String> playerOneHand = new ArrayList<String>();
        createCards(playerOneHandString, playerOneHand);


        String playerTwoHandString = validUserInput.substring(15, 29);
        System.out.println(playerTwoHandString);
        ArrayList<String> playerTwoHand = new ArrayList<String>();
        createCards(playerTwoHandString, playerTwoHand);

        System.out.println(playerOneHand);
        System.out.println(playerTwoHand);

    }

    public static void allocateHand()
    {
        Player playerOne = new Player("playerOne", ArrayList<>playerOneHand, 0, 0);
        Player playerTwo = new Player("playerTwo", ArrayList<>playerTwoHand, 0, 0);
    }


}
