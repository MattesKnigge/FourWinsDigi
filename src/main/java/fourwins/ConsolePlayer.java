package fourwins;

import fourwins.Enums.Color;
import fourwins.Exception.ColumnFullException;
import fourwins.Exception.IllegalMoveException;

import java.util.Scanner;

/**
 * Console player class
 * extends player class and implements doTurn method for console input player
 */
public class ConsolePlayer extends Player {
    /**
     * Constructor for console player
     *
     * @param color the color of the token
     * @param bord  the bord
     */
    public ConsolePlayer(Color color, Bord bord) {
        super(color, bord);
    }

    /**
     * doTurn method for console input player
     *
     * @throws ColumnFullException  if column is full
     * @throws IllegalMoveException if move is illegal
     */
    @Override
    public void doTurn() throws ColumnFullException, IllegalMoveException {
        Scanner consoleReader = new Scanner(System.in);
        System.out.print("Which column do you want to drop your token in?");
        int columnIn = consoleReader.nextInt();
        super.doDrop(columnIn);
    }
}
