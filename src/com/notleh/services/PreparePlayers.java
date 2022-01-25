package com.notleh.services;

import com.notleh.entities.Hand;
import com.notleh.entities.Player;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import static com.notleh.enums.EnumHandScores.ZER0;
import static com.notleh.services.Game.game;
import static com.notleh.services.InputSeperateSort.createCardArray;

public class PreparePlayers {

    public static int PLAYER_ONE_BEGIN = 0;
    public static int PLAYER_ONE_END = 14;
    public static int PLAYER_TWO_BEGIN = 15;
    public static int PLAYER_TWO_END = 29;

    public static void preparePlayers (String inputLine, String playerOneName, String playerTwoName, Integer playerOneCount, Integer playerTwoCount) throws FileNotFoundException {

        ArrayList<String> playerOneHandArr = createCardArray(inputLine, PLAYER_ONE_BEGIN, PLAYER_ONE_END);
        ArrayList<String> playerTwoHandArr = createCardArray(inputLine, PLAYER_TWO_BEGIN, PLAYER_TWO_END);

        Hand playerOneHand = new Hand();
        Hand playerTwoHand = new Hand();

        playerOneHand.buildHand(playerOneHandArr);
        playerTwoHand.buildHand(playerTwoHandArr);

        System.out.println(playerOneHand.cardsInHand.toString());
        System.out.println(playerTwoHand.cardsInHand.toString());

        Player playerOne = new Player("playerOne", playerOneHand, ZER0, playerOneCount);
        Player playerTwo = new Player("playerTwo", playerTwoHand, ZER0, playerTwoCount);

        game(playerOne, playerOneHand, playerTwo, playerTwoHand);
    }

}
