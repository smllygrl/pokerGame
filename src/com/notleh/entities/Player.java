package com.notleh.entities;

import java.util.ArrayList;

public class Player {

    String name;
    ArrayList<Card> hand;
    Integer currentScore;
    Integer winCount;

    public Player(String name, ArrayList<Card> hand, Integer currentScore, Integer winCount)
    {
        this.name = name;
        this.hand = hand;
        this.currentScore = currentScore;
        this.winCount = winCount;
    }

    public Player() {

    }
}
