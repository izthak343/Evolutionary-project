package FunctionSet;

import Game.Board;
import Tree.Node;

import java.util.ArrayList;
import java.util.List;

public class addNode extends Node
{
    public addNode()
    {
        children = new ArrayList<Node>();
    }
    public int high;
    public List<Node> getChildren() {
        return children;
    }

    @Override
    public float evaluate(Board board,char myColor ,char enemyColor)
    {
        return children.get(0).evaluate(board,myColor,enemyColor)+children.get(1).evaluate(board,myColor,enemyColor);
    }
    public String print() {
        return "("+children.get(0).print()+"+"+children.get(1).print()+")";
    }
}
