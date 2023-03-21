package fourwins;

public class Cell extends GameObject {
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

    @Override
    public String toString() {
        String s;
        if(this.token == null){
            s = "[ ]";
        } else {
            s =  "[" + token.toString() + "]";
        }
        return s;
    }
}
