package fourwins;


import fourwins.Enums.Color;
import fourwins.Exception.ColumnFullException;
import fourwins.Exception.IllegalMoveException;

public class MocPlayer extends Player {
    private final int move;

    public MocPlayer(Color color, Bord bord, int move) {
        super(color, bord);
        this.move = move;
    }

    @Override
    public void doTurn() throws ColumnFullException, IllegalMoveException {
        super.doDrop(move);
    }
}
