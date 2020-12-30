//I worked on the homework assignment alone, using only course materials.
import java.util.Scanner;
import java.util.Random;
public class TicTacToe {
    public static void main(String[] args) {
        Scanner x = new Scanner(System.in);
        int players = TicTacToe.getNumberPlayers(x);
        if (players == 1) {
            TicTacToe.onePlayer();
        } else {
            TicTacToe.twoPlayer();
        }

    }
    // Place your methods here
    public static void onePlayer() {
        Board board = new Board();
        boolean repeatPrompt = true;
        Scanner newOne = new Scanner(System.in);
        Random computer = new Random();
        System.out.println(board);
        while (repeatPrompt) {
            boolean checker = true;
            Location y = getInput("1", newOne);
            while (checker) {
                if (board.emptySpot(y.getRow(), y.getColumn())) {
                    checker = false;
                } else {
                    y = getInput("1", newOne);
                }
            }
            board.validSpace(y.getRow(), y.getColumn(), 'X');
            System.out.println(board);
            if (board.getGameState() == GameState.ONGOING) {
                repeatPrompt = true;
            } else {
                if (board.getGameState() == GameState.PLAYER1_WIN) {
                    System.out.println("Player 1 wins!");
                    repeatPrompt = false;
                    break;
                } else if (board.getGameState() == GameState.TIE) {
                    System.out.println("It is a Tie");
                    repeatPrompt = false;
                    break;
                } else {
                    System.out.println("Computer Wins");
                    repeatPrompt = false;
                    break;
                }
            }
            System.out.println("The Computer is making a move...");
            Location newComputer = new Location(computer.nextInt(3), computer.nextInt(3));
            boolean checkerTwo = true;
            int count = 0;
            while (checkerTwo) {
                if (board.emptySpot(newComputer.getRow(), newComputer.getColumn())) {
                    checkerTwo = false;
                } else {
                    if (count >= 9) {
                        checkerTwo = false;
                        repeatPrompt = false;
                    }
                    newComputer = new Location(computer.nextInt(3), computer.nextInt(3));
                    count += 1;
                }
            }
            board.validSpace(newComputer.getRow(), newComputer.getColumn(), 'O');
            System.out.println(board);
            if (board.getGameState() == GameState.ONGOING) {
                repeatPrompt = true;
            } else {
                repeatPrompt = false;
                if (board.getGameState() == GameState.PLAYER1_WIN) {
                    System.out.println("Player 1 wins!");
                } else if (board.getGameState() == GameState.TIE) {
                    System.out.println("It is a Tie");
                    repeatPrompt = false;
                } else {
                    System.out.println("Computer Wins");
                }
            }
        }
    }
    public static void twoPlayer() {
        Board board = new Board();
        boolean repeatPrompt = true;
        Scanner newOne = new Scanner(System.in);
        System.out.println(board);
        while (repeatPrompt) {
            boolean checker = true;
            Location y = getInput("1", newOne);
            while (checker) {
                if (board.emptySpot(y.getRow(), y.getColumn())) {
                    checker = false;
                } else {
                    y = getInput("1", newOne);
                }
            }
            board.validSpace(y.getRow(), y.getColumn(), 'X');
            System.out.println(board);
            if (board.getGameState() == GameState.ONGOING) {
                repeatPrompt = true;
            } else {
                if (board.getGameState() == GameState.PLAYER1_WIN) {
                    System.out.println("Player 1 wins!");
                    repeatPrompt = false;
                    break;
                } else if (board.getGameState() == GameState.TIE) {
                    System.out.println("It is a Tie");
                    repeatPrompt = false;
                    break;
                } else {
                    System.out.println("Plater 2 Wins");
                    repeatPrompt = false;
                    break;
                }
            }
            boolean checkerTwo = true;
            Location z = getInput("2", newOne);
            while (checkerTwo) {
                if (board.emptySpot(z.getRow(), z .getColumn())) {
                    checkerTwo = false;
                } else {
                    z = getInput("2", newOne);
                }
            }
            board.validSpace(z.getRow(), z.getColumn(), 'O');
            System.out.println(board);
            if (board.getGameState() == GameState.ONGOING) {
                repeatPrompt = true;
            } else {
                if (board.getGameState() == GameState.PLAYER1_WIN) {
                    System.out.println("Player 1 wins!");
                    repeatPrompt = false;
                    break;
                } else if (board.getGameState() == GameState.TIE) {
                    System.out.println("It is a Tie");
                    repeatPrompt = false;
                    break;
                } else {
                    System.out.println("Player 2 wins!");
                    repeatPrompt = false;
                    break;

                }
            }
        }
    }



    /********************************************************
     *                                                      *
     *      DO NOT MODIFY CODE BELOW THIS BOX               *
     *                                                      *
     ********************************************************/

   /**
     * Gets number of players from command line
     * @param sc        for reading from command-line
     * @return number of players (always 1 or 2)
     */
    private static int getNumberPlayers(Scanner sc) {
        boolean repeatPrompt = true;
        int numPlayers = 0;
        while (repeatPrompt) {
            System.out.print("How many players (1 or 2)? ");
            String input = sc.next();
            try {
                numPlayers = Integer.parseInt(input);
                if (numPlayers == 1 || numPlayers == 2) {
                    repeatPrompt = false;
                } else {
                    System.out.println("Enter 1 or 2 players.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please only enter a number.");
            }
        }
        return numPlayers;
    }

   /**
     * Handles scanner calls and user input
     * @param player    whose turn it is
     * @param sc        for reading from command-line
     * @return int[] holding row, column in that order
     */
    private static Location getInput(String player, Scanner sc) {
        boolean repeatPrompt = true;
        int row = -1;
        int col = -1;
        while (repeatPrompt) {
            System.out.print("Enter desired square for " + player + ": ");
            String input = sc.next();
            input = input.trim();
            String[] splitInput = input.split(",");
            try {
                row = Integer.parseInt(splitInput[0]);
                col = Integer.parseInt(splitInput[1]);
                repeatPrompt = false;
            } catch (NumberFormatException | IndexOutOfBoundsException e) {
                System.out.println("Please follow the format 'row,col'; for ex '1,2'");
            }
        }
        Location loc = new Location(row, col);
        return loc;
    }




}


