package com.notleh;

import com.notleh.entities.Hand;
import com.notleh.entities.Player;
import com.notleh.entities.Card;
import com.notleh.enums.EnumHandScores;
import com.notleh.services.Game;
import com.notleh.services.InputSeperateSort;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

import static com.notleh.enums.EnumHandScores.ZER0;
import static com.notleh.services.Game.game;
//import static com.notleh.services.InputHandler.handleInput;
//import static com.notleh.services.ValidateHand.validateHand;
import static com.notleh.services.InputHandler.getInput;
import static com.notleh.services.InputHandler.handleInput;
import static com.notleh.services.InputSeperateSort.createCardArray;
import static com.notleh.services.PreparePlayers.preparePlayers;

public class Main {

    public static int PLAYER_ONE_BEGIN = 0;
    public static int PLAYER_ONE_END = 14;
    public static int PLAYER_TWO_BEGIN = 15;
    public static int PLAYER_TWO_END = 29;

    public static void main(String[] args) throws FileNotFoundException {

        int playerOneCount = 0;
        int playerTwoCount = 0;

        File file = new File("/Users/NLH/Desktop/poker-hands.txt");
        Scanner sc = new Scanner(file);

       while (sc.hasNext()) {
           String line = sc.nextLine();
           preparePlayers(line, "playerOne", "playerTwo", playerOneCount, playerTwoCount);
       }



//        String inputString = handleInput();

//       String line = handleInput();
//
//        ArrayList<String> playerOneHandArr = createCardArray(line, PLAYER_ONE_BEGIN, PLAYER_ONE_END);
//        ArrayList<String> playerTwoHandArr = createCardArray(line, PLAYER_TWO_BEGIN, PLAYER_TWO_END);
//
//        Hand playerOneHand = new Hand();
//        Hand playerTwoHand = new Hand();
//
//        playerOneHand.buildHand(playerOneHandArr);
//        playerTwoHand.buildHand(playerTwoHandArr);
//
//        System.out.println(playerOneHand.cardsInHand.toString());
//        System.out.println(playerTwoHand.cardsInHand.toString());
//
//        Player playerOne = new Player("playerOne", playerOneHand, ZER0, 0);
//        Player playerTwo = new Player("playerTwo", playerTwoHand, ZER0, 0);
//
//        Game game = new Game();
//        game(playerOne, playerOneHand, playerTwo, playerTwoHand);
    }

}

