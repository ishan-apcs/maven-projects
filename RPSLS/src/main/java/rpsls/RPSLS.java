package rpsls;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author ishanmadan
 */
public class RPSLS {
    static int userScore = 0;
    static int computerScore = 0;
    
    public static void main(String[] args) throws InterruptedException {
        Scanner input = new Scanner(System.in);
        
        System.out.println("Hi there! Welcome to Rock, Paper, Scissors...Lizard, Spock!");
        
        boolean keepPlaying = true;
        
        while (keepPlaying) {
            System.out.println("Do you want to play normal Rock Paper Scissors (reply RPS), Rock Paper Scissors Lizard Spock "
                    + "(reply RPSLS), or Rock Paper Scissors 101 (reply RPS101)?");
            String versionChoice = input.nextLine().toLowerCase().replaceAll("[^rpsls101]", "");
            
            while (!(versionChoice.equals("rps") || versionChoice.equals("rpsls") || versionChoice.equals("rps101"))) {
                System.out.println("I'm sorry, that's not a valid answer. Do you want to play normal Rock Paper Scissors (reply RPS),"
                        + " Rock Paper Scissors Lizard Spock (reply RPSLS), or Rock Paper Scissors 101 (reply RPS101)?");
                versionChoice = input.nextLine().toLowerCase().replaceAll("[^rpsls101]", "");
            }
            
            String userChoice = "";
            String computerChoice = "";
            
            if (versionChoice.equals("rps101")) {
                userChoice = rps101Choice(input);
                computerChoice = rps101ComputerChoice();
                
                if (userChoice.equals("exit")) {
                    System.out.println("Bye!");
                    keepPlaying = false;
                } else {
                    Map<String, Integer> choiceValues = rps101MapChoices();
                    int userInt = (int)choiceValues.get(userChoice);
                    int computerInt = (int)choiceValues.get(computerChoice);

                    System.out.println("I choose " + computerChoice + ".");
                    
                    if (userInt == computerInt) {
                        System.out.println("It's a tie!");
                    } else if (userInt > computerInt) {
                        if ((userInt - computerInt) > 50) {
                            userScore++;
                            System.out.println("You win!");
                        } else {
                            computerScore++;
                            System.out.println("You lose!");
                        }
                    } else if (userInt < computerInt) {
                        if ((computerInt - userInt) > 50) {
                            computerScore++;
                            System.out.println("You lose!");
                        } else {
                            userScore++;
                            System.out.println("You win!");
                        }
                    }
                    
                    System.out.println();

                    System.out.print("Score: you " + userScore + ", me "+ computerScore + ". ");
                    if (userScore > computerScore) {
                        System.out.print("You're winning!");
                    } else if (userScore < computerScore) {
                        System.out.print("I'm winning!");
                    } else {
                        System.out.print("We're tied!");
                    }

                    System.out.println();

                    // wait
                    TimeUnit.MILLISECONDS.sleep(500);
                    System.out.println("\nLet's play again!");
                }
            } else {
                if (versionChoice.equals("rpsls")) {
                    userChoice = rpslsChoice(input);
                    computerChoice = rpslsComputerChoice();
                } else if (versionChoice.equals("rps")) {
                    userChoice = rpsChoice(input);
                    computerChoice = rpsComputerChoice();
                }

                if (userChoice.equals("exit")) {
                    System.out.println("Bye!");
                    keepPlaying = false;
                } else {
                    Map<String, Integer> choiceValues = new HashMap<String, Integer>();
                    choiceValues.put("rock", 0);
                    choiceValues.put("paper", 1);
                    choiceValues.put("scissors", 2);
                    choiceValues.put("spock", 3);
                    choiceValues.put("lizard", 4);


                    int userInt = (int)choiceValues.get(userChoice);
                    int computerInt = (int)choiceValues.get(computerChoice);

                    System.out.println("I choose " + computerChoice + ".");
                    String victory = victoryCheck(computerInt, userInt);
                    System.out.println(victory);

                    System.out.println();

                    System.out.print("Score: you " + userScore + ", me "+ computerScore + ". ");
                    if (userScore > computerScore) {
                        System.out.print("You're winning!");
                    } else if (userScore < computerScore) {
                        System.out.print("I'm winning!");
                    } else {
                        System.out.print("We're tied!");
                    }

                    System.out.println();

                    // wait
                    TimeUnit.MILLISECONDS.sleep(500);
                    System.out.println("\nLet's play again!");
                }
            }
        }
    }
    
