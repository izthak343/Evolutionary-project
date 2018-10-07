package genetics;

import Players.treePlayer;
import Tree.Node;
import Tree.Population;
import Tree.nodeFactory;
import random.SingletonRandom;

public class variationOperators {
    //cross over function
    public static treePlayer crossOver(treePlayer tp1,treePlayer tp2,int maxHigh)
    {
        SingletonRandom rand=SingletonRandom.INSTANCE;
        Node ptr;
        if(rand.nextInt(2)==0)
        {
            int num=rand.nextInt(maxHigh+1);
            ptr=tp1.getRandomNode(num);
            ptr=tp2.combineWithTree(num,ptr);
        }
        else
        {
            int num=rand.nextInt(maxHigh+1);
            ptr=tp2.getRandomNode(num);
            ptr=tp1.combineWithTree(num,ptr);
        }
        return new treePlayer(ptr);
    }
    //mutation function
    public static treePlayer mutation(treePlayer tp1)
    {
        //get the head of the tree
        Node newTree= tp1.getRandomNode(0);
        Node ptr1=newTree;
        SingletonRandom rand=SingletonRandom.INSTANCE;
        int num=rand.nextInt(Population.dept+1);
        if(num==0)
            return new treePlayer(nodeFactory.buildTree(Population.dept));
        for (int i = 0; i < num-1; i++)
        {
            if(rand.nextInt(2)==0)
                ptr1=ptr1.getChildren().get(0);
            else
                ptr1=ptr1.getChildren().get(1);
        }
        if(rand.nextInt(2)==0)
            ptr1.getChildren().set(0,nodeFactory.buildTree(Population.dept-num));
        else
            ptr1.getChildren().set(1,nodeFactory.buildTree(Population.dept-num));
        return new treePlayer(newTree);

    }

}
