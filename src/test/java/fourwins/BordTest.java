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
        printWinner(b1);
        Assert.assertNotEquals(b1.testVictory(), Winner.NONE);
    }

    @Test
    public void GameBoard2() {
        String testBoard2 = "[ ][ ][ ][ ][ ][ ][ ]\n[ ][ ][ ][ ][X][ ][ ]\n[ ][ ][ ][ ][X][ ][ ]\n[ ][ ][ ][ ][X][ ][O]\n[ ][ ][X][ ][X][X][O]\n[O][X][O][X][O][O][O]\n";
        Assert.assertEquals(b2.toString(), testBoard2);
    }

    @Test
    public void GameBoard2TestWinner() {
        printWinner(b2);
        Assert.assertNotEquals(b2.testVictory(), Winner.NONE);
    }

    @Test
    public void GameBoard3() {
        String testBoard3 = "[ ][ ][ ][ ][ ][ ][ ]\n[ ][ ][ ][ ][ ][ ][ ]\n[ ][ ][ ][X][ ][ ][O]\n[ ][ ][ ][X][X][O][X]\n[ ][ ][ ][O][O][X][X]\n[ ][ ][ ][O][O][O][X]\n";
        Assert.assertEquals(b3.toString(), testBoard3);
    }

    @Test
    public void GameBoard3TestWinner() {
        /*
         * We have encountered a situation where there could be two winners with the current given information.
         * The issue is that we don't know the order in which the yellow and red tokens are dropped.
         * This could result in both players connecting four tokens in a row/column/diagonal at the same time.
         *
         * We have implemented a solution that makes the most sense with the information given.
         * But we acknowledge that there could be other valid solutions.
         * We will continue to refine our program to handle all possible scenarios.
         *
         * In future project tasks we will check for the winner after every token drop.
         * So the following situation would not be possible
         */
        printWinner(b3);
        Assert.assertNotEquals(b3.testVictory(), Winner.NONE);
    }

    /*
     * Fun method for packaged win conditions
     * Not part of the exercise.
     */
    private void printWinner(Bord bord) {
        System.out.println("The winner for the following bord:\n\n" + bord.toString() + "\nis: " + bord.testVictory());
    }
}