    public static String rpslsChoice(Scanner input) throws InterruptedException {
        // wait
        TimeUnit.MILLISECONDS.sleep(500);
        System.out.println("Rock...");
        // wait
        TimeUnit.MILLISECONDS.sleep(500);
        System.out.println("Paper...");
        // wait
        TimeUnit.MILLISECONDS.sleep(500);
        System.out.println("Scissors...");
        // wait
        TimeUnit.MILLISECONDS.sleep(500);
        System.out.println("Lizard...");
        // wait
        TimeUnit.MILLISECONDS.sleep(500);
        System.out.println("Spock...");
        // wait
        TimeUnit.MILLISECONDS.sleep(500);
        System.out.println("Shoot! (Reply with your choice, or exit to exit)");
        String userChoice = input.nextLine().toLowerCase().replaceAll("[^rockpapesilzdxt]", "");

        while (!(userChoice.equals("rock") || 
                userChoice.equals("paper") || 
                userChoice.equals("scissors") || 
                userChoice.equals("lizard") || 
                userChoice.equals("spock") || 
                userChoice.equals("exit"))) {
            System.out.println("I'm sorry, but that wasn't a recognized choice. Try again?\nRock...");
            // wait
            TimeUnit.MILLISECONDS.sleep(500);
            System.out.println("Paper...");
            // wait
            TimeUnit.MILLISECONDS.sleep(500);
            System.out.println("Scissors...");
            // wait
            TimeUnit.MILLISECONDS.sleep(500);
            System.out.println("Lizard...");
            // wait
            TimeUnit.MILLISECONDS.sleep(500);
            System.out.println("Spock...");
            // wait
            TimeUnit.MILLISECONDS.sleep(500);
            System.out.println("Shoot! (Reply with your choice, or exit to exit)");
            userChoice = input.nextLine().toLowerCase().replaceAll("[^rockpapersilzdxt]", "");
        }
        
        return userChoice;
    }
    
    public static String rpsChoice(Scanner input) throws InterruptedException {
        // wait
        TimeUnit.MILLISECONDS.sleep(500);
        System.out.println("Rock...");
        // wait
        TimeUnit.MILLISECONDS.sleep(500);
        System.out.println("Paper...");
        // wait
        TimeUnit.MILLISECONDS.sleep(500);
        System.out.println("Scissors...");
        // wait
        TimeUnit.MILLISECONDS.sleep(500);
        System.out.println("Shoot! (Reply with your choice, or exit to exit)");
        String userChoice = input.nextLine().toLowerCase().replaceAll("[^rockpapesixt]", "");

        while (!(userChoice.equals("rock") || 
                userChoice.equals("paper") || 
                userChoice.equals("scissors") ||
                userChoice.equals("exit"))) {
            System.out.println("I'm sorry, but that wasn't a recognized choice. Try again?\nRock...");
            // wait
            TimeUnit.MILLISECONDS.sleep(500);
            System.out.println("Paper...");
            // wait
            TimeUnit.MILLISECONDS.sleep(500);
            System.out.println("Scissors...");
            // wait
            TimeUnit.MILLISECONDS.sleep(500);
            System.out.println("Shoot! (Reply with your choice, or exit to exit)");
            userChoice = input.nextLine().toLowerCase().replaceAll("[^rockpapersixt]", "");
        }
        
        return userChoice;
    }
    
    public static String rps101Choice(Scanner input) throws InterruptedException {
        Map<String, Integer> mapChoices = rps101MapChoices();
        String[] choices = rps101Choices();
        
        System.out.println("Choices:");
        
        for (String item: choices) {
            System.out.println(item);
        }
        
        System.out.println("Etc, etc, etc, Shoot! (reply with your choice, or exit to exit)");
        String userChoice = input.nextLine().toLowerCase().replaceAll("[^abcdefghiklmnopqrstuvwy]", "");
        
        while(mapChoices.get(userChoice) == null) {
            System.out.println("I'm sorry, but that wasn't a recognized choice. Try again?");
            
            TimeUnit.MILLISECONDS.sleep(500);
            
            System.out.println("Etc, etc, etc, Shoot! (reply with your choice, or exit to exit)");
            userChoice = input.nextLine().toLowerCase().replaceAll("[^abcdefghiklmnopqrstuvwy]", "");
        }
        
        return userChoice;
    }
    
