package com.notleh;

import com.notleh.entities.Hand;
import com.notleh.entities.Player;
import com.notleh.entities.Card;
import com.notleh.services.InputSeperateSort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

// Services

import static com.notleh.services.ValidateHand.validateHand;
import static com.notleh.services.InputSeperateSort.createCardArray;

public class Main {

    public static int PLAYER_ONE_BEGIN = 0;
    public static int PLAYER_ONE_END = 14;
    public static int PLAYER_TWO_BEGIN = 15;
    public static int PLAYER_TWO_END = 29;

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.println("Input 10 card values + ENTER (eg. AH 9S 4D TD 8S 4H JS 3C TC 8D)");
        String inputHandString = input.nextLine();
        validateHand(inputHandString);

        ArrayList<String> playerOneHandArr = createCardArray(inputHandString, PLAYER_ONE_BEGIN, PLAYER_ONE_END);
        ArrayList<String> playerTwoHandArr = createCardArray(inputHandString, PLAYER_TWO_BEGIN, PLAYER_TWO_END);

        Hand playerOneHand = new Hand();
        Hand playerTwoHand = new Hand();

        playerOneHand.buildHand(playerOneHandArr);
        System.out.printf(String.valueOf(playerOneHand.cardsInHand.toString()));
        playerTwoHand.buildHand(playerTwoHandArr);
        System.out.printf(playerTwoHand.cardsInHand.toString());

        Player playerOne = new Player("playerOne", playerOneHand, 0, 0);
        Player playerTwo = new Player("playerTwo", playerTwoHand, 0, 0);
    }

}

