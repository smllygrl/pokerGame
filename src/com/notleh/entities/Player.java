package com.notleh.entities;

import java.util.ArrayList;

public class Player {

    String name;
    ArrayList<ArrayList<String>> hand;
    Integer currentScore;
    Integer winCount;

    public Player(String name, ArrayList<ArrayList<String>> hand, Integer currentScore, Integer winCount)
    {
        this.name = name;
        this.hand = hand;
        this.currentScore = currentScore;
        this.winCount = winCount;
    }

    public void sayScoreAndWins()
    {
        System.out.println(name + "got a score of : " + currentScore + " and has won this many games: " + winCount);
    }

}
