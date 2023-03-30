package fourwins;

import fourwins.Enums.Winner;
import fourwins.Exception.ColumnFullException;
import fourwins.Exception.IllegalMoveException;

import java.io.IOException;
import java.util.Scanner;

/**
 * Console part of the game.
 */

public class ConsoleGame extends Game {
    public ConsoleGame(Bord bord) {
        super(bord);
    }

    /**
     * start the game with two players either human or computer
     *
     * @param player1 player 1 (computer or human)
     * @param player2 player 2 (computer or human)
     */
    @Override
    public void doGame(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
        System.out.println("Welcome to FourWins!");
        System.out.println("Player 1 is red, player 2 is yellow.");
        System.out.println("Which player starts? (1 or 2)");
        Scanner scanner = new Scanner(System.in);
        //int playerIn = scanner.nextInt();

        // right now the game is set to play against a computer player
        // for computer vs player, switch out the line below for the line above
        // it enables funtion to choose which player starts

        int playerIn = 1; // TODO: remove this line and uncomment the line above to play against a human player

        if (playerIn == 1) { //
            this.currentPlayer = player1;
        } else if (playerIn == 2) {
            this.currentPlayer = player2;
        } else {
            System.out.println("Invalid input, player 1 starts.");
            this.currentPlayer = player1;
        }

        while (bord.testVictory().equals(Winner.NONE)) {
            System.out.println(bord);
            System.out.println("Player " + currentPlayer + " is on turn.");
            //int columnIn = scanner.nextInt();
            // To play against a human player, uncomment the line above and remove the line below
            // switch out .doTurn() for .doDrop(columnIn) to play against a human player
            try {
                currentPlayer.doTurn();
            } catch (ColumnFullException e) {
                System.out.println("Column is full, try again.");
            } catch (IllegalMoveException e) {
                System.out.println("Illegal move, try again.");
            } catch (IOException e) {
                System.out.println("Invalid input, try again.");
            }
            swapPlayer();
        }

        System.out.println("\nPlayer " + currentPlayer + " has won!");
        System.out.println("Final bord:");
        System.out.println(bord); // print the final board
    }
}

