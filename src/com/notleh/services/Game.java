package com.notleh.services;

import com.notleh.entities.Hand;
import com.notleh.entities.Player;
import com.notleh.enums.EnumHandScores;


import java.io.FileNotFoundException;


import static com.notleh.enums.EnumHandScores.*;
import static com.notleh.services.HandEvaluator.*;

public class Game {

    public static int PLAYER_ONE_BEGIN = 0;
    public static int PLAYER_ONE_END = 14;
    public static int PLAYER_TWO_BEGIN = 15;
    public static int PLAYER_TWO_END = 29;

    public static void game (Player playerOne, Hand playerOneHand, Player playerTwo, Hand playerTwoHand) throws FileNotFoundException {
        playGame(playerOne, playerOneHand);
        playGame(playerTwo, playerTwoHand);
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

                            if (player.getCurrentScore() != EnumHandScores.STRAIGHT) {

                                threeOfAKind(player, playerHand);

                                if (player.getCurrentScore() != EnumHandScores.THREE_OF_KIND) {

                                    testForTwoPairs(player, playerHand);

                                    if (player.getCurrentScore() != EnumHandScores.TWO_PAIRS) {

                                        testForOnePair(player, playerHand);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
