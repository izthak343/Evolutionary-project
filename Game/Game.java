package Game;

import Players.Player;
import Players.humanPlayer;
import Players.miniMax;
import Players.treePlayer;

public class Game
{
    public static final int FIRST_PLAYER_WIN = 1;
    public static final int SECOND_PLAYER_WIN = 2;
    public static final int DRAW = 0;

    /*start game between 2 players*/
    public static int startGame(Player p1, Player p2)
    {
        Board board =new Board();
        boolean turnOfFirst =true;
        while (!board.hasEnd())
        {
            Board copy =new Board(board);
            if (turnOfFirst)
            {
                if(p1 instanceof treePlayer)
                {
                    int num= miniMax.Play((treePlayer)(p1) ,copy, 'X', 'O');
                    if (board.insertToCol(num, 'X'))
                        turnOfFirst = false;
                    else System.out.println("Invalid column or full column!");
                }
                else
                {
                    if (board.insertToCol(p1.play(copy, 'X', 'O'), 'X'))
                        turnOfFirst = false;
                    else System.out.println("Invalid column or full column!");
                }
            }
            else
            {
                if(p2 instanceof treePlayer)
                {
                    int num= miniMax.Play((treePlayer)(p2) ,copy, 'O', 'X');
                    if(board.insertToCol(num,'O'))
                        turnOfFirst=true;
                    else System.out.println("Invalid column or full column!");
                }
                else
                {
                    if(board.insertToCol(p2.play(copy, 'O', 'X'),'O'))
                        turnOfFirst=true;
                    else System.out.println("Invalid column or full column!");
                }

            }

            if(board.checkWin())
            {
                if(p1 instanceof humanPlayer || p2 instanceof  humanPlayer)
                    board.print();
                //System.out.println("game end!!");
                if(turnOfFirst)
                     return SECOND_PLAYER_WIN;
                else return FIRST_PLAYER_WIN;
            }

        }
        //System.out.println("game end!!");
        if(p1 instanceof humanPlayer || p2 instanceof  humanPlayer)
            board.print();
        return DRAW;

    }
}
