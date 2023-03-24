package fourwins;

import fourwins.Enums.Color;
import fourwins.Enums.Winner;
import fourwins.Exception.ColumnFullException;
import fourwins.Exception.IllegalMoveException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Bord extends GameObject {
    private ArrayList<ArrayList<Cell>> bord;

    private HashMap<Color, ArrayList<Token>> tokenStore = new HashMap<>();

    public Bord() {
        this.bord = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            ArrayList<Cell> row = new ArrayList<>();
            for (int j = 0; j < 7; j++) {
                row.add(null);
            }
            bord.add(row);
        }
        this.tokenStore.put(Color.RED, Stream.generate(() -> new Token(Color.RED))
                .limit(21)
                .collect(Collectors.toCollection(ArrayList::new)));

        this.tokenStore.put(Color.YELLOW, Stream.generate(() -> new Token(Color.YELLOW))
                .limit(21)
                .collect(Collectors.toCollection(ArrayList::new)));
    }

    public Token getToken(Color color) {
        if (color == Color.RED) {
            return tokenStore.get(Color.RED).remove(0);
        } else if (color == Color.YELLOW) {
            return tokenStore.get(Color.YELLOW).remove(0);
        } else {
            return null;
        }
    }

    public boolean hasToken(Color color) {
        if (color == Color.RED) {
            return (tokenStore.get(Color.RED).size() != 0);
        } else {
            return (tokenStore.get(Color.YELLOW).size() != 0);
        }
    }

    public boolean isTie() {
        if (hasToken(Color.RED) && hasToken(Color.YELLOW)) {
            return false;
        } else {
            return true;
        }
    }

    public ArrayList<ArrayList<Cell>> getBord() {
        return bord;
    }

    public void dropToken(Token token, int column) throws ColumnFullException, IllegalMoveException {
        if (testVictory().equals(Winner.RED) || testVictory().equals(Winner.YELLOW)) {
            throw new IllegalMoveException();
        }
        if (canDrop(column)) {
            column -= 1;
            for (int row = 0; row < bord.size(); row++) {
                if (bord.get(5 - row).get(column) == null) {
                    bord.get(5 - row).set(column, new Cell(token));
                    break;
                }
            }
        } else {
            throw new ColumnFullException("Column is full!");
        }
    }

    public boolean canDrop(int column) {
        column -= 1;
        return bord.get(0).get(column) == null;
    }

    private boolean isRowVictory(Color color) {
        int counter = 0;
        for (int row = 0; row < bord.size(); row++) {
            for (int column = 0; column < bord.get(row).size() - 1; column++) {
                if (bord.get(row).get(column) == null) {
                } else if (bord.get(row).get(column).getToken().getColor().equals(color)) {
                    counter = counter + 1;
                    if (counter == 4) {
                        System.out.println("Is row victory");
                        return true;
                    }
                } else {
                    counter = 0;
                }
            }
            counter = 0;
        }
        return false;
    }

    private boolean isColumnVictory(Color color) {
        int counter = 0;
        for (int column = 0; column < bord.get(0).size(); column++) {
            for (int row = 0; row < bord.size(); row++) {
                if (bord.get(row).get(column) == null) {
                } else if (bord.get(row).get(column).getToken().getColor().equals(color)) {
                    counter = counter + 1;
                    if (counter == 4) {
                        System.out.println("Is column victory");
                        return true;
                    }
                } else {
                    counter = 0;
                }
            }
            counter = 0;
        }
        return false;
    }

    private boolean isDiagonalVictory(Color color) {
        // Check diagonal from top-left to bottom-right
        for (int row = 0; row <= bord.size() - 4; row++) {
            for (int column = 0; column <= bord.get(0).size() - 4; column++) {
                int counter = 0;
                for (int offset = 0; offset < 4; offset++) {
                    if (bord.get(row + offset).get(column + offset) == null) {
                        break;
                    } else if (bord.get(row + offset).get(column + offset).getToken().getColor().equals(color)) {
                        counter++;
                    } else {
                        break;
                    }
                    if (counter == 4) {
                        System.out.println("Is diagonal victory");
                        return true;
                    }
                }
            }
        }

        // Check diagonal from bottom-left to top-right
        for (int row = bord.size() - 1; row >= 3; row--) {
            for (int column = 0; column <= bord.get(0).size() - 4; column++) {
                int counter = 0;
                for (int offset = 0; offset < 4; offset++) {
                    if (bord.get(row - offset).get(column + offset) == null) {
                        break;
                    } else if (bord.get(row - offset).get(column + offset).getToken().getColor().equals(color)) {
                        counter++;
                    } else {
                        break;
                    }
                    if (counter == 4) {
                        System.out.println("Is diagonal victory");
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public Winner testVictory() {
        if (isTie()) {
            return Winner.TIE;
        } else {
            if (isColumnVictory(Color.RED) || isRowVictory(Color.RED) || isDiagonalVictory(Color.RED)) {
                return Winner.RED;
            } else if (isColumnVictory(Color.YELLOW) || isRowVictory(Color.YELLOW) || isDiagonalVictory(Color.YELLOW)) {
                return Winner.YELLOW;
            } else {
                return Winner.NONE;
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < bord.size(); i++) {
            for (int j = 0; j < bord.get(i).size(); j++) {
                if (bord.get(i).get(j) == null) {
                    sb.append("[ ]"); // cheap solution, too stupid atm
                } else {
                    sb.append(bord.get(i).get(j).toString());
                }
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
