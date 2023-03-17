package fourwins;

public class Cell {
    private Token token;

    public Cell(Token token) {
        this.token = token;
    }

    public void setToken(Token token) {
        this.token = token;
    }

    public Token getToken() {
        return token;
    }
}
