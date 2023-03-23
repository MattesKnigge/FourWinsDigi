package fourwins;

import fourwins.Enums.Color;
import fourwins.Exception.ColumnFullException;
import fourwins.Cell;

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
        return bord[0][column] == null;
    }

    public boolean isRowVictory(Color color) {
        int counter = 0;
        for (int row = 0; row < bord.length; row++) {
            for (int column = 0; column < bord[row].length-1; column++) {
                if (bord[row][column] == null) {
                    continue;
                }
                else if (bord[row][column].getToken().getColor() == color) {
                    counter = counter+1;
                    if (counter == 4) {
                        return true;
                    }
                } else {
                    continue;
                }

            }
            counter = 0;

        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < bord.length; i++) {
            for (int j = 0; j < bord[i].length; j++) {
                if (bord[i][j] == null) {
                    sb.append("[ ]"); // cheap solution, too stupid atm
                } else {
                    sb.append(bord[i][j].toString());
                }
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
