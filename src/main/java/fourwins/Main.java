package fourwins;

import fourwins.Enums.Color;
import fourwins.Exception.ColumnFullException;
import fourwins.Exception.IllegalMoveException;

public class Main {
    public static void main(String[] args) {
        Bord b = new Bord();
        //System.out.println(b.getBord().length);
        //System.out.println(b.getBord()[0].length);
        //System.out.println(b.canDrop(1));

        try {
            b.dropToken(b.getToken(Color.YELLOW), 4);
            b.dropToken(b.getToken(Color.YELLOW), 4);
            b.dropToken(b.getToken(Color.RED), 4);
            b.dropToken(b.getToken(Color.YELLOW), 5);
            b.dropToken(b.getToken(Color.RED), 5);
            b.dropToken(b.getToken(Color.YELLOW), 5);
            b.dropToken(b.getToken(Color.RED), 6);
            b.dropToken(b.getToken(Color.RED), 6);
            b.dropToken(b.getToken(Color.RED), 6);
            b.dropToken(b.getToken(Color.YELLOW), 3);
            b.dropToken(b.getToken(Color.YELLOW), 3);
            b.dropToken(b.getToken(Color.RED), 3);
            b.dropToken(b.getToken(Color.RED), 3);
            //b.dropToken(2 ,new Token(Color.YELLOW));
            //b.dropToken(7 ,new Token(Color.RED));
        } catch (ColumnFullException | IllegalMoveException e) {
            System.out.println(e.getClass().getSimpleName());
        }
        System.out.println(b.toString());

        //JOptionPane.showMessageDialog(null, "Winner is: "+b.testVictory());


        System.out.println(b.isTie());
        System.out.println(b.hasToken(Color.YELLOW));
        System.out.println(b.hasToken(Color.RED));

        //System.out.println(new Token(Color.RED));

        //Cell c = new Cell(new Token(Color.YELLOW));
        //System.out.println(c.getToken().getColor() == Color.YELLOW);

        //b.bord[1][3] = s;
        //System.out.println(Arrays.toString(b.getBord()[0]));


        //System.out.println(b.canDrop(1));

    }
}
