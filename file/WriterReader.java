package file;

import Players.treePlayer;

import java.io.*;
import java.util.ArrayList;

public class WriterReader {
    public static ArrayList<treePlayer> readAllPlayers()
    {
        ArrayList<treePlayer> trees = new ArrayList<treePlayer>();
        try
        {
            FileInputStream fi = new FileInputStream(new File("myPlayers.txt"));
            ObjectInputStream oi = new ObjectInputStream(fi);
            trees=(ArrayList<treePlayer>)oi.readObject();
            oi.close();
            fi.close();
            FileOutputStream f = new FileOutputStream(new File("myPlayers.txt"));
            ObjectOutputStream o = new ObjectOutputStream(f);
            o.writeObject(trees);
            o.close();
            f.close();
        } catch (FileNotFoundException e)
        {
            System.out.println("File not found or empty");
        }
        catch (IOException e)
        {
            System.out.println("Error initializing stream");
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return trees;
    }
    public static void addPlayerTofile(treePlayer p)
    {
        ArrayList<treePlayer> trees = new ArrayList<treePlayer>();
        try
        {
            FileInputStream fi = new FileInputStream(new File("myPlayers.txt"));
            ObjectInputStream oi = new ObjectInputStream(fi);
            //System.out.println(oi.available());
            trees=(ArrayList<treePlayer>)oi.readObject();
            oi.close();
            fi.close();
            FileOutputStream f = new FileOutputStream(new File("myPlayers.txt"));
            ObjectOutputStream o = new ObjectOutputStream(f);
            trees.add(p);
            o.writeObject(trees);
            o.close();
            f.close();
        } catch (FileNotFoundException e1)
        {
            //case of new empty file
            try
            {
                FileOutputStream f = new FileOutputStream(new File("myPlayers.txt"));
                ObjectOutputStream o = new ObjectOutputStream(f);
                trees.add(p);
                o.writeObject(trees);
                o.close();
                f.close();
            } catch (IOException e)
            {
                System.out.println("Error initializing stream");
            }
        } catch (IOException e)
        {
            System.out.println("Error initializing stream");
        }
        catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


}

