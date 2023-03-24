package fourwins;

import fourwins.Enums.Color;

/**
 * GameMain_Console class
 * starts a game with console input players
 */
public class GameMain_Console {
    public static void main(String[] args) {
        Bord bord = new Bord();
        Game game = new ConsoleGame(bord);
        Player player1 = new ConsolePlayer(Color.RED, bord);
        Player player2 = new ConsolePlayer(Color.YELLOW, bord);
        game.doGame(player1, player2);
    }
}
