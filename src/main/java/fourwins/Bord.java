package fourwins;

import fourwins.Exception.ColumnFullException;

public class Bord {
    private Cell[][] bord;

    public Bord() {
        this.bord = new Cell[6][7];
    }

    public Cell[][] getBord() {
        return bord;
    }

    public void dropToken(int columnIndex, Token token) throws ColumnFullException {
        columnIndex = columnIndex - 1;
        for (int i = 0; i < bord[columnIndex].length; i++) {
            if (bord[5-i][columnIndex] == null) {
                bord[5-i][columnIndex] = new Cell(token);
                break;
            }
        }
    }



    // in build rn
    public boolean canDrop(int columnIndex) {
        columnIndex = columnIndex - 1;
        for (int i = 0; i < bord[columnIndex].length; i++) {
            if (bord[5 - i][columnIndex] == null) {
                return true;
            }
        }
        return false;
    }

    public String printBoard() {
        StringBuilder sb = new StringBuilder();
        for (Cell[] x : bord) {
            sb.append(System.getProperty("line.separator"));
            for (Cell y : x) {
                if (y == null) {
                    sb.append(" [   ]");
                } else if (y.getToken().getColor() == Color.YELLOW) {
                    System.out.println(y.getToken().getColor());
                    sb.append(" [ O ]");
                } else if (y.getToken().getColor() == Color.RED) {
                    System.out.println(y.getToken().getColor());
                    sb.append(" [ X ]");
                }
            }

        }
        return sb.toString();
    }
}
