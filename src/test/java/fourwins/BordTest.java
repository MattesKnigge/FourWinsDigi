package fourwins;

import fourwins.Enums.Color;
import fourwins.Enums.Winner;
import fourwins.Exception.ColumnFullException;
import fourwins.Exception.IllegalMoveException;
import org.junit.Assert;
import org.junit.Test;

/**
 * This class tests the game board.
 */

public class BordTest {

    @Test
    public void MocGameTest() {
        Bord mocBord = new Bord();
        Player player1 = new MocPlayer(Color.RED, mocBord, 1);
        Player player2 = new MocPlayer(Color.YELLOW, mocBord, 2);
        Game game = new ConsoleGame(mocBord);
        game.doGame(player1, player2);
        Assert.assertEquals(Winner.RED, mocBord.testVictory());
    }

    @Test
    public void GameBoard1() throws ColumnFullException, IllegalMoveException {
        Bord b1 = new Bord();

        b1.dropToken(b1.getToken(Color.YELLOW), 3);
        b1.dropToken(b1.getToken(Color.RED), 3);
        b1.dropToken(b1.getToken(Color.YELLOW), 5);
        b1.dropToken(b1.getToken(Color.YELLOW), 5);
        b1.dropToken(b1.getToken(Color.RED), 5);
        b1.dropToken(b1.getToken(Color.YELLOW), 6);
        b1.dropToken(b1.getToken(Color.RED), 6);
        b1.dropToken(b1.getToken(Color.RED), 7);
        b1.dropToken(b1.getToken(Color.RED), 7);
        b1.dropToken(b1.getToken(Color.RED), 7);
        b1.dropToken(b1.getToken(Color.YELLOW), 7);
        b1.dropToken(b1.getToken(Color.YELLOW), 4);

        String b11 = "[ ][ ][ ][ ][ ][ ][ ]\n[ ][ ][ ][ ][ ][ ][ ]\n[ ][ ][ ][ ][ ][ ][O]\n[ ][ ][ ][ ][X][ ][X]\n[ ][ ][X][ ][O][X][X]\n[ ][ ][O][O][O][O][X]\n";
        Assert.assertEquals(b1.toString(), b11);
        Assert.assertNotEquals(b1.testVictory(), Winner.NONE);
    }

    @Test
    public void GameBoard2() throws ColumnFullException, IllegalMoveException {
        Bord b2 = new Bord();

        b2.dropToken(b2.getToken(Color.YELLOW), 1);
        b2.dropToken(b2.getToken(Color.RED), 2);
        b2.dropToken(b2.getToken(Color.YELLOW), 3);
        b2.dropToken(b2.getToken(Color.RED), 3);
        b2.dropToken(b2.getToken(Color.RED), 4);
        b2.dropToken(b2.getToken(Color.YELLOW), 6);
        b2.dropToken(b2.getToken(Color.RED), 6);
        b2.dropToken(b2.getToken(Color.YELLOW), 7);
        b2.dropToken(b2.getToken(Color.YELLOW), 7);
        b2.dropToken(b2.getToken(Color.YELLOW), 7);
        b2.dropToken(b2.getToken(Color.YELLOW), 5);
        b2.dropToken(b2.getToken(Color.RED), 5);
        b2.dropToken(b2.getToken(Color.RED), 5);
        b2.dropToken(b2.getToken(Color.RED), 5);
        b2.dropToken(b2.getToken(Color.RED), 5);

        String b12 = "[ ][ ][ ][ ][ ][ ][ ]\n[ ][ ][ ][ ][X][ ][ ]\n[ ][ ][ ][ ][X][ ][ ]\n[ ][ ][ ][ ][X][ ][O]\n[ ][ ][X][ ][X][X][O]\n[O][X][O][X][O][O][O]\n";
        Assert.assertEquals(b2.toString(), b12);
        Assert.assertNotEquals(b2.testVictory(), Winner.NONE);
    }

    @Test
    public void GameBoard3() throws ColumnFullException, IllegalMoveException {
        Bord b3 = new Bord();

        b3.dropToken(b3.getToken(Color.YELLOW), 5);
        b3.dropToken(b3.getToken(Color.YELLOW), 5);
        b3.dropToken(b3.getToken(Color.RED), 5);
        b3.dropToken(b3.getToken(Color.YELLOW), 6);
        b3.dropToken(b3.getToken(Color.RED), 6);
        b3.dropToken(b3.getToken(Color.YELLOW), 6);
        b3.dropToken(b3.getToken(Color.RED), 7);
        b3.dropToken(b3.getToken(Color.RED), 7);
        b3.dropToken(b3.getToken(Color.RED), 7);
        b3.dropToken(b3.getToken(Color.YELLOW), 4);
        b3.dropToken(b3.getToken(Color.YELLOW), 4);
        b3.dropToken(b3.getToken(Color.RED), 4);
        b3.dropToken(b3.getToken(Color.RED), 4);

        String b13 = "[ ][ ][ ][ ][ ][ ][ ]\n[ ][ ][ ][ ][ ][ ][ ]\n[ ][ ][ ][X][ ][ ][ ]\n[ ][ ][ ][X][X][O][X]\n[ ][ ][ ][O][O][X][X]\n[ ][ ][ ][O][O][O][X]\n";
        Assert.assertEquals(b3.toString(), b13);
        Assert.assertNotEquals(b3.testVictory(), Winner.NONE);
    }

    @Test
    public void GameBoard4() throws ColumnFullException, IllegalMoveException {
        Bord b4 = new Bord();
        for (int i = 0; i < 3; i++) {
            b4.dropToken(b4.getToken(Color.RED), 1);
            b4.dropToken(b4.getToken(Color.RED), 2);
            b4.dropToken(b4.getToken(Color.RED), 3);
            b4.dropToken(b4.getToken(Color.YELLOW), 4);
            b4.dropToken(b4.getToken(Color.RED), 5);
            b4.dropToken(b4.getToken(Color.RED), 6);
            b4.dropToken(b4.getToken(Color.RED), 7);

            b4.dropToken(b4.getToken(Color.YELLOW), 1);
            b4.dropToken(b4.getToken(Color.YELLOW), 2);
            b4.dropToken(b4.getToken(Color.YELLOW), 3);
            b4.dropToken(b4.getToken(Color.RED), 4);
            b4.dropToken(b4.getToken(Color.YELLOW), 5);
            b4.dropToken(b4.getToken(Color.YELLOW), 6);
            b4.dropToken(b4.getToken(Color.YELLOW), 7);
        }

        String b14 = "[O][O][O][X][O][O][O]\n[X][X][X][O][X][X][X]\n[O][O][O][X][O][O][O]\n[X][X][X][O][X][X][X]\n[O][O][O][X][O][O][O]\n[X][X][X][O][X][X][X]\n";
        Assert.assertEquals(b4.toString(), b14);
        Assert.assertEquals(b4.testVictory(), Winner.TIE);
    }
}