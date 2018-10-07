package Tree;

import Game.Board;

public interface INode
{
    public float evaluate(Board board,char myColor ,char enemyColor);
    public String print();

}
