package fourwins;

import fourwins.Enums.Color;

public class Token{
    private final Color color;
    //private final Player player;

    public Token(Color color) { //, Player player
        this.color = color;
        //this.player = null;
    }


    //public Player getPlayer() {
    //    return player;
    //}

    public Color getColor() {
        return color;
    }
}
