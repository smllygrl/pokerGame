package com.notleh.entities;

import com.notleh.services.InputSeperateSort;

import java.util.ArrayList;
import java.util.List;

public class Hand {

    static int HAND_SIZE = 5;

    public ArrayList<Card> cardsInHand = null;

    public void buildHand(InputSeperateSort cardArrValue)
    {
        System.out.println("Building hand");
        for (int i = 0; i < HAND_SIZE; i++) {
            cardsInHand.add(new Card(cardArrValue));
        }
        System.out.println(cardsInHand);

    }

    public List<Card> getHand()
    {
        return cardsInHand;
    }

}


