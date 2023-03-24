package fourwins;

public abstract class Game {
    Bord bord;
    Player currentPlayer;
    Player player1;
    Player player2;

    public Game(Bord bord) {
        this.bord = bord;
    }

    protected void swapPlayer() {
        if (currentPlayer == player1) {
            currentPlayer = player2;
        } else {
            currentPlayer = player1;
        }
    }

    public abstract void doGame(Player player1, Player player2);
}
