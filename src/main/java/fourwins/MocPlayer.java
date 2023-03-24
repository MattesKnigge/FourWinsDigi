package fourwins;


import fourwins.Enums.Color;
import fourwins.Exception.ColumnFullException;
import fourwins.Exception.IllegalMoveException;

/**
 * Moc player class
 * extends player class and implements doTurn method for mock player
 */

public class MocPlayer extends Player {
    private final int move;

    /**
     * Constructor for moc player
     *
     * @param color the color of the token
     * @param bord  the bord
     * @param move  the move
     */
    public MocPlayer(Color color, Bord bord, int move) {
        super(color, bord);
        this.move = move;
    }

    /**
     * doTurn method for moc player
     *
     * @throws ColumnFullException  if column is full
     * @throws IllegalMoveException if move is illegal
     */

    @Override
    public void doTurn() throws ColumnFullException, IllegalMoveException {
        super.doDrop(move);
    }
}
