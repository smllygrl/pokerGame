package com.notleh.entities;

import com.notleh.enums.EnumHandScores;

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

    public EnumHandScores getCurrentScore() {
        return currentScore;
    }

    public void setWinCount(Integer winCount)
    {
        this.winCount = winCount;
    }

    public Integer getWinCount(Player currentPlayer) {
        return winCount;
    }
}

