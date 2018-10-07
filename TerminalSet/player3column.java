package TerminalSet;

import Game.Board;
import Tree.Node;

public class player3column extends Node
{
    public int high;
    @Override
    public float evaluate(Board board,char myColor ,char enemyColor)
    {
        char b[][]=board.getBoard();
        float num=0;

        for (int i = Board.BOARD_HEIGHT - 3; i >= 0; i--) {
            for (int j = Board.BOARD_WIDTH - 1; j >= 0; j--) {
                if (b[i][j] ==myColor && b[i][j] == b[i + 1][j] && b[i][j] == b[i + 2][j])
                         {
                    num++;
                }
            }
        }

        return num;
    }
    @Override
    public String print() {
        return " player3column ";
    }
}
