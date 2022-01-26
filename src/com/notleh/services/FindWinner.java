//package com.notleh.services;
//
//import com.notleh.entities.Hand;
//import com.notleh.entities.Player;
//
//import com.notleh.enums.EnumHandScores;
//
//import java.io.FileNotFoundException;
//import java.util.Objects;
//import java.util.Scanner;
////
////import static com.notleh.services.Game.playAgain;
//import static com.notleh.services.SolveDraw.solveDraw;
//
//public class FindWinner {
//
//    public static Integer findWinner(Player playerOne, Player playerTwo, Hand playerOneHand, Hand playerTwoHand) {
//        int playerOneFinalScore = playerOne.getCurrentScore().getScore();
//        int playerTwoFinalScore = playerTwo.getCurrentScore().getScore();
//
//        int returnWinner = 0;
//
//        if (playerOneFinalScore != playerTwoFinalScore)
//        {
//            if (playerOneFinalScore > playerTwoFinalScore)
//            {
//                returnWinner = 1;
//
//            } else {
//                returnWinner = 2;
//            }
//
//        } else {
//
//        }
//
//        return returnWinner;
//
//    }
//}
