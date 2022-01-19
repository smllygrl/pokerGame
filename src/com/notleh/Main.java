package com.notleh;

import com.notleh.entities.Hand;
import com.notleh.entities.Player;
import com.notleh.entities.Card;
import com.notleh.enums.EnumHandScores;
import com.notleh.services.Game;
import com.notleh.services.InputSeperateSort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

// Services

import static com.notleh.enums.EnumHandScores.START_SCORE;
import static com.notleh.services.Game.game;
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
        playerTwoHand.buildHand(playerTwoHandArr);
        System.out.println(playerOneHand.cardsInHand.toString());
        System.out.println(playerTwoHand.cardsInHand.toString());
        Player playerOne = new Player("playerOne", playerOneHand, START_SCORE, 0);
        Player playerTwo = new Player("playerTwo", playerTwoHand, START_SCORE, 0);

        Game game = new Game();
        game(playerOne, playerOneHand, playerTwo, playerTwoHand);
    }

}

