package Players;

import Game.Board;

import java.util.Scanner;

public class humanPlayer implements  Player {
    @Override
    public int play(Board board, char First, char Second)
    {
        Scanner s = new Scanner(System.in);
        board.print();
        System.out.print("Select a column: ");
        return s.nextInt();
    }
}
