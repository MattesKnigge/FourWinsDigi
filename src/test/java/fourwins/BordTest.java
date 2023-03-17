package fourwins;

import fourwins.Enums.Color;
import fourwins.Exception.ColumnFullException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BordTest {
    Bord b1 = new Bord();
    Bord b2 = new Bord();
    Bord b3 = new Bord();


    @Before
    public void setUpBoard1() {
        try {
            b1.dropToken(3 ,new Token(Color.YELLOW));
            b1.dropToken(4 ,new Token(Color.YELLOW));
            b1.dropToken(5 ,new Token(Color.YELLOW));
            b1.dropToken(5 ,new Token(Color.YELLOW));
            b1.dropToken(6 ,new Token(Color.YELLOW));
            b1.dropToken(7 ,new Token(Color.RED));
            b1.dropToken(7 ,new Token(Color.RED));
            b1.dropToken(7 ,new Token(Color.RED));
            b1.dropToken(7 ,new Token(Color.YELLOW));
            b1.dropToken(6 ,new Token(Color.RED));
            b1.dropToken(5 ,new Token(Color.RED));
            b1.dropToken(3 ,new Token(Color.RED));

            b2.dropToken(1 ,new Token(Color.YELLOW));
            b2.dropToken(2 ,new Token(Color.RED));
            b2.dropToken(3 ,new Token(Color.YELLOW));
            b2.dropToken(3 ,new Token(Color.RED));
            b2.dropToken(4 ,new Token(Color.RED));
            b2.dropToken(5 ,new Token(Color.YELLOW));
            b2.dropToken(5 ,new Token(Color.RED));
            b2.dropToken(5 ,new Token(Color.RED));
            b2.dropToken(5 ,new Token(Color.RED));
            b2.dropToken(5 ,new Token(Color.RED));
            b2.dropToken(6 ,new Token(Color.YELLOW));
            b2.dropToken(6 ,new Token(Color.RED));
            b2.dropToken(7 ,new Token(Color.YELLOW));
            b2.dropToken(7 ,new Token(Color.YELLOW));
            b2.dropToken(7 ,new Token(Color.YELLOW));

            b3.dropToken(4 ,new Token(Color.YELLOW));
            b3.dropToken(4 ,new Token(Color.YELLOW));
            b3.dropToken(4 ,new Token(Color.RED));
            b3.dropToken(4 ,new Token(Color.RED));
            b3.dropToken(5 ,new Token(Color.YELLOW));
            b3.dropToken(5 ,new Token(Color.YELLOW));
            b3.dropToken(5 ,new Token(Color.RED));
            b3.dropToken(6 ,new Token(Color.YELLOW));
            b3.dropToken(6 ,new Token(Color.RED));
            b3.dropToken(6 ,new Token(Color.YELLOW));
            b3.dropToken(7 ,new Token(Color.RED));
            b3.dropToken(7 ,new Token(Color.RED));
            b3.dropToken(7 ,new Token(Color.RED));
            b3.dropToken(7 ,new Token(Color.YELLOW));
        }
        catch (ColumnFullException e) {
            System.out.println(e.getMessage());
        }

    }

    @Test
public void GameBoard1Test() {
    String testBoard1 = "[ ][ ][ ][ ][ ][ ][ ]\n[ ][ ][ ][ ][ ][ ][ ]\n[ ][ ][ ][ ][ ][ ][O]\n[ ][ ][ ][ ][X][ ][X]\n[ ][ ][X][ ][O][X][X]\n[ ][ ][O][O][O][O][X]\n";
    Assert.assertEquals(b1.toString(b1.buildBord()), testBoard1);
}
@Test
public void GameBoard2Test() {
    String testBoard2 = "[ ][ ][ ][ ][ ][ ][ ]\n[ ][ ][ ][ ][X][ ][ ]\n[ ][ ][ ][ ][X][ ][ ]\n[ ][ ][ ][ ][X][ ][O]\n[ ][ ][X][ ][X][X][O]\n[O][X][O][X][O][O][O]\n";
    Assert.assertEquals(b2.toString(b2.buildBord()), testBoard2);
}
@Test
public void GameBoard3Test() {
    String testBoard3 = "[ ][ ][ ][ ][ ][ ][ ]\n[ ][ ][ ][ ][ ][ ][ ]\n[ ][ ][ ][X][ ][ ][O]\n[ ][ ][ ][X][X][O][X]\n[ ][ ][ ][O][O][X][X]\n[ ][ ][ ][O][O][O][X]\n";
    Assert.assertEquals(b3.toString(b3.buildBord()), testBoard3);
}
}