package com.notleh.services;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateHand {

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
