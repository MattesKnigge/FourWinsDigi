package fourwins;

import fourwins.Enums.Color;
import fourwins.Exception.ColumnFullException;

public class Bord extends GameObject{
    private Cell[][] bord;

    public Bord() {
        this.bord = new Cell[6][7];
    }

    public Cell[][] getBord() {
        return bord;
    }

    public void dropToken(int column, Token token) throws ColumnFullException {
        if (canDrop(column)) {
            column -= 1;
            for (int row = 0; row < bord[row].length-1; row++) {
                if (bord[5-row][column] == null) {
                    bord[5-row][column] = new Cell(token);
                    break;
                }
            }
            //bord[5][6] = new Cell(token);
        }
    }

    public boolean canDrop(int column) {
        column -= 1;
        for (int row = 0; row < bord[row].length-1; row++) {
            if (bord[5-row][column] == null) {
                return true;
            }
        }
        return false;
    }

    public StringBuilder buildBord() {
        StringBuilder sb = new StringBuilder();
        for (Cell[] x : bord) {
            for (Cell y : x) {
                if (y == null) {
                    sb.append("[ ]");
                } else if (y.getToken().getColor() == Color.YELLOW) {
                    sb.append("[O]");
                } else if (y.getToken().getColor() == Color.RED) {
                    sb.append("[X]");
                }
            }
            sb.append("\n");
        }
        return sb;
    }

    @Override
    public String toString(Object o) {
        return o.toString();
    }
}