    public static String rpsComputerChoice() {
        String[] options = {"rock", "paper", "scissors"};
        double rand = Math.random();
        double doubleOptionIndex = options.length * rand;
        int optionIndex = (int)(doubleOptionIndex);
        return options[optionIndex];
    }
    
    public static String rpslsComputerChoice() {
        String[] options = {"rock", "paper", "scissors", "lizard", "spock"};
        double rand = Math.random();
        double doubleOptionIndex = options.length * rand;
        int optionIndex = (int)(doubleOptionIndex);
        return options[optionIndex];
    }
    
    public static String rps101ComputerChoice() {
        String[] options = rps101Choices();
        double rand = Math.random();
        double doubleOptionIndex = options.length * rand;
        int optionIndex = (int)(doubleOptionIndex);
        return options[optionIndex];
    }
    
    public static String victoryCheck(int computerInt, int userInt) {
        //user is first dimension, computer is second
        String[][] replyArray = {
            {"It's a tie!", 
            "You lose! Paper covers rock.", 
            "You win! Rock crushes scissors.", 
            "You lose! Spock vaporizes rock.", 
            "You win! Rock crushes lizard."},
            {"You win! Paper covers rock.",
            "It's a tie!",
            "You lose! Scissors cuts paper.",
            "You win! Paper disproves Spock.",
            "You lose! Lizard eats paper."},
            {"You lose! Rock crushes scissors.",
            "You win! Scissors cuts paper.",
            "It's a tie!",
            "You lose! Spock smashes scissors.",
            "You win! Scissors decapitates lizard."},
            {"You win! Spock vaporizes rock.",
            "You lose! Paper disproves Spock.",
            "You win! Spock smashes scissors.",
            "It's a tie!",
            "You lose! Lizard poisons Spock."},
            {"You lose! Rock crushes lizard.",
            "You win! Lizard eats paper.",
            "You lose! Scissors decapitates lizard.",
            "You win! Lizard poisons Spock.",
            "It's a tie!"}};
        if (userInt > 4 || userInt < 0 || computerInt > 4 || userInt < 0) {
            exit();
        }
        
        if (userInt > computerInt) {
            if (((userInt - computerInt) % 2) == 1) {
                userScore++;
            } else {
                computerScore++;
            }
        } else if (userInt < computerInt) {
            if (((computerInt - userInt) % 2) == 1) {
                computerScore++;
            } else {
                userScore++;
            }
        }
        
        return replyArray[userInt][computerInt];
    }
    
