package fourwins;

import fourwins.Enums.Color;
import fourwins.Exception.ColumnFullException;
import fourwins.Exception.IllegalMoveException;

import java.io.IOException;

/**
 * Player class
 * abstract class for player
 */

public abstract class Player {
    private final Color color;
    private final Bord bord;

    /**
     * Constructor for player
     *
     * @param color the color of the token
     * @param bord  the bord
     */
    public Player(Color color, Bord bord) {
        this.color = color;
        this.bord = bord;
    }

    /**
     * doDrop method
     * drops a token in the given column
     *
     * @param columnIndex the column index
     * @throws ColumnFullException  if column is full
     * @throws IllegalMoveException if move is illegal
     */
    protected void doDrop(int columnIndex) throws ColumnFullException, IllegalMoveException {
        bord.dropToken(bord.getToken(color), columnIndex);
    }

    /**
     * doTurn method for player
     *
     * @throws ColumnFullException  if column is full
     * @throws IllegalMoveException if move is illegal
     * @throws IOException          if input is wrong
     */
    public abstract void doTurn() throws ColumnFullException, IllegalMoveException, IOException;
}
