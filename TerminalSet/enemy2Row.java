package TerminalSet;

import Game.Board;
import Tree.Node;

public class enemy2Row extends Node
{
    public int high;
    @Override
    public float evaluate(Board board,char myColor ,char enemyColor)
    {
        char b[][]=board.getBoard();
        float num=0;
        for (int i = Board.BOARD_HEIGHT - 1; i >= 0; i--) {
            for (int j = Board.BOARD_WIDTH - 2; j >= 0; j--) {
                if (b[i][j] == enemyColor && b[i][j] == b[i][j + 1]
                        ) {
                    num++;
                }
            }
        }
        return num;
    }
    @Override
    public String print() {
        return " enemy2Row ";
    }
}
