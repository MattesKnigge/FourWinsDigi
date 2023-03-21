package fourwins;

import com.sun.source.tree.ReturnTree;
import fourwins.Enums.Color;

public class Token extends GameObject{
    private final Color color;


    public Token(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    @Override
    public String toString() {
        String s = "";
        s = switch (color) {
            case RED -> "X";
            case YELLOW -> "O";
        };
        return s;
    }
}
