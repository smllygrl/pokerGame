package com.notleh.services;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static com.notleh.services.ValidateHand.validateHand;

public class InputHandler {

    public static String getInput () throws FileNotFoundException {
        handleInput();
        return null;
    }

    public static String handleInput () throws FileNotFoundException {

        File file = new File("/Users/NLH/Desktop/poker-hands.txt");
        Scanner sc = new Scanner(file);
        String line = "";

        if (sc.hasNext()) {
            System.out.println("Running txt file");
            line = sc.nextLine();
            System.out.println(line);
        } else manualInput();


        return line;
    }

    public static String manualInput() {

        System.out.println("Manual input now required");
        Scanner manualInput = new Scanner(System.in);

        System.out.println("Input 10 card values + ENTER (eg. AH 9S 4D TD 8S 4H JS 3C TC 8D)");
        String manLine = manualInput.nextLine();

        validateHand(manLine);

        return manLine;

    }
}
