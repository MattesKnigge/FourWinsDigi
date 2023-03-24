package fourwins;

import fourwins.Enums.Color;

/**
 * A token is a game object that can be placed on a board.
 * It has a color, which can be red or yellow.
 * The color of a token is used to determine the winner of the game.
 */

public class Token extends GameObject {
    private final Color color;

    /**
     * Constructor for Token
     *
     * @param color the color of the token
     */

    public Token(Color color) {
        this.color = color;
    }

    /**
     * gets color
     *
     * @return the color of the token
     */
    public Color getColor() {
        return color;
    }

    /**
     * toString method for Token
     *
     * @return the string representation of the token
     */
    @Override
    public String toString() {
        String s;
        s = switch (color) {
            case RED -> "X";
            case YELLOW -> "O";
        };
        return s;
    }
}
