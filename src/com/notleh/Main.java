package com.notleh;

//import com.notleh.entities.Player;
import com.notleh.entities.Card;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.println("Input 10 card values + ENTER (eg. AH 9S 4D TD 8S 4H JS 3C TC 8D)");
        String inputHandString = input.nextLine();
        validateHand(inputHandString);

    }

    public static boolean validateHand(String string) {

//        REGEX must ensure 1 space between each value or card assignment won't work

        Pattern pattern = Pattern.compile("([1-9TKQJA][DHSC]\\s?){10}");
        Matcher matcher = pattern.matcher(string);
        boolean validInput = matcher.find();
        if (validInput) {
            System.out.println("Valid input, cards being assigned");
            return true;
        } else {
            System.out.println("Invalid input. Please re-read input instructions and try again.");
            return false;
        }
    }
}

