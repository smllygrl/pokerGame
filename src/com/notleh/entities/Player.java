package com.notleh.entities;

import java.util.ArrayList;

public class Player {

    String name;
    Hand cardsInHand;
    Integer currentScore;
    Integer winCount;

    public Player(String name, Hand cardsInHand, Integer currentScore, Integer winCount)
    {
        this.name = name;
        this.cardsInHand = cardsInHand;
        this.currentScore = currentScore;
        this.winCount = winCount;
    }

}

