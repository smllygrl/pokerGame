package com.notleh.entities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Hand {

    static int HAND_SIZE = 5;

    public ArrayList<Card> cardsInHand = new ArrayList<>(HAND_SIZE);

    public void buildHand(ArrayList<String> cardArrValue)
    {
        System.out.println("Building hand");
        for (int i = 0; i < HAND_SIZE; i++) {
            cardsInHand.add(new Card(cardArrValue));
        }
    }

}


