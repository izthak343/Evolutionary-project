import Game.Game;
import Players.humanPlayer;
import Players.treePlayer;
import Tree.Population;
import file.WriterReader;

import java.util.ArrayList;
import java.util.Scanner;

public class Main
{
    public static void main(String [] args)
    {
        boolean End=false;
        System.out.println("Welcome to connect 4!");
        Scanner s=new Scanner(System.in);
        int choose;
        int choose1;
        while (!End)
        {
            System.out.print("To play against devolve player enter 1, to evolve player enter 2:");
            choose=s.nextInt();
            if(choose==1)
            {
                ArrayList<treePlayer> players= WriterReader.readAllPlayers();
                if(players.size()==0)
                    System.out.println("There is no players to play against, please evolve player first! ");
                else
                {
                    System.out.println("please choose a player to play against");
                    for (int i = 0; i < players.size(); i++)
                    {
                        System.out.println(players.get(i).name+" --> "+(i+1));
                    }
                    choose=s.nextInt();
                    int num=Game.startGame(new humanPlayer(),players.get(choose-1));
                    if(num==Game.FIRST_PLAYER_WIN)
                        System.out.println("You win");
                    else if(num==Game.SECOND_PLAYER_WIN)
                        System.out.println("You lost!");
                    else System.out.println("It's a draw!");
                }
            }
            else
            {
                System.out.print("Enter size of population(50+): ");
                choose=s.nextInt();
                System.out.print("Enter dept of tree: ");
                choose1=s.nextInt();
                Population p=new Population(choose);
                p.initPopulation(choose1);
                System.out.print("Enter number of generation: ");
                choose1=s.nextInt();
                for (int i = 0; i < choose1; i++)
                {
                    p.tournament();
                    p.nextGeneration();
                    System.out.println("Generation "+(i+1)+" end");
                }
                p.tournament();
                System.out.print("Give a name to the best player: ");
                s.nextLine();
                String name=s.nextLine();
                System.out.println("The best player:");
                treePlayer best=p.getBestPlayer();
                best.name=name;
                System.out.println(best.print());
                System.out.print("To save "+name+" Enter 1, else enter 2:");
                choose=s.nextInt();
                if(choose==1)
                    WriterReader.addPlayerTofile(best);
            }
            System.out.print("Exit enter 1, else enter 2: ");
            choose=s.nextInt();
            if(choose==1)
                End=true;

        }


    }

}