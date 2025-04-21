package com.pluralsight;

import java.util.Random;
import java.util.Scanner;

public class FamousQuotes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        String[] quotes = {
                "Be yourself; everyone else is already taken. – Oscar Wilde",

                "In the middle of difficulty lies opportunity. – Albert Einstein",

                "Happiness depends upon ourselves. – Aristotle",

                "Do what you can, with what you have, where you are. – Theodore Roosevelt",

                "Turn your wounds into wisdom. – Oprah Winfrey",

                "Simplicity is the ultimate sophistication. – Leonardo da Vinci",

                "Let your smile change the world.– Unknown",

                "What we think, we become. – Buddha",

                "Act as if what you do makes a difference. It does. – William James:",

                "Dream big. Start small. Act now. – Robin Sharma"
        };

        boolean continueProgram = true;

        while (continueProgram) {
            System.out.println("\nEnter a number between 1 and 10");
            String input = scanner.nextLine();
            int choice = Integer.parseInt(input);

            if (choice >= 1 && choice <= 10) {
                System.out.println("Quote: " + quotes[choice - 1]);
            } else {
                System.out.println("Invalid");
            }
            System.out.println("\nwould you want anoither quote? (yes/no):");
            String answer = scanner.nextLine().trim().toLowerCase();
            if (!answer.equals("yes")) {
                continueProgram = false;
            }
        }

        scanner.close();

    }
}
