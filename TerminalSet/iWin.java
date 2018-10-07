package TerminalSet;

import Game.Board;
import Tree.Node;

public class iWin extends Node
{
    public int high;
    @Override
    public float evaluate(Board board,char myColor ,char enemyColor)
    {
        if(board.checkWin() && board.getWiner()==myColor)
            return  1;
        else return 0;
    }
    @Override
    public String print() {
        return " iWin ";
    }

//    @Override
//    public String toString() {
//        return " iWin ";
//    }
}
