package com.notleh.entities;

import com.notleh.enums.EnumHandScores;

import java.util.ArrayList;

public class Player {

    String name;
    Hand cardsInHand;
    EnumHandScores currentScore;
    Integer winCount;

    public Player(String name, Hand cardsInHand, EnumHandScores currentScore, Integer winCount)
    {
        this.name = name;
        this.cardsInHand = cardsInHand;
        this.currentScore = currentScore;
        this.winCount = winCount;
    }

    public void setCurrentScore(EnumHandScores currentScore) {
        this.currentScore = currentScore;
    }
}

