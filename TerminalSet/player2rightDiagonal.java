package TerminalSet;

import Game.Board;
import Tree.Node;

public class player2rightDiagonal extends Node
{
    public int high;
    @Override
    public float evaluate(Board board,char myColor ,char enemyColor)
    {
        char b[][]=board.getBoard();
        float num=0;

        for (int i = Board.BOARD_HEIGHT - 2; i >= 0; i--) {
            for (int j = Board.BOARD_WIDTH - 2; j >= 0; j--) {
                if (b[i][j] == myColor && b[i][j] == b[i + 1][j + 1]
                        )
                         {
                    num++;
                }
            }
        }
        return num;
    }
    @Override
    public String print() {
        return " player2rightDiagonal ";
    }
}
