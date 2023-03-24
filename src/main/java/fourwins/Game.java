package fourwins;

/**
 * Game class for the four wins game.
 * This class is the base class for the game.
 * It contains the game board and the players.
 * It also contains the swapPlayer method, which swaps the current player.
 * The doGame method is abstract and must be implemented in the subclasses.
 * The doGame method contains the game logic.
 * The doGame method is called in the main method of the ConsoleGame class.
 */
public abstract class Game {
    Bord bord;
    Player currentPlayer;
    Player player1;
    Player player2;

    /**
     * Constructor for Game class
     *
     * @param bord the game board
     */
    public Game(Bord bord) {
        this.bord = bord;
    }

    /**
     * swaps the current player
     */
    protected void swapPlayer() {
        if (currentPlayer == player1) {
            currentPlayer = player2;
        } else {
            currentPlayer = player1;
        }
    }

    public abstract void doGame(Player player1, Player player2);
}
