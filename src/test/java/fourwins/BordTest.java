package fourwins;

import fourwins.Enums.Color;
import fourwins.Enums.Winner;
import fourwins.Exception.ColumnFullException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BordTest {
    Bord b1 = new Bord();
    Bord b2 = new Bord();
    Bord b3 = new Bord();


    @Before
    public void setUpBoard() {
        try {
            b1.dropToken(3, new Token(Color.YELLOW));
            b1.dropToken(4, new Token(Color.YELLOW));
            b1.dropToken(5, new Token(Color.YELLOW));
            b1.dropToken(5, new Token(Color.YELLOW));
            b1.dropToken(6, new Token(Color.YELLOW));
            b1.dropToken(7, new Token(Color.RED));
            b1.dropToken(7, new Token(Color.RED));
            b1.dropToken(7, new Token(Color.RED));
            b1.dropToken(7, new Token(Color.YELLOW));
            b1.dropToken(6, new Token(Color.RED));
            b1.dropToken(5, new Token(Color.RED));
            b1.dropToken(3, new Token(Color.RED));

            b2.dropToken(1, new Token(Color.YELLOW));
            b2.dropToken(2, new Token(Color.RED));
            b2.dropToken(3, new Token(Color.YELLOW));
            b2.dropToken(3, new Token(Color.RED));
            b2.dropToken(4, new Token(Color.RED));
            b2.dropToken(5, new Token(Color.YELLOW));
            b2.dropToken(5, new Token(Color.RED));
            b2.dropToken(5, new Token(Color.RED));
            b2.dropToken(5, new Token(Color.RED));
            b2.dropToken(5, new Token(Color.RED));
            b2.dropToken(6, new Token(Color.YELLOW));
            b2.dropToken(6, new Token(Color.RED));
            b2.dropToken(7, new Token(Color.YELLOW));
            b2.dropToken(7, new Token(Color.YELLOW));
            b2.dropToken(7, new Token(Color.YELLOW));

            b3.dropToken(4, new Token(Color.YELLOW));
            b3.dropToken(4, new Token(Color.YELLOW));
            b3.dropToken(4, new Token(Color.RED));
            b3.dropToken(4, new Token(Color.RED));
            b3.dropToken(5, new Token(Color.YELLOW));
            b3.dropToken(5, new Token(Color.YELLOW));
            b3.dropToken(5, new Token(Color.RED));
            b3.dropToken(6, new Token(Color.YELLOW));
            b3.dropToken(6, new Token(Color.RED));
            b3.dropToken(6, new Token(Color.YELLOW));
            b3.dropToken(7, new Token(Color.RED));
            b3.dropToken(7, new Token(Color.RED));
            b3.dropToken(7, new Token(Color.RED));
            b3.dropToken(7, new Token(Color.YELLOW));
        } catch (ColumnFullException e) {
            System.out.println(e.getMessage());
        }

    }

    @Test
    public void GameBoard1() {
        String testBoard1 = "[ ][ ][ ][ ][ ][ ][ ]\n[ ][ ][ ][ ][ ][ ][ ]\n[ ][ ][ ][ ][ ][ ][O]\n[ ][ ][ ][ ][X][ ][X]\n[ ][ ][X][ ][O][X][X]\n[ ][ ][O][O][O][O][X]\n";
        Assert.assertEquals(b1.toString(), testBoard1);
    }

    @Test
    public void GameBoard1TestWinner() {
        System.out.println("The winner is: " + b1.testVictory());
        Assert.assertNotEquals(b1.testVictory(), Winner.NONE);
    }

    @Test
    public void GameBoard2() {
        String testBoard2 = "[ ][ ][ ][ ][ ][ ][ ]\n[ ][ ][ ][ ][X][ ][ ]\n[ ][ ][ ][ ][X][ ][ ]\n[ ][ ][ ][ ][X][ ][O]\n[ ][ ][X][ ][X][X][O]\n[O][X][O][X][O][O][O]\n";
        Assert.assertEquals(b2.toString(), testBoard2);
    }

    @Test
    public void GameBoard2TestWinner() {
        System.out.println("The winner is: " + b2.testVictory());
        Assert.assertNotEquals(b2.testVictory(), Winner.NONE);
    }

    @Test
    public void GameBoard3() {
        String testBoard3 = "[ ][ ][ ][ ][ ][ ][ ]\n[ ][ ][ ][ ][ ][ ][ ]\n[ ][ ][ ][X][ ][ ][O]\n[ ][ ][ ][X][X][O][X]\n[ ][ ][ ][O][O][X][X]\n[ ][ ][ ][O][O][O][X]\n";
        Assert.assertEquals(b3.toString(), testBoard3);
    }

    @Test
    public void GameBoard3TestWinner() {
        System.out.println("The winner is: " + b3.testVictory());
        Assert.assertNotEquals(b3.testVictory(), Winner.NONE);
    }
}