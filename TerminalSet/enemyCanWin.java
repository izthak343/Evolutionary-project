package TerminalSet;

import Game.Board;
import Tree.Node;

public class enemyCanWin extends Node
{
    public int high;
    @Override
    public float evaluate(Board board,char myColor ,char enemyColor)
    {
        char b[][]=board.getBoard();
        float num=0;

        for (int i = 1; i <=Board.BOARD_WIDTH ; i++) {
            Board copy=new Board(board);
            if(copy.insertToCol(i,enemyColor) && copy.checkWin() && board.getWiner()==enemyColor)
                num++;
        }

        return num;
    }
    @Override
    public String print() {
        return " enemyCanWin ";
    }
}
