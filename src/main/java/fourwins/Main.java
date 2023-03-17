package fourwins;

import fourwins.Exception.ColumnFullException;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Bord b = new Bord();
        System.out.println(b.getBord().length);
        System.out.println(b.getBord()[0].length);


        try {
            b.dropToken(1 ,new Token(Color.RED));
            b.dropToken(2 ,new Token(Color.RED));
            b.dropToken(3 ,new Token(Color.YELLOW));
            b.dropToken(1 ,new Token(Color.YELLOW));
            b.dropToken(2 ,new Token(Color.RED));
            b.dropToken(1 ,new Token(Color.RED));
            b.dropToken(1 ,new Token(Color.RED));
            b.dropToken(1 ,new Token(Color.RED));
            b.dropToken(1 ,new Token(Color.RED));


        }
        catch (ColumnFullException e) {
            System.out.println(e.getMessage());
        }



        System.out.println(new Token(Color.RED));

        Cell c = new Cell(new Token(Color.YELLOW));
        System.out.println(c.getToken().getColor() == Color.YELLOW);

        //b.bord[1][3] = s;
        System.out.println(Arrays.toString(b.getBord()[0]));
        System.out.println(b.printBoard());

        System.out.println(b.canDrop(1));

    }
}
