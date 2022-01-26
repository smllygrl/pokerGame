package com.notleh.entities;

import com.notleh.enums.EnumHandScores;

public class Player {

    String name;
    Hand cardsInHand;
    EnumHandScores currentScore;

    public Player(String name, Hand cardsInHand, EnumHandScores currentScore)
    {
        this.name = name;
        this.cardsInHand = cardsInHand;
        this.currentScore = currentScore;
    }

    public void setCurrentScore(EnumHandScores currentScore) {
        this.currentScore = currentScore;
    }

    public EnumHandScores getCurrentScore() {
        return currentScore;
    }


}

