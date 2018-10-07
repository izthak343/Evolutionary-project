package FunctionSet;

import Game.Board;
import Tree.Node;

import java.util.ArrayList;
import java.util.List;

public class subNode extends Node
{
    public subNode()
    {
        children = new ArrayList<Node>();
    }
    public List<Node> getChildren() {
        return children;
    }
    public int high;


    @Override
    public float evaluate(Board board,char myColor ,char enemyColor)
    {
        return children.get(0).evaluate(board,myColor,enemyColor)-children.get(1).evaluate(board,myColor,enemyColor);
    }
    public String print() {
        return "("+children.get(0).print()+"-"+children.get(1).print()+")";
    }
}
