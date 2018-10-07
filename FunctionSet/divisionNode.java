package FunctionSet;

import Game.Board;
import Tree.Node;

import java.util.ArrayList;
import java.util.List;

public class divisionNode extends Node {
    public divisionNode()
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
        float x=children.get(1).evaluate(board,myColor,enemyColor);
        if(x!=0)
            return children.get(0).evaluate(board,myColor,enemyColor)/x;
        else return children.get(0).evaluate(board,myColor,enemyColor);
    }
    public String print() {
        return "("+children.get(0).print()+"/"+children.get(1).print()+")";
    }
}