    public static Map<String, Integer> rps101MapChoices() {
        Map<String, Integer> choiceValues = new HashMap<String, Integer>();
        choiceValues.put("dynamite", 0);
        choiceValues.put("tornado", 1);
        choiceValues.put("quicksand", 2);
        choiceValues.put("pit", 3);
        choiceValues.put("chain", 4);
        choiceValues.put("gun", 5);
        choiceValues.put("law", 6);
        choiceValues.put("whip", 7);
        choiceValues.put("sword", 8);
        choiceValues.put("rock", 9);
        choiceValues.put("death", 10);
        choiceValues.put("wall", 11);
        choiceValues.put("sun", 12);
        choiceValues.put("camera", 13);
        choiceValues.put("fire", 14);
        choiceValues.put("chainsaw", 15);
        choiceValues.put("school", 16);
        choiceValues.put("scissors", 17);
        choiceValues.put("poison", 18);
        choiceValues.put("cage", 19);
        choiceValues.put("axe", 20);
        choiceValues.put("peace", 21);
        choiceValues.put("computer", 22);
        choiceValues.put("castle", 23);
        choiceValues.put("snake", 24);
        choiceValues.put("blood", 25);
        choiceValues.put("porcupine", 26);
        choiceValues.put("vulture", 27);
        choiceValues.put("monkey", 28);
        choiceValues.put("king", 29);
        choiceValues.put("queen", 30);
        choiceValues.put("prince", 31);
        choiceValues.put("princess", 32);
        choiceValues.put("police", 33);
        choiceValues.put("woman", 34);
        choiceValues.put("baby", 35);
        choiceValues.put("man", 36);
        choiceValues.put("home", 37);
        choiceValues.put("train", 38);
        choiceValues.put("car", 39);
        choiceValues.put("noise", 40);
        choiceValues.put("bicycle", 41);
        choiceValues.put("tree", 42);
        choiceValues.put("turnip", 43);
        choiceValues.put("duck", 44);
        choiceValues.put("wolf", 45);
        choiceValues.put("cat", 46);
        choiceValues.put("bird", 47);
        choiceValues.put("fish", 48);
        choiceValues.put("spider", 49);
        choiceValues.put("cockroach", 50);
        choiceValues.put("brain", 51);
        choiceValues.put("community", 52);
        choiceValues.put("cross", 53);
        choiceValues.put("money", 54);
        choiceValues.put("vampire", 55);
        choiceValues.put("sponge", 56);
        choiceValues.put("church", 57);
        choiceValues.put("butter", 58);
        choiceValues.put("book", 59);
        choiceValues.put("paper", 60);
        choiceValues.put("cloud", 61);
        choiceValues.put("airplane", 62);
        choiceValues.put("moon", 63);
        choiceValues.put("grass", 64);
        choiceValues.put("film", 65);
        choiceValues.put("toilet", 66);
        choiceValues.put("air", 67);
        choiceValues.put("planet", 68);
        choiceValues.put("guitar", 69);
        choiceValues.put("bowl", 70);
        choiceValues.put("cup", 71);
        choiceValues.put("beer", 72);
        choiceValues.put("rain", 73);
        choiceValues.put("water", 74);
        choiceValues.put("tv", 75);
        choiceValues.put("rainbow", 76);
        choiceValues.put("ufo", 77);
        choiceValues.put("alien", 78);
        choiceValues.put("prayer", 79);
        choiceValues.put("mountain", 80);
        choiceValues.put("satan", 81);
        choiceValues.put("dragon", 82);
        choiceValues.put("diamonds", 83);
        choiceValues.put("platinum", 84);
        choiceValues.put("gold", 85);
        choiceValues.put("devil", 86);
        choiceValues.put("fence", 87);
        choiceValues.put("videogame", 88);
        choiceValues.put("math", 89);
        choiceValues.put("robot", 90);
        choiceValues.put("heart", 91);
        choiceValues.put("electricity", 92);
        choiceValues.put("lightning", 93);
        choiceValues.put("medusa", 94);
        choiceValues.put("power", 95);
        choiceValues.put("laser", 96);
        choiceValues.put("nuke", 97);
        choiceValues.put("sky", 98);
        choiceValues.put("tank", 99);
        choiceValues.put("helicopter", 100);
        return choiceValues;
    }
    
    public static String[] rps101Choices() {
        String[] choices = {"dynamite", "tornado", "quicksand", "pit", "chain", "gun", "law", "whip", "sword", "rock", "death", "wall", "sun", "camera", "fire", "chainsaw", "school", "scissors", "poison", "cage", "axe", "peace", "computer", "castle", "snake", "blood", "porcupine", "vulture", "monkey", "king", "queen", "prince", "princess", "police", "woman", "baby", "man", "home", "train", "car", "noise", "bicycle", "tree", "turnip", "duck", "wolf", "cat", "bird", "fish", "spider", "cockroach", "brain", "community", "cross", "money", "vampire", "sponge", "church", "butter", "book", "paper", "cloud", "airplane", "moon", "grass", "film", "toilet", "air", "planet", "guitar", "bowl", "cup", "beer", "rain", "water", "tv", "rainbow", "ufo", "alien", "prayer", "mountain", "satan", "dragon", "diamonds", "platinum", "gold", "devil", "fence", "videogame", "math", "robot", "heart", "electricity", "lightning", "medusa", "power", "laser", "nuke", "sky", "tank", "helicopter"};
        return choices;
    }
    
    public static void exit() {
        System.out.println("I'm sorry, but it appears that I can't code. My sincerest apologies. You will now be redirected to the "
                + "afterlife. Goodbye!");
        System.exit(0);
    }
}