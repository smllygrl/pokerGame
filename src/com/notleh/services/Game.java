package com.notleh.services;

import com.notleh.entities.Hand;
import com.notleh.entities.Player;
import com.notleh.enums.EnumHandScores;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Objects;

import static com.notleh.enums.EnumHandScores.STRAIGHT;
import static com.notleh.enums.EnumHandScores.THREE_OF_KIND;
import static com.notleh.services.FindWinner.findWinner;
import static com.notleh.services.HandEvaluator.*;
import static com.notleh.services.InputHandler.handleInput;
import static com.notleh.services.InputSeperateSort.createCardArray;

public class Game {

    public static int PLAYER_ONE_BEGIN = 0;
    public static int PLAYER_ONE_END = 14;
    public static int PLAYER_TWO_BEGIN = 15;
    public static int PLAYER_TWO_END = 29;

    public static void game (Player playerOne, Hand playerOneHand, Player playerTwo, Hand playerTwoHand) throws FileNotFoundException {

        playGame(playerOne, playerOneHand);
        playGame(playerTwo, playerTwoHand);
        findWinner(playerOne, playerTwo, playerOneHand, playerTwoHand);
    }

    public static void playGame (Player player, Hand playerHand) {

        royalFlushTest(player, playerHand);

        if (player.getCurrentScore() != EnumHandScores.ROYAL_FLUSH) {

            straightFlushTest(player, playerHand);

            if (player.getCurrentScore() != EnumHandScores.STRAIGHT_FLUSH) {

                fourOfAKind(player, playerHand);

                if (player.getCurrentScore() != EnumHandScores.FOUR_OF_KIND) {

                    fullHouseTest(player, playerHand);

                    if (player.getCurrentScore() != EnumHandScores.FULL_HOUSE) {

                        flushTest(player, playerHand);

                        if (player.getCurrentScore() != EnumHandScores.FLUSH) {

                            straightTest(player, playerHand);

                            if (player.getCurrentScore() != STRAIGHT) {

                                threeOfAKind(player, playerHand);

                                if (player.getCurrentScore() != THREE_OF_KIND) {

                                    pairTest(player, playerHand);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public static void playAgain (Player playerOne, Player playerTwo) throws FileNotFoundException {

        String inputString = handleInput();

        ArrayList<String> playerOneHandArr = createCardArray(inputString, PLAYER_ONE_BEGIN, PLAYER_ONE_END);
        ArrayList<String> playerTwoHandArr = createCardArray(inputString, PLAYER_TWO_BEGIN, PLAYER_TWO_END);

        Hand playerOneNewHand = new Hand();
        Hand playerTwoNewHand = new Hand();

        playerOneNewHand.buildHand(playerOneHandArr);
        playerTwoNewHand.buildHand(playerTwoHandArr);

        game(playerOne, playerOneNewHand, playerTwo, playerTwoNewHand);
    }
}
