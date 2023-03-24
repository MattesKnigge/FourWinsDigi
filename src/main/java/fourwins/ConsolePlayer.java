package fourwins;

import fourwins.Enums.Color;
import fourwins.Exception.ColumnFullException;
import fourwins.Exception.IllegalMoveException;

import java.io.IOException;
import java.util.Scanner;

public class ConsolePlayer extends Player {
    public ConsolePlayer(Color color, Bord bord) {
        super(color, bord);
    }

    @Override
    public void doTurn() throws ColumnFullException, IllegalMoveException, IOException {
        Scanner consoleReader = new Scanner(System.in);
        System.out.print("Which column do you want to drop your token in?");
        int columnIn = consoleReader.nextInt();
        super.doDrop(columnIn);
    }
}
