package Game;

import Players.treePlayer;
import random.SingletonRandom;

import java.util.ArrayList;

public class Tournament
{
    public static void playTournament(ArrayList<treePlayer> trees)
    {
        if(trees.size()==1)
            return;
        int num1 = 0;
        int num2 = 0;
        ArrayList<treePlayer> winners = new ArrayList<treePlayer>();
        ArrayList<treePlayer> losers = new ArrayList<treePlayer>();
        //case of odd trees -> game between the first and the last tree
        if(trees.size()%2!=0)
        {
            int winner = Game.startGame(trees.get(0), trees.get(trees.size()-1));
            if (winner == Game.FIRST_PLAYER_WIN)
                num1++;
            else if (winner != Game.DRAW)
                num2++;
            winner = Game.startGame(trees.get(trees.size()-1), trees.get(0));
            if (winner == Game.FIRST_PLAYER_WIN)
                num2++;
            else if (winner != Game.DRAW)
                num1++;
            //tree 1 win more times
            if (num1 < num2) {
                trees.get(trees.size()-1).setRank(trees.size()/2);
                winners.add(trees.get(trees.size()-1));
                losers.add(trees.get(0));
            }
            else
            {
                //draw - luck will decide
                if (SingletonRandom.INSTANCE.nextInt(2) == 1)
                {
                    trees.get(0).setRank(trees.size()/2);
                    winners.add(trees.get(0));
                    losers.add(trees.get(trees.size()-1));
                }
            }

        }
        //Tournament between all trees
        for (int i = 0; i < trees.size() - 1; i=i+2)
        {
            int winner = Game.startGame(trees.get(i), trees.get(i + 1));
            if (winner == Game.FIRST_PLAYER_WIN)
                num1++;
            else if (winner != Game.DRAW)
                num2++;
            winner = Game.startGame(trees.get(i + 1), trees.get(i));
            if (winner == Game.FIRST_PLAYER_WIN)
                num2++;
            else if (winner != Game.DRAW)
                num1++;
            //tree 1 win more times
            if (num1 > num2) {
                trees.get(i).setRank(trees.size()/2);
                winners.add(trees.get(i));
                losers.add(trees.get(i + 1));
            } else {
                //tree 2 win more times
                if (num1 < num2)
                {
                    trees.get(i + 1).setRank(trees.size()/2);
                    winners.add(trees.get(i + 1));
                    losers.add(trees.get(i));
                }
                else
                    {
                    //draw - luck will decide
                    if (SingletonRandom.INSTANCE.nextInt(2) == 1)
                    {
                        trees.get(i).setRank(trees.size()/2);
                        winners.add(trees.get(i));
                        losers.add(trees.get(i + 1));
                    }
                    else {
                            trees.get(i + 1).setRank(trees.size()/2);
                            winners.add(trees.get(i + 1));
                            losers.add(trees.get(i));
                        }
                }
            }
        }
        playTournament(winners);
        playTournament(losers);
    }


}
