package com.notleh.services;

import com.notleh.entities.Hand;
import com.notleh.entities.Player;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import static com.notleh.enums.EnumHandScores.ZER0;
import static com.notleh.services.Game.game;
import static com.notleh.services.InputSeperateSort.createCardArray;
import static com.notleh.services.SolveDraw.solveDraw;

public class InitiateGame {

    public static int PLAYER_ONE_BEGIN = 0;
    public static int PLAYER_ONE_END = 14;
    public static int PLAYER_TWO_BEGIN = 15;
    public static int PLAYER_TWO_END = 29;

    public static Integer initiateGame (String inputLine) throws FileNotFoundException {

        int winner;

        ArrayList<String> playerOneHandArr = createCardArray(inputLine, PLAYER_ONE_BEGIN, PLAYER_ONE_END);
        ArrayList<String> playerTwoHandArr = createCardArray(inputLine, PLAYER_TWO_BEGIN, PLAYER_TWO_END);

        Hand playerOneHand = new Hand();
        Hand playerTwoHand = new Hand();

        playerOneHand.buildHand(playerOneHandArr);
        playerTwoHand.buildHand(playerTwoHandArr);

        Player playerOne = new Player("playerOne", playerOneHand, ZER0);
        Player playerTwo = new Player("playerTwo", playerTwoHand, ZER0);

        game(playerOne, playerOneHand, playerTwo, playerTwoHand);

        if (playerOne.getCurrentScore().getScore() == playerTwo.getCurrentScore().getScore()){
            solveDraw(playerOne, playerTwo, playerOneHand, playerTwoHand);
        }


        if (playerOne.getCurrentScore().getScore() > playerTwo.getCurrentScore().getScore()){
            winner = 1;
        } else winner = 2;


//        if (winner == 0) {
//            System.out.println("DEBUG INFO - Input: " + inputLine + ". P1 hand: " + playerOneHand.cardsInHand.toString() + ". P2 hand: " + playerTwoHand.cardsInHand.toString() + ".");
//            System.out.println("CONT - P1 score: " + playerOne.getCurrentScore().getScore() + ". P2 score: " + playerTwo.getCurrentScore().getScore());
//        }

        return winner;
    }


}
