package fourwins;

import fourwins.Enums.Color;
import fourwins.Exception.ColumnFullException;

import javax.sound.midi.Soundbank;

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
        } else {
            throw new ColumnFullException("Column is full!");
        }
    }

    public boolean canDrop(int column) {
        column -= 1;
        System.out.println(bord[0][column] == null);
        return bord[0][column] == null;
    }

    @Override
    public String toString() {
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
        return sb.toString();
    }
}
