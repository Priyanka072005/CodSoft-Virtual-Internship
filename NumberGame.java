package com.task;

import java.util.Random;
import java.util.Scanner;

public class NumberGame{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        int score = 0;

        System.out.println("Welcome to the Number Guessing Game!");

        String playAgain = "yes";

        while (playAgain.equalsIgnoreCase("yes")) {
            int number = rand.nextInt(100) + 1;
            int attempts = 3;
            boolean guessed = false;

            System.out.println("\nI have chosen a number between 1 and 100.");
            System.out.println("You have " + attempts + " attempts to guess it.");

            while (attempts > 0) {
                System.out.print("Enter your guess number : ");
                int guess = sc.nextInt();

                if (guess == number) {
                    System.out.println("Correct! You guessed it!");
                    score++;
                    guessed = true;
                    break;
                } 
                else if (guess < number) {
                    System.out.println("Too low!");
                } 
                else {
                    System.out.println("Too high!");
                }

                attempts--;
                System.out.println("Attempts left: " + attempts);
            }

            if (!guessed) {
                System.out.println("Sorry! The number was " + number);
            }

            System.out.println("Your score: " + score);

            System.out.print("Do you want to play again? (yes/no): ");
            playAgain = sc.next();
        }

        System.out.println("Thanks for playing! Final score: " + score);
        sc.close();
    }
}
