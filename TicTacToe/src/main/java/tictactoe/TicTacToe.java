package tictactoe;

import java.util.Scanner;

/**
 * @author ishanmadan
 */
public class TicTacToe {
    public static String[][] grid = {
        {" ", " ", " "},
        {" ", " ", " "},
        {" ", " ", " "}};

    public static int victory = 0; // 0 is no winner yet, 1 is X, 2 is O, 3 is tie
    public static Scanner input = new Scanner(System.in);
    public static String reply; // used to make intelUserChoice results global
    public static boolean a1, a2, a3, b1, b2, b3, c1, c2, c3; // to make writing compIntel easier, just holds value of user response

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        boolean run = true;

        System.out.print("Hello, and welcome to Tic-Tac-Toe! ");
        
        // Runs again and again while user still wants to play again
        while (run) {
            String gameMode;
            
            System.out.println("Do you want to play against another player, the computer in random mode, or the computer in intelligent mode? "
                + "Please reply with \"player\", \"random\", or \"intel\".");
            gameMode = input.nextLine().toLowerCase().replaceAll("[^playerndomit]", "");
            while (!(gameMode.equals("player") || gameMode.equals("random") || gameMode.equals("intel"))) {
                System.out.println("I'm sorry, that's not a valid option. Please reply with \"player\", \"random\", or \"intel\".");
                gameMode = input.nextLine().toLowerCase().replaceAll("[^playerndomit]", "");
            }
    
            System.out.println("This is the grid:");
            printGrid();
            System.out.println("To play, enter your selections from the grid using letter/number combos (like A1, B2, and C3) when "
                    + "prompted.");
    
            if (gameMode.equals("player")) {
                player();
            } else if (gameMode.equals("random")) {
                compRandom();
            } else if (gameMode.equals("intel")) {
                compIntel();
            } else {
                exit();
            }

            System.out.println("Do you want to play again?");
            String playAgain = input.nextLine().toLowerCase().replaceAll("[^yesno]", "");
            while (!(playAgain.equals("yes") || playAgain.equals("no"))) {
                System.out.println("I'm sorry, that's not a valid option. Please reply with either \"yes\" or \"no\".");
                playAgain = input.nextLine().toLowerCase().replaceAll("[^yesno]", "");
            }

            if (playAgain.equals("yes")) {
                run = true;
                resetGrid();
                printGrid();
            } else if (playAgain.equals("no")) {
                run = false;
            } else {
                exit();
            }
        }
    }

    // player vs player game mode, player x goes first (player o goes second)
    public static void player() {
        boolean valid;

        while (victory == 0) {
            System.out.println("Player X, enter your selection.");
            reply = input.nextLine().toLowerCase().replaceAll("[^abc123]", "");

            valid = false;

            while (!valid) {
                if (reply.equals("a1") && grid[0][0].equals(" ")) {
                    grid[0][0] = "X";
                    valid = true;
                    printGrid();
                } else if (reply.equals("a2") && grid[1][0].equals(" ")) {
                    grid[1][0] = "X";
                    valid = true;
                    printGrid();
                } else if (reply.equals("a3") && grid[2][0].equals(" ")) {
                    grid[2][0] = "X";
                    valid = true;
                    printGrid();
                } else if (reply.equals("b1") && grid[0][1].equals(" ")) {
                    grid[0][1] = "X";
                    valid = true;
                    printGrid();
                } else if (reply.equals("b2") && grid[1][1].equals(" ")) {
                    grid[1][1] = "X";
                    valid = true;
                    printGrid();
                } else if (reply.equals("b3") && grid[2][1].equals(" ")) {
                    grid[2][1] = "X";
                    valid = true;
                    printGrid();
                } else if (reply.equals("c1") && grid[0][2].equals(" ")) {
                    grid[0][2] = "X";
                    valid = true;
                    printGrid();
                } else if (reply.equals("c2") && grid[1][2].equals(" ")) {
                    grid[1][2] = "X";
                    valid = true;
                    printGrid();
                } else if (reply.equals("c3") && grid[2][2].equals(" ")) {
                    grid[2][2] = "X";
                    valid = true;
                    printGrid();
                } else {
                    valid = false;
                    System.out.println("I'm sorry, that's not a valid answer. Here's the grid, please try again:");
                    printGrid();
                    System.out.println("Player X, enter your selection.");
                    reply = input.nextLine().toLowerCase().replaceAll("[^abc123]", "");
                }
            }

            checkVictory();

            if (victory == 0) {
                System.out.println("Player O, enter your selection.");
                reply = input.nextLine().toLowerCase().replaceAll("[^abc123]", "");

                valid = false;

                while (!valid) {
                    if (reply.equals("a1") && grid[0][0].equals(" ")) {
                        grid[0][0] = "O";
                        valid = true;
                        printGrid();
                    } else if (reply.equals("a2") && grid[1][0].equals(" ")) {
                        grid[1][0] = "O";
                        valid = true;
                        printGrid();
                    } else if (reply.equals("a3") && grid[2][0].equals(" ")) {
                        grid[2][0] = "O";
                        valid = true;
                        printGrid();
                    } else if (reply.equals("b1") && grid[0][1].equals(" ")) {
                        grid[0][1] = "O";
                        valid = true;
                        printGrid();
                    } else if (reply.equals("b2") && grid[1][1].equals(" ")) {
                        grid[1][1] = "O";
                        valid = true;
                        printGrid();
                    } else if (reply.equals("b3") && grid[2][1].equals(" ")) {
                        grid[2][1] = "O";
                        valid = true;
                        printGrid();
                    } else if (reply.equals("c1") && grid[0][2].equals(" ")) {
                        grid[0][2] = "O";
                        valid = true;
                        printGrid();
                    } else if (reply.equals("c2") && grid[1][2].equals(" ")) {
                        grid[1][2] = "O";
                        valid = true;
                        printGrid();
                    } else if (reply.equals("c3") && grid[2][2].equals(" ")) {
                        grid[2][2] = "O";
                        valid = true;
                        printGrid();
                    } else {
                        valid = false;
                        System.out.println("I'm sorry, that's not a valid answer. Here's the grid, please try again:");
                        printGrid();
                        System.out.println("Player O, enter your selection.");
                        reply = input.nextLine().toLowerCase().replaceAll("[^abc123]", "");
                    }
                }
            }

            checkVictory();
        }

        if (victory == 1) {
            System.out.println("Congratulations! Player X has won!");
        } else if (victory == 2) {
            System.out.println("Congratulations! Player O has won!");
        } else if (victory == 3) {
            System.out.println("It's a tie!");
        } else {
            exit();
        }

    }

    // check whether either player has won (used by player vs player and compRandom)
    public static void checkVictory() {
        String a1 = grid[0][0];
        String a2 = grid[1][0];
        String a3 = grid[2][0];

        String b1 = grid[0][1];
        String b2 = grid[1][1];
        String b3 = grid[2][1];

        String c1 = grid[0][2];
        String c2 = grid[1][2];
        String c3 = grid[2][2];

        if (a1.equals(a2) && a2.equals(a3)) {
            if (a1.equals("X")) {
                victory = 1;
            } else if (a1.equals("O")) {
                victory = 2;
            }
        } else if (b1.equals(b2) && b2.equals(b3)) {
            if (b1.equals("X")) {
                victory = 1;
            } else if (b1.equals("O")) {
                victory = 2;
            }
        } else if (c1.equals(c2) && c2.equals(c3)) {
            if (c1.equals("X")) {
                victory = 1;
            } else if (c1.equals("O")) {
                victory = 2;
            }
        } else if (a1.equals(b1) && b1.equals(c1)) {
            if (a1.equals("X")) {
                victory = 1;
            } else if (a1.equals("O")) {
                victory = 2;
            }
        } else if (a2.equals(b2) && b2.equals(c2)) {
            if (a2.equals("X")) {
                victory = 1;
            } else if (a2.equals("O")) {
                victory = 2;
            }
        } else if (a3.equals(b3) && b3.equals(c3)) {
            if (a3.equals("X")) {
                victory = 1;
            } else if (a3.equals("O")) {
                victory = 2;
            }
        } else if (a1.equals(b2) && b2.equals(c3)) {
            if (a1.equals("X")) {
                victory = 1;
            } else if (a1.equals("O")) {
                victory = 2;
            }
        } else if (a3.equals(b2) && b2.equals(c1)) {
            if (a3.equals("X")) {
                victory = 1;
            } else if (a3.equals("O")) {
                victory = 2;
            }
        }

        int fillCount = 0;

        for (String[] array : grid) {
            for (String element : array) {
                if (!element.equals(" ")) {
                    fillCount++;
                }
            }
        }

        if (fillCount == 9) {
            victory = 3;
        }
    }

    // random mode, user has the choice of whether they want to play first or not, comp uses Math.random() to play
    public static void compRandom() {
        String userReply;
        String firstReply;
        boolean valid;

        int rand1;
        int rand2;

        System.out.println("Do you want to go first?");

        firstReply = input.nextLine().toLowerCase().replaceAll("[^yesno]", "");

        while (!(firstReply.equals("yes") || firstReply.equals("no"))) {
            System.out.println("I'm sorry, that's not a valid reply. Do you want to go first? Please answer \"yes\" or \"no\"");
            firstReply = input.nextLine().toLowerCase().replaceAll("[^yesno]", "");
        }

        if (firstReply.equals("yes")) {
            while (victory == 0) {
                System.out.println("Enter your selection.");
                userReply = input.nextLine().toLowerCase().replaceAll("[^abc123]", "");

                valid = false;

                while (!valid) {
                    if (userReply.equals("a1") && grid[0][0].equals(" ")) {
                        grid[0][0] = "X";
                        valid = true;
                        printGrid();
                    } else if (userReply.equals("a2") && grid[1][0].equals(" ")) {
                        grid[1][0] = "X";
                        valid = true;
                        printGrid();
                    } else if (userReply.equals("a3") && grid[2][0].equals(" ")) {
                        grid[2][0] = "X";
                        valid = true;
                        printGrid();
                    } else if (userReply.equals("b1") && grid[0][1].equals(" ")) {
                        grid[0][1] = "X";
                        valid = true;
                        printGrid();
                    } else if (userReply.equals("b2") && grid[1][1].equals(" ")) {
                        grid[1][1] = "X";
                        valid = true;
                        printGrid();
                    } else if (userReply.equals("b3") && grid[2][1].equals(" ")) {
                        grid[2][1] = "X";
                        valid = true;
                        printGrid();
                    } else if (userReply.equals("c1") && grid[0][2].equals(" ")) {
                        grid[0][2] = "X";
                        valid = true;
                        printGrid();
                    } else if (userReply.equals("c2") && grid[1][2].equals(" ")) {
                        grid[1][2] = "X";
                        valid = true;
                        printGrid();
                    } else if (userReply.equals("c3") && grid[2][2].equals(" ")) {
                        grid[2][2] = "X";
                        valid = true;
                        printGrid();
                    } else {
                        valid = false;
                        System.out.println("I'm sorry, that's not a valid answer. Here's the grid, please try again:");
                        printGrid();
                        System.out.println("Enter your selection.");
                        userReply = input.nextLine().toLowerCase().replaceAll("[^abc123]", "");
                    }
                }

                checkVictory();

                if (victory == 0) {
                    rand1 = (int)(Math.random() * 3);
                    rand2 = (int)(Math.random() * 3);

                    while (grid[rand1][rand2] != " ") {
                        rand1 = (int)(Math.random() * 3);
                        rand2 = (int)(Math.random() * 3);
                    }

                    grid[rand1][rand2] = "O";

                    System.out.println("The computer played:");
                    printGrid();
                }

                checkVictory();
            }

            if (victory == 1) {
                System.out.println("Congratulations! You win!");
            } else if (victory == 2) {
                System.out.println("I win!");
            } else if (victory == 3) {
                System.out.println("It's a tie!");
            } else {
                exit();
            }
        } else if (firstReply.equals("no")) {
            while (victory == 0) {
                rand1 = (int)(Math.random() * 3);
                rand2 = (int)(Math.random() * 3);

                while (grid[rand1][rand2] != " ") {
                    rand1 = (int)(Math.random() * 3);
                    rand2 = (int)(Math.random() * 3);
                }

                grid[rand1][rand2] = "X";

                System.out.println("The computer played:");
                printGrid();

                checkVictory();

                if (victory == 0) {
                    System.out.println("Enter your selection.");
                    userReply = input.nextLine().toLowerCase().replaceAll("[^abc123]", "");

                    valid = false;

                    while (!valid) {
                        if (userReply.equals("a1") && grid[0][0].equals(" ")) {
                            grid[0][0] = "O";
                            valid = true;
                            printGrid();
                        } else if (userReply.equals("a2") && grid[1][0].equals(" ")) {
                            grid[1][0] = "O";
                            valid = true;
                            printGrid();
                        } else if (userReply.equals("a3") && grid[2][0].equals(" ")) {
                            grid[2][0] = "O";
                            valid = true;
                            printGrid();
                        } else if (userReply.equals("b1") && grid[0][1].equals(" ")) {
                            grid[0][1] = "O";
                            valid = true;
                            printGrid();
                        } else if (userReply.equals("b2") && grid[1][1].equals(" ")) {
                            grid[1][1] = "O";
                            valid = true;
                            printGrid();
                        } else if (userReply.equals("b3") && grid[2][1].equals(" ")) {
                            grid[2][1] = "O";
                            valid = true;
                            printGrid();
                        } else if (userReply.equals("c1") && grid[0][2].equals(" ")) {
                            grid[0][2] = "O";
                            valid = true;
                            printGrid();
                        } else if (userReply.equals("c2") && grid[1][2].equals(" ")) {
                            grid[1][2] = "O";
                            valid = true;
                            printGrid();
                        } else if (userReply.equals("c3") && grid[2][2].equals(" ")) {
                            grid[2][2] = "O";
                            valid = true;
                            printGrid();
                        } else {
                            valid = false;
                            System.out.println("I'm sorry, that's not a valid answer. Here's the grid, please try again:");
                            printGrid();
                            System.out.println("Enter your selection.");
                            userReply = input.nextLine().toLowerCase().replaceAll("[^abc123]", "");
                        }
                    }
                }

                checkVictory();
            }

            if (victory == 1) {
                System.out.println("I win!");
            } else if (victory == 2) {
                System.out.println("Congratulations! You win!");
            } else if (victory == 3) {
                System.out.println("It's a tie!");
            } else {
                exit();
            }
        } else {
            exit();
        }
    }

    // computer intelligent mode, crown jewel of this program, responsible for 2504 lines of code, took about 2 weeks
    // uses the chart at https://xkcd.com/832/ and way, way, waaay too many if statements
    // plays agains the user in order to always win or tie (it is impossible for the user to win against compIntel)
    public static void compIntel() {
        String firstReply;

        System.out.println("Do you want to go first?");

        firstReply = input.nextLine().toLowerCase().replaceAll("[^yesno]", "");

        while (!(firstReply.equals("yes") || firstReply.equals("no"))) {
            System.out.println("I'm sorry, that's not a valid reply. Do you want to go first? Please answer \"yes\" or \"no\"");
            firstReply = input.nextLine().toLowerCase().replaceAll("[^yesno]", "");
        }

        if (firstReply.equals("no")) {
            grid[0][0] = "X";
            System.out.println("The computer played:");
            printGrid();
            intelPlayerChoiceO();

            if (a2) {
                grid[1][1] = "X";
                System.out.println("The computer played:");
                printGrid();
                intelPlayerChoiceO();

                if (a3 || b1 || b3 || c1 || c2) {
                    winX(2, 2);
                } else if (c3) {
                    grid[0][2] = "X";
                    System.out.println("The computer played:");
                    printGrid();
                    intelPlayerChoiceO();

                    if (a3 || b3 || c2) {
                        winX(0, 1);
                    } else if (b1) {
                        winX(2, 0);
                    }
                }
            } else if (a3) {
                grid[0][2] = "X";
                System.out.println("The computer played:");
                printGrid();
                intelPlayerChoiceO();

                if (a2 || b2 || b3 || c2 || c3) {
                    winX(0, 1);
                } else if (b1) {
                    grid[2][2] = "X";
                    System.out.println("The computer played:");
                    printGrid();
                    intelPlayerChoiceO();

                    if (a2 || b2 || b3) {
                        winX(1, 2);
                    } else if (c2) {
                        winX(1, 1);
                    }
                }
            } else if (b1) {
                grid[1][1] = "X";
                System.out.println("The computer played:");
                printGrid();
                intelPlayerChoiceO();

                if (a2 || a3 || b3 || c1 || c2) {
                    winX(2, 2);
                } else if (c3) {
                    grid[2][0] = "X";
                    System.out.println("The computer played:");
                    printGrid();
                    intelPlayerChoiceO();

                    if (b3 || c1 || c2) {
                        winX(1, 0);
                    } else if (a2) {
                        winX(0, 2);
                    }
                }
            } else if (b2) {
                grid[2][2] = "X";
                System.out.println("The computer played:");
                printGrid();
                intelPlayerChoiceO();

                if (a2) {
                    grid[1][2] = "X";
                    System.out.println("The computer played:");
                    printGrid();
                    intelPlayerChoiceO();

                    if (a2 || b1 || b3) {
                        winX(0, 2);
                    } else if (c1) {
                        grid[2][0] = "X";
                        System.out.println("The computer played:");
                        printGrid();
                        intelPlayerChoiceO();

                        if (b1) {
                            winX(2, 1);
                        } else if (b3) {
                            tieX(0, 1);
                        }
                    }
                } else if (a3) {
                    grid[0][2] = "X";
                    System.out.println("The computer played:");
                    printGrid();
                    intelPlayerChoiceO();

                    if (a2 || c2) {
                        winX(0, 1);
                    } else if (b1 || b3) {
                        winX(1, 2);
                    }
                } else if (b1) {
                    grid[0][1] = "X";
                    System.out.println("The computer played:");
                    printGrid();
                    intelPlayerChoiceO();

                    if (a2 || c1 || c2) {
                        winX(2, 1);
                    } else if (a3) {
                        grid[0][2] = "X";
                        System.out.println("The computer played:");
                        printGrid();
                        intelPlayerChoiceO();

                        if (a2) {
                            winX(1, 0);
                        } else if (c2) {
                            tieX(1, 2);
                        }
                    }
                } else if (b3) {
                    grid[0][1] = "X";
                    System.out.println("The computer played:");
                    printGrid();
                    intelPlayerChoiceO();

                    if (a2 || a3 || c2) {
                        winX(0, 2);
                    } else if (c1) {
                        grid[2][0] = "X";
                        System.out.println("The computer played:");
                        printGrid();
                        intelPlayerChoiceO();

                        if (a2) {
                            tieX(1, 2);
                        } else if (c2) {
                            winX(1, 0);
                        }
                    }
                } else if (c1) {
                    grid[2][0] = "X";
                    System.out.println("The computer played:");
                    printGrid();
                    intelPlayerChoiceO();

                    if (a2 || c2) {
                        winX(2, 1);
                    } else if (b1 || b3) {
                        winX(1, 0);
                    }
                } else if (c2) {
                    grid[1][0] = "X";
                    System.out.println("The computer played:");
                    printGrid();
                    intelPlayerChoiceO();

                    if (b1 || b3 || c1) {
                        winX(2, 0);
                    }
                }
            } else if (b3) {
                grid[1][1] = "X";
                System.out.println("The computer played:");
                printGrid();
                intelPlayerChoiceO();

                if (a2 || a3 || b1 || c1 || c2) {
                    winX(2, 2);
                } else if (c3) {
                    grid[2][0] = "X";
                    System.out.println("The computer played:");
                    printGrid();
                    intelPlayerChoiceO();

                    if (a2) {
                        winX(0, 2);
                    } else if (b1 || c1 || c2) {
                        winX(1, 0);
                    }
                }
            } else if (c1) {
                grid[2][0] = "X";
                System.out.println("The computer played:");
                printGrid();
                intelPlayerChoiceO();

                if (b1 || b2 || b3 || c2 || c3) {
                    winX(1, 0);
                } else if (a2) {
                    grid[2][2] = "X";
                    System.out.println("The computer played:");
                    printGrid();
                    intelPlayerChoiceO();

                    if (b1 || b2 || c2) {
                        winX(2, 1);
                    } else if (b3) {
                        winX(1, 1);
                    }
                }
            } else if (c2) {
                grid[1][1] = "X";
                System.out.println("The computer played:");
                printGrid();
                intelPlayerChoiceO();

                if (a2 || a3 || b1 || b3 || c1) {
                    grid[2][2] = "X";
                    System.out.println("The computer played:");
                    printGrid();
                } else if (c3) {
                    grid[0][2] = "X";
                    System.out.println("The computer played:");
                    printGrid();
                    intelPlayerChoiceO();

                    if (a2 || a3 || b3) {
                        winX(0, 1);
                    } else if (b1) {
                        winX(2, 0);
                    }
                }
            } else if (c3) {
                grid[0][2] = "X";
                System.out.println("The computer played:");
                printGrid();
                intelPlayerChoiceO();

                if (a2 || a3 || b2 || b3 || c2) {
                    winX(0, 1);
                } else if (b1) {
                    grid[2][0] = "X";
                    System.out.println("The computer played:");
                    printGrid();
                    intelPlayerChoiceO();

                    if (a2) {
                        winX(1, 1);
                    } else if (b2 || b3 || c2) {
                        winX(1, 0);
                    }
                }
            } else {
                exit();
            }
        } else if (firstReply.equals("yes")) {
            printGrid();
            intelPlayerChoiceX();
            
            if (a1) {
                grid[1][1] = "O";
                System.out.println("The computer played:");
                printGrid();
                intelPlayerChoiceX();

                if (a2) {
                    grid[2][0] = "O";
                    System.out.println("The computer played:");
                    printGrid();
                    intelPlayerChoiceX();

                    if (b1 || b3 || c2 || c3) {
                        winO(0, 2);
                    } else if (c1) {
                        grid[0][1] = "O";
                        System.out.println("The computer played:");
                        printGrid();
                        intelPlayerChoiceX();

                        if (b3 || c2) {
                            tieO(2, 2);
                        } else if (c3) {
                            tieO(1, 2);
                        }
                    }
                } else if (a3) {
                    grid[1][0] = "O";
                    System.out.println("The computer played:");
                    printGrid();
                    intelPlayerChoiceX();

                    if (b1 || b3 || c1 || c3) {
                        winO(1, 2);
                    } else if (c2) {
                        grid[0][1] = "O";
                        System.out.println("The computer played:");
                        printGrid();
                        intelPlayerChoiceX();

                        if (c1 || c3) {
                            winO(2, 1);
                        } else if (b3) {
                            tieO(2, 2);
                        }
                    }
                } else if (b1) {
                    grid[0][2] = "O";
                    System.out.println("The computer played:");
                    printGrid();
                    intelPlayerChoiceX();

                    if (a2 || b3 || c2 || c3) {
                        winO(2, 0);
                    } else if (a3) {
                        grid[1][0] = "O";
                        System.out.println("The computer played:");
                        printGrid();
                        intelPlayerChoiceX();

                        if (b3 || c2) {
                            tieO(2, 2);
                        } else if (c3) {
                            tieO(2, 1);
                        }
                    }
                } else if (b3) {
                    grid[2][2] = "O";
                    System.out.println("The computer played:");
                    printGrid();
                    intelPlayerChoiceX();

                    if (a2) {
                        grid[2][0] = "O";
                        System.out.println("The computer played:");
                        printGrid();
                        intelPlayerChoiceX();

                        if (b1 || c2) {
                            winO(0, 2);
                        } else if (c1) {
                            tieO(0, 1);
                        }
                    } else if (a3) {
                        grid[1][0] = "O";
                        System.out.println("The computer played:");
                        printGrid();
                        intelPlayerChoiceX();

                        if (b1 || c1) {
                            winO(1, 2);
                        } else if (c2) {
                            tieO(0, 1);
                        }
                    } else if (b1) {
                        grid[0][2] = "O";
                        System.out.println("The computer played:");
                        printGrid();
                        intelPlayerChoiceX();

                        if (a2 || c2) {
                            winO(2, 0);
                        } else if (a3) {
                            tieO(1, 0);
                        }
                    } else if (c1) {
                        grid[0][1] = "O";
                        System.out.println("The computer played:");
                        printGrid();
                        intelPlayerChoiceX();

                        if (a2 || c2) {
                            tieO(2, 0);
                        } else if (a3) {
                            tieO(1, 0);
                        }
                    } else if (c2) {
                        grid[0][2] = "O";
                        System.out.println("The computer played:");
                        printGrid();
                        intelPlayerChoiceX();

                        if (a2 || b1) {
                            winO(2, 0);
                        } else if (a3) {
                            winO(1, 0);
                        }
                    }
                } else if (c1) {
                    grid[0][1] = "O";
                    System.out.println("The computer played:");
                    printGrid();
                    intelPlayerChoiceX();

                    if (a2 || a3 || c2 || c3) {
                        winO(2, 1);
                    } else if (b3) {
                        grid[1][0] = "O";
                        System.out.println("The computer played:");
                        printGrid();
                        intelPlayerChoiceX();

                        if (a3 || c3) {
                            winO(1, 2);
                        } else if (c2) {
                            tieO(2, 2);
                        }
                    }
                } else if (c2) {
                    grid[2][2] = "O";
                    System.out.println("The computer played:");
                    printGrid();
                    intelPlayerChoiceX();

                    if (a2) {
                        grid[2][0] = "O";
                        System.out.println("The computer played:");
                        printGrid();
                        intelPlayerChoiceX();

                        if (b1 || b3) {
                            winO(0, 2);
                        } else if (c1) {
                            tieO(0, 1);
                        }
                    } else if (a3) {
                        grid[1][0] = "O";
                        System.out.println("The computer played:");
                        printGrid();
                        intelPlayerChoiceX();

                        if (b1 || b3) {
                            tieO(0, 2);
                        } else if (c1) {
                            tieO(0, 1);
                        }
                    } else if (b1) {
                        grid[0][2] = "O";
                        System.out.println("The computer played:");
                        printGrid();
                        intelPlayerChoiceX();

                        if (a2 || b3) {
                            winO(2, 0);
                        } else if (a3) {
                            tieO(1, 0);
                        }
                    } else if (b3) {
                        grid[2][0] = "O";
                        System.out.println("The computer played:");
                        printGrid();
                        intelPlayerChoiceX();

                        if (a2 || b1) {
                            winO(2, 0);
                        } else if (c1) {
                            tieO(0, 1);
                        }
                    } else if (c1) {
                        grid[0][1] = "O";
                        System.out.println("The computer played:");
                        printGrid();
                        intelPlayerChoiceX();

                        if (a2 || a3) {
                            winO(2, 1);
                        } else if (b3) {
                            tieO(1, 0);
                        }
                    }
                } else if (c3) {
                    grid[2][1] = "O";
                    System.out.println("The computer played:");
                    printGrid();
                    intelPlayerChoiceX();

                    if (a2 || a3 || c1 || c2) {
                        winO(0, 1);
                    } else if (b1) {
                        grid[0][2] = "O";
                        System.out.println("The computer played:");
                        printGrid();
                        intelPlayerChoiceX();

                        if (a2 || c2) {
                            winO(2, 0);
                        } else if (a3) {
                            tieO(1, 0);
                        }
                    }
                }
            } else if (a2) {
                grid[1][1] = "O";
                System.out.println("The computer played:");
                printGrid();
                intelPlayerChoiceX();

                if (a1) {
                    grid[2][0] = "O";
                    System.out.println("The computer played:");
                    printGrid();
                    intelPlayerChoiceX();

                    if (b1 || b3 || c2 || c3) {
                        winO(0, 2);
                    } else if (c1) {
                        grid[0][1] = "O";
                        System.out.println("The computer played:");
                        printGrid();
                        intelPlayerChoiceX();

                        if (c2 || c3) {
                            winO(2, 1);
                        } else if (b3) {
                            tieO(1, 2);
                        }
                    }
                } else if (a3) {
                    grid[0][0] = "O";
                    System.out.println("The computer played:");
                    printGrid();
                    intelPlayerChoiceX();

                    if (b1 || b3 || c1 || c2) {
                        winO(2, 2);
                    } else if (c3) {
                        grid[2][1] = "O";
                        System.out.println("The computer played:");
                        printGrid();
                        intelPlayerChoiceX();

                        if (c1 || c2) {
                            winO(0, 1);
                        } else if (b1) {
                            tieO(1, 2);
                        }
                    }
                } else if (b1) {
                    grid[0][0] = "O";
                    System.out.println("The computer played:");
                    printGrid();
                    intelPlayerChoiceX();

                    if (a3 || b3 || c1 || c2) {
                        winO(2, 2);
                    } else if (c3) {
                        grid[2][0] = "O";
                        System.out.println("The computer played:");
                        printGrid();
                        intelPlayerChoiceX();

                        if (b3 || c2) {
                            winO(0, 2);
                        } else if (c1) {
                            tieO(1, 2);
                        }
                    }
                } else if (b3) {
                    grid[2][0] = "O";
                    System.out.println("The computer played:");
                    printGrid();
                    intelPlayerChoiceX();

                    if (a1 || b1 || c2 || c3) {
                        winO(0, 2);
                    } else if (c3) {
                        grid[0][0] = "O";
                        System.out.println("The computer played:");
                        printGrid();
                        intelPlayerChoiceX();

                        if (b1 || c2) {
                            winO(2, 2);
                        } else if (c3) {
                            tieO(1, 2);
                        }
                    }
                } else if (c1) {
                    grid[2][0] = "O";
                    System.out.println("The computer played:");
                    printGrid();
                    intelPlayerChoiceX();

                    if (a1) {
                        grid[0][1] = "O";
                        System.out.println("The computer played:");
                        printGrid();
                        intelPlayerChoiceX();

                        if (c2 || c3) {
                            winO(2, 1);
                        } else if (b3) {
                            tieO(1, 2);
                        }
                    } else if (b1) {
                        grid[0][0] = "O";
                        System.out.println("The computer played:");
                        printGrid();
                        intelPlayerChoiceX();

                        if (b3 || c2) {
                            winO(2, 2);
                        } else if (c3) {
                            tieO(1, 2);
                        }
                    } else if (b3) {
                        grid[2][2] = "O";
                        System.out.println("The computer played:");
                        printGrid();
                        intelPlayerChoiceX();

                        if (b1 || c2) {
                            winO(0, 0);
                        } else if (a1) {
                            tieO(0, 1);
                        }
                    } else if (c2) {
                        grid[2][2] = "O";
                        System.out.println("The computer played:");
                        printGrid();
                        intelPlayerChoiceX();

                        if (a1 || b1) {
                            winO(2, 1);
                        } else if (b3) {
                            winO(0, 0);
                        }
                    } else if (c3) {
                        grid[1][2] = "O";
                        System.out.println("The computer played:");
                        printGrid();
                        intelPlayerChoiceX();

                        if (a1 || b3) {
                            tieO(0, 1);
                        } else if (b1) {
                            tieO(0, 0);
                        }
                    }
                } else if (c2) {
                    grid[0][1] = "O";
                    intelPlayerChoiceX();

                    if (a1 || a3 || c1 || c3) {
                        winO(2, 1);
                    } else if (b3) {
                        grid[0][2] = "O";
                        System.out.println("The computer played:");
                        printGrid();
                        intelPlayerChoiceX();

                        if (a1) {
                            winO(2, 0);
                        } else if (a3 || c3) {
                            winO(0, 0);
                        }
                    }
                } else if (c3) {
                    grid[0][0] = "O";
                    System.out.println("The computer played:");
                    printGrid();
                    intelPlayerChoiceX();

                    if (a3) {
                        grid[2][1] = "O";
                        System.out.println("The computer played:");
                        printGrid();
                        intelPlayerChoiceX();

                        if (c1 || c2) {
                            winO(0, 1);
                        } else if (b1) {
                            tieO(1, 2);
                        }
                    } else if (b1) {
                        grid[0][2] = "O";
                        System.out.println("The computer played:");
                        printGrid();
                        intelPlayerChoiceX();

                        if (a3) {
                            tieO(2, 1);
                        } else if (b3 || c2) {
                            winO(2, 0);
                        }
                    } else if (b3) {
                        grid[2][0] = "O";
                        System.out.println("The computer played:");
                        printGrid();
                        intelPlayerChoiceX();

                        if (b1 || c2) {
                            winO(0, 2);
                        } else if (c1) {
                            tieO(1, 2);
                        }
                    } else if (c1) {
                        grid[1][2] = "O";
                        System.out.println("The computer played:");
                        printGrid();
                        intelPlayerChoiceX();

                        if (a3 || b1) {
                            tieO(2, 1);
                        } else if (b3) {
                            tieO(2, 0);
                        }
                    } else if (c2) {
                        grid[0][2] = "O";
                        System.out.println("The computer played:");
                        printGrid();
                        intelPlayerChoiceX();

                        if (a3 || b3) {
                            winO(0, 1);
                        } else if (b1) {
                            winO(2, 0);
                        }
                    }
                }
            } else if (a3) {
                grid[1][1] = "O";
                System.out.println("The computer played:");
                printGrid();
                intelPlayerChoiceX();

                if (a1) {
                    grid[1][0] = "O";
                    System.out.println("The computer played:");
                    printGrid();
                    intelPlayerChoiceX();

                    if (b1 || b3 || c1 || c3) {
                        winO(1, 2);
                    } else if (c2) {
                        grid[2][1] = "O";
                        System.out.println("The computer played:");
                        printGrid();
                        intelPlayerChoiceX();

                        if (c1 || c3) {
                            winO(0, 1);
                        } else if (b1) {
                            tieO(0, 2);
                        }
                    }
                } else if (a2) {
                    grid[0][0] = "O";
                    System.out.println("The computer played:");
                    printGrid();
                    intelPlayerChoiceX();

                    if (b1 || b3 || c1 || c2) {
                        winO(2, 2);
                    } else if (c3) {
                        grid[2][1] = "O";
                        System.out.println("The computer played:");
                        printGrid();
                        intelPlayerChoiceX();
    
                        if (b1 || c2) {
                            tieO(0, 2);
                        } else if (c1) {
                            tieO(1, 2);
                        }
                    }
                } else if (b1) {
                    grid[0][2] = "O";
                    System.out.println("The computer played:");
                    printGrid();
                    intelPlayerChoiceX();

                    if (a1) {
                        grid[1][0] = "O";
                        System.out.println("The computer played:");
                        printGrid();
                        intelPlayerChoiceX();
    
                        if (b3 || c3) {
                            winO(1, 2);
                        } else if (c2) {
                            tieO(2, 1);
                        }
                    } else if (a2) {
                        grid[0][0] = "O";
                        System.out.println("The computer played:");
                        printGrid();
                        intelPlayerChoiceX();
    
                        if (b3 || c2) {
                            winO(2, 2);
                        } else if (c3) {
                            tieO(2, 1);
                        }
                    } else if (b3) {
                        grid[2][2] = "O";
                        System.out.println("The computer played:");
                        printGrid();
                        intelPlayerChoiceX();
    
                        if (a2 || c2) {
                            winO(0, 0);
                        } else if (a1) {
                            tieO(1, 0);
                        }
                    } else if (c2) {
                        grid[2][2] = "O";
                        System.out.println("The computer played:");
                        printGrid();
                        intelPlayerChoiceX();
    
                        if (a2 || b3) {
                            winO(0, 0);
                        } else if (a1) {
                            tieO(1, 0);
                        }
                    } else if (c3) {
                        grid[2][1] = "O";
                        System.out.println("The computer played:");
                        printGrid();
                        intelPlayerChoiceX();
    
                        if (a1) {
                            tieO(1, 0);
                        } else if (a2 || c2) {
                            tieO(0, 0);
                        }
                    }
                } else if (b3) {
                    grid[2][2] = "O";
                    System.out.println("The computer played:");
                    printGrid();
                    intelPlayerChoiceX();

                    if (a2 || b1 || c1 || c2) {
                        winO(0, 0);
                    } else if (a1) {
                        grid[1][0] = "O";
                        System.out.println("The computer played:");
                        printGrid();
                        intelPlayerChoiceX();
    
                        if (b1 || c2) {
                            tieO(0, 2);
                        } else if (c1) {
                            tieO(0, 1);
                        }
                    }
                } else if (c1) {
                    grid[1][2] = "O";
                    System.out.println("The computer played:");
                    printGrid();
                    intelPlayerChoiceX();

                    if (a1 || b1 || b3 || c3) {
                        winO(1, 0);
                    } else if (a2) {
                        grid[0][0] = "O";
                        System.out.println("The computer played:");
                        printGrid();
                        intelPlayerChoiceX();
    
                        if (b1 || b3) {
                            winO(2, 2);
                        } else if (c3) {
                            tieO(2, 1);
                        }
                    }
                } else if (c2) {
                    grid[0][2] = "O";
                    System.out.println("The computer played:");
                    printGrid();
                    intelPlayerChoiceX();

                    if (a1) {
                        grid[1][0] = "O";
                        System.out.println("The computer played:");
                        printGrid();
                        intelPlayerChoiceX();
    
                        if (b1 || b3) {
                            tieO(2, 2);
                        } else if (c3) {
                            tieO(2, 1);
                        }
                    } else if (a2) {
                        grid[0][0] = "O";
                        System.out.println("The computer played:");
                        printGrid();
                        intelPlayerChoiceX();
    
                        if (b1 || b3) {
                            winO(2, 2);
                        } else if (c3) {
                            tieO(2, 1);
                        }
                    } else if (b1) {
                        grid[0][0] = "O";
                        System.out.println("The computer played:");
                        printGrid();
                        intelPlayerChoiceX();
    
                        if (a2 || b3) {
                            winO(2, 2);
                        } else if (c3) {
                            tieO(2, 1);
                        }
                    } else if (b3) {
                        grid[2][2] = "O";
                        System.out.println("The computer played:");
                        printGrid();
                        intelPlayerChoiceX();
    
                        if (a1) {
                            tieO(1, 0);
                        } else if (a2 || b1) {
                            winO(0, 0);
                        }
                    } else if (c3) {
                        grid[2][1] = "O";
                        System.out.println("The computer played:");
                        printGrid();
                        intelPlayerChoiceX();
    
                        if (a1 || a2) {
                            winO(0, 1);
                        } else if (b1) {
                            tieO(1, 0);
                        }
                    }
                } else if (c3) {
                    grid[2][1] = "O";
                    System.out.println("The computer played:");
                    printGrid();
                    intelPlayerChoiceX();

                    if (a1 || a2 || c1 || c2) {
                        winO(0, 1);
                    } else if (b1) {
                        grid[1][0] = "O";
                        System.out.println("The computer played:");
                        printGrid();
                        intelPlayerChoiceX();
    
                        if (a1 || c1) {
                            winO(1, 2);
                        } else if (c2) {
                            tieO(0, 2);
                        }
                    }
                }
            } else if (b1) {
                grid[1][1] = "O";
                System.out.println("The computer played:");
                printGrid();
                intelPlayerChoiceX();

                if (a1) {
                    grid[0][2] = "O";
                    System.out.println("The computer played:");
                    printGrid();
                    intelPlayerChoiceX();

                    if (a2 || b3 || c2 || c3) {
                        winO(2, 0);
                    } else if (a3) {
                        grid[1][0] = "O";
                        System.out.println("The computer played:");
                        printGrid();
                        intelPlayerChoiceX();
    
                        if (b3 || c3) {
                            winO(1, 2);
                        } else if (c2) {
                            tieO(2, 1);
                        }
                    }
                } else if (a2) {
                    grid[0][0] = "O";
                    System.out.println("The computer played:");
                    printGrid();
                    intelPlayerChoiceX();

                    if (a3 || b3 || c1 || c2) {
                        winO(2, 2);
                    } else if (c3) {
                        grid[0][2] = "O";
                        System.out.println("The computer played:");
                        printGrid();
                        intelPlayerChoiceX();
    
                        if (a3) {
                            tieO(2, 1);
                        } else if (b3 || c2) {
                            winO(2, 0);
                        }
                    }
                } else if (a3) {
                    grid[0][2] = "O";
                    System.out.println("The computer played:");
                    printGrid();
                    intelPlayerChoiceX();

                    if (a1) {
                        grid[1][0] = "O";
                        System.out.println("The computer played:");
                        printGrid();
                        intelPlayerChoiceX();
    
                        if (b3 || c3) {
                            winO(1, 2);
                        } else if (c2) {
                            tieO(2, 1);
                        }
                    } else if (a2) {
                        grid[1][0] = "O";
                        System.out.println("The computer played:");
                        printGrid();
                        intelPlayerChoiceX();
    
                        if (b3 || c3) {
                            winO(1, 2);
                        } else if (c2) {
                            tieO(2, 1);
                        }
                    } else if (b3) {
                        grid[2][2] = "O";
                        System.out.println("The computer played:");
                        printGrid();
                        intelPlayerChoiceX();
    
                        if (a1 || a2) {
                            winO(1, 2);
                        } else if (c2) {
                            winO(0, 0);
                        }
                    } else if (c2) {
                        grid[2][2] = "O";
                        System.out.println("The computer played:");
                        printGrid();
                        intelPlayerChoiceX();
    
                        if (a1) {
                            tieO(1, 0);
                        } else if (a2 || b3) {
                            winO(0, 0);
                        }
                    } else if (c3) {
                        grid[2][1] = "O";
                        System.out.println("The computer played:");
                        printGrid();
                        intelPlayerChoiceX();
    
                        if (a1 || c2) {
                            tieO(1, 0);
                        } else if (a2) {
                            tieO(0, 0);
                        }
                    }
                } else if (b3) {
                    grid[1][2] = "O";
                    System.out.println("The computer played:");
                    printGrid();
                    intelPlayerChoiceX();

                    if (a1 || a3 || c1 || c3) {
                        winO(1, 0);
                    } else if (a2) {
                        grid[2][2] = "O";
                        System.out.println("The computer played:");
                        printGrid();
                        intelPlayerChoiceX();
    
                        if (a1 || a3) {
                            winO(0, 2);
                        } else if (c1) {
                            tieO(0, 0);
                        }
                    }
                } else if (c1) {
                    grid[0][0] = "O";
                    System.out.println("The computer played:");
                    printGrid();
                    intelPlayerChoiceX();

                    if (a2 || a3 || b3 || c2) {
                        winO(2, 2);
                    } else if (c3) {
                        grid[1][2] = "O";
                        System.out.println("The computer played:");
                        printGrid();
                        intelPlayerChoiceX();
    
                        if (a2) {
                            tieO(2, 1);
                        } else if (a3 || b3) {
                            winO(1, 0);
                        }
                    }
                } else if (c2) {
                    grid[0][2] = "O";
                    System.out.println("The computer played:");
                    printGrid();
                    intelPlayerChoiceX();

                    if (a1 || a2 || b3 || c3) {
                        winO(2, 0);
                    } else if (a3) {
                        grid[0][0] = "O";
                        System.out.println("The computer played:");
                        printGrid();
                        intelPlayerChoiceX();
    
                        if (a2 || b3) {
                            winO(2, 2);
                        } else if (c3) {
                            tieO(2, 1);
                        }
                    }
                } else if (c3) {
                    grid[0][0] = "O";
                    System.out.println("The computer played:");
                    printGrid();
                    intelPlayerChoiceX();

                    if (a2) {
                        grid[2][0] = "O";
                        System.out.println("The computer played:");
                        printGrid();
                        intelPlayerChoiceX();
    
                        if (b3 || c2) {
                            winO(0, 2);
                        } else if (c1) {
                            tieO(1, 2);
                        }
                    } else if (a3) {
                        grid[2][1] = "O";
                        System.out.println("The computer played:");
                        printGrid();
                        intelPlayerChoiceX();
    
                        if (a2 || c1) {
                            tieO(1, 2);
                        } else if (c2) {
                            tieO(0, 2);
                        }
                    } else if (b3) {
                        grid[2][0] = "O";
                        System.out.println("The computer played:");
                        printGrid();
                        intelPlayerChoiceX();
    
                        if (a2) {
                            winO(0, 2);
                        } else if (c1 || c2) {
                            winO(1, 0);
                        }
                    } else if (c1) {
                        grid[1][2] = "O";
                        System.out.println("The computer played:");
                        printGrid();
                        intelPlayerChoiceX();
    
                        if (a2) {
                            tieO(2, 1);
                        } else if (a3 || b3) {
                            winO(1, 0);
                        }
                    } else if (c2) {
                        grid[0][2] = "O";
                        System.out.println("The computer played:");
                        printGrid();
                        intelPlayerChoiceX();
    
                        if (a2 || b3) {
                            winO(2, 0);
                        } else if (a3) {
                            tieO(2, 1);
                        }
                    }
                }
            } else if (b2) {
                grid[0][0] = "O";
                System.out.println("The computer played:");
                printGrid();
                intelPlayerChoiceX();

                if (a2) {
                    grid[1][2] = "O";
                    System.out.println("The computer played:");
                    printGrid();
                    intelPlayerChoiceX();

                    if (a3) {
                        grid[0][2] = "O";
                        System.out.println("The computer played:");
                        printGrid();
                        intelPlayerChoiceX();
    
                        if (b1 || b3) {
                            winO(2, 2);
                        } else if (c3) {
                            winO(0, 1);
                        }
                    } else if (b1) {
                        grid[2][1] = "O";
                        System.out.println("The computer played:");
                        printGrid();
                        intelPlayerChoiceX();
    
                        if (a3 || c3) {
                            tieO(0, 2);
                        } else if (c1) {
                            tieO(2, 0);
                        }
                    } else if (b3) {
                        grid[0][1] = "O";
                        System.out.println("The computer played:");
                        printGrid();
                        intelPlayerChoiceX();
    
                        if (a3 || c3) {
                            winO(0, 2);
                        } else if (c1) {
                            tieO(2, 0);
                        }
                    } else if (c1) {
                        grid[2][0] = "O";
                        System.out.println("The computer played:");
                        printGrid();
                        intelPlayerChoiceX();
    
                        if (b1 || c3) {
                            tieO(2, 1);
                        } else if (b3) {
                            tieO(0, 1);
                        }
                    } else if (c3) {
                        grid[0][2] = "O";
                        System.out.println("The computer played:");
                        printGrid();
                        intelPlayerChoiceX();
    
                        if (a3 || b3) {
                            winO(0, 1);
                        } else if (b1) {
                            tieO(2, 1);
                        }
                    }
                } else if (a3) {
                    grid[0][2] = "O";
                    System.out.println("The computer played:");
                    printGrid();
                    intelPlayerChoiceX();

                    if (a2 || b3 || c2 || c3) {
                        winO(0, 1);
                    } else if (b1) {
                        grid[2][1] = "O";
                        System.out.println("The computer played:");
                        printGrid();
                        intelPlayerChoiceX();
    
                        if (a2 || c3) {
                            tieO(1, 2);
                        } else if (c2) {
                            tieO(1, 0);
                        }
                    }
                } else if (b1) {
                    grid[2][1] = "O";
                    System.out.println("The computer played:");
                    printGrid();
                    intelPlayerChoiceX();

                    if (a2) {
                        grid[1][2] = "O";
                        System.out.println("The computer played:");
                        printGrid();
                        intelPlayerChoiceX();
    
                        if (a3) {
                            tieO(0, 2);
                        } else if (c1 || c3) {
                            tieO(2, 0);
                        }
                    } else if (a3) {
                        grid[0][2] = "O";
                        System.out.println("The computer played:");
                        printGrid();
                        intelPlayerChoiceX();
    
                        if (a2 || c3) {
                            tieO(1, 2);
                        } else if (c2) {
                            tieO(1, 0);
                        }
                    } else if (c1) {
                        grid[2][0] = "O";
                        System.out.println("The computer played:");
                        printGrid();
                        intelPlayerChoiceX();
    
                        if (a2 || c2) {
                            winO(2, 2);
                        } else if (c3) {
                            winO(1, 0);
                        }
                    } else if (c2) {
                        grid[1][0] = "O";
                        System.out.println("The computer played:");
                        printGrid();
                        intelPlayerChoiceX();
    
                        if (a3) {
                            tieO(0, 2);
                        } else if (c1 || c3) {
                            winO(2, 0);
                        }
                    } else if (c3) {
                        grid[2][0] = "O";
                        System.out.println("The computer played:");
                        printGrid();
                        intelPlayerChoiceX();
    
                        if (a2) {
                            tieO(1, 2);
                        } else if (c1 || c3) {
                            winO(2, 0);
                        }
                    }
                } else if (b3) {
                    grid[0][1] = "O";
                    System.out.println("The computer played:");
                    printGrid();
                    intelPlayerChoiceX();

                    if (a2 || a3 || c2 || c3) {
                        winO(0, 2);
                    } else if (c1) {
                        grid[2][0] = "O";
                        System.out.println("The computer played:");
                        printGrid();
                        intelPlayerChoiceX();
    
                        if (a2) {
                            tieO(1, 2);
                        } else if (c2 || c3) {
                            winO(1, 0);
                        }
                    }
                } else if (c1) {
                    grid[2][0] = "O";
                    System.out.println("The computer played:");
                    printGrid();
                    intelPlayerChoiceX();

                    if (b1 || b3 || c2 || c3) {
                        winO(1, 0);
                    } else if (a2) {
                        grid[1][2] = "O";
                        System.out.println("The computer played:");
                        printGrid();
                        intelPlayerChoiceX();
    
                        if (b1 || c3) {
                            tieO(2, 1);
                        } else if (b3) {
                            tieO(0, 1);
                        }
                    }
                } else if (c2) {
                    grid[1][0] = "O";
                    System.out.println("The computer played:");
                    printGrid();
                    intelPlayerChoiceX();

                    if (b1 || b3 || c1 || c3) {
                        winO(2, 0);
                    } else if (a3) {
                        grid[0][2] = "O";
                        System.out.println("The computer played:");
                        printGrid();
                        intelPlayerChoiceX();
    
                        if (b1) {
                            tieO(2, 1);
                        } else if (b3 || c3) {
                            winO(0, 1);
                        }
                    }
                } else if (c3) {
                    grid[2][0] = "O";
                    System.out.println("The computer played:");
                    printGrid();
                    intelPlayerChoiceX();

                    if (b1 || b3 || c1 || c2) {
                        winO(1, 0);
                    } else if (a2) {
                        grid[1][2] = "O";
                        System.out.println("The computer played:");
                        printGrid();
                        intelPlayerChoiceX();
    
                        if (b1) {
                            tieO(2, 1);
                        } else if (b3 || c1) {
                            tieO(0, 1);
                        }
                    }
                }
            } else if (b3) {
                grid[1][1] = "O";
                System.out.println("The computer played:");
                printGrid();
                intelPlayerChoiceX();

                if (a1) {
                    grid[2][2] = "O";
                    System.out.println("The computer played:");
                    printGrid();
                    intelPlayerChoiceX();

                    if (a2) {
                        grid[2][0] = "O";
                        System.out.println("The computer played:");
                        printGrid();
                        intelPlayerChoiceX();
    
                        if (b1 || c2) {
                            winO(0, 2);
                        } else if (c1) {
                            tieO(0, 1);
                        }
                    } else if (a3) {
                        grid[1][0] = "O";
                        System.out.println("The computer played:");
                        printGrid();
                        intelPlayerChoiceX();
    
                        if (b1 || c1) {
                            winO(1, 2);
                        } else if (c2) {
                            tieO(0, 1);
                        }
                    } else if (b1) {
                        grid[0][2] = "O";
                        System.out.println("The computer played:");
                        printGrid();
                        intelPlayerChoiceX();
    
                        if (a2 || a3) {
                            winO(1, 2);
                        } else if (c2) {
                            winO(2, 0);
                        }
                    } else if (c1) {
                        grid[0][1] = "O";
                        System.out.println("The computer played:");
                        printGrid();
                        intelPlayerChoiceX();
    
                        if (a2) {
                            tieO(2, 0);
                        } else if (a3 || c2) {
                            tieO(1, 0);
                        }
                    } else if (c2) {
                        grid[0][2] = "O";
                        System.out.println("The computer played:");
                        printGrid();
                        intelPlayerChoiceX();
    
                        if (a2 || b1) {
                            winO(2, 0);
                        } else if (a3) {
                            tieO(1, 0);
                        }
                    }
                } else if (a2) {
                    grid[2][0] = "O";
                    System.out.println("The computer played:");
                    printGrid();
                    intelPlayerChoiceX();

                    if (a1 || b1 || c2 || c3) {
                        winO(0, 2);
                    } else if (c1) {
                        grid[2][2] = "O";
                        System.out.println("The computer played:");
                        printGrid();
                        intelPlayerChoiceX();
    
                        if (a1) {
                            tieO(0, 1);
                        } else if (b1 || c2) {
                            winO(0, 0);
                        }
                    }
                } else if (a3) {
                    grid[2][2] = "O";
                    System.out.println("The computer played:");
                    printGrid();
                    intelPlayerChoiceX();

                    if (a2 || b1 || c1 || c2) {
                        winO(0, 0);
                    } else if (a1) {
                        grid[1][0] = "O";
                        System.out.println("The computer played:");
                        printGrid();
                        intelPlayerChoiceX();
    
                        if (b1 || c1) {
                            winO(1, 2);
                        } else if (c2) {
                            tieO(0, 1);
                        }
                    }
                } else if (b1) {
                    grid[1][0] = "O";
                    System.out.println("The computer played:");
                    printGrid();
                    intelPlayerChoiceX();

                    if (a1 || a3 || c1 || c3) {
                        winO(1, 2);
                    } else if (c2) {
                        grid[0][0] = "O";
                        System.out.println("The computer played:");
                        printGrid();
                        intelPlayerChoiceX();
    
                        if (a3) {
                            winO(2, 2);
                        } else if (c1 || c3) {
                            winO(2, 0);
                        }
                    }
                } else if (c1) {
                    grid[2][0] = "O";
                    System.out.println("The computer played:");
                    printGrid();
                    intelPlayerChoiceX();

                    if (a1) {
                        grid[0][1] = "O";
                        System.out.println("The computer played:");
                        printGrid();
                        intelPlayerChoiceX();
    
                        if (a2 || c3) {
                            tieO(1, 2);
                        } else if (c2) {
                            tieO(2, 2);
                        }
                    } else if (a2) {
                        grid[0][0] = "O";
                        System.out.println("The computer played:");
                        printGrid();
                        intelPlayerChoiceX();
    
                        if (b1 || c2) {
                            winO(2, 2);
                        } else if (c3) {
                            tieO(1, 2);
                        }
                    } else if (b1) {
                        grid[0][0] = "O";
                        System.out.println("The computer played:");
                        printGrid();
                        intelPlayerChoiceX();
    
                        if (a2) {
                            winO(2, 2);
                        } else if (c2 || c3) {
                            winO(1, 0);
                        }
                    } else if (c2) {
                        grid[2][2] = "O";
                        System.out.println("The computer played:");
                        printGrid();
                        intelPlayerChoiceX();
    
                        if (a1) {
                            tieO(0, 1);
                        } else if (a2 || b1) {
                            winO(0, 0);
                        }
                    } else if (c3) {
                        grid[1][2] = "O";
                        System.out.println("The computer played:");
                        printGrid();
                        intelPlayerChoiceX();
    
                        if (a1 || b1) {
                            winO(1, 0);
                        } else if (a2) {
                            tieO(0, 1);
                        }
                    }
                } else if (c2) {
                    grid[2][2] = "O";
                    System.out.println("The computer played:");
                    printGrid();
                    intelPlayerChoiceX();

                    if (a2 || a3 || b1 || c1) {
                        winO(0, 0);
                    } else if (a1) {
                        grid[2][0] = "O";
                        System.out.println("The computer played:");
                        printGrid();
                        intelPlayerChoiceX();
    
                        if (a2 || b1) {
                            winO(0, 2);
                        } else if (c1) {
                            tieO(0, 1);
                        }
                    }
                } else if (c3) {
                    grid[2][0] = "O";
                    System.out.println("The computer played:");
                    printGrid();
                    intelPlayerChoiceX();

                    if (a1 || a2 || b1 || c2) {
                        winO(0, 2);
                    } else if (c1) {
                        grid[1][2] = "O";
                        System.out.println("The computer played:");
                        printGrid();
                        intelPlayerChoiceX();
    
                        if (a1 || b1) {
                            winO(1, 0);
                        } else if (a2) {
                            tieO(0, 1);
                        }
                    }
                }
            } else if (c1) {
                grid[1][1] = "O";
                System.out.println("The computer played:");
                printGrid();
                intelPlayerChoiceX();

                if (a1) {
                    grid[0][1] = "O";
                    System.out.println("The computer played:");
                    printGrid();
                    intelPlayerChoiceX();
    
                    if (a2 || a3 || c2 || c3) {
                        winO(2, 1);
                    } else if (b3) {
                        grid[1][2] = "O";
                        System.out.println("The computer played:");
                        printGrid();
                        intelPlayerChoiceX();
        
                        if (a2) {
                            tieO(2, 0);
                        } else if (a3 || c3) {
                            winO(1, 0);
                        }
                    }
                } else if (a2) {
                    grid[2][0] = "O";
                    System.out.println("The computer played:");
                    printGrid();
                    intelPlayerChoiceX();
    
                    if (a1) {
                        grid[0][1] = "O";
                        System.out.println("The computer played:");
                        printGrid();
                        intelPlayerChoiceX();
        
                        if (b3) {
                            tieO(1, 2);
                        } else if (b2 || b3) {
                            winO(2, 1);
                        }
                    } else if (b1) {
                        grid[0][0] = "O";
                        System.out.println("The computer played:");
                        printGrid();
                        intelPlayerChoiceX();
        
                        if (b3 || c2) {
                            winO(2, 2);
                        } else if (c3) {
                            tieO(1, 2);
                        }
                    } else if (b3) {
                        grid[2][2] = "O";
                        System.out.println("The computer played:");
                        printGrid();
                        intelPlayerChoiceX();
        
                        if (a1) {
                            tieO(0, 1);
                        } else if (b1 || c2) {
                            winO(0, 0);
                        }
                    } else if (c2) {
                        grid[2][2] = "O";
                        System.out.println("The computer played:");
                        printGrid();
                        intelPlayerChoiceX();
        
                        if (a1) {
                            tieO(0, 1);
                        } else if (b1 || b3) {
                            winO(0, 0);
                        }
                    } else if (c3) {
                        grid[1][2] = "O";
                        System.out.println("The computer played:");
                        printGrid();
                        intelPlayerChoiceX();
        
                        if (a1) {
                            tieO(0, 1);
                        } else if (b1 || b3) {
                            tieO(0, 0);
                        }
                    }
                } else if (a3) {
                    grid[1][0] = "O";
                    System.out.println("The computer played:");
                    printGrid();
                    intelPlayerChoiceX();
    
                    if (a1 || b1 || b3 || c3) {
                        winO(1, 2);
                    } else if (c2) {
                        grid[2][2] = "O";
                        System.out.println("The computer played:");
                        printGrid();
                        intelPlayerChoiceX();
        
                        if (a1) {
                            tieO(0, 1);
                        } else if (b1 || b3) {
                            winO(0, 0);
                        }
                    }
                } else if (b1) {
                    grid[0][0] = "O";
                    System.out.println("The computer played:");
                    printGrid();
                    intelPlayerChoiceX();
    
                    if (a2 || a3 || b3 || c2) {
                        winO(2, 2);
                    } else if (c3) {
                        grid[1][2] = "O";
                        System.out.println("The computer played:");
                        printGrid();
                        intelPlayerChoiceX();
        
                        if (a2 || b3) {
                            tieO(2, 0);
                        } else if (a3) {
                            tieO(2, 1);
                        }
                    }
                } else if (b3) {
                    grid[2][0] = "O";
                    System.out.println("The computer played:");
                    printGrid();
                    intelPlayerChoiceX();
    
                    if (a1) {
                        grid[0][1] = "O";
                        System.out.println("The computer played:");
                        printGrid();
                        intelPlayerChoiceX();
        
                        if (a2 || c2) {
                            tieO(2, 2);
                        } else if (c3) {
                            tieO(1, 2);
                        }
                    } else if (a2) {
                        grid[0][0] = "O";
                        System.out.println("The computer played:");
                        printGrid();
                        intelPlayerChoiceX();
        
                        if (b1 || c2) {
                            winO(2, 2);
                        } else if (c3) {
                            tieO(1, 2);
                        }
                    } else if (b1) {
                        grid[0][0] = "O";
                        System.out.println("The computer played:");
                        printGrid();
                        intelPlayerChoiceX();
        
                        if (a2 || c2) {
                            winO(2, 2);
                        } else if (c3) {
                            tieO(1, 2);
                        }
                    } else if (c2) {
                        grid[2][2] = "O";
                        System.out.println("The computer played:");
                        printGrid();
                        intelPlayerChoiceX();
        
                        if (a1) {
                            tieO(0, 1);
                        } else if (a2 || b1) {
                            winO(0, 0);
                        }
                    } else if (c3) {
                        grid[1][2] = "O";
                        System.out.println("The computer played:");
                        printGrid();
                        intelPlayerChoiceX();
        
                        if (a1 || b1) {
                            winO(1, 0);
                        } else if (a2) {
                            winO(0, 1);
                        }
                    }
                } else if (c2) {
                    grid[2][2] = "O";
                    System.out.println("The computer played:");
                    printGrid();
                    intelPlayerChoiceX();
    
                    if (a2 || a3 || b1 || b3) {
                        winO(0, 0);
                    } else if (a1) {
                        grid[0][1] = "O";
                        System.out.println("The computer played:");
                        printGrid();
                        intelPlayerChoiceX();
        
                        if (a2 || b3) {
                            tieO(0, 2);
                        } else if (a3) {
                            tieO(1, 0);
                        }
                    }
                } else if (c3) {
                    grid[1][2] = "O";
                    System.out.println("The computer played:");
                    printGrid();
                    intelPlayerChoiceX();
    
                    if (a1 || a3 || b1 || b3) {
                        winO(1, 0);
                    } else if (a2) {
                        grid[0][1] = "O";
                        System.out.println("The computer played:");
                        printGrid();
                        intelPlayerChoiceX();
        
                        if (a1 || a3) {
                            winO(2, 1);
                        } else if (b3) {
                            tieO(2, 0);
                        }
                    }
                }
            } else if (c2) {
                grid[1][1] = "O";
                System.out.println("The computer played:");
                printGrid();
                intelPlayerChoiceX();

                if (a1) {
                    grid[2][2] = "O";
                    System.out.println("The computer played:");
                    printGrid();
                    intelPlayerChoiceX();
    
                    if (a2) {
                        grid[2][0] = "O";
                        System.out.println("The computer played:");
                        printGrid();
                        intelPlayerChoiceX();
        
                        if (b1 || c1) {
                            winO(2, 1);
                        } else if (b3) {
                            winO(0, 2);
                        }
                    } else if (a3) {
                        grid[1][0] = "O";
                        System.out.println("The computer played:");
                        printGrid();
                        intelPlayerChoiceX();
        
                        if (b1) {
                            tieO(0, 2);
                        } else if (b3 || c1) {
                            tieO(0, 1);
                        }
                    } else if (b1) {
                        grid[0][2] = "O";
                        System.out.println("The computer played:");
                        printGrid();
                        intelPlayerChoiceX();
        
                        if (a2 || b3) {
                            winO(2, 0);
                        } else if (a3) {
                            tieO(1, 0);
                        }
                    } else if (b3) {
                        grid[2][0] = "O";
                        System.out.println("The computer played:");
                        printGrid();
                        intelPlayerChoiceX();
        
                        if (a2 || b1) {
                            winO(0, 2);
                        } else if (c1) {
                            tieO(0, 1);
                        }
                    } else if (c1) {
                        grid[0][1] = "O";
                        System.out.println("The computer played:");
                        printGrid();
                        intelPlayerChoiceX();
        
                        if (a2 || a3) {
                            winO(2, 1);
                        } else if (b3) {
                            tieO(1, 0);
                        }
                    }
                } else if (a2) {
                    grid[2][1] = "O";
                    System.out.println("The computer played:");
                    printGrid();
                    intelPlayerChoiceX();
    
                    if (a1 || a3 || b1 || b3) {
                        winO(0, 1);
                    } else if (b1) {
                        grid[2][0] = "O";
                        System.out.println("The computer played:");
                        printGrid();
                        intelPlayerChoiceX();
        
                        if (a1 || c1) {
                            winO(2, 2);
                        } else if (c3) {
                            winO(0, 2);
                        }
                    }
                } else if (a3) {
                    grid[0][2] = "O";
                    System.out.println("The computer played:");
                    printGrid();
                    intelPlayerChoiceX();
    
                    if (a1) {
                        grid[1][0] = "O";
                        System.out.println("The computer played:");
                        printGrid();
                        intelPlayerChoiceX();
        
                        if (b1 || c3) {
                            tieO(2, 1);
                        } else if (b3) {
                            tieO(2, 2);
                        }
                    } else if (a2) {
                        grid[0][0] = "O";
                        System.out.println("The computer played:");
                        printGrid();
                        intelPlayerChoiceX();
        
                        if (b1) {
                            winO(2, 2);
                        } else if (b3 || c3) {
                            winO(0, 1);
                        }
                    } else if (b1) {
                        grid[0][0] = "O";
                        System.out.println("The computer played:");
                        printGrid();
                        intelPlayerChoiceX();
        
                        if (a2 || b3) {
                            winO(2, 2);
                        } else if (c3) {
                            tieO(2, 1);
                        }
                    } else if (b3) {
                        grid[2][2] = "O";
                        System.out.println("The computer played:");
                        printGrid();
                        intelPlayerChoiceX();
        
                        if (a1) {
                            tieO(1, 0);
                        } else if (a2 || b1) {
                            winO(0, 0);
                        }
                    } else if (c3) {
                        grid[2][1] = "O";
                        System.out.println("The computer played:");
                        printGrid();
                        intelPlayerChoiceX();
        
                        if (a1 || a2) {
                            winO(0, 1);
                        } else if (b1) {
                            tieO(1, 0);
                        }
                    }
                } else if (b1) {
                    grid[0][2] = "O";
                    System.out.println("The computer played:");
                    printGrid();
                    intelPlayerChoiceX();
    
                    if (a1 || a2 || b3 || c3) {
                        winO(2, 0);
                    } else if (a3) {
                        grid[2][2] = "O";
                        System.out.println("The computer played:");
                        printGrid();
                        intelPlayerChoiceX();
        
                        if (a1) {
                            tieO(1, 0);
                        } else if (a2 || b3) {
                            winO(0, 0);
                        }
                    }
                } else if (b3) {
                    grid[2][2] = "O";
                    System.out.println("The computer played:");
                    printGrid();
                    intelPlayerChoiceX();
    
                    if (a2 || a3 || b1 || c1) {
                        winO(0, 0);
                    } else if (a1) {
                        grid[0][2] = "O";
                        System.out.println("The computer played:");
                        printGrid();
                        intelPlayerChoiceX();
        
                        if (a2 || b1) {
                            winO(2, 0);
                        } else if (a3) {
                            tieO(1, 0);
                        }
                    }
                } else if (c1) {
                    grid[2][2] = "O";
                    System.out.println("The computer played:");
                    printGrid();
                    intelPlayerChoiceX();
    
                    if (a2 || a3 || b1 || b3) {
                        winO(0, 0);
                    } else if (a1) {
                        grid[0][1] = "O";
                        System.out.println("The computer played:");
                        printGrid();
                        intelPlayerChoiceX();
        
                        if (a2 || a3) {
                            winO(2, 1);
                        } else if (b3) {
                            tieO(1, 0);
                        }
                    }
                } else if (c3) {
                    grid[0][2] = "O";
                    System.out.println("The computer played:");
                    printGrid();
                    intelPlayerChoiceX();
    
                    if (a1 || a2 || b1 || b3) {
                        winO(2, 0);
                    } else if (a3) {
                        grid[2][1] = "O";
                        System.out.println("The computer played:");
                        printGrid();
                        intelPlayerChoiceX();
        
                        if (a1 || a2) {
                            winO(0, 1);
                        } else if (b1) {
                            tieO(1, 0);
                        }
                    }
                }
            } else if (c3) {
                grid[1][1] = "O";
                System.out.println("The computer played:");
                printGrid();
                intelPlayerChoiceX();

                if (a1) {
                    grid[0][1] = "O";
                    System.out.println("The computer played:");
                    printGrid();
                    intelPlayerChoiceX();
    
                    if (a2 || a3 || c1 || c2) {
                        winO(2, 1);
                    } else if (b3) {
                        grid[2][0] = "O";
                        System.out.println("The computer played:");
                        printGrid();
                        intelPlayerChoiceX();
        
                        if (a2 || c2) {
                            winO(0, 2);
                        } else if (c1) {
                            tieO(1, 2);
                        }
                    }
                } else if (a2) {
                    grid[0][0] = "O";
                    System.out.println("The computer played:");
                    printGrid();
                    intelPlayerChoiceX();
    
                    if (a3) {
                        grid[2][1] = "O";
                        System.out.println("The computer played:");
                        printGrid();
                        intelPlayerChoiceX();
        
                        if (b1) {
                            tieO(1, 2);
                        } else if (c1 || c2) {
                            winO(0, 1);
                        }
                    } else if (b1) {
                        grid[0][2] = "O";
                        System.out.println("The computer played:");
                        printGrid();
                        intelPlayerChoiceX();
        
                        if (a3) {
                            tieO(2, 1);
                        } else if (b3 || c2) {
                            winO(2, 0);
                        }
                    } else if (b3) {
                        grid[2][0] = "O";
                        System.out.println("The computer played:");
                        printGrid();
                        intelPlayerChoiceX();
        
                        if (b1 || c2) {
                            winO(0, 2);
                        } else if (c1) {
                            tieO(1, 2);
                        }
                    } else if (c1) {
                        grid[1][2] = "O";
                        System.out.println("The computer played:");
                        printGrid();
                        intelPlayerChoiceX();
        
                        if (a3) {
                            tieO(2, 1);
                        } else if (b1 || b3) {
                            tieO(2, 0);
                        }
                    } else if (c2) {
                        grid[0][2] = "O";
                        System.out.println("The computer played:");
                        printGrid();
                        intelPlayerChoiceX();
        
                        if (a3) {
                            tieO(2, 1);
                        } else if (b1 || b3) {
                            winO(2, 0);
                        }
                    }
                } else if (a3) {
                    grid[2][1] = "O";
                    System.out.println("The computer played:");
                    printGrid();
                    intelPlayerChoiceX();
    
                    if (a1 || a2 || c1 || c2) {
                        winO(0, 1);
                    } else if (b1) {
                        grid[1][2] = "O";
                        System.out.println("The computer played:");
                        printGrid();
                        intelPlayerChoiceX();
        
                        if (a1 || c1) {
                            winO(1, 0);
                        } else if (a2) {
                            tieO(0, 0);
                        }
                    }
                } else if (b1) {
                    grid[0][0] = "O";
                    System.out.println("The computer played:");
                    printGrid();
                    intelPlayerChoiceX();
    
                    if (a2) {
                        grid[2][0] = "O";
                        System.out.println("The computer played:");
                        printGrid();
                        intelPlayerChoiceX();
        
                        if (b3 || c2) {
                            winO(0, 2);
                        } else if (c1) {
                            tieO(1, 2);
                        }
                    } else if (a3) {
                        grid[2][1] = "O";
                        System.out.println("The computer played:");
                        printGrid();
                        intelPlayerChoiceX();
        
                        if (a2 || c2) {
                            tieO(0, 2);
                        } else if (c1) {
                            tieO(1, 2);
                        }
                    } else if (b3) {
                        grid[2][0] = "O";
                        System.out.println("The computer played:");
                        printGrid();
                        intelPlayerChoiceX();
        
                        if (a2 || c2) {
                            winO(0, 2);
                        } else if (c1) {
                            tieO(1, 2);
                        }
                    } else if (c1) {
                        grid[1][2] = "O";
                        System.out.println("The computer played:");
                        printGrid();
                        intelPlayerChoiceX();
        
                        if (a2) {
                            tieO(2, 1);
                        } else if (a3 || b3) {
                            winO(1, 0);
                        }
                    } else if (c2) {
                        grid[0][2] = "O";
                        System.out.println("The computer played:");
                        printGrid();
                        intelPlayerChoiceX();
        
                        if (a2 || b3) {
                            winO(2, 0);
                        } else if (a3) {
                            tieO(2, 1);
                        }
                    }
                } else if (b3) {
                    grid[2][0] = "O";
                    System.out.println("The computer played:");
                    printGrid();
                    intelPlayerChoiceX();
    
                    if (a1 || a2 || b1 || c2) {
                        winO(0, 2);
                    } else if (c1) {
                        grid[1][2] = "O";
                        System.out.println("The computer played:");
                        printGrid();
                        intelPlayerChoiceX();
        
                        if (a1) {
                            tieO(0, 1);
                        } else if (a2 || b1) {
                            tieO(0, 0);
                        }
                    }
                } else if (c1) {
                    grid[1][2] = "O";
                    System.out.println("The computer played:");
                    printGrid();
                    intelPlayerChoiceX();
    
                    if (a1 || a3 || b1 || b3) {
                        winO(0, 1);
                    } else if (a2) {
                        grid[2][1] = "O";
                        System.out.println("The computer played:");
                        printGrid();
                        intelPlayerChoiceX();
        
                        if (a1 || a3) {
                            winO(0, 1);
                        } else if (b1) {
                            tieO(0, 0);
                        }
                    }
                } else if (c2) {
                    grid[0][2] = "O";
                    System.out.println("The computer played:");
                    printGrid();
                    intelPlayerChoiceX();
    
                    if (a1 || a2 || b1 || b3) {
                        winO(2, 0);
                    } else if (a3) {
                        grid[2][1] = "O";
                        System.out.println("The computer played:");
                        printGrid();
                        intelPlayerChoiceX();
        
                        if (a1) {
                            tieO(1, 0);
                        } else if (a2 || b1) {
                            tieO(0, 0);
                        }
                    }
                }
            } else {
                exit();
            }
        } else {
            exit();
        }
    }

    // Secondary functions that make compIntel much easier to write (and shorter)
    public static void intelPlayerChoiceX() { // makes user choose a valid spot on grid when they're X
        boolean valid;

        System.out.println("Enter your selection.");
        reply = input.nextLine().toLowerCase().replaceAll("[^abc123]", "");

        valid = false;

        while (!valid) {
            if (reply.equals("a1") && grid[0][0].equals(" ")) {
                grid[0][0] = "X";
                valid = true;
                printGrid();
            } else if (reply.equals("a2") && grid[1][0].equals(" ")) {
                grid[1][0] = "X";
                valid = true;
                printGrid();
            } else if (reply.equals("a3") && grid[2][0].equals(" ")) {
                grid[2][0] = "X";
                valid = true;
                printGrid();
            } else if (reply.equals("b1") && grid[0][1].equals(" ")) {
                grid[0][1] = "X";
                valid = true;
                printGrid();
            } else if (reply.equals("b2") && grid[1][1].equals(" ")) {
                grid[1][1] = "X";
                valid = true;
                printGrid();
            } else if (reply.equals("b3") && grid[2][1].equals(" ")) {
                grid[2][1] = "X";
                valid = true;
                printGrid();
            } else if (reply.equals("c1") && grid[0][2].equals(" ")) {
                grid[0][2] = "X";
                valid = true;
                printGrid();
            } else if (reply.equals("c2") && grid[1][2].equals(" ")) {
                grid[1][2] = "X";
                valid = true;
                printGrid();
            } else if (reply.equals("c3") && grid[2][2].equals(" ")) {
                grid[2][2] = "X";
                valid = true;
                printGrid();
            } else {
                valid = false;
                System.out.println("I'm sorry, that's not a valid answer. Here's the grid, please try again:");
                printGrid();
                System.out.println("Enter your selection.");
                reply = input.nextLine().toLowerCase().replaceAll("[^abc123]", "");
            }
        }

        replyBools();
    }

    public static void intelPlayerChoiceO() { // makes user choose a valid spot on grid when they're O
        boolean valid;

        System.out.println("Enter your selection.");
        reply = input.nextLine().toLowerCase().replaceAll("[^abc123]", "");

        valid = false;

        while (!valid) {
            if (reply.equals("a1") && grid[0][0].equals(" ")) {
                grid[0][0] = "O";
                valid = true;
                printGrid();
            } else if (reply.equals("a2") && grid[1][0].equals(" ")) {
                grid[1][0] = "O";
                valid = true;
                printGrid();
            } else if (reply.equals("a3") && grid[2][0].equals(" ")) {
                grid[2][0] = "O";
                valid = true;
                printGrid();
            } else if (reply.equals("b1") && grid[0][1].equals(" ")) {
                grid[0][1] = "O";
                valid = true;
                printGrid();
            } else if (reply.equals("b2") && grid[1][1].equals(" ")) {
                grid[1][1] = "O";
                valid = true;
                printGrid();
            } else if (reply.equals("b3") && grid[2][1].equals(" ")) {
                grid[2][1] = "O";
                valid = true;
                printGrid();
            } else if (reply.equals("c1") && grid[0][2].equals(" ")) {
                grid[0][2] = "O";
                valid = true;
                printGrid();
            } else if (reply.equals("c2") && grid[1][2].equals(" ")) {
                grid[1][2] = "O";
                valid = true;
                printGrid();
            } else if (reply.equals("c3") && grid[2][2].equals(" ")) {
                grid[2][2] = "O";
                valid = true;
                printGrid();
            } else {
                valid = false;
                System.out.println("I'm sorry, that's not a valid answer. Here's the grid, please try again:");
                printGrid();
                System.out.println("Enter your selection.");
                reply = input.nextLine().toLowerCase().replaceAll("[^abc123]", "");
            }
        }

        replyBools();
    }

    public static void replyBools() { // convert user's reply to a boolean (compIntel)
        a1 = reply.equals("a1");
        a2 = reply.equals("a2");
        a3 = reply.equals("a3");
        b1 = reply.equals("b1");
        b2 = reply.equals("b2");
        b3 = reply.equals("b3");
        c1 = reply.equals("c1");
        c2 = reply.equals("c2");
        c3 = reply.equals("c3");
    }

    public static void winX(int y, int x) { // compIntel wins when comp is X
        grid[y][x] = "X";
        System.out.println("The computer played:");
        printGrid();
        System.out.println("I win!");
    }

    public static void winO(int y, int x) { // compIntel wins when comp is O
        grid[y][x] = "O";
        System.out.println("The computer played:");
        printGrid();
        System.out.println("I win!");
    }

    public static void tieX(int y, int x) { // tie when comp is X
        grid[y][x] = "X";
        System.out.println("The computer played:");
        printGrid();
        System.out.println("It's a tie!");
    }

    public static void tieO(int y, int x) { // tie when comp is O
        grid[y][x] = "O";
        System.out.println("The computer played:");
        printGrid();
        intelPlayerChoiceX();
        System.out.println("It's a tie!");
    }
    
    // prints the grid, used literally everywhere
    public static void printGrid() {
        System.out.println("  A   B   C\n" +
            "1 " + grid[0][0] + " | " + grid[0][1] + " | " + grid[0][2] + "  \n" +
            " ---+---+---\n" +
            "2 " + grid[1][0] + " | " + grid[1][1] + " | " + grid[1][2] + "  \n" +
            " ---+---+---\n" +
            "3 " + grid[2][0] + " | " + grid[2][1] + " | " + grid[2][2]);

    }

    public static void resetGrid() {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                grid[i][j] = " ";
            }
        }
    }

    // code failure (unexpected behavior)
    public static void exit() {
        System.out.println("I'm sorry, but it appears that I can't code. My sincerest apologies. You will now be redirected to the "
                + "afterlife. Goodbye!");
        System.exit(0);
    }
}
// I love you 3000