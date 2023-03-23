package fourwins;

import fourwins.Enums.Color;
import fourwins.Enums.Winner;
import fourwins.Exception.ColumnFullException;

public class Bord extends GameObject {
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
            for (int row = 0; row < bord[row].length - 1; row++) {
                if (bord[5 - row][column] == null) {
                    bord[5 - row][column] = new Cell(token);
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

    private boolean isRowVictory(Color color) {
        int counter = 0;
        for (int row = 0; row < bord.length; row++) {
            for (int column = 0; column < bord[row].length - 1; column++) {
                if (bord[row][column] == null) {
                } else if (bord[row][column].getToken().getColor().equals(color)) {
                    counter = counter + 1;
                    if (counter == 4) {
                        return true;
                    }
                } else {
                }
            }
            counter = 0;
        }
        return false;
    }

    private boolean isColumnVictory(Color color) {
        int counter = 0;
        for (int column = 0; column < bord[0].length; column++) {
            for (int row = 0; row < bord.length; row++) {
                if (bord[row][column] == null) {
                } else if (bord[row][column].getToken().getColor().equals(color)) {
                    counter = counter + 1;
                    if (counter == 4) {
                        return true;
                    }
                } else {
                }
            }
            counter = 0;
        }
        return false;
    }

    private boolean isDiagonalVictory(Color color) {
        // Check diagonal from top-left to bottom-right
        for (int row = 0; row <= bord.length - 4; row++) {
            for (int column = 0; column <= bord[0].length - 4; column++) {
                int counter = 0;
                for (int offset = 0; offset < 4; offset++) {
                    if (bord[row + offset][column + offset] == null) {
                        break;
                    } else if (bord[row + offset][column + offset].getToken().getColor().equals(color)) {
                        counter++;
                    } else {
                        break;
                    }
                    if (counter == 4) {
                        return true;
                    }
                }
            }
        }

        // Check diagonal from bottom-left to top-right
        for (int row = bord.length - 1; row >= 3; row--) {
            for (int column = 0; column <= bord[0].length - 4; column++) {
                int counter = 0;
                for (int offset = 0; offset < 4; offset++) {
                    if (bord[row - offset][column + offset] == null) {
                        break;
                    } else if (bord[row - offset][column + offset].getToken().getColor().equals(color)) {
                        counter++;
                    } else {
                        break;
                    }
                    if (counter == 4) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public Winner testVictory() {
        if (isColumnVictory(Color.RED) || isRowVictory(Color.RED) || isDiagonalVictory(Color.RED)) {
            return Winner.RED;
        } else if (isColumnVictory(Color.YELLOW) || isRowVictory(Color.YELLOW) || isDiagonalVictory(Color.YELLOW)) {
            return Winner.YELLOW;
        } else {
            return Winner.NONE;
        }
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
