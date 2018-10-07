package Tree;

import Game.Tournament;
import Players.treePlayer;
import genetics.variationOperators;
import random.ListUtil;
import random.SingletonRandom;

import java.util.ArrayList;
import java.util.Collections;

public class Population
{
    private ArrayList<treePlayer> trees;
    int sizeOfPopulation;
    public static int dept;
    public Population(int size)
    {
        trees = new ArrayList<treePlayer>(size);
        sizeOfPopulation=size;
    }
    //init the population
    public void initPopulation(int deptOfTrees)
    {
        for (int i = 0; i < sizeOfPopulation; i++) {
            trees.add(new treePlayer(nodeFactory.buildTree(deptOfTrees)));
        }
    }
    public void tournament()
    {
        Tournament.playTournament(trees);
    }
    public void printRank()
    {
        for (int i = 0; i <sizeOfPopulation ; i++)
        {
            System.out.println("Tree "+(i+1)+":");
            System.out.println(trees.get(i).print());
            System.out.println("Rank of tree "+(i+1)+": "+trees.get(i).getRank());
        }
    }

    public ArrayList<treePlayer> getTrees() {
        return trees;
    }
    public void nextGeneration()
    {
        ArrayList<treePlayer> newP=new ArrayList<treePlayer>();
        ArrayList<treePlayer> chooingTrees;
        SingletonRandom rand =SingletonRandom.INSTANCE;
        for (int i = 0; i < sizeOfPopulation; i++)
        {
            chooingTrees = ListUtil.chooseRandomly(trees,10, rand);
            Collections.sort(chooingTrees);
            if(rand.nextInt(100)<97)
                newP.add(variationOperators.crossOver(chooingTrees.get(0),chooingTrees.get(1),dept));
            else
                newP.add(variationOperators.mutation(chooingTrees.get(0)));
        }
        trees=newP;
    }
    public treePlayer getBestPlayer()
    {
        ArrayList<treePlayer> p=new ArrayList<treePlayer>();
        for (int i = 0; i < sizeOfPopulation; i++)
        {
            p.add(new treePlayer(trees.get(i)));
            p.get(i).setRank(trees.get(i).getRank());
        }
        Collections.sort(p);
        System.out.println("Rank: "+p.get(0).getRank() );
        return p.get(0);
    }

}
