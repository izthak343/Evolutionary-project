package Tree;

import FunctionSet.*;
import TerminalSet.*;
import random.SingletonRandom;

public class nodeFactory
{
   //build a tree
    public static Node buildTree(int depth)
    {
        SingletonRandom rand = SingletonRandom.INSTANCE;
        return build(depth,rand);
    }
    public static Node build(int depth,SingletonRandom rand)
    {
        Node node;
        if(depth>0)
        {
            int num=rand.nextInt(4);
            switch (num)
            {
                case 0:
                    node=new addNode();
                    node.getChildren().add(build(depth-1,rand ));
                    node.getChildren().add(build(depth-1,rand ));
                    break;
                case 1:
                    node=new subNode();
                    node.getChildren().add(build(depth-1,rand ));
                    node.getChildren().add(build(depth-1,rand ));
                    break;
                case 2:
                    node=new divisionNode();
                    node.getChildren().add(build(depth-1,rand ));
                    node.getChildren().add(build(depth-1,rand ));
                    break;
                default:
                    node=new multiplicationNode();
                    node.getChildren().add(build(depth-1,rand ));
                    node.getChildren().add(build(depth-1,rand ));
                    break;
            }
        }
        else
        {
            int num=rand.nextInt(18);
            switch (num)
            {
                case 0:
                    node=new enemy2column();
                    break;
                case 1:
                    node=new enemy2leftDiagonal();
                    break;
                case 2:
                    node=new enemy2rightDiagonal();
                    break;
                case 3:
                    node=new enemy2Row();
                    break;
                case 4:
                    node=new enemy3column();
                    break;
                case 5:
                    node=new enemy3leftDiagonal();
                    break;
                case 6:
                    node=new enemy3rightDiagonal();
                    break;
                case 7:
                    node=new enemy3Row();
                    break;
                case 8:
                    node=new enemyCanWin();
                    break;
                case 9:
                    node=new iWin();
                    break;
                case 10:
                    node=new player2column();
                    break;
                case 11:
                    node=new player2leftDiagonal();
                    break;
                case 12:
                    node=new player2rightDiagonal();
                    break;
                case 13:
                    node=new player2Row();
                    break;
                case 14:
                    node=new player3column();
                    break;
                case 15:
                    node=new player3leftDiagonal();
                    break;
                case 16:
                    node=new player3rightDiagonal();
                    break;
                default:
                    node=new player3Row();
                    break;
            }
        }
        return node;
    }
    //create a copy of a node
    public static Node createCopy(Node n)
    {
        Node n1;
         if(n instanceof divisionNode)
        {
            n1=new divisionNode();
            n1.getChildren().add(createCopy(n.getChildren().get(0) ));
            n1.getChildren().add(createCopy(n.getChildren().get(1) ));
        }
        else if(n instanceof multiplicationNode)
        {
            n1=new multiplicationNode();
            n1.getChildren().add(createCopy(n.getChildren().get(0) ));
            n1.getChildren().add(createCopy(n.getChildren().get(1) ));
        }
        else if(n instanceof subNode)
        {
            n1=new subNode();
            n1.getChildren().add(createCopy(n.getChildren().get(0) ));
            n1.getChildren().add(createCopy(n.getChildren().get(1) ));
        }
         else if(n instanceof addNode)
         {
             n1=new addNode();
             n1.getChildren().add(createCopy(n.getChildren().get(0) ));
             n1.getChildren().add(createCopy(n.getChildren().get(1) ));
         }
        else if(n instanceof enemy2column)
        {
            n1=new enemy2column();
        }
        else if(n instanceof enemy2leftDiagonal)
        {
            n1=new enemy2leftDiagonal();
        }
        else if(n instanceof enemy2rightDiagonal)
        {
            n1=new enemy2rightDiagonal();
        }
        else if(n instanceof enemy2Row)
        {
            n1=new enemy2Row();
        }
        else if(n instanceof enemy3column)
        {
            n1=new enemy3column();
        }
        else if(n instanceof enemy3leftDiagonal)
        {
            n1=new enemy3leftDiagonal();
        }
        else if(n instanceof enemy3rightDiagonal)
        {
            n1=new enemy3rightDiagonal();
        }
        else if(n instanceof enemy3Row)
        {
            n1=new enemy3Row();
        }
        else if(n instanceof enemyCanWin)
        {
            n1=new enemyCanWin();
        }
        else if(n instanceof player2column)
        {
            n1=new player2column();
        }
        else if(n instanceof player2leftDiagonal)
        {
            n1=new player2leftDiagonal();
        }
        else if(n instanceof player2rightDiagonal)
        {
            n1=new player2rightDiagonal();
        }
        else if(n instanceof player2Row)
        {
            n1=new player2Row();
        }
        else if(n instanceof player3column)
        {
            n1=new player3column();
        }
        else if(n instanceof player3leftDiagonal)
        {
            n1=new player3leftDiagonal();
        }
        else if(n instanceof player3rightDiagonal)
        {
            n1=new player3rightDiagonal();
        }
        else if(n instanceof player3Row)
        {
            n1=new player3Row();
        }
        else
        {
            n1=new iWin();
        }
        return n1;
    }


}
