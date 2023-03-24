package fourwins;

import fourwins.Enums.Color;
import fourwins.Enums.Winner;
import fourwins.Exception.ColumnFullException;
import fourwins.Exception.IllegalMoveException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;
// write comments for this class

/**
 * @author Jannes Bikker and Mattes Knigge
 * @version 1.0
 * @since 1.0
 * The class Bord is the class that contains the game board and the tokens.
 * It also contains the methods to drop tokens and check for a winner.
 */
public class Bord extends GameObject {
    private ArrayList<ArrayList<Cell>> bord;

    private HashMap<Color, ArrayList<Token>> tokenStore = new HashMap<>();

    /**
     * Constructor for Bord
     * Creates a new bord with 6 rows and 7 columns.
     * Creates 21 tokens for each color and adds them to the tokenStore.
     * The tokenStore is a HashMap that contains the color as key and an ArrayList of tokens as value.
     * The ArrayList of tokens is used to keep track of the tokens that are still available.
     * The tokens are added to the bord in the constructor.
     */
    public Bord() {
        this.bord = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            ArrayList<Cell> row = new ArrayList<>();
            for (int j = 0; j < 7; j++) {
                row.add(null);
            }
            bord.add(row);
        }
        this.tokenStore.put(Color.RED, Stream.generate(() -> new Token(Color.RED)) // generate a stream of tokens
                .limit(21) // 21 tokens per color (red in this case)
                .collect(Collectors.toCollection(ArrayList::new))); // collect the stream to an ArrayList

        this.tokenStore.put(Color.YELLOW, Stream.generate(() -> new Token(Color.YELLOW))
                .limit(21)
                .collect(Collectors.toCollection(ArrayList::new)));
    }

    /**
     * gets bord
     *
     * @return the bord
     */
    public ArrayList<ArrayList<Cell>> getBord() {
        return bord;
    }

    /**
     * gets token from tokenStore
     *
     * @param color the color of the token
     * @return the token
     */
    public Token getToken(Color color) {
        if (color == Color.RED) {
            return tokenStore.get(Color.RED).remove(0);
        } else if (color == Color.YELLOW) {
            return tokenStore.get(Color.YELLOW).remove(0);
        } else {
            return null;
        }
    }

    /**
     * Checks if a player has Tokens left
     *
     * @param color the color of the player
     * @return true if the player has tokens left, false if not
     */
    public boolean hasToken(Color color) {
        if (color == Color.RED) {
            return (tokenStore.get(Color.RED).size() != 0);
        } else {
            return (tokenStore.get(Color.YELLOW).size() != 0);
        }
    }

    /**
     * Checks if game is a tie
     *
     * @return true if game is a tie, false if not
     */
    public boolean isTie() {
        if (hasToken(Color.RED) && hasToken(Color.YELLOW)) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * drops a token in a column if possible
     *
     * @param token  the token to be dropped
     * @param column the column to drop the token in
     * @throws ColumnFullException
     * @throws IllegalMoveException
     */
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

    /**
     * Checks if player can drop a token in a column
     *
     * @param column the column to be checked
     * @return true if player can drop a token in the column, false if not
     */
    public boolean canDrop(int column) {
        column -= 1;
        return bord.get(0).get(column) == null;
    }

    /**
     * Checks if it is a victory via a row
     *
     * @param color the color of the player
     * @return true if it is a victory via a row, false if not
     */
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

    /**
     * Checks if it is a victory via a column
     *
     * @param color the color of the player
     * @return true if it is a victory via a column, false if not
     */
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

    /**
     * Checks if it is a victory via a diagonal
     *
     * @param color the color of the player
     * @return true if it is a victory via a diagonal, false if not
     */
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

    /**
     * Checks if a player has won
     *
     * @return true if a player has won, false if not
     */
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

    /**
     * toString method
     *
     * @return the board as a string
     */
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
