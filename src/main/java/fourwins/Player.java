package fourwins;

import fourwins.Enums.Color;
import fourwins.Exception.ColumnFullException;
import fourwins.Exception.IllegalMoveException;

import java.io.IOException;

public abstract class Player {
    private final Color color;
    private final Bord bord;

    public Player(Color color, Bord bord) {
        this.color = color;
        this.bord = bord;
    }

    protected void doDrop(int columnIndex) throws ColumnFullException, IllegalMoveException {
        bord.dropToken(bord.getToken(color), columnIndex);
    }

    public abstract void doTurn() throws ColumnFullException, IllegalMoveException, IOException;
}
