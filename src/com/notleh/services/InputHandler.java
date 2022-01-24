package com.notleh.services;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static com.notleh.services.ValidateHand.validateHand;

public class InputHandler {

    public static String handleInput () throws FileNotFoundException {

        String inputHandString = null;
        Scanner sc = new Scanner(new File("/Users/NLH/Desktop/poker-hands.txt"));

        System.out.println("Input 10 card values + ENTER (eg. AH 9S 4D TD 8S 4H JS 3C TC 8D)");

        if (sc.nextLine() == null) {
            System.out.println("Manual input now required");
            Scanner manualInput = new Scanner(System.in);
            String inputHandString = manualInput.nextLine();
//            validateHand(manualInputString);
        } else {
            String inputHandString = sc.nextLine();
//            validateHand(inputHandString);
        }

        return inputHandString;

    }
}
