package Players;

import Game.Board;
import Tree.Node;
import Tree.nodeFactory;
import random.SingletonRandom;

import java.io.Serializable;

public class treePlayer implements  Player ,Serializable,Comparable<treePlayer>
{
    Node tree;
    int rank;
    public String name;
    public treePlayer(int depth)
    {
        tree = nodeFactory.buildTree(depth);
        rank=0;
    }
    public treePlayer(Node tree)
    {
        this.tree=tree;
        rank=0;
    }
    public treePlayer(treePlayer tp)
    {
        tree = nodeFactory.createCopy(tp.tree);
        rank=0;
    }

    @Override
    //return the index to play without minimax
    public int play(Board board, char myColor, char enemyColor) {
        int maxIndex=-1;
        float max=-1;
        boolean sec=false;
        float num;
        for (int i = 0; i < Board.BOARD_WIDTH; i++)
        {
            Board copy =new Board(board);
            if(copy.insertToCol(i+1,myColor))
            {
                num=eval(copy,myColor,enemyColor);
                if(!sec)
                {
                    max=num;
                    maxIndex=i+1;
                    sec=true;
                }
                else
                {
                    if(num>max)
                    {
                        max = num;
                        maxIndex = i + 1;
                    }
                }
            }
        }
        return maxIndex;
    }
    //eval board
    public float eval(Board board, char myColor, char enemyColor)
    {
        return tree.evaluate(board,myColor,enemyColor);
    }
    public String print()
    {
        return tree.print();
    }
    public void setRank(int num){rank+=num;}
    @Override
    public int compareTo(treePlayer tp)
    {
        return tp.rank-this.rank;
    }
    public int getRank() {
        return rank;
    }
    //return a random node in the tree
    public Node getRandomNode(int depth)
    {
        Node ptr1=nodeFactory.createCopy(tree);
        SingletonRandom rand=SingletonRandom.INSTANCE;
        for (int i = 0; i < depth; i++)
        {
            if(rand.nextInt(2)==0)
                ptr1=ptr1.getChildren().get(0);
            else
                ptr1=ptr1.getChildren().get(1);
        }
        return ptr1;
    }
    //return new tree-combination of this tree with other
    public Node combineWithTree(int depth,Node n)
    {
        Node ptr= nodeFactory.createCopy(tree);
        Node ptr1=ptr;
        SingletonRandom rand=SingletonRandom.INSTANCE;
        if(depth==0)
            return ptr;
        for (int i = 0; i < depth-1; i++)
        {
            if(rand.nextInt(2)==0)
                ptr1=ptr1.getChildren().get(0);
            else
                ptr1=ptr1.getChildren().get(1);
        }
        if (rand.nextInt(2) == 0)
            ptr1.getChildren().set(0, n);
        else
            ptr1.getChildren().set(1, n);
        return ptr;





    }



}
