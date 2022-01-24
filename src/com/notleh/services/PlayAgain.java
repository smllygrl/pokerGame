package com.notleh.services;

import com.notleh.entities.Hand;
import com.notleh.entities.Player;
import com.notleh.enums.EnumHandScores;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import static com.notleh.services.Game.game;
import static com.notleh.services.InputSeperateSort.createCardArray;
import static com.notleh.services.ValidateHand.validateHand;

public class PlayAgain {

    public static int PLAYER_ONE_BEGIN = 0;
    public static int PLAYER_ONE_END = 14;
    public static int PLAYER_TWO_BEGIN = 15;
    public static int PLAYER_TWO_END = 29;

    public static void playAgain (Player playerOne, Player playerTwo) throws FileNotFoundException {

        Scanner sc = new Scanner(new File("/Users/NLH/Desktop/poker-hands.txt"));

        System.out.println("Input 10 card values + ENTER (eg. AH 9S 4D TD 8S 4H JS 3C TC 8D)");

        String inputHandString = null;

       while (sc.nextLine() != null) {
           inputHandString = sc.nextLine();
           validateHand(inputHandString);
//            System.out.println("Manual input now required");
//            Scanner manualInput = new Scanner(System.in);
//            String manualInputString = manualInput.nextLine();
//            validateHand(manualInputString);
        }

        ArrayList<String> playerOneHandArr = createCardArray(inputHandString, PLAYER_ONE_BEGIN, PLAYER_ONE_END);
        ArrayList<String> playerTwoHandArr = createCardArray(inputHandString, PLAYER_TWO_BEGIN, PLAYER_TWO_END);

        Hand playerOneNewHand = new Hand();
        Hand playerTwoNewHand = new Hand();

        playerOneNewHand.buildHand(playerOneHandArr);
        playerTwoNewHand.buildHand(playerTwoHandArr);

        System.out.println(playerOneNewHand.cardsInHand.toString());
        System.out.println(playerTwoNewHand.cardsInHand.toString());

        playerOne.setCurrentScore(EnumHandScores.ZER0);
        playerTwo.setCurrentScore(EnumHandScores.ZER0);

        game(playerOne, playerOneNewHand, playerTwo, playerTwoNewHand);
    }
}
