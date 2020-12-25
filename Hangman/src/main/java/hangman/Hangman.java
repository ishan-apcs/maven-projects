package hangman;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Hangman {
    private Figure figure;
    private Words words;
    private Scanner input;
    
    private int stage;
    private String word;
    private ArrayList<String> usedLetters = new ArrayList<String>();
    private List<String> resultLetters = new ArrayList<String>();

    public Hangman(Figure figure, Words words, Scanner input) {
        this.figure = figure;
        this.words = words;
        this.input = input;
    }

    public void run() {
        stage = 0;
        word = words.getRandomWord();
        
        usedLetters.clear();
        resultLetters.clear();
        String[] wordLetters = word.split("");

        for (int i = 0; i < word.length(); i++) {
            resultLetters.add("_");
        }

        print();
        
        while (gameOver() == 0) {
            System.out.println("Guess a letter (or the word):");
            String guess = input.nextLine().toLowerCase().replaceAll("[^abcdefghijklmnopqrstuvwxyz]", "");
            
            while (guess.length() < 1 || usedLetters.indexOf(guess) != -1) {
                System.out.println("I'm sorry, that's not a valid guess. Please try again:");
                guess = input.nextLine().toLowerCase().replaceAll("[^abcdefghijklmnopqrstuvwxyz]", "");
            }

            if (word.equals(guess)) {
                resultLetters = Arrays.asList(guess.split(""));
            } else if (guess.length() > 1) {
                System.out.println("\nI'm sorry, that's not the word.");
                stage++;
                print();
            } else {
                usedLetters.add(guess);

                boolean correct = false;
                for (int i = 0; i < wordLetters.length; i++) {
                    if (wordLetters[i].equals(guess)) {
                        resultLetters.set(i, guess);
                        correct = true;
                    }
                }
    
                if (correct) {
                    System.out.println("\nThe letter " + guess + " is in the word!");
                } else {
                    System.out.println("\nOops! The letter " + guess + " is not in the word!");
                    stage++;
                }
    
                print();
            }
        }
        
        if (gameOver() == 1) {
            System.out.println("\nCongratulations! You've succeeded at Hangman!");
        } else if (gameOver() == 2) {
            System.out.println("\nYou lost! The word was " + word + ".");
        }
    }

    public int gameOver() {
        if (stage == figure.getNumStages() - 1) {
            return 2;
        }

        for (String letter : resultLetters) {
            if (letter.equals("_")) {
                return 0;
            }
        }

        return 1;
    }

    public void print() {
        System.out.println(figure.print(stage));
        
        System.out.println("\nWord:");
        for (String letter : resultLetters) {
            System.out.print(letter);
        }
        System.out.println("");

        boolean hasIncorrect = false;
        for (String letter : usedLetters) {
            if (resultLetters.indexOf(letter) == -1) {
                hasIncorrect = true;
            }
        }

        if (hasIncorrect) {
            System.out.println("\nIncorrect Letters:");
            for (String letter : usedLetters) {
                if (resultLetters.indexOf(letter) == -1) {
                    System.out.print(letter);
                }
            }
        }

        System.out.println("");
    }
}