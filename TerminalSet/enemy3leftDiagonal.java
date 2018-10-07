package TerminalSet;

import Game.Board;
import Tree.Node;

public class enemy3leftDiagonal extends Node
{
    public int high;
    @Override
    public float evaluate(Board board,char myColor ,char enemyColor)
    {
        char b[][]=board.getBoard();
        float num=0;

        for (int i = Board.BOARD_HEIGHT - 4; i >= 0; i--) {
            for (int j = Board.BOARD_WIDTH-1; j >= Board.BOARD_WIDTH - 3; j--) {
                if (b[i][j] == enemyColor && b[i][j] == b[i + 1][j - 1]
                        && b[i][j] == b[i + 2][j - 2]
                        ) {
                    num++;
                }
            }
        }

        return num;
    }
    @Override
    public String print() {
        return " enemy3leftDiagonal ";
    }
}
