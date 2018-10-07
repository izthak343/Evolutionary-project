package Tree;

import java.io.Serializable;
import java.util.List;

public abstract class Node implements INode ,Serializable
{
    public List<Node> children;
    //public static final int MAX_DEPTH =5;
    public Node(){};
    public Node(Node n)
    {
        super();
    }
    public List<Node> getChildren() {
        return children;
    }

}
