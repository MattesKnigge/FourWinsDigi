package fourwins;

/**
 * This class represents a cell in the game board.
 * It contains a token, which can be null.
 * It also contains a toString method, which returns a string representation of the cell.
 * If the cell contains a token, the string representation of the token is returned.
 * If the cell does not contain a token, a string representation of an empty cell is returned.
 * The string representation of an empty cell ind the CLI is "[ ]".
 */
public class Cell extends GameObject {
    private Token token;

    /**
     * Constructor for Cell
     *
     * @param token the token that is placed in the cell
     */
    public Cell(Token token) {
        this.token = token;
    }

    /**
     * gets token
     *
     * @return the token that is placed in the cell
     */
    public Token getToken() {
        return token;
    }

    /**
     * sets token
     *
     * @param token the token that is placed in the cell
     */
    public void setToken(Token token) {
        this.token = token;
    }

    /**
     * toString method for Cell
     *
     * @return the string representation of the cell
     */
    @Override
    public String toString() {
        String s;
        if (this.token == null) {
            s = "[ ]";
        } else {
            s = "[" + token.toString() + "]";
        }
        return s;
    }
}
